package com.nepflow.NepenthesManagement.Service;


import com.nepflow.NepenthesManagement.Model.CloneMetadata.Location;
import com.nepflow.NepenthesManagement.Model.CloneMetadata.Sex;
import com.nepflow.NepenthesManagement.Model.CloneMetadata.Seller;
import com.nepflow.NepenthesManagement.Model.CloneMetadata.PrivateSeller;
import com.nepflow.NepenthesManagement.Model.CloneMetadata.Producer;

/**
 * Interface which defines Methods to manage Metadata.
 * @version 14. Nov 2024
 * @author David Schmidt
 */
public interface NepenthesManagementMetaDataService {


    /**
     * Method definition to store a Location into the Database.
     * @param locationAsString name of the Location
     * @return Location object
     */
    Location saveLocation(String locationAsString);

    /**
     * Method definition to store a Producer into the Database.
     * @param producerAsString name of the Producer
     * @param contact contact information of the Producer on where to reach
     * @return Producer object
     */
    Producer saveProducer(String producerAsString, String contact);

    /**
     * Method definition to store a private Seller into the Database.
     * @param sellerAsString name of the Seller
     * @param contact contact information of the Seller on where to reach
     * @return Seller object
     */
    PrivateSeller savePrivateSeller(String sellerAsString, String contact);

    /**
     * Method definition to retrieve a Location object using the name of the Location.
     * @param locationAsString name of the Location
     * @return Location object
     */
    Location getLocation(String locationAsString);

    /**
     * Method definition to retrieve a Seller (private or producer)
     * object using the name of the Seller.
     * @param sellerAsString name of the Seller
     * @return concrete Seller object
     */
    Seller getSeller(String sellerAsString);

    /**
     * Method definition to retrieve a Producer
     * object using the name of the Producer.
     * @param producerAsString name of the Producer
     * @return Producer object
     */
    Producer getProducer(String producerAsString);

    /**
     * Method definition to retrieve a specific Sex.
     * @param sexAsString sex as a String
     * @return Sex object
     */
    Sex getSex(String sexAsString);

    /**
     * Method definition to store a sex String as Sex Object into the Database.
     * @param sexAsString name of the sex to store into the database
     * @return sex object
     */
    Sex saveSex(String sexAsString);

}
