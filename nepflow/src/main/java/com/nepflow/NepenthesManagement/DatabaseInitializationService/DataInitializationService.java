package com.nepflow.NepenthesManagement.DatabaseInitializationService;


import com.nepflow.NepenthesManagement.Model.Labels.Label;
import com.nepflow.NepenthesManagement.Model.Labels.Species;
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

    @Value("classpath:startUpData/nepenthes.txt")
    private Resource LabelSQL;
    @Value("classpath:startUpData/clones.csv")
    private Resource ClonesCSV;
    @Value("classpath:startUpData/sex.txt")
    private Resource SexSQL;
    @Value("classpath:startUpData/producer.csv")
    private Resource ProducerSQL;
    @Value("classpath:startUpData/country.txt")
    private Resource CountryTXT;

    @Value("classpath:startUpData/hybrids.csv")
    private Resource HybridsTXT;

    @Value("classpath:startUpData/cultivars.csv")
    private Resource CultivarsCSV;




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

        String nepenthesAsString ;
        String producerAsString;
        String cloneTypeAsString;
        String cloneId;
        String sexAsString;
        String locationAsString;



        if (false) {
            String SPLIT = ",";
            // Store known cultivars
            Label labelAtRuntime;

            int PRODUCER_INDEX = 0;
            int CLONETYPE_INDEX = PRODUCER_INDEX + 1;
            int NEPENTHES_INDEX = CLONETYPE_INDEX + 1;
            int CLONEID_INDEX = NEPENTHES_INDEX + 1;
            int SEX_INDEX = CLONEID_INDEX + 1;
            int LOCATION_INDEX = SEX_INDEX + 1;








            // store supported countries
            for (String countyLine : this.getLines(CountryTXT)) {
                this.userManagementService.saveCountry(countyLine);
            }
            // store sex
            for (String sexLine : this.getLines(SexSQL)) {
                this.nepenthesManagementMetaDataService.saveSex(sexLine);
            }
            // store valid Producers
            for (String producerLine : this.getLines(ProducerSQL)) {
                String[] lineParts = producerLine.split(SPLIT);
                this.nepenthesManagementMetaDataService.saveProducer(lineParts[0], lineParts[1]);
            }
            // Store known Nepenthes
            for (String nepenthesLine : this.getLines(LabelSQL)) {
                this.nepenthesManagementService.createLabel(new Species(nepenthesLine));
            }

            for (String line : this.getLines(ClonesCSV)) {
                String[] lineParts = line.split(SPLIT);
                nepenthesAsString = getIndexValue(lineParts,NEPENTHES_INDEX).trim();
                sexAsString = getIndexValue(lineParts,SEX_INDEX).trim();
                producerAsString = getIndexValue(lineParts,PRODUCER_INDEX).trim();
                cloneTypeAsString = getIndexValue(lineParts,CLONETYPE_INDEX).trim();
                cloneId = getIndexValue(lineParts,CLONEID_INDEX).trim();
                locationAsString = getIndexValue(lineParts,LOCATION_INDEX).trim();

                Label nepenthes = this.nepenthesManagementService.createLabel(new Species(lineParts[NEPENTHES_INDEX].trim()));
                if(cloneTypeAsString.equals("IV")){
                    this.nepenthesManagementService.saveIVClone(nepenthes,
                            cloneId, sexAsString,
                            locationAsString, producerAsString);
                }else{
                    this.nepenthesManagementService.saveICCloneWithCloneId(nepenthes,cloneId, sexAsString,
                            locationAsString, producerAsString);

                }

            }


            // store hybrids/multi hybrids
            for (String line : this.getLines(HybridsTXT)) {
                String lineParts[] = line.split(SPLIT);
                String location = getIndexValue(lineParts,LOCATION_INDEX);
                labelAtRuntime = labelRecognizerService.returnRightLabelClass(lineParts[2]);


                if (labelAtRuntime != null) {
                    labelAtRuntime = this.nepenthesManagementService.createLabel(labelAtRuntime);
                    this.nepenthesManagementService.saveIVClone(labelAtRuntime,
                            lineParts[1], null,
                            location, lineParts[0]);
                }

            }
        }

    }

    public String getIndexValue( String[] values,int index ){
        if(index < values.length){
            return values[index];
        }else{
            return "";
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







