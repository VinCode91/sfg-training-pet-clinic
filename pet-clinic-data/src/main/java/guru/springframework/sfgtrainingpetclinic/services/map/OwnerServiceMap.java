package guru.springframework.sfgtrainingpetclinic.services.map;

import guru.springframework.sfgtrainingpetclinic.model.Owner;
import guru.springframework.sfgtrainingpetclinic.services.OwnerService;
import guru.springframework.sfgtrainingpetclinic.services.PetService;
import guru.springframework.sfgtrainingpetclinic.services.PetTypeService;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Set;

@Service
public class OwnerServiceMap extends AbstractMapService<Owner> implements OwnerService {

    private final PetService petService;
    private final PetTypeService petTypeService;

    public OwnerServiceMap(PetService petService, PetTypeService petTypeService) {
        this.petService = petService;
        this.petTypeService = petTypeService;
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    @Override
    public Owner save(Owner object) {
        if (object != null) {
            if (object.getPets() != null && !object.getPets().isEmpty()) {
                object.getPets().forEach( pet -> {
                    if (pet.getPetType() != null) {
                        if (pet.getPetType().getId() == null) {
                            pet.setPetType(petTypeService.save(pet.getPetType()));
                        }
                    } else {
                        throw new RuntimeException("Pet Type is required");
                    }

                    if (pet.getId() == null) {
                        pet.setId(petService.save(pet).getId());
                    }
                });
            }

            return super.save(object);
        }
        return super.save(object);
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return map.entrySet().stream().filter(entry -> lastName.equals(entry.getValue().getLastName()))
                .findFirst().map(Map.Entry::getValue).orElse(null);
    }
}
