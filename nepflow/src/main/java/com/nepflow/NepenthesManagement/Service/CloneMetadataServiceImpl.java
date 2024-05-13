package com.nepflow.NepenthesManagement.Service;

import com.nepflow.NepenthesManagement.Model.Location;
import com.nepflow.NepenthesManagement.Model.Producer;
import com.nepflow.NepenthesManagement.Repository.LocationRepository;
import com.nepflow.NepenthesManagement.Repository.ProducerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CloneMetadataServiceImpl implements CloneMetadataService {

    @Autowired
    LocationRepository locationRepository;

    @Autowired
    ProducerRepository producerRepository;

    @Override
    public boolean createMountain(String mountainName) {
        // maybe separate between checking and actually saving
        Optional<Location> location = this.locationRepository.findById(mountainName);
        if (location.isPresent()) {
            return false;
        }
        this.locationRepository.save(new Location(mountainName));
        return true;
    }

    @Override
    public boolean createProducer(String producerName) {
        Producer producer = this.producerRepository.findProducerByName(producerName);
        if (producer != null) {
            return false;
        }
        this.producerRepository.save(new Producer(producerName));
        return false;
    }
}
