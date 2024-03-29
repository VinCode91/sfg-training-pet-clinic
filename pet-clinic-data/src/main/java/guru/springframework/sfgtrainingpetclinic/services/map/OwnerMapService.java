package guru.springframework.sfgtrainingpetclinic.services.map;

import guru.springframework.sfgtrainingpetclinic.model.Owner;
import guru.springframework.sfgtrainingpetclinic.model.Pet;
import guru.springframework.sfgtrainingpetclinic.model.PetType;
import guru.springframework.sfgtrainingpetclinic.services.OwnerService;
import guru.springframework.sfgtrainingpetclinic.services.PetService;
import guru.springframework.sfgtrainingpetclinic.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Set;

@Service
@Profile({"default", "map"})
public class OwnerMapService extends AbstractMapService<Owner> implements OwnerService {

    private final PetService petService;
    private final PetTypeService petTypeService;

    public OwnerMapService(PetService petService, PetTypeService petTypeService) {
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
    public Owner save(Owner owner) {
        if (owner != null && owner.getPets() != null && !owner.getPets().isEmpty()) {
                owner.getPets().forEach( pet -> {
                    if (pet.getOwner() == null)
                        pet.setOwner(owner);
                    if (pet.getPetType() != null) {
                        if (pet.getPetType().getId() == null) {
                            PetType savedPetType = petTypeService.save(pet.getPetType());
                            pet.getPetType().setId(savedPetType.getId());
                        }
                    } else {
                        throw new RuntimeException("Pet Type is required");
                    }

                    if (pet.getId() == null) {
                        Pet savedPet = petService.save(pet);
                        pet.setId(savedPet.getId());
                    }
                });
        }
        return super.save(owner);
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return map.entrySet().stream().filter(entry -> lastName.equalsIgnoreCase(entry.getValue().getLastName()))
                .findFirst().map(Map.Entry::getValue).orElse(null);
    }
}
