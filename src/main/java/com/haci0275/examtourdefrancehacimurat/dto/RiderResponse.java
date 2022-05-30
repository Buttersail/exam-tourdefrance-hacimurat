package com.haci0275.examtourdefrancehacimurat.dto;

import com.haci0275.examtourdefrancehacimurat.entities.Rider;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
}
