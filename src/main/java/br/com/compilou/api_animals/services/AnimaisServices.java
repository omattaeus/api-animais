package br.com.compilou.api_animals.services;

import br.com.compilou.api_animals.exceptions.ResourceNotFoundException;
import br.com.compilou.api_animals.models.Animais;
import br.com.compilou.api_animals.repositories.AnimaisRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AnimaisServices {

    private final AnimaisRepository animaisRepository;

    public AnimaisServices(AnimaisRepository animaisRepository) {
        this.animaisRepository = animaisRepository;
    }

    public List<Animais> findAllAnimals(){
        return animaisRepository.findAll();
    }

    public Animais findAnimaisById(UUID id){
        return animaisRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                "No record found for this ID!"
        ));
    }

    public Animais createAnimais(Animais animais){

        Optional<Animais> savedAnimals = animaisRepository.findByName(animais.getName());

        if(savedAnimals.isPresent()){
            throw new ResourceNotFoundException("Animals already exist with given name: " + animais.getName());
        }

        return animaisRepository.save(animais);
    }

    public Animais updateAnimais(Animais animais){
        var entity = animaisRepository.findById(animais.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

        entity.setName(animais.getName());
        entity.setAge(animais.getAge());
        entity.setRace(animais.getRace());

        return animaisRepository.save(animais);
    }

    public void deleteAnimals(UUID id){
        var entity = animaisRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
        animaisRepository.delete(entity);
    }
}
