package com.nepflow.NepenthesManagement.Service;

import com.nepflow.NepenthesManagement.Model.Mountain;
import com.nepflow.NepenthesManagement.Model.Producer;
import com.nepflow.NepenthesManagement.Repository.MountainRepository;
import com.nepflow.NepenthesManagement.Repository.ProducerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CloneMetadataServiceImpl implements CloneMetadataService {

    @Autowired
    MountainRepository mountainRepository;

    @Autowired
    ProducerRepository producerRepository;

    @Override
    public boolean createMountain(String mountainName) {
        // maybe separate between checking and actually saving
        Mountain mountain = this.mountainRepository.findMountainByName(mountainName);
        if (mountain != null) {
            return false;
        }
        this.mountainRepository.save(new Mountain(mountainName));
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
