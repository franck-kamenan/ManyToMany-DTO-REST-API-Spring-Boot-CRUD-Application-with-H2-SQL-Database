package com.example.demouniverse.services;

import java.util.List;
import java.util.stream.Collectors;

import com.example.demouniverse.mappers.HeroMapper;
import com.example.demouniverse.models.dtos.HeroDTO;
import com.example.demouniverse.models.entities.Hero;
import com.example.demouniverse.models.entities.Villain;
import com.example.demouniverse.models.forms.CatchForm;
import com.example.demouniverse.models.forms.HeroForm;
import com.example.demouniverse.repositories.HeroRepository;
import com.example.demouniverse.repositories.VillainRepository;

import org.springframework.stereotype.Service;

@Service
public class HeroService implements BaseService<HeroDTO, HeroForm, Long> {

    private final HeroRepository heroRepository;
    private final HeroMapper heroMapper;
    private final VillainRepository villainRepository;

    public HeroService(HeroRepository heroRepository, HeroMapper heroMapper, VillainRepository villainRepository) {

        this.heroRepository = heroRepository;
        this.heroMapper = heroMapper;
        this.villainRepository = villainRepository;
    }

    @Override
    public List<HeroDTO> getAll() {

        return this.heroRepository
                .findAll()
                .stream()
                .map(this.heroMapper::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public HeroDTO getOneById(Long id) {

        return this.heroMapper.entityToDto(this.heroRepository
                .findById(id)
                .orElse(null));
    }

    @Override
    public HeroDTO insert(HeroForm form) {

        Hero h = this.heroMapper.formToEntity(form);
        return this.heroMapper.entityToDto(this.heroRepository.save(h));
    }

    public HeroDTO catchVillain(CatchForm form) {

        Hero h = this.heroRepository.findById(form.getHeroId()).orElse(null);
        Villain v = this.villainRepository.findById(form.getVillainId()).orElse(null);
        h.getVillains().add(v);
        return this.heroMapper.entityToDto(this.heroRepository.save(h));
    }

    @Override
    public Long delete(Long id) {

        Hero h = this.heroRepository
                .findById(id)
                .orElse(null);
        if (h != null) {
            this.heroRepository.delete(h);
            return h.getId();
        }
        return -1L;
    }

    @Override
    public HeroDTO update(HeroForm form, Long id) {
        Hero h = this.heroRepository
                .findById(id)
                .orElse(null);
        if (h != null) {
            h.setAlias(form.getAlias());
            h.setTeam(form.getTeam());
            this.heroRepository.save(h);
        }
        return this.heroMapper.entityToDto(h);
    }
}