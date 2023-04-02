package guru.springframework.sfgtrainingpetclinic.services.map;

import guru.springframework.sfgtrainingpetclinic.model.Owner;
import guru.springframework.sfgtrainingpetclinic.model.Pet;
import guru.springframework.sfgtrainingpetclinic.model.PetType;
import guru.springframework.sfgtrainingpetclinic.services.PetService;
import guru.springframework.sfgtrainingpetclinic.services.PetTypeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class OwnerMapServiceTest {
    @InjectMocks
    OwnerMapService service;
    @Mock
    PetService petService;
    @Mock
    PetTypeService petTypeService;
    @Spy
    HashMap<Long, Owner> map;
    Set<Owner> geeruSalum;
    Owner buur;

    @BeforeEach
    void setUp() {
        service.setMap(map);
        buur = Owner.builder().id(1L).firstName("Macodou").lastName("N'diaye").address("1 yoonu Saloum")
                .city("Ngasobyl").telephone("764527859").build();
        Owner lingeer = Owner.builder().id(2L).firstName("Yandé").lastName("Ndiaye").address("2 yoonu Saloum")
                .city("Ngasobyl").telephone("764527859").build();
        geeruSalum = new HashSet<>(Arrays.asList(buur, lingeer));
    }

    @Test
    void findAll() {
        // given
        given(map.values()).willReturn(geeruSalum);
        // when
        Set<Owner> owners = service.findAll();
        // then
        assertEquals(geeruSalum, owners);
    }

    @Test
    void deleteById() {
        // given
        map.put(1L, buur);
        assertEquals(1, map.values().size());
        // when
        service.deleteById(1L);
        // then
        assertEquals(0, map.values().size());
    }

    @Test
    void delete() {
        // given
        map.put(1L, buur);
        // when
        service.delete(buur);
        // then
        assertEquals(0, map.values().size());
    }

    @Test
    void save() {
        // given
        PetType fowl = PetType.builder().name("fowl").build();
        Pet poule = Pet.builder().petType(fowl).build();
        poule.setPetType(fowl);
        buur.addPet(poule);

        PetType savedFowl = PetType.builder().id(4L).build();
        Pet savedPoule = Pet.builder().id(13L).build();

        given(petTypeService.save(any())).willReturn(savedFowl);
        given(petService.save(any())).willReturn(savedPoule);
        // when
        service.save(buur);
        // then
        assertNotNull(buur.getId());
        assertEquals(buur, poule.getOwner());
        assertEquals(4L, fowl.getId());
        assertEquals(13L, poule.getId());
    }

    @Test
    void findById() {
        // given
        map.put(1L, buur);
        // when
        Owner foundOwner = service.findById(1L);
        // then
        assertEquals(buur, foundOwner);
    }

    @Test
    void findByLastName() {
        // given
        map.put(1L, buur);
        // when
        Owner foundOwner = service.findByLastName("N'diaye");
        // then
        assertEquals(buur, foundOwner);
    }
}
