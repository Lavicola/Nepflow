package com.nepflow.NepenthesManagement.DatabaseInitializationService;


import com.nepflow.NepenthesManagement.Model.CloneMetadata.Grex;
import com.nepflow.NepenthesManagement.Model.CloneMetadata.Location;
import com.nepflow.NepenthesManagement.Model.CloneMetadata.Producer;
import com.nepflow.NepenthesManagement.Model.CloneMetadata.Sex;
import com.nepflow.NepenthesManagement.Model.Clones.ICClone;
import com.nepflow.NepenthesManagement.Model.Clones.ICNepenthesClone;
import com.nepflow.NepenthesManagement.Model.Clones.IVNepenthesClone;
import com.nepflow.NepenthesManagement.Model.Labels.Nepenthes;
import com.nepflow.NepenthesManagement.Repository.LabelRepository;
import com.nepflow.NepenthesManagement.Service.NepenthesManagementMetaDataService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//@Service
public class DataInitializationService {
//TODO at some refactor, just a solution to get data for now

    @Value("classpath:sql/nepenthes.sql")
    private Resource LabelSQL;
    @Value("classpath:sql/clones.sql")
    private Resource ClonesSQL;
    @Value("classpath:sql/sex.sql")
    private Resource SexSQL;
    @Value("classpath:sql/producer.sql")
    private Resource ProducerSQL;

    @Autowired
    LabelRepository labelRepository;

    @Autowired
    NepenthesManagementMetaDataService nepenthesManagementMetaDataService;

    @Transactional("transactionManager")
    @PostConstruct
    public void initializeModel() throws IOException {
        List<String> lines;
        HashMap<String, Sex> sexHashMap = new HashMap<>();
        HashMap<String, Producer> producerHashMap = new HashMap<>();
        HashMap<String, Nepenthes> nepenthesHashMap = new HashMap<>();

        for (String sex:this.getLines(SexSQL)) {
            if(sexHashMap.containsKey(sex)){
                continue;
            }
            sexHashMap.put(sex,new Sex(sex));
        }
        for (String producer:this.getLines(ProducerSQL)) {
            if(producerHashMap.containsKey(producer)){
                continue;
            }
            producerHashMap.put(producer,new Producer(producer));
        }
        for (String producer:this.getLines(ProducerSQL)) {
            if(producerHashMap.containsKey(producer)){
                continue;
            }
            producerHashMap.put(producer,new Producer(producer));
        }
        for (String label:this.getLines(LabelSQL)) {
            if(nepenthesHashMap.containsKey(label)){
                continue;
            }
            nepenthesHashMap.put(label,new Nepenthes(label,0));
            labelRepository.save(nepenthesHashMap.get(label));
        }
        Grex grex = null;
        for (String line:this.getLines(ClonesSQL)) {
            String[] lineParts = line.split(",");
            Producer producer = producerHashMap.getOrDefault(lineParts[0],null);
            String cloneid = lineParts[1];
            Nepenthes nepenthes = nepenthesHashMap.getOrDefault(lineParts[2],null);
            Location location = this.nepenthesManagementMetaDataService.saveLocation(lineParts[3]);
            Sex sex = sexHashMap.getOrDefault(lineParts[4],null);
            ICClone ivNepenthesICClone = new IVNepenthesClone(nepenthes,cloneid,sex,grex,producer,location);






        }



        //this.speciesCloneRepository.save(clone);

        }


    public List<String> getLines(Resource resource) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(resource.getInputStream(), StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            return lines;
        }
        return lines;
    }


}







