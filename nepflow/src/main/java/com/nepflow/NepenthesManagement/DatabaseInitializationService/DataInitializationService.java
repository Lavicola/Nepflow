package com.nepflow.NepenthesManagement.DatabaseInitializationService;


import com.nepflow.NepenthesManagement.Model.CloneMetadata.Grex;
import com.nepflow.NepenthesManagement.Model.Labels.Label;
import com.nepflow.NepenthesManagement.Model.Labels.Nepenthes;
import com.nepflow.NepenthesManagement.Repository.LabelRepository;
import com.nepflow.NepenthesManagement.Service.LabelRecognizerService;
import com.nepflow.NepenthesManagement.Service.NepenthesManagementMetaDataService;
import com.nepflow.NepenthesManagement.Service.NepenthesManagementService;
import com.nepflow.NepenthesManagement.Service.NepenthesRetrivalService;
import com.nepflow.UserManagement.Service.UserManagementService;
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
import java.util.List;

@Service
public class DataInitializationService {

    @Value("classpath:sql/nepenthes.sql")
    private Resource LabelSQL;
    @Value("classpath:sql/clones.csv")
    private Resource ClonesCSV;
    @Value("classpath:sql/sex.sql")
    private Resource SexSQL;
    @Value("classpath:sql/producer.sql")
    private Resource ProducerSQL;
    @Value("classpath:sql/country.txt")
    private Resource CountryTXT;

    @Value("classpath:sql/hybrids.csv")
    private Resource HybridsTXT;

    @Autowired
    LabelRepository labelRepository;

    @Autowired
    NepenthesManagementService nepenthesManagementService;

    @Autowired
    NepenthesManagementMetaDataService nepenthesManagementMetaDataService;

    @Autowired
    UserManagementService userManagementService;


     @Autowired
    NepenthesRetrivalService nepenthesRetrivalService;

     @Autowired
    LabelRecognizerService labelRecognizerService;

    @Transactional("transactionManager")
    @PostConstruct
    public void initializeModel() throws IOException {


        if(false) {

            // store supported countries
            for (String countryAsString : this.getLines(CountryTXT)) {
                this.userManagementService.saveCountry(countryAsString);
            }

            // store sex
            for (String sex : this.getLines(SexSQL)) {
                this.nepenthesManagementMetaDataService.saveSex(sex);
            }
            // store valid Producers
            for (String producerLine : this.getLines(ProducerSQL)) {
                String[] lineParts = producerLine.split(",");
                this.nepenthesManagementMetaDataService.saveProducer(lineParts[0],lineParts[1]);
            }
            // Store known Nepenthes
            for (String nepenthes : this.getLines(LabelSQL)) {
                this.nepenthesManagementService.createLabel(new Nepenthes(nepenthes));
            }


            Grex grex = null;
            int PRODUCER_INDEX = 0;
            int CLONE_INDEX = 1;
            int NEPENTHES_INDEX = 2;
            int SEX_INDEX = 3;
            int LOCATION_INDEX = 4;

            for (String line : this.getLines(ClonesCSV)) {
                String[] lineParts = line.split(",");
                Label nepenthes = this.nepenthesManagementService.createLabel(new Nepenthes(lineParts[NEPENTHES_INDEX].trim()));
                this.nepenthesManagementService.saveIVClone( nepenthes,
                        lineParts[CLONE_INDEX].trim(), lineParts[SEX_INDEX], grex,
                        lineParts[LOCATION_INDEX].trim(), lineParts[PRODUCER_INDEX]);
            }

        }

        Label label;
        for (String line : this.getLines(HybridsTXT)) {
            Nepenthes nepenthes = new Nepenthes("hamata x villosa");

            String lineParts[] = line.split(",");
            label = labelRecognizerService.returnRightLabelClass(lineParts[2]);
            System.out.println(label);

        }




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







