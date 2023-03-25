package guru.springframework.sfgtrainingpetclinic.services.map;

import guru.springframework.sfgtrainingpetclinic.model.Specialty;
import guru.springframework.sfgtrainingpetclinic.model.Vet;
import guru.springframework.sfgtrainingpetclinic.services.SpecialtyService;
import guru.springframework.sfgtrainingpetclinic.services.VetService;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Set;

@Service
public class VetMapService extends AbstractMapService<Vet> implements VetService {

    private final SpecialtyService specialtyService;

    public VetMapService(SpecialtyService specialtyService) {
        this.specialtyService = specialtyService;
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }

    @Override
    public Vet save(Vet object) {
        if (object!=null && object.getSpecialties().size() > 0) {
            object.getSpecialties().forEach(spe -> {
                if (spe.getId() == null) {
                    Specialty savedSpecialty = specialtyService.save(spe);
                    spe.setId(savedSpecialty.getId());
                }
            });
        }

        return super.save(object);
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Vet findByLastName(String lastName) {
        return map.entrySet().stream().filter(entry -> lastName.equals(entry.getValue().getLastName()))
                .findFirst().map(Map.Entry::getValue).orElse(null);
    }
}
