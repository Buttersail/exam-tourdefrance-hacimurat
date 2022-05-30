package com.haci0275.examtourdefrancehacimurat.services;

import com.haci0275.examtourdefrancehacimurat.dto.RiderRequest;
import com.haci0275.examtourdefrancehacimurat.dto.RiderResponse;
import com.haci0275.examtourdefrancehacimurat.entities.Rider;
import com.haci0275.examtourdefrancehacimurat.error.Client4xxException;
import com.haci0275.examtourdefrancehacimurat.repositories.RiderRepository;
import org.springframework.stereotype.Service;

@Service
public class RiderService {

    RiderRepository riderRepository;

    public RiderService(RiderRepository riderRepository) {
        this.riderRepository = riderRepository;
    }

    public RiderResponse addRider(RiderRequest body) {
        Rider newRider = riderRepository.save(new Rider(body));
        return new RiderResponse(newRider);
    }

    public RiderResponse editRider(RiderRequest body, int id) {
        Rider rider = riderRepository.findById(id).orElseThrow();
        return new RiderResponse(riderRepository.save(rider));
    }

    public void deleteRider(int id) {
        Rider rider = riderRepository.findById(id).orElseThrow();
        try {
            riderRepository.delete(rider);
        } catch (Exception ex) {
            throw new RuntimeException();

        }
    }
}