package com.nepflow.NepenthesManagement.Service;


import com.nepflow.NepenthesManagement.LabelFormats;
import com.nepflow.NepenthesManagement.Model.Labels.Label;
import com.nepflow.NepenthesManagement.Model.Labels.MultiHybrid;
import com.nepflow.NepenthesManagement.Model.Labels.Species;
import com.nepflow.NepenthesManagement.Model.Labels.PrimaryHybrid;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertTrue;

/**
 * This Test checks, if the LabelRecognizerService returns the right Subclass of the Label
 *
 */


public class LabelRecognizerServiceTest {




    @Test
    public void LabelRecognizerSelectionTest(){
        Label primaryHybrid;
        Label nepenthes;
        Label multiHybrid;
        LabelRecognizerServiceImpl service = new LabelRecognizerServiceImpl();

        nepenthes = service.returnRightLabelClass(LabelFormats.nep1);
        primaryHybrid = service.returnRightLabelClass(LabelFormats.hybridFormat1);
        multiHybrid = service.returnRightLabelClass(LabelFormats.multiHybridFormat2);

        assertTrue(nepenthes instanceof Species);
        assertTrue(primaryHybrid instanceof PrimaryHybrid);
        assertTrue(multiHybrid instanceof MultiHybrid);






    }

}
