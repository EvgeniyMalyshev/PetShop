package com.petshop.petshop.controller;

import com.petshop.petshop.model.Pet;
import com.petshop.petshop.service.PetService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.annotation.XmlRootElement;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;
import static org.springframework.http.MediaType.APPLICATION_XML;
import static org.springframework.http.MediaType.APPLICATION_XML_VALUE;

@org.springframework.web.bind.annotation.RestController
@RequiredArgsConstructor(onConstructor = @_(@Autowired))
@RequestMapping(value = "/api",produces = {APPLICATION_JSON_UTF8_VALUE})
@CrossOrigin
public class RestController {
    @Autowired
    PetService petService;

    @GetMapping("")
    public ResponseEntity list (){
        return ResponseEntity.ok().body(petService.petList());
    }

    @GetMapping("/{id}")
    public ResponseEntity getPetById(@PathVariable int id){
        return  ResponseEntity.status(HttpStatus.OK).body(petService.getPetbyId(id));
    }


    @PostMapping("")
    public ResponseEntity createPet(@RequestBody Pet pet){
        Pet petSave = petService.savePet(pet);
        return ResponseEntity.status(HttpStatus.CREATED).body(petSave);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletePet (@PathVariable int id){
        if(petService.getPetbyId(id)!=null) {
            Pet deletePetpet = petService.deletePet(id);
            return ResponseEntity.status(HttpStatus.OK).body(deletePetpet);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity updatePet (@PathVariable int id, @RequestBody Pet pet){
        Pet updatePet = petService.getPetbyId(id);
        if(updatePet == null) {
            return ResponseEntity.notFound().build();
        }
        updatePet.setAge(pet.getAge());
        updatePet.setName(pet.getName());
        petService.updatePet(updatePet);
        return ResponseEntity.ok(updatePet);
    }


}
