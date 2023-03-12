package guru.springframework.sfgtrainingpetclinic.services.map;

import guru.springframework.sfgtrainingpetclinic.model.Vet;
import guru.springframework.sfgtrainingpetclinic.services.VetService;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Set;

@Service
public class VetServiceMap extends AbstractMapService<Vet> implements VetService {
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
