package guru.springframework.sfgtrainingpetclinic.services;

import guru.springframework.sfgtrainingpetclinic.model.Pet;

import java.util.Set;

public interface PetService {
    Pet findById(Long id);

    Pet save(Pet pet);

    Set<Pet> findAll();
}
