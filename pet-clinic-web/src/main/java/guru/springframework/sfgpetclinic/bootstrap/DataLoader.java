package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.VetService;
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
        owner1.setFirstName("Dexter");
        owner1.setLastName("Morgan");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Lily");
        owner2.setLastName("Morgan");

        ownerService.save(owner2);

        System.out.println("Loaded Owner data");

        Vet vet1 = new Vet();
        vet1.setFirstName("Ganesh");
        vet1.setLastName("Gaitonde");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Isha");
        vet2.setLastName("Gaitonde");

        vetService.save(vet2);

        System.out.println("Loaded Vet data");
    }
}
