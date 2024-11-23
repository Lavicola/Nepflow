package com.nepflow.GrowlistManagement.Service;

import com.nepflow.BaseModules.ImageModule.Service.BucketImageService;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Model which defines Methods in order
 * to return the right Label class at runtime.
 *
 * @author David Schmidt
 * @version 21. Nov 2024
 */

@Service
public class GrowlistServiceImpl implements Growlistservice {

    /**
     *
     */
    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;


    /**
     *
     */
    @Autowired
    private GrowlistRepository growListRepository;

    /**
     *
     */
    @Autowired
    private BucketImageService bucketImageService;

    /**
     *
     */
    @Autowired
    private SpecimenRepository specimenRepository;

    /**
     *
     */
    @Autowired
    private NepenthesRetrievalService nepenthesRetrievalService;

    /**
     *
     */
    @Autowired
    private NepenthesManagementService nepenthesManagementService;

    /**
     *
     */
    @Value("${growlist.bucketname}")
    private String bucketname;

    /**
     *
     */
    @Value("${growlist.path}")
    private String path;


    /**
     * @param user
     */
    @Override
    public void createGrowlist(final User user) {
        this.growListRepository.save(new Growlist(user));
    }

    /**
     * @param username
     * @return
     */
    @Override
    public Growlist getGrowlist(final String username) {
        return this.growListRepository.findGrowlistByUsername(username);
    }


    /**
     * @param user            User which will be referenced in the created Specimen
     * @param internalCloneId clone (primary key) which will be referenced in the created Specimen
     * @return Specimen
     */
    @Override
    @Transactional("transactionManager")
    public Specimen addExistingCloneToGrowList(final User user, final String internalCloneId) {
        Specimen specimen = null;
        Clone clone = this.nepenthesRetrievalService.getCloneByInternalCloneId(internalCloneId);
        if (clone != null) {
            specimen = this.specimenRepository.addSpecimenToGrowlistAndUserReturnSpecimenWithoutUser(user.getOAuthId(), clone.getInternalCloneId());
        }

        return specimen;
    }

    /**
     * Method to add a List of clone to the User. By default all added clones will have unknown sex.
     *
     * @param user             User which will be referenced in the created Specimen
     * @param internalCloneIds clones (primary key) which will be referenced in the created Specimens
     * @return Specimen
     */
    @Override
    @Transactional("transactionManager")
    public List<Specimen> addExistingClonesToGrowlist(final User user, final List<String> internalCloneIds) {
        Map<String, Long> cloneMap = internalCloneIds.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        String growlistId = this.growListRepository.getGrowlistIdByUserId(user.getOAuthId());
        if (growlistId == null) {
            return new ArrayList<>(0);
        }
        Growlist growlist = this.growListRepository.findById(growlistId).get();
        List<Clone> clones = this.nepenthesRetrievalService.getClonesByInternalCloneId(cloneMap.keySet().stream()
                .map(cloneId -> Clone.generateInternalCloneId(cloneId, null))
                .collect(Collectors.toSet()));
        List<Specimen> specimenList = new ArrayList<>(internalCloneIds.size());
        for (Clone clone : clones) {
            for (int i = 0; i < cloneMap.get(clone.getInternalCloneId()); i++) {
                Specimen specimen = new Specimen(clone, user);
                growlist.addSpecimen(specimen);
                specimenList.add(specimen);
            }
        }
        this.growListRepository.save(growlist);
        return specimenList;
    }


    /**
     * @param user             User which will be referenced in the created Specimen
     * @param labelName        name to retrieve the corresponding Label for the clone reference
     * @param cloneId          id of the clone
     * @param sexAsString      sex of the clone
     * @param locationAsString location of the clone
     * @param producerAsString producer name of the clone
     * @return Specimen
     */
    @Override
    @Transactional("transactionManager")
    public Specimen addNewIVCloneToGrowList(final User user, final String labelName, final String cloneId, final String sexAsString, final String locationAsString, String producerAsString) {
        Clone clone = this.nepenthesManagementService.saveIVClone(labelName, cloneId, sexAsString, locationAsString, producerAsString);
        return this.addExistingCloneToGrowList(user, clone.getInternalCloneId());
    }

    /**
     * @param user             User which will be referenced in the created Specimen
     * @param labelName        name to retrieve the corresponding Label for the clone reference
     * @param cloneId          id of the clone
     * @param sexAsString      sex of the clone
     * @param locationAsString location of the clone
     * @param sellerAsString   seller name of the clone
     * @return Specimen
     */
    @Override
    @Transactional("transactionManager")
    public Specimen addNewICCloneToGrowList(final User user, final String labelName, final String cloneId, final String sexAsString, final String locationAsString, final String sellerAsString) {
        Clone clone = this.nepenthesManagementService.saveICClone(labelName, sexAsString, locationAsString, sellerAsString);
        return this.addExistingCloneToGrowList(user, clone.getInternalCloneId());
    }

    /**
     * @param oAuthId       id(primary key) of the user
     * @param specimenId    specimen id (primary key) of the specimen
     * @param multipartFile file containing image and metadata
     * @return true if success, else false
     */
    @Override
    public boolean updateSpecimenImage(final String oAuthId, final String specimenId, final MultipartFile multipartFile) {
        Specimen specimen = this.specimenRepository.findSpecimenByUuid(specimenId);
        String location;
        if (specimen == null || !specimen.getUser().getOAuthId().equals(oAuthId)) {
            return false;
        }

        try {
            location = this.bucketImageService.convertAndSaveImageRoutine(this.bucketname, this.path, multipartFile.getOriginalFilename(), multipartFile);
        } catch (IOException | NoSuchAlgorithmException | RuntimeException e) {
            return false;
        }
        specimen.setImagePath(location);
        this.specimenRepository.save(specimen);
        return true;
    }

    /**
     * @param user        User which initiated the request
     * @param specimenId  id(primary key) of the specimen to change the flower status
     * @param isFlowering true if flowering, else false
     * @return true if success, else false
     */
    public boolean updateFlowerStatus(final User user, final String specimenId, final boolean isFlowering) {
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

    /**
     * @param oAuthId     id(primary key) of the user
     * @param specimenId  id(primary key) of the specimen to change the flower status
     * @param sexAsString sex as String value
     * @return true if success, else false
     */
    @Override
    public boolean updateSex(final String oAuthId, final String specimenId, final String sexAsString) {
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

    /**
     * @param oAuthId    id(primary key) of the user which initiated the request
     * @param growlistId id(primary key) of the growlist
     * @param isPublic   true if public, false for private
     * @return true if success, else false
     */
    @Override
    public boolean updateGrowlistVisibility(final String oAuthId, final String growlistId, final boolean isPublic) {
        return this.growListRepository.updateGrowlistVisibility(oAuthId, growlistId, isPublic);
    }

    /**
     * @param user       User which initiated the request
     * @param specimenId id(primary key of the Specimen)
     * @return true if success, else false
     */
    @Override
    public boolean deleteSpecimenFromGrowlist(final User user, final String specimenId) {
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
        this.bucketImageService.deleteImage(bucketname, imageLocation);

        return true;
    }


}
