package com.Festify.EventManagement.service;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import com.Festify.EventManagement.model.VenueDataBase;
import com.Festify.EventManagement.repository.VenueRepository;

@Service
public class VenueService {

    VenueRepository VenueRepo;
    public VenueService(VenueRepository VenueRepo) {
        this.VenueRepo = VenueRepo;
    }

    public List<VenueDataBase> GetVenue() {
        return VenueRepo.findAll();
    }

    public List<VenueDataBase> getVenueById(Long id) {
        return VenueRepo.findById(id).map(Collections::singletonList).orElseGet(Collections::emptyList);
    }
}
