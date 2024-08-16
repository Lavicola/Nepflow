package com.nepflow.GrowlistManagement.Controller;

import com.nepflow.BaseModules.ImageModule.Service.ImageService;
import com.nepflow.GrowlistManagement.Dto.*;
import com.nepflow.GrowlistManagement.Model.Growlist;
import com.nepflow.GrowlistManagement.Model.Specimen;
import com.nepflow.GrowlistManagement.Service.Growlistservice;
import com.nepflow.UserManagement.Model.User;
import com.nepflow.UserManagement.Service.AuthenticationService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class GrowlistmanagementApiControllerImpl implements GrowlistmanagementApiDelegate {

    @Autowired
    AuthenticationService authenticationService;

    @Autowired
    Growlistservice growlistservice;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    ImageService imageService;


    public ResponseEntity<GrowlistDTO> growlistUsernameClonesGet(String username) {

        User user = this.authenticationService.getAuthenticatedUser();
        if (user == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new GrowlistDTO());
        }
        Growlist growlist = this.growlistservice.getGrowlist(username);
        if (growlist != null && (growlist.isPublic() || user.getUsername().equals(username))) {
            return ResponseEntity.status(HttpStatus.OK).body(this.modelMapper.map(growlist, GrowlistDTO.class));
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new GrowlistDTO());


    }

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

    public ResponseEntity<SpecimenCloneDTO> growlistCreateCloneCloneTypePost(CloneType cloneType,
                                                                             LabelCloneDTO labelCloneDTO) {
        User user = this.authenticationService.getAuthenticatedUser();
        if (user == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new SpecimenCloneDTO());
        }
        Specimen specimen = null;
        CloneDTO cloneDTO = labelCloneDTO.getClone();

        if (cloneType.equals(CloneType.ic)) {
            specimen = this.growlistservice.addNewICCloneToGrowList(user, labelCloneDTO.getLabel().getNepenthesName(), cloneDTO.getCloneId(),
                    cloneDTO.getSex(), cloneDTO.getLocation(), cloneDTO.getProducer());
        } else {
            specimen = this.growlistservice.addNewIVCloneToGrowList(user, labelCloneDTO.getLabel().getNepenthesName(), cloneDTO.getCloneId(),
                    cloneDTO.getSex(), cloneDTO.getLocation(), cloneDTO.getProducer());
        }

        if (specimen != null) {
            return ResponseEntity.ok(this.modelMapper.map(specimen, SpecimenCloneDTO.class));

        } else {
            return ResponseEntity.internalServerError().body(null);
        }
    }

    public ResponseEntity<Void> specimensSpecimenIdImagePut(String specimenId, MultipartFile file) {
        User user = this.authenticationService.getAuthenticatedUser();
        boolean isSuccess = false;
        if (user == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
        isSuccess = this.growlistservice.updateSpecimenImage(user.getOAuthId(), specimenId, file);
        if (isSuccess) {
            return ResponseEntity.ok(null);
        } else {
            return ResponseEntity.internalServerError().body(null);
        }

    }

    public ResponseEntity<SpecimenUpdateSex> specimensSpecimenIdSexPatch(String specimenId,
                                                                         SpecimenUpdateSex specimenUpdateSex) {

        User user = this.authenticationService.getAuthenticatedUser();
        boolean isSuccess;
        if (user == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
        isSuccess = this.growlistservice.updateSex(user.getOAuthId(), specimenId, specimenUpdateSex.getSex());
        if (isSuccess) {
            return ResponseEntity.ok(specimenUpdateSex);
        }

        return ResponseEntity.internalServerError().body(null);

    }

    public ResponseEntity<SpecimenUpdateFlowerStatus> specimensSpecimenIdFloweringPatch(String specimenId, SpecimenUpdateFlowerStatus specimenUpdateSex) {
        User user = this.authenticationService.getAuthenticatedUser();
        SpecimenUpdateFlowerStatus flowerStatus = new SpecimenUpdateFlowerStatus();
        boolean isSuccess = false;
        if (user == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
        isSuccess = this.growlistservice.updateFlowerStatus(user, specimenId, specimenUpdateSex.getIsFlowering());
        if (isSuccess) {
            flowerStatus.setIsFlowering(specimenUpdateSex.getIsFlowering());
            return ResponseEntity.ok(flowerStatus);
        } else {
            return ResponseEntity.internalServerError().body(null);
        }


    }

    public ResponseEntity<GrowlistPublic> growlistGrowlistIdPublicPatch(String growlistId,
                                                                        GrowlistPublic growlistPublic) {
        User user = this.authenticationService.getAuthenticatedUser();
        if (user == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }

        boolean isSuccess;
        isSuccess = this.growlistservice.updateGrowlistVisibility(user.getOAuthId(), growlistId, growlistPublic.getIsPublic());

        return isSuccess ? ResponseEntity.ok().body(growlistPublic) : ResponseEntity.internalServerError().body(null);

    }

    public ResponseEntity<SpecimenCloneDTO> specimensSpecimenIdGet(String specimenId) {

        return null;

    }

    public ResponseEntity<Void> specimensSpecimenIdDelete(String specimenId) {
        User user = this.authenticationService.getAuthenticatedUser();
        boolean isSuccess;
        if (user == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
        isSuccess = this.growlistservice.deleteSpecimenFromGrowlist(user, specimenId);

        return isSuccess ? ResponseEntity.ok().body(null) : ResponseEntity.internalServerError().body(null);


    }

}
