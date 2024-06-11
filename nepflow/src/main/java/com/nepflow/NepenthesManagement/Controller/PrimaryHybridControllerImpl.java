package com.nepflow.NepenthesManagement.Controller;

import com.nepflow.NepenthesManagement.Dto.LabelClonesDTO;
import com.nepflow.NepenthesManagement.Dto.LabelDTO;
import com.nepflow.NepenthesManagement.Model.Clones.ICPrimaryHybrid;
import com.nepflow.NepenthesManagement.Model.Clones.IVPrimaryHybrid;
import com.nepflow.NepenthesManagement.Model.Labels.Label;
import com.nepflow.NepenthesManagement.Model.Labels.PrimaryHybrid;
import com.nepflow.NepenthesManagement.Service.NepenthesRetrivalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class PrimaryHybridControllerImpl implements PrimaryHybridApiDelegate{

    @Autowired
    ControllerUtilityService controllerUtilityService;

    @Autowired
    NepenthesRetrivalService nepenthesRetrivalService;

    public ResponseEntity<List<LabelDTO>> clonePrimaryHybridGet() {

        return null;
    }
    public ResponseEntity<List<LabelClonesDTO>> clonePrimaryHybridIcGet() {

        return null;
    }
    public  ResponseEntity<LabelClonesDTO> clonePrimaryHybridIcNameGet(String name) {
        Label label = this.nepenthesRetrivalService.getLabelWithClonesByLabelClassAndNepenthesNameAndCloneType(PrimaryHybrid.class.getSimpleName(), name, ICPrimaryHybrid.class.getSimpleName());
        return ResponseEntity.ok(this.controllerUtilityService.labelToLabelClonesDTO(label));
    }
    public ResponseEntity<LabelClonesDTO> clonePrimaryHybridIcNamePost(String name,
                                                                       LabelClonesDTO labelClonesDTO) {

        return null;
    }
    public ResponseEntity<LabelClonesDTO> clonePrimaryHybridIcNamePut(String name,
                                                                      LabelClonesDTO labelClonesDTO) {

        return null;
    }
    public  ResponseEntity<LabelClonesDTO> clonePrimaryHybridIvNameGet(String name) {
        Label label = this.nepenthesRetrivalService.getLabelWithClonesByLabelClassAndNepenthesNameAndCloneType(PrimaryHybrid.class.getSimpleName(), name, IVPrimaryHybrid.class.getSimpleName());
        return ResponseEntity.ok(this.controllerUtilityService.labelToLabelClonesDTO(label));
    }
    public ResponseEntity<LabelClonesDTO> clonePrimaryHybridIvNamePost(String name,
                                                                       LabelClonesDTO labelClonesDTO) {

        return null;
    }
    public ResponseEntity<LabelClonesDTO> clonePrimaryHybridIvNamePut(String name,
                                                                      LabelClonesDTO labelClonesDTO) {

        return null;
    }
    public ResponseEntity<LabelClonesDTO> clonePrimaryHybridNameGet(String name) {

        return null;
    }
    public ResponseEntity<LabelClonesDTO> clonePrimaryHybridPost(LabelClonesDTO labelClonesDTO) {

        return null;
    }


}
