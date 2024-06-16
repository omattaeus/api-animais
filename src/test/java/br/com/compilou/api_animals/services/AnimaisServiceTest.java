package br.com.compilou.api_animals.services;

import br.com.compilou.api_animals.exceptions.ResourceNotFoundException;
import br.com.compilou.api_animals.models.Animais;
import br.com.compilou.api_animals.repositories.AnimaisRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class AnimaisServiceTest {

    @Mock
    private AnimaisRepository animaisRepository;
    @InjectMocks
    private AnimaisServices animaisService;

    private Animais animais;

    private final UUID defaultUuid = UUID.fromString("8043da8d8b30e3-de52-4f1c-a71c-9905ac");

    @BeforeEach
    void setup(){
        animais = new Animais("Gael", "4", "Caramelo");
    }

    @DisplayName("Given Animais Object When Save Animais then Return Object")
    @Test
    void testGivenAnimaisObject_WhenSaveAnimais_thenReturnObject(){

        given(animaisRepository.findByName(anyString())).willReturn(Optional.empty());
        given(animaisRepository.save(animais)).willReturn(animais);

        Animais savedAnimais = animaisService.createAnimais(animais);

        Assertions.assertNotNull(savedAnimais);
        Assertions.assertEquals("Gael", savedAnimais.getName());
        Assertions.assertEquals("4", savedAnimais.getAge());
        Assertions.assertEquals("Caramelo", savedAnimais.getRace());
    }

    @DisplayName("Given Existing Animals When Save Animals Then Throws Exception")
    @Test
    void testGivenExistingAnimals_WhenSaveAnimals_thenThrowsException(){

        given(animaisRepository.findByName(anyString())).willReturn(Optional.of(animais));

        Assertions.assertThrows(ResourceNotFoundException.class, () -> {
            animaisService.createAnimais(animais);
        });

        verify(animaisRepository, never()).save(any(Animais.class));
    }
}