package guru.springframework.sfgtrainingpetclinic.controllers;

import guru.springframework.sfgtrainingpetclinic.model.Owner;
import guru.springframework.sfgtrainingpetclinic.services.OwnerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.Matchers.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.isNotNull;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verifyNoInteractions;

@WebMvcTest(OwnerController.class)
class OwnerControllerTest {
    @MockBean
    OwnerService ownerService;
    @Autowired
    MockMvc mockMvc;
    Set<Owner> owners;

    @BeforeEach
    void setUp() {
        owners = new HashSet<>(Arrays.asList(Owner.builder().id(1L).lastName("Ndiaye").build(),
                Owner.builder().id(2L).lastName("SARR").build()
        ));
    }

    @Test
    void listOwners() throws Exception {
        // given
        given(ownerService.findAll()).willReturn(owners);

        // when // then
        mockMvc.perform(MockMvcRequestBuilders.get("/owners/index"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(1))
                .andExpect(MockMvcResultMatchers.model().attributeExists("owners"))
                .andExpect(MockMvcResultMatchers.model().attribute("owners", hasSize(2)))
                .andExpect(MockMvcResultMatchers.model().attribute("owners", owners))
                .andExpect(MockMvcResultMatchers.view().name("owners/index"));
    }

    @Test
    void findOwners() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/owners/find"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("notimplemented"));
        verifyNoInteractions(ownerService);
    }

    @Test
    void displayOwner() throws Exception {
        // given
        given(ownerService.findById(anyLong())).willReturn(Owner.builder().id(1L).lastName("Ndiaye").build());

        // when - then
        mockMvc.perform(MockMvcRequestBuilders.get("/owners/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().attribute("owner", hasProperty("id", is(1L))))
                .andExpect(MockMvcResultMatchers.view().name("owners/ownerDetails"));
    }
}
