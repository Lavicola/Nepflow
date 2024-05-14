package com.nepflow.NepenthesManagement.Controller;
import com.nepflow.NepenthesManagement.Model.Clone;

import com.nepflow.NepenthesManagement.Dto.ICCloneDTO;
import com.nepflow.NepenthesManagement.Dto.IVCloneDTO;
import com.nepflow.NepenthesManagement.Model.ICClone;
import com.nepflow.NepenthesManagement.Model.IVClone;
import com.nepflow.NepenthesManagement.Model.Nepenthes;
import com.nepflow.NepenthesManagement.Service.NepenthesManagementRetrievalService;
import com.nepflow.NepenthesManagement.Service.NepenthesManagementservice;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class NepenthesManagementControllerImpl implements NepenthesManagementApiDelegate {

    @Autowired
    NepenthesManagementservice nepenthesManagementservice;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    NepenthesManagementRetrievalService nepenthesManagementRetrievalService;


    public ResponseEntity<List<String>> nepenthesGet() {
        List<String> nepenthesNames = this.nepenthesManagementRetrievalService.getNepenthesList().
                stream().
                map(nepenthes -> nepenthes.getName()).collect(Collectors.toList());

        return ResponseEntity.ok(nepenthesNames);
    }

    public ResponseEntity<String> nepenthesPost(String name) {
        Nepenthes nepenthes = this.modelMapper.map(name,Nepenthes.class);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    public ResponseEntity<ICCloneDTO> cloneSpeciesIcPost(ICCloneDTO icCloneDTO) {
        Clone clone = this.modelMapper.map(icCloneDTO, ICClone.class);

        return null;
    }

    public ResponseEntity<IVCloneDTO> cloneSpeciesIvPost(IVCloneDTO ivCloneDTO) {
        Clone clone = this.modelMapper.map(ivCloneDTO, IVClone.class);

        return null;
    }

    public ResponseEntity<ICCloneDTO> cloneHybridsIcPost(ICCloneDTO icCloneDTO) {

        return null;
    }

    public ResponseEntity<IVCloneDTO> cloneHybridsIvPost(IVCloneDTO ivCloneDTO) {
        return null;
    }

    public ResponseEntity<ICCloneDTO> cloneMultiHybridIcPost(ICCloneDTO icCloneDTO) {
        return null;

    }

    public ResponseEntity<IVCloneDTO> cloneMultiHybridIvPost(IVCloneDTO ivCloneDTO) {

        return null;

    }
}


