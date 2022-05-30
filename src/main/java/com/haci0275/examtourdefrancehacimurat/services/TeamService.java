package com.haci0275.examtourdefrancehacimurat.services;

import com.haci0275.examtourdefrancehacimurat.dto.RiderRequest;
import com.haci0275.examtourdefrancehacimurat.dto.RiderResponse;
import com.haci0275.examtourdefrancehacimurat.dto.TeamRequest;
import com.haci0275.examtourdefrancehacimurat.dto.TeamResponse;
import com.haci0275.examtourdefrancehacimurat.entities.Rider;
import com.haci0275.examtourdefrancehacimurat.entities.Team;
import com.haci0275.examtourdefrancehacimurat.error.Client4xxException;
import com.haci0275.examtourdefrancehacimurat.repositories.TeamRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {

    TeamRepository teamRepository;

    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public List<TeamResponse> getTeams(){
        List<Team> teams = teamRepository.findAll();
        return TeamResponse.getTeamsFromEntities(teams);
    }

    public TeamResponse getTeam(int id) throws Exception {
        Team team = teamRepository.findById(id).orElseThrow(() -> new Client4xxException("Fejl", HttpStatus.NOT_FOUND));
        return new TeamResponse(team);
    }

    public TeamResponse addTeam(TeamRequest body) {
        Team newTeam = teamRepository.save(new Team(body));
        return new TeamResponse(newTeam);
    }

    public TeamResponse editTeam(TeamRequest body, int id) {
        Team team = teamRepository.findById(id).orElseThrow();
        return new TeamResponse(teamRepository.save(team));
    }

    public void deleteTeam(int id) {
        Team team = teamRepository.findById(id).orElseThrow();
        try {
            teamRepository.delete(team);
        } catch (Exception ex) {
            throw new Client4xxException("Fejl", HttpStatus.NOT_FOUND);

        }
    }
}
