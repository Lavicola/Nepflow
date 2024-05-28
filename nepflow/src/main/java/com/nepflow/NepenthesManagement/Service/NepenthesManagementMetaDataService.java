package com.nepflow.NepenthesManagement.Service;

import com.nepflow.NepenthesManagement.Model.CloneMetadata.Location;
import com.nepflow.NepenthesManagement.Model.CloneMetadata.Producer;
import com.nepflow.NepenthesManagement.Model.CloneMetadata.Sex;

public interface NepenthesManagementMetaDataService {

    Location saveLocation(String locationAsString);
    Producer saveProducer(String producerAsString);

    Location getLocation(String locationAsString);
    Producer getProducer(String producerAsString);

    Sex getSex(String sexAsString);

    Sex saveSex(String sexAsString);

}
