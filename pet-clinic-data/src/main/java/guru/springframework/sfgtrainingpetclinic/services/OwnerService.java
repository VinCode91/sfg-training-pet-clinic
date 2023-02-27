package guru.springframework.sfgtrainingpetclinic.services;

import guru.springframework.sfgtrainingpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long>{
    Owner findByLastName(String lastName);

}
