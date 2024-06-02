package com.nepflow.NepenthesManagement.Service;

import com.nepflow.NepenthesManagement.Model.CloneMetadata.*;

public interface NepenthesManagementMetaDataService {

    Location saveLocation(String locationAsString);
    Producer saveProducer(String producerAsString, String contact);
    PrivateSeller savePrivateSeller(String sellerAsString, String contact);

    Location getLocation(String locationAsString);
    Seller getSeller(String sellerAsString);
    Producer getProducer(String producerAsString);

    Sex getSex(String sexAsString);

    Sex saveSex(String sexAsString);

}
