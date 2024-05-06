package com.nepflow.GrowlistManagement.Repository;

import com.nepflow.GrowlistManagement.Model.NepenthesClone;
import com.nepflow.UserManagement.Model.User;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface NepenthesCloneRepository extends Neo4jRepository<NepenthesClone, UUID> {


    @Query("MATCH(n:NepenthesClone) -[GROWS_WITH]-> () RETURN n")
    List<NepenthesClone> findAllByUser(User user);

    @Query("MATCH (u:User {username: $username})\n" +
            "MATCH (c:IVClone{cloneId:$nepenthesCloneID})\n" +
            "CREATE (n:NepenthesClone)\n" +
            "CREATE (n)-[r:GROWS_AT]->(u)\n" +
            "CREATE (n)-[i:IDENTICALLY_TO]->(c)\n" +
            "RETURN n,u,c")
    NepenthesClone customSave(String username,String nepenthesCloneID);

}
