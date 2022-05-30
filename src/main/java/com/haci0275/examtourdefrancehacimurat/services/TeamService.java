package com.haci0275.examtourdefrancehacimurat.services;

import com.haci0275.examtourdefrancehacimurat.repositories.TeamRepository;
import org.springframework.stereotype.Service;

@Service
public class TeamService {

    TeamRepository teamRepository;

    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }
}
