package guru.springframework.sfgtrainingpetclinic.services.springdatajpa;

import guru.springframework.sfgtrainingpetclinic.model.Owner;
import guru.springframework.sfgtrainingpetclinic.repositories.OwnerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {
    @InjectMocks
    OwnerSDJpaService service;
    @Mock
    OwnerRepository ownerRepository;
    Owner buur;
    Set<Owner> geeruSalum;

    @BeforeEach
    void setUp() {
        buur = Owner.builder().id(1L).firstName("Macodou").lastName("N'diaye").address("1 yoonu Saloum")
                .city("Ngasobyl").telephone("764527859").build();
        Owner lingeer = Owner.builder().id(2L).firstName("Yandé").lastName("Ndiaye").address("2 yoonu Saloum")
                .city("Ngasobyl").telephone("764527859").build();
        geeruSalum = new HashSet<>(Arrays.asList(buur, lingeer));
    }

    @Test
    void findAll() {
        // given
        given(ownerRepository.findAll()).willReturn(geeruSalum);
        // when
        Set<Owner> foundOwners = service.findAll();
        // then
        assertEquals(geeruSalum, foundOwners);
    }

    @Test
    void findById() {
        // given
        given(ownerRepository.findById(1L)).willReturn(Optional.of(buur));
        // when
        Owner foundOwner = service.findById(1L);
        // then
        assertEquals(buur, foundOwner);
    }

    @Test
    void save() {
        // given
        given(ownerRepository.save(buur)).willReturn(buur);
        // when
        Owner savedOwner = service.save(buur);
        // then
        assertEquals(buur, savedOwner);
    }

    @Test
    void delete() {
        service.delete(buur);
        verify(ownerRepository).delete(any());
    }

    @Test
    void deleteById() {
        service.deleteById(1L);
        verify(ownerRepository).deleteById(anyLong());
    }

    @Test
    void findByLastName() {
        // given
        given(ownerRepository.findByLastName("N'diaye")).willReturn(buur);
        // when
        Owner foundOwner = service.findByLastName("N'diaye");
        // then
        assertEquals(buur, foundOwner);
    }
}
