package guru.springframework.sfgtrainingpetclinic.bootstrap;

import guru.springframework.sfgtrainingpetclinic.model.Owner;
import guru.springframework.sfgtrainingpetclinic.model.PetType;
import guru.springframework.sfgtrainingpetclinic.model.Vet;
import guru.springframework.sfgtrainingpetclinic.services.OwnerService;
import guru.springframework.sfgtrainingpetclinic.services.PetTypeService;
import guru.springframework.sfgtrainingpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("dog");
        PetType savedDogType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("cat");
        PetType savedCatType = petTypeService.save(cat);

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
