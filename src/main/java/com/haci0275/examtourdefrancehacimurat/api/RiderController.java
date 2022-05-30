package com.haci0275.examtourdefrancehacimurat.api;

import com.haci0275.examtourdefrancehacimurat.dto.RiderRequest;
import com.haci0275.examtourdefrancehacimurat.dto.RiderResponse;
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

    @PostMapping
    public RiderResponse addRider(@RequestBody RiderRequest body) {
        return riderService.addRider(body);
    }

    @PutMapping
    public RiderResponse editRider(@RequestBody RiderRequest body, @PathVariable int id) {
        return riderService.editRider(body, id);
    }

    @DeleteMapping
    public void deleteRider(@PathVariable int id) {
        riderService.deleteRider(id);
    }

}