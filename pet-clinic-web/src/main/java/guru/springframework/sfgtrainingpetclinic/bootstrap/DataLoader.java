package guru.springframework.sfgtrainingpetclinic.bootstrap;

import guru.springframework.sfgtrainingpetclinic.model.Owner;
import guru.springframework.sfgtrainingpetclinic.model.Pet;
import guru.springframework.sfgtrainingpetclinic.model.PetType;
import guru.springframework.sfgtrainingpetclinic.model.Vet;
import guru.springframework.sfgtrainingpetclinic.services.OwnerService;
import guru.springframework.sfgtrainingpetclinic.services.PetTypeService;
import guru.springframework.sfgtrainingpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

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

        PetType canine = new PetType();
        canine.setName("canine");
        PetType savedCanineType = petTypeService.save(canine);

        PetType hare = new PetType();
        canine.setName("hare");
        PetType savedHareType = petTypeService.save(hare);

        Pet macsPet = new Pet();
        macsPet.setPetType(savedCanineType);
        macsPet.setName("Bouki");
        macsPet.setBirthDate(LocalDate.now().minusMonths(15L));

        Pet leuk = new Pet();
        leuk.setPetType(savedHareType);
        leuk.setName("Leuk");
        leuk.setBirthDate(LocalDate.now().minusWeeks(5L));

        Owner owner1 = new Owner();
        owner1.setFirstName("Macodou");
        owner1.setLastName("Ndiaye");
        owner1.setAddress("123 rue de la Paix");
        owner1.setCity("Ngasobyl");
        owner1.setTelephone("764527859");
        owner1.getPets().add(macsPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Yandé");
        owner2.setLastName("Ndiaye");
        owner2.setAddress("5 rue Lamine Gueye");
        owner2.setCity("Ndianda");
        owner2.setTelephone("771234578");
        owner2.getPets().add(leuk);

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
