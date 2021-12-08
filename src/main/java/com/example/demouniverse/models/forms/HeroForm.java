package com.example.demouniverse.models.forms;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class HeroForm {

    @NotNull
    @Size(min = 2, max = 30)
    private String alias;

    @NotNull
    @Size(min = 2, max = 30)
    private String team;

    public String getAlias() {

        return alias;
    }

    public void setAlias(String alias) {

        this.alias = alias;
    }

    public String getTeam() {

        return team;
    }

    public void setTeam(String team) {
        
        this.team = team;
    }
}