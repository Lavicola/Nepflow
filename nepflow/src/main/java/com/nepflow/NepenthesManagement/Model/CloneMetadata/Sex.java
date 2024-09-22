package com.nepflow.NepenthesManagement.Model.CloneMetadata;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Version;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

/**
 * Models used to represent the concrete Sexes of Nepenthes.
 *
 * @author David Schmidt
 * @version 21. Nov 2024
 */


@Node
@NoArgsConstructor
public class Sex {

    /**
     *
     */
    @Id
    @Getter
    private String sexAsString;

    /**
     *
     */
    @Version
    private Long version;

    /**
     * @param sexAsString the sexAsString which shall represent a concrete sex.
     */
    public Sex(final String sexAsString) {
        this.sexAsString = sexAsString;

    }


}
