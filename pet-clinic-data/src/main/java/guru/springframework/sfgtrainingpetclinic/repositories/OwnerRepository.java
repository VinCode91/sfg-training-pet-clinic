package guru.springframework.sfgtrainingpetclinic.repositories;

import guru.springframework.sfgtrainingpetclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
}
