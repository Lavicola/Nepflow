package com.nepflow.NepenthesManagement.Controller;

import com.nepflow.NepenthesManagement.Dto.*;
import com.nepflow.NepenthesManagement.Model.Clones.*;
import com.nepflow.NepenthesManagement.Model.Labels.Label;
import com.nepflow.NepenthesManagement.Model.Labels.MultiHybrid;
import com.nepflow.NepenthesManagement.Model.Labels.PrimaryHybrid;
import com.nepflow.NepenthesManagement.Model.Labels.Species;
import com.nepflow.NepenthesManagement.Service.NepenthesRetrievalService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * API Controller Method Implementation for the Nepenthesmanagement API.
 * to return the right Label class at runtime.
 *
 * @author David Schmidt
 * @version 14. Nov 2024
 */
@Controller
public class NepenthesApiControllerImpl implements NepenthesApiDelegate {

    /*** Service to retrieve Clones and Labels.*/
    @Autowired
    private NepenthesRetrievalService nepenthesRetrievalService;

    /*** ModelMapper. */
    @Autowired
    @Qualifier("modelMapperNepenthes")
    private ModelMapper modelMapper;

    /**
     * central Mapping to convert a LabelType/NepenthesType and CloneType to a string.
     **/
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

    /**
     * @param nepenthesType also called LabelType
     * @param cloneType     IV or IC
     * @return string representation of the CloneType
     */
    public static String resolveCloneType(final String nepenthesType, final String cloneType) {
        Map<String, String> cloneTypeMap = NEPENTHES_TYPE_MAP.get(nepenthesType);
        if (cloneTypeMap != null) {
            return cloneTypeMap.getOrDefault(cloneType, cloneTypeMap.get("default"));
        }
        return cloneType;
    }

    /**
     * Controller Implementation to return a Label and all its Clone depending on the Arguments.
     *
     * @param nepenthesType
     * @param cloneType
     * @param name
     * @return DTO Object containing the Label and Clones depending on the Argument
     */
    public ResponseEntity<LabelClonesDTO> cloneNepenthesTypeCloneTypeNameGet(final NepenthesType nepenthesType,
                                                                             final CloneType cloneType,
                                                                             final String name) {


        Label label = this.nepenthesRetrievalService.getLabelWithClonesByLabelClassAndNepenthesNameAndCloneType(
                nepenthesType.getValue(),
                name, resolveCloneType(nepenthesType.getValue(), cloneType.getValue())
        );

        return ResponseEntity.ok(this.labelToLabelClonesDTO(label));
    }


    public ResponseEntity<List<CloneDTO>> clonesGet(List<String> cloneIds) {
        List<CloneDTO> dtoClones = new ArrayList<>();


        if (cloneIds.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(dtoClones);
        }
        List<Clone> clones = this.nepenthesRetrievalService.getClonesByCloneId(cloneIds);
        clones.stream().forEach(clone -> {
            dtoClones.add(this.modelMapper.map(clone, CloneDTO.class));
        });
        return ResponseEntity.status(HttpStatus.OK).body(dtoClones);

    }





    /**
     * Method to return all Labels of a specific subclass.
     *
     * @param nepenthesType Label subclass type
     * @return
     */
    public ResponseEntity<List<LabelDTO>> cloneNepenthesTypeGet(final NepenthesType nepenthesType) {
        List<Label> labels = this.nepenthesRetrievalService.getLabelsByNepenthesType(nepenthesType.getValue());
        return ResponseEntity.ok(this.labelToLabelDTO(labels));
    }


    /**
     * @param nepenthesType Label subclass type (used to reduce search space)
     * @param name          Name of the Nepenthes
     * @return A Label and all of it´s clones
     */
    public ResponseEntity<LabelClonesDTO> cloneNepenthesTypeNameGet(NepenthesType nepenthesType,
                                                                    String name) {
        Label label = this.nepenthesRetrievalService.getLabelWithClonesByLabelClassAndNepenthesNameAndCloneType(
                nepenthesType.getValue(),
                name, Clone.class.getSimpleName()
        );
        return ResponseEntity.ok(this.labelToLabelClonesDTO(label));
    }


    /**
     * Helper Method to convert a list of Labels to their DTO representation.
     *
     * @param labels list of Labels
     * @return DTO representation of a List of Label
     */
    public List<LabelDTO> labelToLabelDTO(final List<Label> labels) {
        List<LabelDTO> labelDTOList = new ArrayList<>(labels.size());
        labels.stream().forEach(label -> {
            labelDTOList.add(this.modelMapper.map(label, LabelDTO.class));
        });
        return labelDTOList;
    }


    /**
     * Helper Method to convert a list of Labels and their Clones to a DTO representation.
     *
     * @param label a Label and it´s clones
     * @return DTO representation of a Label and it´s clones
     */
    public LabelClonesDTO labelToLabelClonesDTO(Label label) {
        if (label == null) {
            return new LabelClonesDTO();
        }

        LabelClonesDTO labelClonesDTO = new LabelClonesDTO();
        labelClonesDTO.setLabel(this.modelMapper.map(label, LabelDTO.class));
        List<CloneDTO> cloneDTOS = this.convertToCloneDTO(label);
        List<CloneDTO> clones = cloneDTOS.stream()
                .map(cloneDTO -> this.modelMapper.map(cloneDTO, CloneDTO.class))
                .collect(Collectors.toList());
        labelClonesDTO.setClones(clones);

        return labelClonesDTO;


    }

    /**
     * Helper Method to convert the Clones of a Label to their DTO Representation.
     *
     * @param label a Label and their clone references
     * @return DTO Representation of the Clones
     */
    public List<CloneDTO> convertToCloneDTO(Label label) {
        String nepenthesName = label.getName();

        List<CloneDTO> cloneDTOS = new ArrayList<>();
        label.getCloneIcList().forEach(clone -> {
            CloneDTO cloneDTO = this.modelMapper.map(clone, CloneDTO.class);
            cloneDTO.setNepenthesName(nepenthesName);
            cloneDTOS.add(cloneDTO);
        });


        label.getCloneIVList().forEach(clone -> {
            CloneDTO cloneDTO = this.modelMapper.map(clone, CloneDTO.class);
            cloneDTO.setNepenthesName(nepenthesName);
            cloneDTOS.add(cloneDTO);
        });

        return cloneDTOS;
    }


}



