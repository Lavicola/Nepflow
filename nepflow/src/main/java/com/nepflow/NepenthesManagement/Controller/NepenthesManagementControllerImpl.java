package com.nepflow.NepenthesManagement.Controller;
import com.nepflow.NepenthesManagement.Model.*;

import com.nepflow.NepenthesManagement.Dto.ICCloneDTO;
import com.nepflow.NepenthesManagement.Dto.IVCloneDTO;
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
        SpeciesClone clone = new ICClone();
        this.nepenthesManagementservice.createNewSpeciesClone(clone,
                icCloneDTO.getNepenthes(),icCloneDTO.getCloneId(),
                icCloneDTO.getLocation(),icCloneDTO.getSex(),null);

        return null;
    }

    public ResponseEntity<IVCloneDTO> cloneSpeciesIvPost(IVCloneDTO ivCloneDTO) {
        SpeciesClone clone = new IVClone();
        this.nepenthesManagementservice.createNewSpeciesClone(clone,
                ivCloneDTO.getNepenthes(),ivCloneDTO.getCloneId(),
                ivCloneDTO.getLocation(),ivCloneDTO.getSex(),ivCloneDTO.getProducer());

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


