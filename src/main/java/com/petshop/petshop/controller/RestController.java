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
        petService.savePet(pet);
        return ResponseEntity.status(HttpStatus.CREATED).body("created");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletePet (@PathVariable int id){
        petService.deletePet(id);
        return  ResponseEntity.status(HttpStatus.OK).body("deleted");

    }

    @PutMapping("")
    public ResponseEntity updatePet (@RequestBody Pet pet){
        //return ResponseEntity.status(HttpStatus.OK).body(petService.updatePet(pet));
        petService.savePet(pet);
        return ResponseEntity.status(HttpStatus.OK).body("ok");
    }


}
