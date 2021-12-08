package com.example.demouniverse.models.forms;

import javax.validation.constraints.NotNull;

public class CatchForm {

    @NotNull
    private Long heroId;

    @NotNull
    private Long villainId;

    public Long getHeroId() {

        return heroId;
    }

    public void setHeroId(Long heroId) {

        this.heroId = heroId;
    }

    public Long getVillainId() {

        return villainId;
    }

    public void setVillainId(Long villainId) {
        
        this.villainId = villainId;
    }
}