package com.nepflow.GrowlistManagement.Controller;

import com.nepflow.GrowlistManagement.Dto.CloneDTO;
import com.nepflow.GrowlistManagement.Dto.LabelSpecimenDTO;
import com.nepflow.GrowlistManagement.Dto.SpecimenCloneDTO;
import com.nepflow.GrowlistManagement.Model.Specimen;
import com.nepflow.GrowlistManagement.Service.Growlistservice;
import com.nepflow.GrowlistManagement.Dto.CloneType;
import com.nepflow.GrowlistManagement.Dto.LabelCloneDTO;
import com.nepflow.NepenthesManagement.Model.Labels.Label;
import com.nepflow.UserManagement.Model.User;
import com.nepflow.UserManagement.Service.AuthenticationService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

@Controller
public class GrowlistmanagementApiControllerImpl implements GrowlistmanagementApiDelegate {

    @Autowired
    AuthenticationService authenticationService;

    @Autowired
    Growlistservice growlistservice;

    @Autowired
    ModelMapper modelMapper;


    public ResponseEntity<SpecimenCloneDTO> growlistCloneAddInternalCloneIdPost(String internalCloneId) {
        User user = this.authenticationService.getAuthenticatedUser();
        SpecimenCloneDTO specimenCloneDTO;
        Specimen specimen = null;
        if (user == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new SpecimenCloneDTO());
        }
        specimen = this.growlistservice.addExistingCloneToGrowList(user, internalCloneId);
        specimenCloneDTO = this.modelMapper.map(specimen.getClone(), SpecimenCloneDTO.class);
        return ResponseEntity.ok(specimenCloneDTO);
    }

    public ResponseEntity<SpecimenCloneDTO> growlistCloneCreateCloneTypePost(CloneType cloneType,
                                                                  LabelCloneDTO labelCloneDTO) {
        User user = this.authenticationService.getAuthenticatedUser();
        if (user == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new SpecimenCloneDTO());
        }
        Specimen specimen = null;
        CloneDTO cloneDTO = labelCloneDTO.getClone();

        if (cloneType.equals(CloneType.ic)) {
            specimen = this.growlistservice.addNewICCloneToGrowList(user, labelCloneDTO.getLabel().getName(), cloneDTO.getCloneId(),
                    cloneDTO.getSex(), cloneDTO.getLocation(), cloneDTO.getProducer());
        } else {
            specimen = this.growlistservice.addNewIVCloneToGrowList(user, labelCloneDTO.getLabel().getName(), cloneDTO.getCloneId(),
                    cloneDTO.getSex(), cloneDTO.getLocation(), cloneDTO.getProducer());
        }

        if (specimen != null) {
            return ResponseEntity.ok(this.modelMapper.map(specimen, SpecimenCloneDTO.class));

        } else {
            return ResponseEntity.internalServerError().body(null);
        }
    }

}
