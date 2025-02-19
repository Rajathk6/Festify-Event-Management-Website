package com.Festify.EventManagement.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Festify.EventManagement.model.VenueDataBase;
import com.Festify.EventManagement.service.VenueService;

@RestController
@RequestMapping("/venueapi")
public class VenueController {
    
    VenueService service;
    public VenueController(VenueService service) {
        this.service = service;
    }

    @GetMapping("/data")
    public ResponseEntity<List<VenueDataBase>> GetVenueData() {
        List<VenueDataBase> venues = service.GetVenue();
        return new ResponseEntity<>(venues, HttpStatus.OK);
    }
}
