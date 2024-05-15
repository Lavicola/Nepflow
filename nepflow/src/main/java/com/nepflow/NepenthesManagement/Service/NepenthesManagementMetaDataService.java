package com.nepflow.NepenthesManagement.Service;

import com.nepflow.NepenthesManagement.Model.Location;
import com.nepflow.NepenthesManagement.Model.Producer;
import com.nepflow.NepenthesManagement.Model.Sex;

public interface NepenthesManagementMetaDataService {

    Producer getProducer(String producer);
    Location getLocation(String location);
    Sex getSex(String sex);
}
