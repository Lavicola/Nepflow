package com.nepflow.PollenExchange.Exception;

public class CouldNotCopyCurrentSpecimenImage extends RuntimeException {
    /**
     * @param exceptionMsg
     */
    public CouldNotCopyCurrentSpecimenImage(final String exceptionMsg) {
        super(String.format("Could not Copy Specimen Image for Pollenoffer:", exceptionMsg));

    }

}