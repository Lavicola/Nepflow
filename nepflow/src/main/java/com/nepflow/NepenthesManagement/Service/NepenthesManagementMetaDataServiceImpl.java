package com.nepflow.NepenthesManagement.Service;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import com.nepflow.NepenthesManagement.Model.Location;
import com.nepflow.NepenthesManagement.Model.Producer;
import com.nepflow.NepenthesManagement.Model.Sex;
import com.nepflow.NepenthesManagement.Repository.LocationRepository;
import com.nepflow.NepenthesManagement.Repository.ProducerRepository;
import com.nepflow.NepenthesManagement.Repository.SexRepository;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NepenthesManagementMetaDataServiceImpl implements NepenthesManagementMetaDataService{
    @Autowired
    ProducerRepository producerRepository;
    @Autowired
    LocationRepository locationRepository;
    @Autowired
    SexRepository sexRepository;

    @Override
    public Producer getProducer(String producer) {
        return this.producerRepository.findProducerByName(producer);
    }

    @Override
    public Location getLocation(String location) {
        return this.locationRepository.findLocationByName(location);
    }

    @Override
    public Sex getSex(String sex) {
        return this.sexRepository.findSexBySex(sex);
    }
}
