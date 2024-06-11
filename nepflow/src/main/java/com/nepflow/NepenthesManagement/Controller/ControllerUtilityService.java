package com.nepflow.NepenthesManagement.Controller;

import com.nepflow.NepenthesManagement.Dto.CloneDTO;
import com.nepflow.NepenthesManagement.Dto.LabelClonesDTO;
import com.nepflow.NepenthesManagement.Dto.LabelClonesDTOClonesInner;
import com.nepflow.NepenthesManagement.Dto.LabelDTO;
import com.nepflow.NepenthesManagement.Model.Labels.Label;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Most Controllers need the same Mapping, instead configuring ModelMapper for the specific Types
 * This Service is used by the Controllers to convert the Objects for now
 */

@Service
public class ControllerUtilityService {

    @Autowired
    ModelMapper modelMapper;

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
