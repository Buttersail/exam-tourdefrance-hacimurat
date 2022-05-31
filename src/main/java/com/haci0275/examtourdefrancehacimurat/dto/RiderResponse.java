package com.haci0275.examtourdefrancehacimurat.dto;

import com.haci0275.examtourdefrancehacimurat.entities.Rider;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class RiderResponse {

    private int id;
    private String name;
    private String country;
    private int age;
    private double time;
    private int mountainPts;
    private int sprintPts;

    private TeamResponse team;

    public RiderResponse(Rider body) {
        this.id = body.getId();
        this.name = body.getName();
        this.country = body.getCountry();
        this.age = body.getAge();
        this.time = body.getTime();
        this.mountainPts = body.getMountainPts();
        this.sprintPts = body.getSprintPts();

        if (body.getTeam() != null) {
            this.team = new TeamResponse(body.getTeam());
        }

    }

    public static List<RiderResponse> getTeamsFromEntities(List<Rider> riders) {
        return riders.stream().map(rider -> new RiderResponse(rider)).collect(Collectors.toList());
    }
}
