package com.example.demouniverse.repositories;

import com.example.demouniverse.models.entities.Villain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VillainRepository extends JpaRepository<Villain, Long> {}