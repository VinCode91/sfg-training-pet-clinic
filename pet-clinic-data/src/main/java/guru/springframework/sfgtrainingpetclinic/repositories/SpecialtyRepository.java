package guru.springframework.sfgtrainingpetclinic.repositories;

import guru.springframework.sfgtrainingpetclinic.model.Specialty;
import org.springframework.data.repository.CrudRepository;

public interface SpecialtyRepository extends CrudRepository<Specialty, Long> {
}
