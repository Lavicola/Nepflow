package com.nepflow.NepenthesManagement.Controller;

import com.nepflow.NepenthesManagement.Dto.CloneDTO;
import com.nepflow.NepenthesManagement.Dto.HybridCloneDTO;
import com.nepflow.NepenthesManagement.Dto.LabelDTO;
import com.nepflow.NepenthesManagement.Model.Clones.*;
import com.nepflow.NepenthesManagement.Model.Labels.Label;
import com.nepflow.NepenthesManagement.Model.Labels.MultiHybrid;
import com.nepflow.NepenthesManagement.Model.Labels.Nepenthes;
import com.nepflow.NepenthesManagement.Model.Labels.PrimaryHybrid;
import com.nepflow.NepenthesManagement.Service.NepenthesRetrivalService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller
public class NepenthesManagementControllerImpl implements NepenthesManagementApiDelegate {


    @Autowired
    NepenthesRetrivalService nepenthesRetrivalService;

    @Autowired
    ModelMapper modelMapper;

    public ResponseEntity<List<LabelDTO>> nepenthesGet() {
        List<Label> labels = this.nepenthesRetrivalService.getLabelsByLabelname(Nepenthes.class.getSimpleName());
        List<LabelDTO> nepenthes = new ArrayList<>(labels.size());
        labels.stream().forEach(label -> {
            LabelDTO labelDTO = this.modelMapper.map(label, LabelDTO.class);
            nepenthes.add(labelDTO);
        });
        return ResponseEntity.ok(nepenthes);
    }

    public ResponseEntity<List<CloneDTO>> cloneSpeciesGet() {
        List<Label> labels = this.nepenthesRetrivalService.getClonesByLabelClass(Nepenthes.class.getSimpleName());
        return ResponseEntity.ok(convertToCloneDTO(labels));
    }

    public ResponseEntity<List<CloneDTO>> cloneSpeciesIvGet() {
        List<Label> labels = this.nepenthesRetrivalService.getClonesByLabelClassAndCloneClass(Nepenthes.class.getSimpleName(), IVNepenthesClone.class.getSimpleName());
        return ResponseEntity.ok(convertToCloneDTO(labels));
    }

    public ResponseEntity<List<CloneDTO>> cloneSpeciesIcGet() {
        List<Label> labels = this.nepenthesRetrivalService.getClonesByLabelClassAndCloneClass(Nepenthes.class.getSimpleName(), ICNepenthesClone.class.getSimpleName());
        return ResponseEntity.ok(convertToCloneDTO(labels));
    }

    public ResponseEntity<List<HybridCloneDTO>> clonePrimaryHybridsGet() {
        List<Label> labels = this.nepenthesRetrivalService.getClonesByLabelClassAndCloneClass(PrimaryHybrid.class.getSimpleName(), ICNepenthesClone.class.getSimpleName());

        return ResponseEntity.ok(convertToHybridCloneDTO(labels));

    }


    public ResponseEntity<List<HybridCloneDTO>> clonePrimaryHybridsIvGet() {
        List<Label> labels = this.nepenthesRetrivalService.getClonesByLabelClassAndCloneClass(PrimaryHybrid.class.getSimpleName(), IVPrimaryHybrid.class.getSimpleName());

        return ResponseEntity.ok(convertToHybridCloneDTO(labels));

    }

    public ResponseEntity<List<HybridCloneDTO>> clonePrimaryHybridsIcGet() {
        return ResponseEntity.ok(convertToHybridCloneDTO(this.nepenthesRetrivalService.getClonesByLabelClassAndCloneClass(PrimaryHybrid.class.getSimpleName(), ICPrimaryHybrid.class.getSimpleName())));

    }


    public ResponseEntity<List<HybridCloneDTO>> cloneMultiHybridGet() {
        List<Label> labels = this.nepenthesRetrivalService.getClonesByLabelClass(MultiHybrid.class.getSimpleName());

        return ResponseEntity.ok(convertToHybridCloneDTO(labels));

    }


    public ResponseEntity<List<HybridCloneDTO>> cloneMultiHybridIvGet() {
        List<Label> labels = this.nepenthesRetrivalService.getClonesByLabelClassAndCloneClass(MultiHybrid.class.getSimpleName(), IVMultiHybrid.class.getSimpleName());

        return ResponseEntity.ok(convertToHybridCloneDTO(labels));

    }

    public ResponseEntity<List<HybridCloneDTO>> cloneMultiHybridIcGet() {
        List<Label> labels = this.nepenthesRetrivalService.getClonesByLabelClassAndCloneClass(MultiHybrid.class.getSimpleName(), ICMultiHybrid.class.getSimpleName());

        return ResponseEntity.ok(convertToHybridCloneDTO(labels));

    }

    public List<CloneDTO> convertToCloneDTO(List<Label> labels) {
        List<CloneDTO> cloneDTOS = new ArrayList<>();


        labels.stream().forEach(label -> {
            label.getCloneIcList().forEach(clone -> {
                CloneDTO cloneDTO = this.modelMapper.map(clone, CloneDTO.class);
                cloneDTO.setLabel(this.modelMapper.map(label, LabelDTO.class));
                cloneDTOS.add(cloneDTO);
            });
        });

        labels.stream().forEach(label -> {
            label.getCloneIVList().forEach(clone -> {
                CloneDTO cloneDTO = this.modelMapper.map(clone, CloneDTO.class);
                cloneDTO.setLabel(this.modelMapper.map(label, LabelDTO.class));
                cloneDTOS.add(cloneDTO);
            });
        });
        return cloneDTOS;
    }

    public List<HybridCloneDTO> convertToHybridCloneDTO(List<Label> labels) {
        List<HybridCloneDTO> cloneDTOS = new ArrayList<>();


        labels.stream().forEach(label -> {
            label.getCloneIcList().forEach(clone -> {
                HybridCloneDTO cloneDTO = this.modelMapper.map(clone, HybridCloneDTO.class);
                cloneDTO.setLabel(this.modelMapper.map(label, LabelDTO.class));
                cloneDTOS.add(cloneDTO);
            });
        });

        labels.stream().forEach(label -> {
            label.getCloneIVList().forEach(clone -> {
                HybridCloneDTO cloneDTO = this.modelMapper.map(clone, HybridCloneDTO.class);
                cloneDTO.setLabel(this.modelMapper.map(label, LabelDTO.class));
                cloneDTOS.add(cloneDTO);
            });
        });
        return cloneDTOS;
    }


}