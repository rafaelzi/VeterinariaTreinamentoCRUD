package com.example.veterinaria.repository;

import com.example.veterinaria.entity.DonoAnimalEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DonoAnimalRepository extends JpaRepository<DonoAnimalEntity, UUID> {
}
