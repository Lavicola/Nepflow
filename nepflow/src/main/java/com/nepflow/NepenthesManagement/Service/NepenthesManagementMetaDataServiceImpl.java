package com.nepflow.NepenthesManagement.Service;

import com.nepflow.NepenthesManagement.Model.CloneMetadata.Location;
import com.nepflow.NepenthesManagement.Model.CloneMetadata.Producer;
import com.nepflow.NepenthesManagement.Model.CloneMetadata.Sex;
import com.nepflow.NepenthesManagement.Repository.LocationRepository;
import com.nepflow.NepenthesManagement.Repository.ProducerRepository;
import com.nepflow.NepenthesManagement.Repository.SexRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class NepenthesManagementMetaDataServiceImpl implements NepenthesManagementMetaDataService {

    @Autowired
    LocationRepository locationRepository;

    @Autowired
    ProducerRepository producerRepository;

    @Autowired
    SexRepository sexRepository;

    @Override
    public Location saveLocation(String locationAsString) {
        Optional<Location> loc = this.locationRepository.findById(locationAsString);
        if (loc.isPresent()) {
            return loc.get();
        } else {
            return this.locationRepository.save(new Location(locationAsString));
        }
    }

    @Override
    public Producer saveProducer(String producerAsString) {
        Producer producer = new Producer(producerAsString);
        Producer Rpro = this.producerRepository.findProducerByName(producer.getName());
        if (Rpro != null) {
            return Rpro;
        } else {
            return this.producerRepository.save(producer);
        }
    }

    @Override
    public Location getLocation(String locationAsString) {
        return this.locationRepository.findLocationByName(locationAsString);
    }

    @Override
    public Producer getProducer(String producerAsString) {
        return this.producerRepository.findProducerByName(producerAsString);
    }

    @Override
    public Sex getSex(String sexAsString) {
        return this.sexRepository.findSexBySexAsString(sexAsString);
    }
}
