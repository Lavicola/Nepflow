package com.nepflow.NepenthesManagement.Controller;

import com.nepflow.NepenthesManagement.Dto.LabelClonesDTO;
import com.nepflow.NepenthesManagement.Dto.LabelDTO;
import com.nepflow.NepenthesManagement.Model.Clones.ICMultiHybrid;
import com.nepflow.NepenthesManagement.Model.Clones.ICPrimaryHybrid;
import com.nepflow.NepenthesManagement.Model.Clones.IVMultiHybrid;
import com.nepflow.NepenthesManagement.Model.Labels.Label;
import com.nepflow.NepenthesManagement.Model.Labels.MultiHybrid;
import com.nepflow.NepenthesManagement.Model.Labels.PrimaryHybrid;
import com.nepflow.NepenthesManagement.Service.NepenthesRetrivalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class MultiHybridControllerImpl implements MultiHybridApiDelegate{
    @Autowired
    ControllerUtilityService controllerUtilityService;

    @Autowired
    NepenthesRetrivalService nepenthesRetrivalService;

    public ResponseEntity<List<LabelDTO>> cloneMultiHybridGet() {

        return null;
    }
    public ResponseEntity<List<LabelClonesDTO>> cloneMultiHybridIcGet() {

        return null;
    }
    public  ResponseEntity<LabelClonesDTO> cloneMultiHybridIcNameGet(String name) {
        Label label = this.nepenthesRetrivalService.getLabelWithClonesByLabelClassAndNepenthesNameAndCloneType(MultiHybrid.class.getSimpleName(), name, IVMultiHybrid.class.getSimpleName());
        return ResponseEntity.ok(this.controllerUtilityService.labelToLabelClonesDTO(label));

    }
    public ResponseEntity<LabelClonesDTO> cloneMultiHybridIcNamePost(String name,
                                                                     LabelClonesDTO labelClonesDTO) {

        return null;
    }
    public ResponseEntity<LabelClonesDTO> cloneMultiHybridIcNamePut(String name,
                                                                    LabelClonesDTO labelClonesDTO) {

        return null;
    }
    public  ResponseEntity<LabelClonesDTO> cloneMultiHybridIvNameGet(String name) {
        Label label = this.nepenthesRetrivalService.getLabelWithClonesByLabelClassAndNepenthesNameAndCloneType(MultiHybrid.class.getSimpleName(), name, ICMultiHybrid.class.getSimpleName());
        return ResponseEntity.ok(this.controllerUtilityService.labelToLabelClonesDTO(label));

    }
    public ResponseEntity<LabelClonesDTO> cloneMultiHybridIvNamePost(String name,
                                                                     LabelClonesDTO labelClonesDTO) {

        return null;
    }
    public ResponseEntity<LabelClonesDTO> cloneMultiHybridIvNamePut(String name,
                                                                    LabelClonesDTO labelClonesDTO) {

        return null;
    }
    public ResponseEntity<LabelClonesDTO> cloneMultiHybridNameGet(String name) {

        return null;
    }
    public ResponseEntity<LabelClonesDTO> cloneMultiHybridPost(LabelClonesDTO labelClonesDTO) {

        return null;
    }



}
