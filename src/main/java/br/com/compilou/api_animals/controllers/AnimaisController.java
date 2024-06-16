package br.com.compilou.api_animals.controllers;

import br.com.compilou.api_animals.models.Animais;
import br.com.compilou.api_animals.services.AnimaisServices;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class AnimaisController {

    private final AnimaisServices service;

    public AnimaisController(AnimaisServices service) {
        this.service = service;
    }

    @GetMapping(value = "/all-animais")
    public List<Animais> findAllAnimais(){
        return service.findAllAnimals();
    }

    @GetMapping(value = "/get-animais/{id}")
    public Animais findById(@PathVariable(value = "id") UUID id){
        return service.findAnimaisById(id);
    }

    @PostMapping(value = "create-animais")
    public Animais createAnimais(@RequestBody Animais animais){
        return service.createAnimais(animais);
    }

    @PutMapping
    public Animais updateAnimais(@RequestBody Animais animais){
        return service.updateAnimais(animais);
    }

    @DeleteMapping(value = "/delete-animais/{id}")
    public void deleteAnimais(@PathVariable(value = "id") UUID id){
        service.deleteAnimals(id);
    }

}
