package com.haci0275.examtourdefrancehacimurat.api;

import com.haci0275.examtourdefrancehacimurat.dto.TeamRequest;
import com.haci0275.examtourdefrancehacimurat.dto.TeamResponse;
import com.haci0275.examtourdefrancehacimurat.services.TeamService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/team")
public class TeamController {

    TeamService teamService;
    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping
    public List<TeamResponse> getTeams() {
        return teamService.getTeams();
    }

    @GetMapping("/{id}")
    public TeamResponse getMovieAdmin(@PathVariable int id) throws Exception {
        return teamService.getTeam(id);
    }

    @PostMapping
    public TeamResponse addTeam(@RequestBody TeamRequest body) {
        return teamService.addTeam(body);
    }

    @PutMapping
    public TeamResponse editTeam(@RequestBody TeamRequest body, @PathVariable int id) {
        return teamService.editTeam(body, id);
    }

    @DeleteMapping
    public void deleteTeam(@PathVariable int id) {
        teamService.deleteTeam(id);
    }

}

