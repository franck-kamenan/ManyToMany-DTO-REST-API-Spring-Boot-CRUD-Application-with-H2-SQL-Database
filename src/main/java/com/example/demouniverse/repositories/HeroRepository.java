package com.example.demouniverse.repositories;

import com.example.demouniverse.models.entities.Hero;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeroRepository extends JpaRepository<Hero, Long> {}