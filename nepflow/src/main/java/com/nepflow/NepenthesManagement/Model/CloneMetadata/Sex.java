package com.nepflow.NepenthesManagement.Model.CloneMetadata;

import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Version;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

import java.util.HashMap;
import java.util.Map;

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
     * hashmap to check if given Sex is valid.
     */
    private static final Map<String, SEX> VALID_SEX_VALUES =
            new HashMap<>();

    static {
        for (SEX value : SEX.values()) {
            VALID_SEX_VALUES.put(value.name(), value);
        }
    }


    /**
     *
     */
    @Id
    private SEX sex;

    /**
     *
     */
    @Version
    private Long version;

    /**
     * @param sexAsString the sexAsString which shall represent a concrete sex.
     *                    If the value is not valid the default value will be set to unkown.
     */
    public Sex(final String sexAsString) {
        SEX sex1 = Sex.sexAsStringToSEX(sexAsString);
        if (sex1.equals(SEX.UNKNOWN)) {
            // Setting the sex for unknown would result in more needed space without an additional advantage.
            this.sex = null;
        } else {
            this.sex = sex1;
        }
    }


    /**
     * @return true if sex is not equal null
     */
    public boolean isSEXSet() {
        return this.sex != null;
    }

    /**
     * Method to convert a String to an enum representation.
     *
     * @param sexAsString sexAsString
     * @return enum belonging to the string if exist or UNKNOWN if null
     */
    public static SEX sexAsStringToSEX(final String sexAsString) {
        String sexAsUpperString = sexAsString == null ? "" : sexAsString.toUpperCase();
        return VALID_SEX_VALUES.getOrDefault(sexAsUpperString, SEX.UNKNOWN);
    }

    /**
     * Method to convert Sex to an enum representation.
     *
     * @param sex sex
     * @return enum belonging to the string if exist or UNKNOWN if null
     */
    public static String sexToSexAsString(final Sex sex) {
        return sex == null ? SEX.UNKNOWN.name() : sex.getSexAsString();
    }

    /**
     * @return returns the sex value as String, if null return unkown
     */
    public String getSexAsString() {
        return this.sex == null ? SEX.UNKNOWN.name() : this.sex.name();
    }

    /**
     *
     */
    public enum SEX {
        /**
         *
         */
        MALE,
        /**
         *
         */
        FEMALE,
        /**
         *
         */
        UNKNOWN

    }


}
