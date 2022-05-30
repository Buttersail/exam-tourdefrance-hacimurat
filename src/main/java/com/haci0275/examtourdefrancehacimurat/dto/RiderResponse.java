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

    public RiderResponse(Rider body) {
        this.id = body.getId();
        this.name = body.getName();
    }

    public static List<RiderResponse> getTeamsFromEntities(List<Rider> riders) {
        return riders.stream().map(rider -> new RiderResponse(rider)).collect(Collectors.toList());
    }
}
