package com.nepflow.NepenthesManagement.Controller;

import com.nepflow.NepenthesManagement.Dto.LabelClonesDTO;
import com.nepflow.NepenthesManagement.Dto.LabelDTO;
import com.nepflow.NepenthesManagement.Model.Clones.ICNepenthesClone;
import com.nepflow.NepenthesManagement.Model.Clones.IVNepenthesClone;
import com.nepflow.NepenthesManagement.Model.Labels.Label;
import com.nepflow.NepenthesManagement.Model.Labels.Species;
import com.nepflow.NepenthesManagement.Service.NepenthesRetrivalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;
@Controller
public class SpeciesControllerImpl implements SpeciesApiDelegate{

    @Autowired
    ControllerUtilityService controllerUtilityService;

    @Autowired
    NepenthesRetrivalService nepenthesRetrivalService;
    public ResponseEntity<List<LabelDTO>> cloneSpeciesGet() {
        List<Label> labels = this.nepenthesRetrivalService.getNepenthesByNepenthesType(Species.class.getSimpleName());
        return ResponseEntity.ok(this.controllerUtilityService.labelToLabelDTO(labels));    }
    public ResponseEntity<List<LabelClonesDTO>> cloneSpeciesIcGet() {
return null;
    }
    public ResponseEntity<LabelClonesDTO> cloneSpeciesIcNameGet(String name) {
        Label label = this.nepenthesRetrivalService.getLabelWithClonesByLabelClassAndNepenthesNameAndCloneType(Species.class.getSimpleName(), name,ICNepenthesClone.class.getSimpleName());
        return ResponseEntity.ok(this.controllerUtilityService.labelToLabelClonesDTO(label));
    }
    public ResponseEntity<LabelClonesDTO> cloneSpeciesIcNamePost(String name,
                                                                 LabelClonesDTO labelClonesDTO) {

        return null;
    }
    public ResponseEntity<LabelClonesDTO> cloneSpeciesIcNamePut(String name,
                                                                LabelClonesDTO labelClonesDTO) {

        return null;
    }
    public ResponseEntity<LabelClonesDTO> cloneSpeciesIvNameGet(String name) {
        Label label = this.nepenthesRetrivalService.getLabelWithClonesByLabelClassAndNepenthesNameAndCloneType(Species.class.getSimpleName(), name,IVNepenthesClone.class.getSimpleName());
        return ResponseEntity.ok(this.controllerUtilityService.labelToLabelClonesDTO(label));
    }
    public ResponseEntity<LabelClonesDTO> cloneSpeciesIvNamePost(String name,
                                                                 LabelClonesDTO labelClonesDTO) {

        return null;
    }
    public ResponseEntity<LabelClonesDTO> cloneSpeciesIvNamePut(String name,
                                                                LabelClonesDTO labelClonesDTO) {

        return null;
    }
    public ResponseEntity<LabelClonesDTO> cloneSpeciesNameGet(String name) {

        return null;
    }
    public ResponseEntity<LabelClonesDTO> cloneSpeciesPost(LabelClonesDTO labelClonesDTO) {

        return null;
    }



}
