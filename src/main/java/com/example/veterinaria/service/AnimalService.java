package com.example.veterinaria.service;

import com.example.veterinaria.entity.AnimalEntity;
import com.example.veterinaria.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.UUID;

@Service
public class AnimalService {
    @Autowired
    private AnimalRepository animalRepository;

    public AnimalEntity postAnimal(AnimalEntity animalEntity) {
        return animalRepository.save(animalEntity);
    }

    public List<AnimalEntity> getAllAnimals() {
        return animalRepository.findAll();
    }

    public AnimalEntity getAnimalById(UUID id) {
        var response = animalRepository.findById(id);
        if (response.isEmpty()) {
            throw new RuntimeException("Animal não encontrado");
        }

        return response.get();
    }

    public void deletAnimalById(UUID id) {
        var response = animalRepository.findById(id);
        if (response.isEmpty()) {
            throw new RuntimeException("Animal não encontrado");
        }

        animalRepository.deleteById(id);
    }

    public AnimalEntity updateAnimalById(UUID id, AnimalEntity novoAnimal) {
        var response = animalRepository.findById(id);
        if (response.isEmpty()) {
            throw new RuntimeException("Animal não encontrado");
        }

        response.get().setAnimal(novoAnimal.getAnimal());
        return animalRepository.save(response.get());
    }
}
