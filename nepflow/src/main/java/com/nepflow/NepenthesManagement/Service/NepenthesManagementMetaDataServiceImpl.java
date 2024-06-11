package com.nepflow.NepenthesManagement.Service;

import com.nepflow.NepenthesManagement.Model.CloneMetadata.*;
import com.nepflow.NepenthesManagement.Repository.LocationRepository;
import com.nepflow.NepenthesManagement.Repository.SellerRepository;
import com.nepflow.NepenthesManagement.Repository.SexRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NepenthesManagementMetaDataServiceImpl implements NepenthesManagementMetaDataService {

    @Autowired
    LocationRepository locationRepository;

    @Autowired
    SellerRepository sellerRepository;

    @Autowired
    SexRepository sexRepository;

    @Override
    public Location saveLocation(String locationAsString) {
        if (locationAsString == null || locationAsString.trim().isEmpty()) {
            return null;
        }
        Location location = new Location(locationAsString);
        Location loc = this.locationRepository.findLocationByName(location.getName());
        if (loc != null) {
            return loc;
        } else {
            return this.locationRepository.save(new Location(locationAsString));
        }
    }

    @Override
    public Producer saveProducer(String producerAsString, String contact) {
        Producer producer = new Producer(producerAsString, contact);
        Seller rseller = this.sellerRepository.findSellerByName(producer.getName());
        if (rseller instanceof Producer) {
            return (Producer) rseller;
        } else if (rseller != null) {
            // would throw exception since name of seller is id
            return null;
        } else {
            return this.sellerRepository.save(producer);
        }
    }

    @Override
    public PrivateSeller savePrivateSeller(String sellerAsString, String contact) {
        PrivateSeller seller = new PrivateSeller(sellerAsString, contact);
        Seller rseller = this.sellerRepository.findSellerByName(seller.getName());
        if (rseller instanceof PrivateSeller) {
            return (PrivateSeller) rseller;
        } else if (rseller != null) {
            // would throw exception since name of seller is id
            return null;
        } else {
            return this.sellerRepository.save(seller);
        }

    }

    @Override
    public Location getLocation(String locationAsString) {
        return this.locationRepository.findLocationByName(locationAsString);
    }

    @Override
    public Seller getSeller(String sellerAsString) {

        return this.sellerRepository.findSellerByName(sellerAsString);
    }

    @Override
    public Producer getProducer(String producerAsString) {
        Seller seller = this.sellerRepository.findSellerByName(producerAsString);
        if (seller instanceof Producer) {
            return (Producer) seller;
        } else {
            return null;
        }
    }


    @Override
    public Sex getSex(String sexAsString) {
        return this.sexRepository.findSexBySexAsString(sexAsString);
    }

    @Override
    public Sex saveSex(String sexAsString) {
        Sex rSex = this.sexRepository.findSexBySexAsString(sexAsString);
        if (rSex != null) {
            return rSex;
        } else {
            return this.sexRepository.save(new Sex(sexAsString));
        }

    }

}
