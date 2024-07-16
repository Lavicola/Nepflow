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
            return ResponseEntity.status(HttpStatus.OK).body(this.convertGrowlistToDTO(growlist));
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
        return ResponseEntity.internalServerError().body(null);

    }

    public ResponseEntity<SpecimenUpdateFlowerStatus> specimensSpecimenIdFloweringPatch(String specimenId, SpecimenUpdateFlowerStatus specimenUpdateSex) {
        User user = this.authenticationService.getAuthenticatedUser();
        SpecimenUpdateFlowerStatus flowerStatus = new SpecimenUpdateFlowerStatus();
        boolean isSuccess = false;
        if (user == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
        isSuccess = this.growlistservice.updateFlowerStatus(user.getOAuthId(), specimenId, specimenUpdateSex.getIsFlowering());
        if (isSuccess) {
            flowerStatus.setIsFlowering(specimenUpdateSex.getIsFlowering());
            return ResponseEntity.ok(flowerStatus);
        } else {
            return ResponseEntity.internalServerError().body(null);
        }


    }

    public ResponseEntity<Void> growlistGrowlistIdPublicPatch(String growlistId,
                                                              GrowlistPublic growlistPublic) {

        System.out.println("CALLL");

        return ResponseEntity.ok(null);
    }

    public ResponseEntity<SpecimenCloneDTO> growlistClonesSpecimenIdGet(String specimenId) {

        return null;

    }


    private GrowlistDTO convertGrowlistToDTO(Growlist growlist) {
        GrowlistDTO growlistDTO = new GrowlistDTO();
        SpecimenCloneDTO specimenCloneDTO;
        if (growlist == null) {
            return growlistDTO;
        }
        for (Specimen specimen : growlist.getSpecimens()) {
            specimenCloneDTO = new SpecimenCloneDTO();
            specimenCloneDTO.setCloneId(specimen.getClone().getCloneId());
            specimenCloneDTO.setSpecimenId(specimen.getUuid());
            specimenCloneDTO.setLocation(specimen.getClone().getLocationAsString());
            specimenCloneDTO.setSex(specimen.getClone().getSexAsString());
            specimenCloneDTO.setProducer(specimen.getClone().getSellerAsString());
            specimenCloneDTO.setNepenthesName(specimen.getClone().getLabelName());
            specimenCloneDTO.setFilelocation(specimen.getImagePath());
            specimenCloneDTO.setIsFlowering(specimen.getFlowerStatus());
            growlistDTO.addSpecimensItem(specimenCloneDTO);

        }


        return growlistDTO;
    }


}
