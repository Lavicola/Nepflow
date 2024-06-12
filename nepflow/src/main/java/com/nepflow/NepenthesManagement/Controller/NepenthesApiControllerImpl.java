package com.nepflow.NepenthesManagement.Controller;
import com.nepflow.NepenthesManagement.Dto.*;
import com.nepflow.NepenthesManagement.Model.Clones.*;
import com.nepflow.NepenthesManagement.Model.Labels.Label;
import com.nepflow.NepenthesManagement.Model.Labels.MultiHybrid;
import com.nepflow.NepenthesManagement.Model.Labels.PrimaryHybrid;
import com.nepflow.NepenthesManagement.Model.Labels.Species;
import com.nepflow.NepenthesManagement.Service.NepenthesRetrivalService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class NepenthesApiControllerImpl implements NepenthesApiDelegate{


    @Autowired
    NepenthesRetrivalService nepenthesRetrivalService;

    @Autowired
    ModelMapper modelMapper;


    private static final Map<String, Map<String, String>> NEPENTHES_TYPE_MAP = Map.of(
            Species.class.getSimpleName(), Map.of(
                    CloneType.iv.toString(), IVSpeciesClone.class.getSimpleName(),
                    CloneType.ic.toString(), ICSpeciesClone.class.getSimpleName()
            ),
            PrimaryHybrid.class.getSimpleName(), Map.of(
                    CloneType.iv.toString(), IVPrimaryHybrid.class.getSimpleName(),
                    CloneType.ic.toString(), ICPrimaryHybrid.class.getSimpleName()
            ),
            MultiHybrid.class.getSimpleName(), Map.of(
                    CloneType.iv.toString(), IVMultiHybrid.class.getSimpleName(),
                    CloneType.ic.toString(), ICMultiHybrid.class.getSimpleName()
            )


    );

    public static String resolveCloneType(String nepenthesType, String cloneType) {
        Map<String, String> cloneTypeMap = NEPENTHES_TYPE_MAP.get(nepenthesType);
        if (cloneTypeMap != null) {
            return cloneTypeMap.getOrDefault(cloneType, cloneTypeMap.get("default"));
        }
        return cloneType;
    }

    public ResponseEntity<LabelClonesDTO> cloneNepenthesTypeCloneTypeNameGet(NepenthesType nepenthesType,
                                                                             CloneType cloneType,
                                                                             String name) {


        Label label = this.nepenthesRetrivalService.getLabelWithClonesByLabelClassAndNepenthesNameAndCloneType(
                nepenthesType.getValue(),
                name,resolveCloneType(nepenthesType.getValue(),cloneType.getValue())
        );

        return ResponseEntity.ok(this.labelToLabelClonesDTO(label));
    }


    public ResponseEntity<LabelCloneDTO> cloneNepenthesTypeCloneTypeNameInternalCloneIdPut(NepenthesType nepenthesType,
                                                                                           CloneType cloneType,
                                                                                           String name,
                                                                                           String internalCloneId) {
        return null;
    }

    public ResponseEntity<LabelCloneDTO> cloneNepenthesTypeCloneTypeNamePost(NepenthesType nepenthesType,
                                                                             CloneType cloneType,
                                                                             String name,
                                                                             LabelCloneDTO labelCloneDTO) {
        return null;
    }

    public ResponseEntity<List<LabelDTO>> cloneNepenthesTypeGet(NepenthesType nepenthesType) {
        List<Label> labels = this.nepenthesRetrivalService.getNepenthesByNepenthesType(nepenthesType.getValue());
        return ResponseEntity.ok(this.labelToLabelDTO(labels));
    }



    public ResponseEntity<LabelClonesDTO> cloneNepenthesTypeNameGet(NepenthesType nepenthesType,
                                                                    String name) {
        Label label = this.nepenthesRetrivalService.getLabelWithClonesByLabelClassAndNepenthesNameAndCloneType(
                nepenthesType.getValue(),
                name, Clone.class.getSimpleName()
        );
        return ResponseEntity.ok(this.labelToLabelClonesDTO(label));
    }


    public List<LabelDTO> labelToLabelDTO(List<Label> labels) {
        List<LabelDTO> labelDTOList = new ArrayList<>(labels.size());
        labels.stream().forEach(label -> {
            labelDTOList.add(this.modelMapper.map(label, LabelDTO.class));
        });
        return labelDTOList;
    }


    public LabelClonesDTO labelToLabelClonesDTO(Label label) {

        LabelClonesDTO labelClonesDTO = new LabelClonesDTO();

        labelClonesDTO.setLabel(this.modelMapper.map(label, LabelDTO.class));
        List<CloneDTO> cloneDTOS = this.convertToCloneDTO(label);
        List<LabelClonesDTOClonesInner> inners = cloneDTOS.stream()
                .map(cloneDTO -> this.modelMapper.map(cloneDTO, LabelClonesDTOClonesInner.class))
                .collect(Collectors.toList());
        labelClonesDTO.setClones(inners);

        return labelClonesDTO;


    }
    public List<CloneDTO> convertToCloneDTO(Label label) {
        List<CloneDTO> cloneDTOS = new ArrayList<>();


        label.getCloneIcList().forEach(clone -> {
            CloneDTO cloneDTO = this.modelMapper.map(clone, CloneDTO.class);
            cloneDTOS.add(cloneDTO);
        });


        label.getCloneIVList().forEach(clone -> {
            CloneDTO cloneDTO = this.modelMapper.map(clone, CloneDTO.class);
            cloneDTOS.add(cloneDTO);
        });

        return cloneDTOS;
    }

}



