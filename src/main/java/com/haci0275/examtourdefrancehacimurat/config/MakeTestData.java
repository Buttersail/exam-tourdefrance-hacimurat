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

        Team team2 = new Team("Team+", "+");

        Rider rider3 = new Rider("TeamRider");

        team2.addRider(rider3);

        teamRepository.saveAll(List.of(team2));

    }

    public void makeRiders() {
        Rider rider1 = new Rider("Hakan");
        Rider rider2 = new Rider("Oguzhan");

        riderRepository.save(rider1);
        riderRepository.save(rider2);
    }

    public void makeTeams() {
        Team team1 = new Team("Test", "T");

        teamRepository.save(team1);
    }




    @Override
    public void run(ApplicationArguments args) throws Exception {

        makeTeamsWithRiders();
        makeRiders();
        makeTeams();

    }
}
;