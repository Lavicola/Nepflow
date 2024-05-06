package com.nepflow.NepenthesManagement.Controller;

import com.nepflow.NepenthesManagement.Dto.*;
import com.nepflow.NepenthesManagement.Model.Clone;
import com.nepflow.NepenthesManagement.Model.ICClone;
import com.nepflow.NepenthesManagement.Model.IVClone;
import com.nepflow.NepenthesManagement.Model.Nepenthes;
import com.nepflow.NepenthesManagement.Service.CloneMetadataService;
import com.nepflow.NepenthesManagement.Service.CloneNepenthesService;
import com.nepflow.NepenthesManagement.Service.NepenthesAndCloneRetrivalService;
import com.nepflow.NepenthesManagement.Service.NepenthesAndCloneRetrivalServiceImpl;
import com.nepflow.UserManagement.Service.UserManagementService;
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
    CloneMetadataService cloneMetadataService;

    @Autowired
    CloneNepenthesService cloneNepenthesService;

    @Autowired
    NepenthesAndCloneRetrivalService nepenthesAndCloneRetrivalService;

    @Autowired
    ModelMapper modelMapper;



    public ResponseEntity<IVCloneDTO> cloneIvPost(IVCloneDTO ivCloneDTO) {
        IVClone ivClone = this.modelMapper.map(ivCloneDTO,IVClone.class);



        return null;
    }

    public ResponseEntity<IVCloneDTO> cloneIvPut(IVCloneDTO ivCloneDTO) {
        IVClone ivClone = this.modelMapper.map(ivCloneDTO,IVClone.class);

        return null;
    }


    public ResponseEntity<CloneDTO> cloneIcPut(CloneDTO cloneDTO) {
        ICClone ivClone = this.modelMapper.map(cloneDTO,ICClone.class);

        return null;
    }

    public ResponseEntity<CloneDTO> cloneIcPost(CloneDTO cloneDTO) {
        ICClone ivClone = this.modelMapper.map(cloneDTO,ICClone.class);



        return null;
    }


        public ResponseEntity<String> mountainPost(String mountainName) {
        if (this.cloneMetadataService.createMountain(mountainName)) {
            return ResponseEntity.ok(mountainName);
        }
        return ResponseEntity.internalServerError().body(null);
    }

    public ResponseEntity<List<String>> nepenthesGet() {
        List<String> names = this.nepenthesAndCloneRetrivalService.getNepenthes()
                .stream()
                .map(Nepenthes::getName)
                .collect(Collectors.toList());
        return ResponseEntity.ok(names);
    }

    public ResponseEntity<String> nepenthesPost(String nepenthesName) {
        if(this.cloneNepenthesService.createNewNepenthes(nepenthesName)){
            return ResponseEntity.ok(nepenthesName);
        }
        return ResponseEntity.internalServerError().body(null);
    }

    public ResponseEntity<NepenthesNameCloneGet200Response> nepenthesNameCloneGet(String name,
                                                                                  String clone) {
        Clone cloneNepenthes = this.nepenthesAndCloneRetrivalService.getNepenthesClone(clone, name);


        return ResponseEntity.ok(this.modelMapper.map(cloneNepenthes, CloneDTO.class));
    }

    public ResponseEntity<NepenthesClonesDTO> nepenthesNameGet(String name) {
        List<Clone> clones = this.nepenthesAndCloneRetrivalService.getClonesOfNepenthes(name);
        NepenthesClonesDTO nepenthesClonesDTO = new NepenthesClonesDTO();
        nepenthesClonesDTO.setNepenthes(name);
        nepenthesClonesDTO.clones(
                clones.stream().map(clone -> {
                    NepenthesClonesDTOClonesInner dtoClone = new NepenthesClonesDTOClonesInner();
                    dtoClone.setId(clone.getCloneId());
                    dtoClone.setNepenthes(name);
                    return dtoClone;
                }).collect(Collectors.toList()));

        return ResponseEntity.ok(nepenthesClonesDTO);
    }

    public ResponseEntity<String> producerPost(String producerName) {

        if (this.cloneNepenthesService.createNewNepenthes(producerName)) {
            return ResponseEntity.ok(producerName);
        }

        return ResponseEntity.internalServerError().body(null);

    }
}


