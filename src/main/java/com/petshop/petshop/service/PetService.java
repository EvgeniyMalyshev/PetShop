package com.petshop.petshop.service;

import com.petshop.petshop.model.Pet;
import com.petshop.petshop.repository.PetRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.boot.model.source.spi.PluralAttributeElementSourceManyToMany;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PetService {
    @Autowired
    PetRepository repository;
    public Pet getPet(){
      return repository.findOne(1);

    }
    public void  savePet(Pet pet){
    repository.save(pet);

    }

    public List<Pet> petList (){
        return (List<Pet>) repository.findAll();
    }

public Pet deletePet(int id){
        Pet pet = repository.findOne(id);
        repository.delete(pet.getId());
        return pet;
}

public Pet getPetbyId(int id){
       return repository.findOne(id);
}

public Pet updatePet(Pet pet){
    Pet petUpdated = repository.findOne(pet.getId());
    pet.setName(pet.getName() == null?petUpdated.getName():pet.getName());
    pet.setAge(pet.getAge() == 0?petUpdated.getAge():pet.getAge());
//    petUpdated.setAge(pet.getAge());
//    petUpdated.setName(pet.getName());
        return repository.save(pet);
}


}
