package com.nepflow.GrowlistManagement.Service;

import com.nepflow.BaseModules.ImageModule.Service.ImageService;
import com.nepflow.GrowlistManagement.Event.SpecimenFloweringEvent;
import com.nepflow.GrowlistManagement.Event.SpecimenStoppedFloweringEvent;
import com.nepflow.GrowlistManagement.Model.Growlist;
import com.nepflow.GrowlistManagement.Model.Specimen;
import com.nepflow.GrowlistManagement.Repository.GrowlistRepository;
import com.nepflow.GrowlistManagement.Repository.SpecimenRepository;
import com.nepflow.NepenthesManagement.Exception.CloneAlreadyHasASex;
import com.nepflow.NepenthesManagement.Model.Clones.Clone;
import com.nepflow.NepenthesManagement.Service.NepenthesManagementService;
import com.nepflow.NepenthesManagement.Service.NepenthesRetrievalService;
import com.nepflow.UserManagement.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

@Service
public class GrowlistServiceImpl implements Growlistservice {

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;


    @Autowired
    GrowlistRepository growListRepository;

    @Autowired
    ImageService imageService;

    @Autowired
    SpecimenRepository specimenRepository;

    @Autowired
    NepenthesRetrievalService nepenthesRetrievalService;

    @Autowired
    NepenthesManagementService nepenthesManagementService;

    @Value("${growlist.bucketname}")
    private String bucketname;

    @Value("${growlist.path}")
    private String path;


    @Override
    public void createGrowlist(User user) {
        this.growListRepository.save(new Growlist(user));
    }

    @Override
    public Growlist getGrowlist(String username) {
        return this.growListRepository.findGrowlistByUsername(username);
    }

    @Override
    public Specimen addExistingCloneToGrowList(User user, String internalId) {
        Specimen specimen = null;
        Clone clone = this.nepenthesRetrievalService.getCloneByInternalId(internalId);
        if (clone != null) {
            specimen = this.specimenRepository.addSpecimenToGrowlistAndUserReturnSpecimenWithoutUser(user.getOAuthId(), clone.getInternalCloneId());
        }

        return specimen;
    }

    @Override
    @Transactional("transactionManager")
    public Specimen addNewIVCloneToGrowList(User user, String labelName, String cloneId, String sexAsString, String locationAsString, String producerAsString) {
        Clone clone = this.nepenthesManagementService.saveIVClone(labelName, cloneId, sexAsString, locationAsString, producerAsString);
        return this.addExistingCloneToGrowList(user, clone.getInternalCloneId());
    }

    @Override
    @Transactional("transactionManager")
    public Specimen addNewICCloneToGrowList(User user, String labelName, String cloneId, String sexAsString, String locationAsString, String sellerAsString) {
        Clone clone = this.nepenthesManagementService.saveICClone(labelName, sexAsString, locationAsString, sellerAsString);
        return this.addExistingCloneToGrowList(user, clone.getInternalCloneId());
    }

    @Override
    public boolean updateSpecimenImage(String oAuthId, String specimenId, MultipartFile multipartFile) {
        Specimen specimen = this.specimenRepository.findSpecimenByUuid(specimenId);
        String location;
        if (specimen == null || !specimen.getUser().getOAuthId().equals(oAuthId)) {
            return false;
        }

        try {
            location = this.imageService.saveImageToStorageWebp(
                    this.bucketname,
                    this.path, multipartFile.getOriginalFilename(),
                    multipartFile);
        } catch (IOException | NoSuchAlgorithmException | RuntimeException e) {
            return false;
        }
        specimen.setImagePath(location);
        this.specimenRepository.save(specimen);
        return true;
    }

    public boolean updateFlowerStatus(User user, String specimenId, boolean isFlowering) {
        Specimen specimen = this.specimenRepository.findSpecimenByUuid(specimenId);
        if (specimen == null || !specimen.getUser().equals(user)) {
            return false;
        }
        if (specimen.getFlowerStatus() == isFlowering) {
            return false;
        } else {
            specimen.setFlowerStatus(isFlowering);
            this.specimenRepository.save(specimen);
        }

        if (isFlowering) {
            applicationEventPublisher.publishEvent(new SpecimenFloweringEvent(this, specimen, user));
        } else {
            applicationEventPublisher.publishEvent(new SpecimenStoppedFloweringEvent(this, specimen, user));
        }


        return true;
    }

    @Override
    public boolean updateSex(String oAuthId, String specimenId, String sexAsString) {
        Specimen specimen = specimenRepository.findSpecimenByUuid(specimenId);

        if (specimen == null || !specimen.getUser().getOAuthId().equals(oAuthId)) {
            return false;
        }

        try {
            Clone clone = nepenthesManagementService.getOrCreateSexedClone(specimen.getClone(), sexAsString);
            if (clone != null) {
                specimen.setClone(clone);
                specimenRepository.save(specimen);
                return true;
            }
        } catch (CloneAlreadyHasASex e) {
            return false;
        }

        return false;
    }

    @Override
    public boolean updateGrowlistVisibility(String OAuthId, String growlistId, boolean isPublic) {
        return this.growListRepository.updateGrowlistVisibility(OAuthId, growlistId, isPublic);
    }

    @Override
    public boolean deleteSpecimenFromGrowlist(User user, String specimenId) {
        Specimen specimen = specimenRepository.findSpecimenByUuid(specimenId);
        String imageLocation;
        if (specimen == null) {
            return false;
        }
        imageLocation = specimen.getImagePath();
        if (!specimen.isSpecimenOwner(user)) {
            return false;
        }
        this.specimenRepository.delete(specimen);
        this.imageService.deleteImage(bucketname, imageLocation);

        return true;
    }


}
