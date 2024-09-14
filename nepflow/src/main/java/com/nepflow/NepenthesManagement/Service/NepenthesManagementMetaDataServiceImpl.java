package com.nepflow.NepenthesManagement.Service;

import com.nepflow.NepenthesManagement.Model.CloneMetadata.Location;
import com.nepflow.NepenthesManagement.Model.CloneMetadata.Sex;
import com.nepflow.NepenthesManagement.Model.CloneMetadata.Seller;
import com.nepflow.NepenthesManagement.Model.CloneMetadata.PrivateSeller;
import com.nepflow.NepenthesManagement.Model.CloneMetadata.Producer;
import com.nepflow.NepenthesManagement.Repository.LocationRepository;
import com.nepflow.NepenthesManagement.Repository.SellerRepository;
import com.nepflow.NepenthesManagement.Repository.SexRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Concrete Implementation of the Interface to manage Metadata.
 *
 * @author David Schmidt
 * @version 14. Nov 2024
 */

@Service
public class NepenthesManagementMetaDataServiceImpl implements NepenthesManagementMetaDataService {

    /**
     * Location Repository used to retrieve and store Location into the Database.
     */
    @Autowired
    private LocationRepository locationRepository;

    /**
     * Seller Repository used to retrieve and store Producer and PrivateSeller into the Database.
     */
    @Autowired
    private SellerRepository sellerRepository;

    /**
     * Sex Repository used to retrieve and store Sexes into the Database.
     */
    @Autowired
    private SexRepository sexRepository;

    /**
     * Method implementation to store a Location into the Database.
     *
     * @param locationAsString name of the Location
     * @return Location object or null in case of an error
     */
    @Override
    public Location saveLocation(final String locationAsString) {
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

    /**
     * Method implementation to store a Producer into the Database.
     *
     * @param producerAsString name of the Producer
     * @param contact contact information of the Producer on where to reach
     * @return Producer object or null in case of an error
     */
    @Override
    public Producer saveProducer(final String producerAsString, final String contact) {
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
    /**
     * Method implementation to store a private Seller into the Database.
     * @param sellerAsString name of the Seller
     * @param contact contact information of the Seller on where to reach
     * @return Seller object or null in case of an error
     */
    @Override
    public PrivateSeller savePrivateSeller(final String sellerAsString, final String contact) {
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
    /**
     * Method implementation to retrieve a Location object using the name of the Location.
     * @param locationAsString name of the Location
     * @return Location object or null in case of an error
     */
    @Override
    public Location getLocation(final String locationAsString) {
        return this.locationRepository.findLocationByName(locationAsString);
    }
    /**
     * Method implementation to retrieve a Seller (private or producer)
     * object using the name of the Seller.
     * @param sellerAsString name of the Seller
     * @return concrete Seller object or null in case of an error
     */
    @Override
    public Seller getSeller(final String sellerAsString) {

        return this.sellerRepository.findSellerByName(sellerAsString);
    }
    /**
     * Method implementation to retrieve a Producer
     * object using the name of the Producer.
     * @param producerAsString name of the Producer
     * @return Producer object or null in case of an error
     */
    @Override
    public Producer getProducer(final String producerAsString) {
        Seller seller = this.sellerRepository.findSellerByName(producerAsString);
        if (seller instanceof Producer) {
            return (Producer) seller;
        } else {
            return null;
        }
    }

    /**
     * Method implementation to retrieve a specific Sex.
     * @param sexAsString sex as a String
     * @return Sex object or null in case of an error
     */
    @Override
    public Sex getSex(final String sexAsString) {
        return this.sexRepository.findSexBySexAsString(sexAsString);
    }
    /**
     * Method implementation to store a sex String as Sex Object into the Database.
     * @param sexAsString name of the sex to store into the database
     * @return sex object or null in case of an error
     */
    @Override
    public Sex saveSex(final String sexAsString) {
        Sex rSex = this.sexRepository.findSexBySexAsString(sexAsString);
        if (rSex != null) {
            return rSex;
        } else {
            return this.sexRepository.save(new Sex(sexAsString));
        }

    }

}
