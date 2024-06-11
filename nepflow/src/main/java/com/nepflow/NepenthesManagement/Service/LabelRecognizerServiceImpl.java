package com.nepflow.NepenthesManagement.Service;

import com.nepflow.NepenthesManagement.Exception.InvalidLabelFormatException;
import com.nepflow.NepenthesManagement.Model.Labels.Label;
import com.nepflow.NepenthesManagement.Model.Labels.MultiHybrid;
import com.nepflow.NepenthesManagement.Model.Labels.Species;
import com.nepflow.NepenthesManagement.Model.Labels.PrimaryHybrid;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;

@Service
public class LabelRecognizerServiceImpl implements LabelRecognizerService {
    @Override
    public Label returnRightLabelClass(String name) {
        Label label;

        // Try to instantiate Nepenthes
        label = tryCreateLabel(MultiHybrid.class, name);
        if (label != null) {
            return label;
        }

        // Try to instantiate PrimaryHybrid
        label = tryCreateLabel(PrimaryHybrid.class, name);
        if (label != null) {
            return label;
        }

        // Try to instantiate MultiHybrid
        label = tryCreateLabel(Species.class, name);

        return label; // This may be null if all attempts fail
    }

    private Label tryCreateLabel(Class<? extends Label> clazz, String name) {
        try {
            return clazz.getDeclaredConstructor(String.class).newInstance(name);
        } catch (InvalidLabelFormatException | NoSuchMethodException | InvocationTargetException |
                 IllegalAccessException | InstantiationException e) {
            return null;
        }
    }
}
