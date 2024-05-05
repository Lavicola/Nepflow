package com.nepflow.NepenthesManagement.Model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.neo4j.core.schema.*;

import java.util.Objects;


@Node("Clone")
@Getter
public abstract class Clone {

    @Id
    @GeneratedValue
    private String uuid;

    @Relationship("IDENTICALLY_TO")
    Nepenthes nepenthes;

    @Setter
    @Relationship("ORIGIN")
    Mountain mountain;

    @Setter
    @Relationship("HAS_SEX")
    Sex sex;

    @Property
    String cloneId;

    public Clone(String cloneId, Nepenthes nepenthes) {
        this.cloneId = cloneId;
        this.nepenthes = nepenthes;
    }


    public boolean equals(Object o) {
        assertNotNull(o);
        assertIsExpectedObject(o);
        return true;
    }

    public void assertNotNull(Object o) {
        if (o == null) {
            throw new IllegalArgumentException("object was null");
        }
    }

    public void assertIsExpectedObject(Object o) {
        if (o instanceof Clone) {
            return;
        }
        throw new IllegalArgumentException("Object must be Clone, IndividualClone or IVClone");
    }

    public int hashCode() {
        return Objects.hash(this.getCloneId(), this.getNepenthes().getName());
    }
}
