package com.nepflow.BaseModules.EmailModule;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
public class MailDTO {


    /**
     *
     */
    private String sender;

    /**
     *
     */
    private String subject;

    /**
     *
     */
    private String receiver;

    /**
     * the templateName of which shall be used.
     */
    private String templateName;

    /**
     * the name and values of the variables which will be replaced.
     */
    private Map<String, Object> variables;

}
