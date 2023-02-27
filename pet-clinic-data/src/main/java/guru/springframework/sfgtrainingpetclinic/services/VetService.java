package guru.springframework.sfgtrainingpetclinic.services;

import guru.springframework.sfgtrainingpetclinic.model.Vet;

import java.util.Set;

public interface VetService extends CrudService<Vet, Long> {
    Vet findByLastName(String lastName);
}
