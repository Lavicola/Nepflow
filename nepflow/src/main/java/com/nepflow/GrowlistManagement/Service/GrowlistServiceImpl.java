package com.nepflow.GrowlistManagement.Service;

import com.nepflow.GrowlistManagement.Model.Growlist;
import com.nepflow.GrowlistManagement.Repository.GrowListRepository;
import com.nepflow.UserManagement.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GrowlistServiceImpl implements Growlistservice{

    @Autowired
    GrowListRepository growListRepository;
    @Override
    public void createGrowlist(User user) {
        this.growListRepository.save(new Growlist(user));
    }

    @Override
    public Growlist getGrowListByUser(String userId) {
        return null;
    }
}
