package com.nepflow.NepenthesManagement.Repository;

import com.nepflow.NepenthesManagement.Model.Labels.Label;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * LabelRepository which enables to save and retrieve any subclasses of Labels.
 *
 * @author David Schmidt
 * @version 21. Nov 2024
 */

@Repository
public interface LabelRepository extends Neo4jRepository<Label, String> {

    /**
     * @param nepenthesName Name of the Nepenthes
     * @return concrete Label subclass object
     */
    Label findLabelByName(String nepenthesName);

    /**
     * @param labelType LabelType e.g Species
     * @return amount of unique Labels in the Database
     */
    @Query("MATCH (n:`:#{literal(#labelType)}`) RETURN count(n)")
    int countLabelByLabelClass(String labelType);

    /**
     * @param labelType     labelType e.g Species, PrimaryHybrid
     * @param nepenthesName Name of the Nepenthes
     * @param cloneType     CloneType e.g. IVPrimaryHybrid
     * @param sellerType    SellerType e.g. Producer
     * @return concrete Label, their clones and Metadata depending on given CloneType
     */
    @Query("match(n:`:#{literal(#labelType)}`{name: $nepenthesName})" +
            "-[r:HAS_CLONE]->(c:`:#{literal(#cloneType)}`) " +
            "-[s:SOLD_BY]->(p)" +
            "Optional Match( (clone)-[sexRel:HAS_SEX]->(sex))" +
            "RETURN n, " +
            "COLLECT(r) as relationships, " +
            "COLLECT(c) as clones," +
            "Collect(s) as sold," +
            "COLLECT(p) as producer," +
            "COLLECT(sexRel) as sexRel," +
            "COLLECT(sex) as sex")
    Label findLabelClonesByLabelAndNepenthesNameAndCloneType(String labelType, String nepenthesName, String cloneType, String sellerType);

    /**
     * @param labelType labelType e.g. Species
     * @return List of Labels WITHOUT Clones references and Metadata
     */
    @Query("MATCH (n:`:#{literal(#labelType)}`) RETURN n")
    List<Label> getNepenthesByNepenthesType(String labelType);


}
