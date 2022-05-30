package com.haci0275.examtourdefrancehacimurat.entities;

import com.haci0275.examtourdefrancehacimurat.dto.RiderRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Rider {

    @Id
    private int id;

    private String name;

    @ManyToOne
    private Team team;

    public Rider(String name) {
        this.name = name;
    }

    public Rider(RiderRequest body) {
    }
}
