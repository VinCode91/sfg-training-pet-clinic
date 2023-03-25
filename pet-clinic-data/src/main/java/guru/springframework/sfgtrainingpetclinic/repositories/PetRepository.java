package guru.springframework.sfgtrainingpetclinic.repositories;

import guru.springframework.sfgtrainingpetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
