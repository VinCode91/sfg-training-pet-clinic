package guru.springframework.sfgtrainingpetclinic.repositories;

import guru.springframework.sfgtrainingpetclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
