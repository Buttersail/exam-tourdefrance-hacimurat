package com.haci0275.examtourdefrancehacimurat.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.haci0275.examtourdefrancehacimurat.dto.RiderRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Rider {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String country;
    private int age;
    private double time;
    private int mountainPts;
    private int sprintPts;
    //private int totalPts;

    @ManyToOne()
    private Team team;

    public Rider(String name, String country, int age, double time, int mountainPts, int sprintPts) {
        this.name = name;
        this.country = country;
        this.age = age;
        this.time = time;
        this.mountainPts = mountainPts;
        this.sprintPts = sprintPts;
    }

    public Rider(RiderRequest body) {
        this.name = body.getName();
        this.country = body.getCountry();
        this.age = body.getAge();
        this.time = body.getTime();
        this.mountainPts = body.getMountainPts();
        this.sprintPts = body.getSprintPts();
    }
}
