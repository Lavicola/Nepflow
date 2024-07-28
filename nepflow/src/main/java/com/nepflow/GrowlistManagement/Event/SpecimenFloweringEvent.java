package com.nepflow.GrowlistManagement.Event;

import com.nepflow.GrowlistManagement.Model.Specimen;
import com.nepflow.UserManagement.Model.User;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;


public class SpecimenFloweringEvent extends ApplicationEvent {

    @Getter
    private final Specimen specimen;
    @Getter
    private final User user;


    public SpecimenFloweringEvent(Object source, Specimen specimen, User user) {
        super(source);
        this.specimen = specimen;
        this.user = user;
    }

}
