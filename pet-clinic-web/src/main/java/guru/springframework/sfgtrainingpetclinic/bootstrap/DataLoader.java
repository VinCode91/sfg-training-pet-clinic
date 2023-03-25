package guru.springframework.sfgtrainingpetclinic.bootstrap;

import guru.springframework.sfgtrainingpetclinic.model.*;
import guru.springframework.sfgtrainingpetclinic.services.OwnerService;
import guru.springframework.sfgtrainingpetclinic.services.PetTypeService;
import guru.springframework.sfgtrainingpetclinic.services.SpecialtyService;
import guru.springframework.sfgtrainingpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtyService specialtyService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
    }

    @Override
    public void run(String... args) throws Exception {
        int count = petTypeService.findAll().size();
        if (count == 0)
            loadData();
    }

    private void loadData() {
        PetType canine = new PetType();
        canine.setName("canine");
        PetType savedCanineType = petTypeService.save(canine);

        PetType hare = new PetType();
        canine.setName("hare");
        PetType savedHareType = petTypeService.save(hare);

        Specialty radiology = new Specialty();
        radiology.setDescription("Radiology");
        Specialty savedRadiology = specialtyService.save(radiology);

        Specialty surgery = new Specialty();
        surgery.setDescription("Surgery");
        Specialty savedSurgery = specialtyService.save(surgery);

        Specialty dentistry = new Specialty();
        dentistry.setDescription("Dentistry");
        Specialty savedDentistry = specialtyService.save(dentistry);

        Owner owner1 = new Owner();
        owner1.setFirstName("Macodou");
        owner1.setLastName("Ndiaye");
        owner1.setAddress("123 rue de la Paix");
        owner1.setCity("Ngasobyl");
        owner1.setTelephone("764527859");

        Pet bouki = new Pet();
        bouki.setPetType(savedCanineType);
        bouki.setName("Bouki");
        bouki.setBirthDate(LocalDate.now().minusMonths(15L));
        owner1.getPets().add(bouki);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Yandé");
        owner2.setLastName("Ndiaye");
        owner2.setAddress("5 rue Lamine Gueye");
        owner2.setCity("Ndianda");
        owner2.setTelephone("771234578");

        Pet leuk = new Pet();
        leuk.setPetType(savedHareType);
        leuk.setName("Leuk");
        leuk.setBirthDate(LocalDate.now().minusWeeks(5L));
        owner2.getPets().add(leuk);

        ownerService.save(owner2);
        System.out.println("Loaded owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Aloys");
        vet1.setLastName("SARR");
        vet1.getSpecialties().add(savedSurgery);
        vet1.getSpecialties().add(savedDentistry);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("René");
        vet2.setLastName("Ndiaye");
        vet2.getSpecialties().add(savedRadiology);

        vetService.save(vet2);

        System.out.println("Loaded vets...");
    }
}
