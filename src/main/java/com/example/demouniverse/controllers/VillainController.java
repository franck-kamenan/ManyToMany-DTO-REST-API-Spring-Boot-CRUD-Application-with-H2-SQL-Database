package com.example.demouniverse.controllers;

import java.util.List;

import javax.validation.Valid;

import com.example.demouniverse.models.dtos.VillainDTO;
import com.example.demouniverse.models.forms.VillainForm;
import com.example.demouniverse.services.VillainService;

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
@RequestMapping(path = "/villain")
public class VillainController {
    private final VillainService villainService;

    public VillainController(VillainService villainService) {
        this.villainService = villainService;
    }

    @GetMapping
    public ResponseEntity<List<VillainDTO>> getList() {
        return ResponseEntity.ok(this.villainService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<VillainDTO> getOneById(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(this.villainService.getOneById(id));
    }

    @PostMapping()
    public ResponseEntity<VillainDTO> insertOne(@Valid @RequestBody VillainForm form) {
        return ResponseEntity.ok(this.villainService.insert(form));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<VillainDTO> updateOne(@PathVariable(name = "id") Long id,
            @Valid @RequestBody VillainForm form) {
        return ResponseEntity.ok(this.villainService.update(form, id));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Long> deleteOne(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(this.villainService.delete(id));
    }
}