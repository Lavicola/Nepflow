package com.nepflow.NepenthesManagement.DatabaseInitializationService;

import com.nepflow.NepenthesManagement.Model.*;
import com.nepflow.NepenthesManagement.Repository.*;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DataInitializationService {
//TODO at some refactor, just a solution to get data for now

    @Value("classpath:sql/nepenthes.sql")
    private Resource NepenthesSQL;
    @Value("classpath:sql/clones.sql")
    private Resource ClonesSQL;


    @Autowired
    CloneRepository speciesCloneRepository;

    @Autowired
    NepenthesRepository nepenthesRepository;

    @Autowired
    SexRepository sexRepository;

    @Autowired
    LocationRepository locationRepository;


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
            if (this.speciesCloneRepository.existsCloneByCloneId(parts[0])) {
                continue;
            }
            Nepenthes nepenthes = this.nepenthesRepository.findNepenthesByName(parts[1]);
            SpeciesClone clone;
            if (parts[0].contains("ISC")) {
                //clone = new ICClone(nepenthes.getName(), nepenthes, null, null);
            } else {
               // clone = new IVClone(nepenthes.getName(), parts[0], nepenthes, null, null);
            }
            Optional<Location> mountain;
            Optional<Sex> sex;
            if (parts.length >= 3) {
                mountain = this.locationRepository.findById(parts[2]);
                if (mountain.isPresent()) {
                    //clone.setLocation(mountain.get());
                } else {
                   // clone.setLocation(this.locationRepository.save(new Location(parts[2])));
                }
            }
            if (parts.length >= 4) {
                sex = this.sexRepository.findById(parts[3]);
                if (!sex.isPresent()) {
                    //clone.setSex(this.sexRepository.save(new Sex(parts[3])));
                } else {
                    //clone.setSex(sex.get());
                }
            }


            //this.speciesCloneRepository.save(clone);

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







