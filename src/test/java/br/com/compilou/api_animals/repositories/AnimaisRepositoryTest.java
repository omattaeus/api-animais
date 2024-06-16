package br.com.compilou.api_animals.repositories;

import br.com.compilou.api_animals.models.Animais;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
class AnimaisRepositoryTest {

    @Autowired
    private AnimaisRepository animaisRepository;

    private Animais animais;

    @BeforeEach
    void setup(){
        animais = new Animais("Gael", "4", "Caramelo");
    }

    @DisplayName("Given Animais List When Find All Then Return Animals List")
    @Test
    void testGivenAnimaisList_WhenFindAll_ThenReturnAnimaisList(){
        Animais animais2 = new Animais("Nina", "9", "Gata");

        animaisRepository.save(animais);
        animaisRepository.save(animais2);

        List<Animais> animaisList = animaisRepository.findAll();

        Assertions.assertNotNull(animaisList);
        Assertions.assertEquals(2, animaisList.size());
    }

    @DisplayName("Given Animais Object When Find By Id Then Return Animals Object")
    @Test
    void testGivenAnimaisObject_WhenFindById_ThenReturnAnimalsObject(){

        animaisRepository.save(animais);

        Animais savedAnimais = animaisRepository.findById(animais.getId()).get();

        Assertions.assertNotNull(savedAnimais);
        Assertions.assertEquals(animais.getId(), animais.getId());
    }

    @DisplayName("Given Animais Object When Update Animals Then Return Updated Animals Object")
    @Test
    void testGivenAnimaisObject_WhenUpdateAnimals_ThenReturnUpdatedAnimalsObject(){

        animaisRepository.save(animais);

        Animais savedAnimais = animaisRepository.findById(animais.getId()).get();
        savedAnimais.setName("Britney");
        savedAnimais.setAge("4");

        Animais updatedAnimals = animaisRepository.save(savedAnimais);

        Assertions.assertNotNull(updatedAnimals);
        Assertions.assertEquals("Britney", updatedAnimals.getName());
        Assertions.assertEquals("4", updatedAnimals.getAge());
    }
}
