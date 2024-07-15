package com.nepflow.GrowlistManagement.Event;

import com.nepflow.GrowlistManagement.Model.Specimen;
import org.springframework.context.ApplicationEvent;

public class SpecimenStoppedFloweringEvent extends ApplicationEvent {

    private final Specimen specimen;


    public SpecimenStoppedFloweringEvent(Object source, Specimen specimen) {
        super(source);
        this.specimen = specimen;
    }

    public Specimen getSpecimen() {
        return this.specimen;
    }


}