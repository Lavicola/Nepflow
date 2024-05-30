package com.nepflow.NepenthesManagement.Controller;

import com.nepflow.NepenthesManagement.Dto.CloneDTO;
import com.nepflow.NepenthesManagement.Service.NepenthesManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class NepenthesManagementControllerImpl implements NepenthesManagementApiDelegate{


    @Autowired
    NepenthesManagementService nepenthesManagementService;

    public ResponseEntity<List<CloneDTO>> cloneSpeciesGet() {

        return null;
    }



    }
