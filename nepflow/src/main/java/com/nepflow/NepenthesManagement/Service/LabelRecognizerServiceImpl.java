package com.nepflow.NepenthesManagement.Service;

import com.nepflow.NepenthesManagement.Exception.InvalidLabelFormatException;
import com.nepflow.NepenthesManagement.Model.Labels.Label;
import com.nepflow.NepenthesManagement.Model.Labels.MultiHybrid;
import com.nepflow.NepenthesManagement.Model.Labels.Species;
import com.nepflow.NepenthesManagement.Model.Labels.PrimaryHybrid;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;

@Service
public class LabelRecognizerServiceImpl implements LabelRecognizerService {

    private final List<Class<? extends Label>> labelClasses = Arrays.asList(
            MultiHybrid.class,
            PrimaryHybrid.class,
            Species.class
    );


    @Override
    public Label returnRightLabelClass(String name) {
        for (Class<? extends Label> clazz : labelClasses) {
            Label label = tryCreateLabel(clazz, name);
            if (label != null) {
                return label;
            }
        }

        // Throw an exception if no valid label class could be instantiated
        throw new InvalidLabelFormatException("No valid label found for name: " + name);
    }

    private Label tryCreateLabel(Class<? extends Label> clazz, String name) {
        try {
            return clazz.getDeclaredConstructor(String.class).newInstance(name);
        } catch (InvalidLabelFormatException | NoSuchMethodException | InvocationTargetException |
                 IllegalAccessException | InstantiationException ignored) {

        }
        return null;
    }


}
