package com.haci0275.examtourdefrancehacimurat.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Team {

    @Id
    private int id;

    private String name;
    private String teamLetter;

    @OneToMany(mappedBy = "rider", cascade = {CascadeType.PERSIST ,CascadeType.MERGE})
    private Set<Rider> riders = new HashSet<>();

    public Team(String name, String teamLetter) {
        this.name = name;
        this.teamLetter = teamLetter;
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
