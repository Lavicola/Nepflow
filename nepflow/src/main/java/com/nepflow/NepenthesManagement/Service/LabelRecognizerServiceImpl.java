package com.nepflow.NepenthesManagement.Service;

import com.nepflow.NepenthesManagement.Exception.InvalidLabelFormatException;
import com.nepflow.NepenthesManagement.Model.Labels.Label;
import com.nepflow.NepenthesManagement.Model.Labels.MultiHybrid;
import com.nepflow.NepenthesManagement.Model.Labels.PrimaryHybrid;
import com.nepflow.NepenthesManagement.Model.Labels.Species;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;

/**
 * Implementation of the LabelRecognizerService interface.
 *
 * @author David Schmidt
 * @version 14. Nov 2024
 */

@Service
public class LabelRecognizerServiceImpl implements LabelRecognizerService {

    /**
     * Array which contains all Label classes.
     */
    private final List<Class<? extends Label>> labelClasses = Arrays.asList(
            MultiHybrid.class,
            PrimaryHybrid.class,
            Species.class
    );

    /**
     * Returns the appropriate Label instance based on the provided name
     * Implementation creates objects and
     * checks for the InvalidLabelFormatException.
     *
     * @param name the name used to determine the right Label class
     * @return the Label instance corresponding to the specified name
     */
    @Override
    public Label returnRightLabelClass(final String name) {
        for (Class<? extends Label> clazz : labelClasses) {
            Label label = tryCreateLabel(clazz, name);
            if (label != null) {
                return label;
            }
        }

        // Throw an exception if no valid label class could be instantiated
        throw new InvalidLabelFormatException("No valid label found for name: " + name);
    }

    /**
     * The method uses reflection to invoke the constructor with the provided clazz name.
     * If the instantiation succeeds, it returns the newly created Label instance.
     * If any exception occurs during instantiation—such
     * as InvalidLabelFormatException, NoSuchMethodException, InvocationTargetException,
     * IllegalAccessException, or InstantiationException
     * the method catches these exceptions and returns null
     *
     * @param clazz Name of the class used in the Reflection.
     * @param name  the Name of the Label
     * @return the Label instance corresponding to the specified name
     */
    private Label tryCreateLabel(final Class<? extends Label> clazz, final String name) {
        try {
            return clazz.getDeclaredConstructor(String.class).newInstance(name);
        } catch (InvalidLabelFormatException | NoSuchMethodException
                 | InvocationTargetException | IllegalAccessException
                 | InstantiationException ignored) {

        }
        return null;
    }


}
