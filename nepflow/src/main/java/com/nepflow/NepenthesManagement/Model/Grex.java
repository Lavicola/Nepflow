package com.nepflow.NepenthesManagement.Model;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

@Node
public class Grex {

    @Id
    private String grexId;

    @Relationship(value = "IS_FATHER", direction = Relationship.Direction.OUTGOING)
    Clone father;
    @Relationship(value = "IS_MOTHER", direction = Relationship.Direction.OUTGOING)
    Clone mother;

    public Grex(Clone mother, Clone father, String grexId) {
        assert (father != null);
        assert (mother != null);
        this.mother = mother;
        this.father = father;
        this.grexId = grexId;
    }

    public String getName() {
        String format;
        if (mother instanceof SpeciesClone && father instanceof SpeciesClone) {
            format = "%s x %s";
        } else if (mother instanceof ICHybrid && father instanceof SpeciesClone) {
            format = "(%s) x %s";
        } else if (mother instanceof SpeciesClone && father instanceof ICHybrid) {
            format = "%s x (%s)";
        } else if (mother instanceof SpeciesClone && father instanceof ICMultiHybrid) {
            format = "%s x (%s)";
        } else if (mother instanceof ICMultiHybrid && father instanceof SpeciesClone) {
            format = "(%s) x %s";
        } else {
            format = "(%s) x (%s)";
        }
        return String.format(format, mother.getName(), father.getName());

    }

}
