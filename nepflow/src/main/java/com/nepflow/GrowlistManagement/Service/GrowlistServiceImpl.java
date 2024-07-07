package com.nepflow.GrowlistManagement.Service;

import com.nepflow.GrowlistManagement.Model.Growlist;
import com.nepflow.GrowlistManagement.Model.Specimen;
import com.nepflow.GrowlistManagement.Repository.GrowlistRepository;
import com.nepflow.GrowlistManagement.Repository.SpecimenRepository;
import com.nepflow.NepenthesManagement.Model.Clones.Clone;
import com.nepflow.NepenthesManagement.Service.NepenthesManagementService;
import com.nepflow.NepenthesManagement.Service.NepenthesRetrivalService;
import com.nepflow.UserManagement.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
public class GrowlistServiceImpl implements Growlistservice {

    @Autowired
    GrowlistRepository growListRepository;

    @Autowired
    ImageService imageService;

    @Autowired
    SpecimenRepository specimenRepository;

    @Autowired
    NepenthesRetrivalService nepenthesRetrivalService;

    @Autowired
    NepenthesManagementService nepenthesManagementService;


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
        Clone clone = this.nepenthesRetrivalService.getCloneByInternalId(internalId);
        Specimen specimen = this.specimenRepository.addSpecimenToGrowlist(user.getOAuthId(),clone.getInternalCloneId());
        return specimen;
    }

    @Override
    @Transactional("transactionManager")
    public Specimen addNewIVCloneToGrowList(User user, String labelName, String cloneId, String sexAsString, String locationAsString, String producerAsString) {
        Clone clone = this.nepenthesManagementService.saveIVClone(labelName, cloneId, sexAsString, locationAsString, producerAsString);
        return this.addExistingCloneToGrowList(user,clone.getInternalCloneId());
    }

    @Override
    @Transactional("transactionManager")
    public Specimen addNewICCloneToGrowList(User user, String labelName, String cloneId, String sexAsString, String locationAsString, String sellerAsString) {
        Clone clone = this.nepenthesManagementService.saveICClone(labelName, sexAsString, locationAsString, sellerAsString);
        return this.addExistingCloneToGrowList(user,clone.getInternalCloneId());
    }

    /**
     * This Method is used to update the only values which are allowed to update on a species. This is the Image and also the Sex, but only if Sex is empty
     * @param oAuthId
     * @param specimenId
     * @param multipartFile
     * @param sexAsString
     * @return
     */
    @Override
    public boolean updateSpecimenImage(String oAuthId, String specimenId, MultipartFile multipartFile, String sexAsString){
        if(!this.specimenRepository.isSpeciesOfUser(oAuthId,specimenId)){
            return false;
        }

        Specimen specimen = this.specimenRepository.findSpecimenByUuid(specimenId);

        String imageLocation = null;
        if(specimen == null){
            return false;
        }
        imageLocation = specimen.getImageLocation();
        if(imageLocation == null || imageLocation.equals("")){
            return this.imageService.saveImageToStorageWebp(imageLocation,specimen.getUuid(),null);
        }else{

        }

        return false;
    }


}
