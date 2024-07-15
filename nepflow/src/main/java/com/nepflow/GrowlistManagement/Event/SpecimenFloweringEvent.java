package com.nepflow.GrowlistManagement.Event;

import com.nepflow.GrowlistManagement.Model.Specimen;
import org.springframework.context.ApplicationEvent;


public class SpecimenFloweringEvent extends ApplicationEvent {

    private final Specimen specimen;


    public SpecimenFloweringEvent(Object source, Specimen specimen) {
        super(source);
        this.specimen = specimen;
    }

    public Specimen getSpecimen() {
        return this.specimen;
    }


}
