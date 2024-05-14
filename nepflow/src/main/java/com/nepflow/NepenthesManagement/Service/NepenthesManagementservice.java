package com.nepflow.NepenthesManagement.Service;

import com.nepflow.NepenthesManagement.Model.Clone;
import com.nepflow.NepenthesManagement.Model.Producer;

public interface NepenthesManagementservice {

    public boolean createNewNepenthes(String name);

    public boolean createNewClone(Clone clone);


}
