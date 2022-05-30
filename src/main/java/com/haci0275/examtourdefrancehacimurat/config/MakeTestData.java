package com.haci0275.examtourdefrancehacimurat.config;

import com.haci0275.examtourdefrancehacimurat.entities.Rider;
import com.haci0275.examtourdefrancehacimurat.entities.Team;
import com.haci0275.examtourdefrancehacimurat.repositories.RiderRepository;
import com.haci0275.examtourdefrancehacimurat.repositories.TeamRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
@AllArgsConstructor
@Profile("!test")
public class MakeTestData implements ApplicationRunner {


    RiderRepository riderRepository;
    TeamRepository teamRepository;

    public void makeTeamsWithRiders(){
        Team team1 = new Team("SletteMette","A");
        Team team2 = new Team("DetVedJegIkke", "?");

        Rider rider1 = new Rider("Oguzhan Memis");
        Rider rider2 = new Rider("Hakan Memis");
        Rider rider3 = new Rider("Halit Memis");
        Rider rider4 = new Rider("Annette Schou");

        team1.addRiders(Set.of(rider1, rider2));
        team2.addRiders(Set.of(rider3, rider4));

        //teamRepository.saveAll(List.of(team1, team2));

    }




    @Override
    public void run(ApplicationArguments args) throws Exception {

        makeTeamsWithRiders();

    }
}
