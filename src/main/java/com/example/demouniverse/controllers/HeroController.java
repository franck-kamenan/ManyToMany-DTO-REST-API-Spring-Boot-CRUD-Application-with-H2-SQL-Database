package com.example.demouniverse.controllers;

import java.util.List;

import javax.validation.Valid;

import com.example.demouniverse.models.dtos.HeroDTO;
import com.example.demouniverse.models.forms.CatchForm;
import com.example.demouniverse.models.forms.HeroForm;
import com.example.demouniverse.services.HeroService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/hero")
public class HeroController {
    private final HeroService heroService;

    public HeroController(HeroService heroService) {
        this.heroService = heroService;
    }

    @GetMapping
    public ResponseEntity<List<HeroDTO>> getList() {
        return ResponseEntity.ok(this.heroService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<HeroDTO> getOneById(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(this.heroService.getOneById(id));
    }

    @PostMapping()
    public ResponseEntity<HeroDTO> insertOne(@Valid @RequestBody HeroForm form) {
        return ResponseEntity.ok(this.heroService.insert(form));
    }

    @PostMapping("/catch")
    public ResponseEntity<HeroDTO> catchVillain(@Valid @RequestBody CatchForm form) {
        return ResponseEntity.ok(this.heroService.catchVillain(form));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<HeroDTO> updateOne(@PathVariable(name = "id") Long id,
            @Valid @RequestBody HeroForm form) {
        return ResponseEntity.ok(this.heroService.update(form, id));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Long> deleteOne(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(this.heroService.delete(id));
    }
}