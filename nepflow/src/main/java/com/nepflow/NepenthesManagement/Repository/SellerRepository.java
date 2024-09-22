package com.nepflow.NepenthesManagement.Repository;

import com.nepflow.NepenthesManagement.Model.CloneMetadata.Seller;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

/**
 * SellerRepository which enables to save and retrieve any subclasses of Sellers.
 *
 * @author David Schmidt
 * @version 21. Nov 2024
 */

@Repository
public interface SellerRepository extends Neo4jRepository<Seller, String> {

    /**
     * @param name name of the Seller
     * @return concrete Seller like a Producer or PrivateSeller
     */
    Seller findSellerByName(String name);

}
