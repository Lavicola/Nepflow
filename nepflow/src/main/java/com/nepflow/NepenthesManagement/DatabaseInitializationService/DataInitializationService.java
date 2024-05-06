package com.nepflow.NepenthesManagement.DatabaseInitializationService;

import com.nepflow.NepenthesManagement.Model.Clone;
import com.nepflow.NepenthesManagement.Model.ICClone;
import com.nepflow.NepenthesManagement.Model.IVClone;
import com.nepflow.NepenthesManagement.Model.Nepenthes;
import com.nepflow.NepenthesManagement.Repository.CloneRepository;
import com.nepflow.NepenthesManagement.Repository.IVCloneRepository;
import com.nepflow.NepenthesManagement.Repository.NepenthesRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class DataInitializationService {


    @Value("classpath:sql/nepenthes.sql")
    private Resource NepenthesSQL;
    @Value("classpath:sql/clones.sql")
    private Resource ClonesSQL;


    @Autowired
    CloneRepository cloneRepository;

    @Autowired
    NepenthesRepository nepenthesRepository;

    @Transactional("transactionManager")
    @PostConstruct
    public void initializeModel() throws IOException {
        List<String> lines;
        lines = this.getLines(NepenthesSQL);
        for (String name : lines) {
            if (this.nepenthesRepository.existsByName(name)) {
                continue;
            } else {
                this.nepenthesRepository.save(new Nepenthes(name));
            }
        }
        lines = this.getLines(ClonesSQL);
        for (String line : lines) {
            String[] parts = line.split(",");
            if (this.cloneRepository.existsCloneByCloneIdAndNepenthesName(parts[0], parts[1])) {
                continue;
            } else {
                Nepenthes nepenthes = this.nepenthesRepository.findNepenthesByName(parts[1]);
                Clone clone;

                if(parts[0].contains("ISC")){
                    clone = new ICClone(parts[0], nepenthes);
                }else{
                    clone = new IVClone(parts[0], nepenthes);

                }
                this.cloneRepository.save(clone);
            }
        }


    }

    public List<String> getLines(Resource resource) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(resource.getInputStream(), StandardCharsets.UTF_8))) {
            String line;
            Nepenthes nepenthes;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            return lines;
        }
        return lines;
    }


}







