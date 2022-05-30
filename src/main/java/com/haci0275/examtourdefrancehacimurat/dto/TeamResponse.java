package com.haci0275.examtourdefrancehacimurat.dto;

import com.haci0275.examtourdefrancehacimurat.entities.Team;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TeamResponse {

    private int id;
    private String name;
    private String teamLetter;

    public TeamResponse(Team body) {
        this.id = body.getId();
        this.name = body.getName();
        this.teamLetter = body.getTeamLetter();
    }

}
