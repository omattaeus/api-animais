package br.com.compilou.api_animals.repositories;

import br.com.compilou.api_animals.models.Animais;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface AnimaisRepository extends JpaRepository<Animais, UUID> {

    Optional<Animais> findByName(String name);
}
