package com.example.demouniverse.mappers;

import com.example.demouniverse.models.dtos.VillainDTO;
import com.example.demouniverse.models.entities.Villain;
import com.example.demouniverse.models.forms.VillainForm;

import org.springframework.stereotype.Service;

@Service
public class VillainMapper implements BaseMapper<VillainDTO, VillainForm, Villain> {
    @Override
    public Villain formToEntity(VillainForm form) {

        Villain v = new Villain();
        v.setAlias(form.getAlias());
        v.setTeam(form.getTeam());
        return v;
    }

    @Override
    public VillainDTO entityToDto(Villain entity) {

        if (entity != null && entity.getId() > 0) {

            return VillainDTO.builder()
                    .id(entity.getId())
                    .alias(entity.getAlias())
                    .team(entity.getTeam())
                    .build();
        }
        return null;
    }

    @Override
    public Villain dtoToEntity(VillainDTO dto) {

        Villain villain = new Villain();
        if (dto != null && dto.getId() > 0) {
            
            villain.setId(dto.getId());
            villain.setAlias(dto.getAlias());
            villain.setTeam(dto.getTeam());
        }

        return villain;
    }
}