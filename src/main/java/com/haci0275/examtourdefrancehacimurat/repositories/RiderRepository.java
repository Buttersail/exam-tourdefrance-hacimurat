package com.haci0275.examtourdefrancehacimurat.repositories;

import com.haci0275.examtourdefrancehacimurat.entities.Rider;
import com.haci0275.examtourdefrancehacimurat.entities.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RiderRepository extends JpaRepository<Rider, Integer> {
    List<Team> findRiderByTeam_TeamLetter(String letter);
}
