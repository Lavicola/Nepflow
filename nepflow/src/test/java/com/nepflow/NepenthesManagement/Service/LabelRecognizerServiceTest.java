package com.nepflow.NepenthesManagement.Service;


import com.nepflow.NepenthesManagement.LabelFormats;
import com.nepflow.NepenthesManagement.Model.Labels.Label;
import com.nepflow.NepenthesManagement.Model.Labels.MultiHybrid;
import com.nepflow.NepenthesManagement.Model.Labels.Nepenthes;
import com.nepflow.NepenthesManagement.Model.Labels.PrimaryHybrid;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertTrue;

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

        assertTrue(nepenthes instanceof Nepenthes);
        assertTrue(primaryHybrid instanceof PrimaryHybrid);
        assertTrue(multiHybrid instanceof MultiHybrid);






    }

}
