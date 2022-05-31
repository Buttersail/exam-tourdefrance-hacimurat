package com.haci0275.examtourdefrancehacimurat.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RiderRequest {

    String name;
    String country;
    int age;
    double time;
    int mountainPts;
    int sprintPts;

    String teamLetter;

}
