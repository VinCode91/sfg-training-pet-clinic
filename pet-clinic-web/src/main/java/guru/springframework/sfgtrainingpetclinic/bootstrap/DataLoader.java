package guru.springframework.sfgtrainingpetclinic.bootstrap;

import guru.springframework.sfgtrainingpetclinic.model.Owner;
import guru.springframework.sfgtrainingpetclinic.model.Vet;
import guru.springframework.sfgtrainingpetclinic.services.OwnerService;
import guru.springframework.sfgtrainingpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setFirstName("Macodou");
        owner1.setLastName("Ndiaye");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Yandé");
        owner2.setLastName("Ndiaye");

        ownerService.save(owner2);
        System.out.println("Loaded owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Aloys");
        vet1.setLastName("SARR");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("René");
        vet2.setLastName("Ndiaye");

        vetService.save(vet2);

        System.out.println("Loaded vets...");
    }
}
