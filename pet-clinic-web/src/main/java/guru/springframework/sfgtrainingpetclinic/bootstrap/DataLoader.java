package guru.springframework.sfgtrainingpetclinic.bootstrap;

import guru.springframework.sfgtrainingpetclinic.model.Owner;
import guru.springframework.sfgtrainingpetclinic.model.Vet;
import guru.springframework.sfgtrainingpetclinic.services.OwnerService;
import guru.springframework.sfgtrainingpetclinic.services.VetService;
import guru.springframework.sfgtrainingpetclinic.services.map.OwnerServiceMap;
import guru.springframework.sfgtrainingpetclinic.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader() {
        ownerService = new OwnerServiceMap();
        vetService = new VetServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Macodou");
        owner1.setLastName("Ndiaye");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Yandé");
        owner2.setLastName("Ndiaye");

        ownerService.save(owner2);
        System.out.println("Loaded owners...");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Aloys");
        vet1.setLastName("SARR");

        vetService.save(vet1);

        System.out.println("Loaded vets...");
    }
}