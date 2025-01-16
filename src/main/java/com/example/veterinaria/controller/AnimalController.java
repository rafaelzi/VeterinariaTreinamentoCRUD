package com.example.veterinaria.controller;

import com.example.veterinaria.entity.AnimalEntity;
import com.example.veterinaria.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/animal")
public class AnimalController {
    @Autowired
    private AnimalService animalService;

    @GetMapping
    public List<AnimalEntity> getAllAnimals() {
        return animalService.getAllAnimals();
    }

    @GetMapping("/{id}")
    public AnimalEntity getAnimalById(@PathVariable UUID id) {
        return animalService.getAnimalById(id);
    }

    @PostMapping
    public AnimalEntity postAnimal(@RequestBody AnimalEntity animalEntity) {
        return animalService.postAnimal(animalEntity);
    }

    @DeleteMapping("/{id}")
    public void deletAnimalById(@PathVariable UUID id) {
        animalService.deletAnimalById(id);
    }

    @PutMapping("/{id}")
    public void updateAnimalById(@PathVariable UUID id, @RequestBody AnimalEntity animalEntity) {
        animalService.updateAnimalById(id, animalEntity);
    }
}
