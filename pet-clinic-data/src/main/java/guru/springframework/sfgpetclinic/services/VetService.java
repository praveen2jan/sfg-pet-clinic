package guru.springframework.sfgpetclinic.services;

import guru.springframework.sfgpetclinic.model.Vet;

import java.util.Set;

public interface VetService {
    Vet save(Vet vet);
    Set<Vet> findAll();
    Vet findById(Long id);
}
