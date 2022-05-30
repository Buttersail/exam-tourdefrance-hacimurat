package com.haci0275.examtourdefrancehacimurat.api;

import com.haci0275.examtourdefrancehacimurat.dto.RiderRequest;
import com.haci0275.examtourdefrancehacimurat.dto.RiderResponse;
import com.haci0275.examtourdefrancehacimurat.dto.TeamResponse;
import com.haci0275.examtourdefrancehacimurat.services.RiderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/rider")
public class RiderController {

    RiderService riderService;

    public RiderController(RiderService riderService) {
        this.riderService = riderService;
    }


    @GetMapping()
    public List<RiderResponse> getRiders() {
        return riderService.getRiders();
    }

    @GetMapping("/{id}")
    public RiderResponse getRider(@PathVariable int id) throws Exception {
        return riderService.getRider(id);
    }

    @PostMapping("/{id}")
    public RiderResponse addRider(@RequestBody RiderRequest body) {
        return riderService.addRider(body);
    }

    @PutMapping("/{id}")
    public RiderResponse editRider(@RequestBody RiderRequest body, @PathVariable int id) {
        return riderService.editRider(body, id);
    }

    @DeleteMapping("/{id}")
    public void deleteRider(@PathVariable int id) {
        riderService.deleteRider(id);
    }

}