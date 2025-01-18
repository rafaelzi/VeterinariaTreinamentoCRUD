package com.example.veterinaria.controller;

import com.example.veterinaria.entity.DonoAnimalEntity;
import com.example.veterinaria.service.DonoAnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/dono")
public class DonoAnimalController {
    @Autowired
    private DonoAnimalService donoAnimalService;

    @GetMapping
    public List<DonoAnimalEntity> getAllDonosAnimal() {
        return donoAnimalService.getAllDonosAnimal();
    }

    @GetMapping("/{id}")
    public DonoAnimalEntity getDonoAnimalById(@PathVariable UUID id) {
        return donoAnimalService.getDonoAnimalById(id);
    }

    @PostMapping
    public DonoAnimalEntity postDonoAnimal(@RequestBody DonoAnimalEntity donoAnimalEntity) {
        return donoAnimalService.postDonoAnimal(donoAnimalEntity);
    }

    @DeleteMapping("/{id}")
    public void deletDonoAnimalById(@PathVariable UUID id) {
        donoAnimalService.deletDonoAnimalById(id);
    }

    @PutMapping("/{id}")
    public DonoAnimalEntity updateDonoAnimalById(@PathVariable UUID id, @RequestBody DonoAnimalEntity donoAnimalEntity) {
        return donoAnimalService.updateDonoAnimalById(id, donoAnimalEntity);
    }
}
