package com.nepflow.GrowlistManagement.Service;

import com.nepflow.GrowlistManagement.Model.Growlist;
import com.nepflow.GrowlistManagement.Model.Specimen;
import com.nepflow.GrowlistManagement.Repository.GrowListRepository;
import com.nepflow.NepenthesManagement.Model.Clones.Clone;
import com.nepflow.NepenthesManagement.Service.NepenthesRetrivalService;
import com.nepflow.UserManagement.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GrowlistServiceImpl implements Growlistservice{

    @Autowired
    GrowListRepository growListRepository;

    @Autowired
    NepenthesRetrivalService nepenthesRetrivalService;

    @Override
    public void createGrowlist(User user) {
        this.growListRepository.save(new Growlist(user));
    }

    @Override
    public Specimen addCloneToGrowList(User user, String internalCloneId) {
        Growlist growlist = this.growListRepository.findGrowlistByUser(user);
        Specimen specimen;
        Clone clone = this.nepenthesRetrivalService.getCloneByInternalId(internalCloneId);
        if(clone == null || growlist == null){
            return null;
        }
        specimen = new Specimen(clone);
        growlist.addSpecimen(specimen);
        this.growListRepository.save(growlist);
        return specimen;
    }

    @Override
    public Growlist getGrowListByUser(String userId) {
        return null;
    }
}
