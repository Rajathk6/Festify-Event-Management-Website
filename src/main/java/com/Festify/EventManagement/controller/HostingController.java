package com.Festify.EventManagement.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Festify.EventManagement.model.EventHostDatabase;
import com.Festify.EventManagement.model.VenueHostDatabase;
import com.Festify.EventManagement.service.HostingService;

@Controller
@RequestMapping("/submit")
public class HostingController {
    HostingService EventHostService;
    HostingService VenueHostService;

    public HostingController(HostingService EventHostService, HostingService VenueHostService) {
        this.EventHostService = EventHostService;
        this.VenueHostService = VenueHostService;
    }

    @PostMapping("/eventhosting")
    public ResponseEntity<String> getEvent(@ModelAttribute EventHostDatabase hostdata) {
        EventHostService.addEventdetails(hostdata);
        return new ResponseEntity<>("Event hosted successfully", HttpStatus.CREATED);
    }

    @PostMapping("/venuehosting")
    public ResponseEntity<String> getvenue(@ModelAttribute VenueHostDatabase hostvenue) {
        VenueHostService.addVenuedetails(hostvenue);
        return new ResponseEntity<>("Venue hosted successfully", HttpStatus.CREATED);
    }
}
