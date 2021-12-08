package com.example.demouniverse.services;

import java.util.List;
import java.util.stream.Collectors;

import com.example.demouniverse.mappers.VillainMapper;
import com.example.demouniverse.models.dtos.VillainDTO;
import com.example.demouniverse.models.entities.Villain;
import com.example.demouniverse.models.forms.VillainForm;
import com.example.demouniverse.repositories.VillainRepository;

import org.springframework.stereotype.Service;

@Service
public class VillainService implements BaseService<VillainDTO, VillainForm, Long> {

    private final VillainRepository villainRepository;
    private final VillainMapper villainMapper;

    public VillainService(VillainRepository villainRepository, VillainMapper villainMapper) {

        this.villainRepository = villainRepository;
        this.villainMapper = villainMapper;
    }

    @Override
    public List<VillainDTO> getAll() {

        return this.villainRepository
                .findAll()
                .stream()
                .map(this.villainMapper::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public VillainDTO getOneById(Long id) {

        return this.villainMapper.entityToDto(this.villainRepository
                .findById(id)
                .orElse(null));
    }

    @Override
    public VillainDTO insert(VillainForm form) {

        Villain v = this.villainMapper.formToEntity(form);
        return this.villainMapper.entityToDto(this.villainRepository.save(v));
    }

    @Override
    public Long delete(Long id) {

        Villain v = this.villainRepository
                .findById(id)
                .orElse(null);
        if (v != null) {
            this.villainRepository.delete(v);
            return v.getId();
        }
        return -1L;
    }

    @Override
    public VillainDTO update(VillainForm form, Long id) {
        Villain v = this.villainRepository
                .findById(id)
                .orElse(null);
        if (v != null) {
            v.setAlias(form.getAlias());
            v.setTeam(form.getTeam());
            this.villainRepository.save(v);
        }
        return this.villainMapper.entityToDto(v);
    }
}