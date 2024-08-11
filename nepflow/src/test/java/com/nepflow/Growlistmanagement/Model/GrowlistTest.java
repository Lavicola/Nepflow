package com.nepflow.Growlistmanagement.Model;

import com.nepflow.GrowlistManagement.Model.Growlist;
import com.nepflow.GrowlistManagement.Model.Specimen;
import com.nepflow.LabelCloneDefinitions;
import com.nepflow.NepenthesManagement.Model.Clones.Clone;
import com.nepflow.UserManagement.Model.User;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertTrue;

public class GrowlistTest {


    @Test
    public void addSpecimenUserDifferTest(){
        Clone clone = LabelCloneDefinitions.icSpeciesClone2;
        User user = LabelCloneDefinitions.user1;
        User user2 = LabelCloneDefinitions.user1;
        Growlist growlist = new Growlist(user);
        Specimen userSpecimen= new Specimen(clone,user);
        Specimen noUserSpecimen= new Specimen(clone,user2);

        assertTrue(growlist.addSpecimen(userSpecimen));
        assertTrue(growlist.addSpecimen(noUserSpecimen));


    }


}
