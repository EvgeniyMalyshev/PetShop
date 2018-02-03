package com.petshop.petshop.controller;

import com.petshop.petshop.model.Pet;
import com.petshop.petshop.service.PetService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.OK;

@Controller
@RequiredArgsConstructor (onConstructor = @_(@Autowired))
public class MainController {
    @Autowired
    PetService petService;

    @GetMapping("/")
    public String home1() {
        return "/home";
    }

    @GetMapping("/home")
    public String home() {
        return "/home";
    }

    @GetMapping("/admin")
    public String admin(Model model) {
        model.addAttribute("pet", new Pet());
        model.addAttribute("petList", petService.petList());
        return "/admin";
    }

    @GetMapping("/login")
    public String login() {
        return "/login";
    }

    @GetMapping("/403")
    public String error403() {
        return "/error/403";
    }


    @PostMapping("/add")
    public String save(@ModelAttribute("pet") Pet pet, Model model){
        petService.savePet(pet);
        return "redirect:/admin";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id){
        petService.deletePet(id);
       return "redirect:/admin";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable int id, Model model){
        model.addAttribute("pet", petService.getPetbyId(id));
        return "updated";
    }


}
