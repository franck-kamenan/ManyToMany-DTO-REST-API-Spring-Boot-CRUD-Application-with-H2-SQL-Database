package com.example.demouniverse.mappers;

public interface BaseMapper<TDTO, TFORM, TENTITY> {
    
    public TENTITY formToEntity(TFORM form);

    public TDTO entityToDto(TENTITY entity);

    public TENTITY dtoToEntity(TDTO dto);
}