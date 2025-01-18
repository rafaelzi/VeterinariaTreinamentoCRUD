package com.example.veterinaria.service;

import com.example.veterinaria.entity.AnimalEntity;
import com.example.veterinaria.entity.DonoAnimalEntity;
import com.example.veterinaria.exception.BadRequestException;
import com.example.veterinaria.exception.ForbiddenException;
import com.example.veterinaria.repository.DonoAnimalRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DonoAnimalService {
    @Autowired private DonoAnimalRepository donoAnimalRepository;

    public DonoAnimalEntity postDonoAnimal(DonoAnimalEntity donoAnimalEntity) {
        if (donoAnimalEntity.getNome().isEmpty()) {
            throw new BadRequestException("Nome vazio, invalido");
        }

        return donoAnimalRepository.save(donoAnimalEntity);
    }

    public List<DonoAnimalEntity> getAllDonosAnimal() {
        return donoAnimalRepository.findAll();
    }

    public DonoAnimalEntity getDonoAnimalById(UUID id) {
        var response = donoAnimalRepository.findById(id);
        if (response.isEmpty()) {
            throw new ObjectNotFoundException(id, DonoAnimalEntity.class.getSimpleName());
        }

        return response.get();
    }

    public void deletDonoAnimalById(UUID id) {
            throw new ForbiddenException("FORBIDDEN REQUEST");
    }

    public DonoAnimalEntity updateDonoAnimalById(UUID id, DonoAnimalEntity novoDonoAnimal) {
        var response = donoAnimalRepository.findById(id);
        if (response.isEmpty()) {
            throw new ObjectNotFoundException(id, DonoAnimalEntity.class.getSimpleName());
        }

        response.get().setTelefone(novoDonoAnimal.getTelefone());
        return donoAnimalRepository.save(response.get());
    }
}
