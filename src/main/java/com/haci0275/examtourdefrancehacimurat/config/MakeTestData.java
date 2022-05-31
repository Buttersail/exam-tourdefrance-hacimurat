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
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Component
@AllArgsConstructor
@Profile("!test")
@Transactional
public class MakeTestData implements ApplicationRunner {


    RiderRepository riderRepository;
    TeamRepository teamRepository;

    public void makeTeamsWithRiders(){

        Team team1 = new Team("Test", "T");
        Team team2 = new Team("Team+", "+");

        Rider rider1 = new Rider("Hakan", "Denmark", 21, 99.99, 2, 3);
        Rider rider2 = new Rider("Oguzhan", "Denmark", 26, 50.0, 15, 20);
        Rider rider3 = new Rider("TeamRider", "France", 25, 20.0, 20, 30);

        team2.addRider(rider3);
        team1.addRiders(Set.of(rider1, rider2));

        teamRepository.saveAll(List.of(team1, team2));

    }

    public void makeRiders() {
    }

    public void makeTeams() {

    }




    @Override
    public void run(ApplicationArguments args) throws Exception {

        makeTeamsWithRiders();
        //makeRiders();
        //makeTeams();

    }
}
;