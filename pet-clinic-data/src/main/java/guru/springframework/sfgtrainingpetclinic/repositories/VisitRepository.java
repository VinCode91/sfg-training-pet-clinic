package guru.springframework.sfgtrainingpetclinic.repositories;

import guru.springframework.sfgtrainingpetclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
