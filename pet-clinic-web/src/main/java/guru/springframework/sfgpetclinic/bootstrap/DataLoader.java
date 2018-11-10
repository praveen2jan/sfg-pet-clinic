package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.*;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.PetTypeService;
import guru.springframework.sfgpetclinic.services.SpecialityService;
import guru.springframework.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();
        if (count==0)
            loadData();
    }

    private void loadData() {
        Speciality radiology = new Speciality();
        radiology.setDescription("radiology");
        Speciality savedRadiology = specialityService.save(radiology);

        Speciality surgery = new Speciality();
        radiology.setDescription("surgery");
        Speciality savedSurgery = specialityService.save(surgery);

        Speciality dentistry = new Speciality();
        radiology.setDescription("dentistry");
        Speciality savedDentistry = specialityService.save(dentistry);

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType savedCatType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Dexter");
        owner1.setLastName("Morgan");
        owner1.setAddress("Thubarahalli");
        owner1.setCity("Bangalore");
        owner1.setTelephone("2738782");

        Pet dexterPet = new Pet();
        dexterPet.setPetType(savedDogType);
        dexterPet.setOwner(owner1);
        dexterPet.setBirthDate(LocalDate.now());
        dexterPet.setName("DexterPet");
        owner1.getPets().add(dexterPet);
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Lily");
        owner2.setLastName("Morgan");
        owner2.setAddress("Kundanahalli");
        owner2.setCity("Bangalore");
        owner2.setTelephone("832493849");

        Pet lilyCat = new Pet();
        lilyCat.setPetType(savedCatType);
        lilyCat.setName("Lily Cat");
        lilyCat.setBirthDate(LocalDate.now());
        lilyCat.setOwner(owner2);
        owner2.getPets().add(lilyCat);
        ownerService.save(owner2);

        System.out.println("Loaded Owner data");

        Vet vet1 = new Vet();
        vet1.setFirstName("Ganesh");
        vet1.setLastName("Gaitonde");
        vet1.getSpecialities().add(savedRadiology);
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Isha");
        vet2.setLastName("Gaitonde");
        vet2.getSpecialities().add(savedDentistry);
        vetService.save(vet2);

        System.out.println("Loaded Vet data");
    }
}
