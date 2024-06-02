package com.nepflow.NepenthesManagement.Repository;

import com.nepflow.NepenthesManagement.Model.CloneMetadata.Seller;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SellerRepository extends Neo4jRepository<Seller,String> {

    Seller findSellerByName(String name);

}
