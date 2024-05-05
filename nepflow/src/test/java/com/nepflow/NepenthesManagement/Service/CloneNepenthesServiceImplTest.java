package com.nepflow.NepenthesManagement.Service;

import com.nepflow.NepenthesManagement.Model.Clone;
import com.nepflow.NepenthesManagement.Model.ICClone;
import com.nepflow.NepenthesManagement.Model.Nepenthes;
import com.nepflow.NepenthesManagement.Repository.CloneRepository;
import com.nepflow.NepenthesManagement.Repository.NepenthesRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CloneNepenthesServiceImplTest {

    @Mock
    NepenthesRepository nepenthesRepository;

    @Mock
    CloneRepository cloneRepository;

    @InjectMocks
    CloneNepenthesServiceImpl cloneNepenthesService;

    Nepenthes villosa = new Nepenthes("villosa");
    Clone clone = new ICClone("BE-5555", villosa);


    @Test
    public void createNewIndividualCloneTest() {
        boolean isCreated;
        boolean isCreated2;
        isCreated = this.cloneNepenthesService.createNewNepenthesIndividualClone(clone.getCloneId(), clone.getNepenthes().getName());
        when(cloneRepository.existsByCloneIdAndNepenthesName(clone.getCloneId(), clone.getNepenthes().getName())).thenReturn(true);
        isCreated2 = this.cloneNepenthesService.createNewNepenthesIndividualClone(clone.getCloneId(), clone.getNepenthes().getName());

        assertTrue(isCreated);
        assertFalse(isCreated2);

        Mockito.verify(cloneRepository, times(1)).save(Mockito.any());

    }



}
