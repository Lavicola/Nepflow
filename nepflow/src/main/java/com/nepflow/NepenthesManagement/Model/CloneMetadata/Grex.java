package com.nepflow.NepenthesManagement.Model.CloneMetadata;

import com.nepflow.NepenthesManagement.Model.Clones.Clone;
import org.springframework.data.annotation.Version;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

/**
 * Crossing two Clones with each other results in a Grex.
 * This Model abstracts a Grex.
 *
 * @author David Schmidt
 * @version 14. Nov 2024
 */
@Node
public class Grex {

    /**
     *
     */
    @Id
    private String grexId;


    /**
     *
     */
    @Version
    private Long version;

    /**
     *
     */
    @Relationship(value = "IS_FATHER", direction = Relationship.Direction.OUTGOING)
    private Clone father;
    /**
     *
     */
    @Relationship(value = "IS_MOTHER", direction = Relationship.Direction.OUTGOING)
    private Clone mother;

    /**
     * @param mother
     * @param father
     * @param grexId
     */
    public Grex(final Clone mother, final Clone father, final String grexId) {
        assert (father != null);
        assert (mother != null);
        this.mother = mother;
        this.father = father;
        this.grexId = grexId;
    }


    /**
     * @param father father of the Grex
     * @return true if father could be set, false if father was already set
     */
    public boolean setFather(final Clone father) {
        if (father != null) {
            this.father = father;
            return true;
        } else {
            return false;
        }
    }

    /**
     * @param mother mother of the Grex
     * @return true if mother could be set, false if mother was already set
     */
    public boolean setMother(final Clone mother) {
        if (mother != null) {
            this.mother = mother;
            return true;
        } else {
            return false;
        }
    }

    /**
     * TODO.
     * @return
     */
    public String getName() {
        return "";
    }

}
