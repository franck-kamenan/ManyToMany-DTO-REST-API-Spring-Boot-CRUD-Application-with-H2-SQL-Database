package com.example.demouniverse.mappers;

import com.example.demouniverse.models.dtos.HeroDTO;
import com.example.demouniverse.models.entities.Hero;
import com.example.demouniverse.models.forms.HeroForm;

import org.springframework.stereotype.Service;

@Service
public class HeroMapper implements BaseMapper<HeroDTO, HeroForm, Hero> {
    @Override
    public Hero formToEntity(HeroForm form) {

        Hero h = new Hero();
        h.setAlias(form.getAlias());
        h.setTeam(form.getTeam());
        return h;
    }

    @Override
    public HeroDTO entityToDto(Hero entity) {

        if (entity != null && entity.getId() > 0) {

            return HeroDTO.builder()
                    .id(entity.getId())
                    .alias(entity.getAlias())
                    .team(entity.getTeam())
                    .build();
        }
        return null;
    }

    @Override
    public Hero dtoToEntity(HeroDTO dto) {

        Hero h = new Hero();
        if (dto != null && dto.getId() > 0) {
            
            h.setId(dto.getId());
            h.setAlias(dto.getAlias());
            h.setTeam(dto.getTeam());
        }

        return h;
    }
}