package br.com.compilou.api_animals.models;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "animais")
public class Animais {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private String age;
    private String race;

    public Animais(){}

    public Animais(UUID id, String name, String age, String race) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.race = race;
    }

    public Animais(String name, String age, String race) {
        this.name = name;
        this.age = age;
        this.race = race;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }
}
