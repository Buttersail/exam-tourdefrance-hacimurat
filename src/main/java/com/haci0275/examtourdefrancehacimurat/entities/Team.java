package com.haci0275.examtourdefrancehacimurat.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.haci0275.examtourdefrancehacimurat.dto.TeamRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String teamLetter;

    @OneToMany(mappedBy = "team", cascade = {CascadeType.PERSIST ,CascadeType.MERGE})
    private Set<Rider> riders = new HashSet<>();

    public Team(String name, String teamLetter) {
        this.name = name;
        this.teamLetter = teamLetter;
    }

    public Team(TeamRequest body) {
        this.name = body.getName();
        this.teamLetter = body.getTeamLetter();
    }

    public void addRider(Rider rider) {
        this.riders.add(rider);
        rider.setTeam(this);
    }

    public void addRiders(Set<Rider> riders) {
        this.riders.addAll(riders);
        for (Rider rider : riders) {
            rider.setTeam(this);
        }
    }
}
