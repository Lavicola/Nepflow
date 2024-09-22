package com.nepflow.GrowlistManagement.Event;

import com.nepflow.GrowlistManagement.Model.Specimen;
import com.nepflow.UserManagement.Model.User;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

/**
 * Event used to asynchronous mark a Specimen as not flowering for the PollenExchange.
 *
 * @author David Schmidt
 * @version 21. Nov 2024
 */

public class SpecimenStoppedFloweringEvent extends ApplicationEvent {
    /**
     *
     */
    @Getter
    private final Specimen specimen;
    /**
     *
     */
    @Getter
    private final User user;


    /**
     * @param source
     * @param specimen
     * @param user
     */
    public SpecimenStoppedFloweringEvent(final Object source,
                                         final Specimen specimen, final User user) {
        super(source);
        this.specimen = specimen;
        this.user = user;
    }


}
