package com.Festify.EventManagement.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.Festify.EventManagement.model.EventDataBase;
import com.Festify.EventManagement.model.VenueDataBase;
import com.Festify.EventManagement.service.EventService;
import com.Festify.EventManagement.service.VenueService;

@Controller
public class RequestHandler {
    // constructor injection for service layer
    EventService Eventservice;
    VenueService Venueservice;

    public RequestHandler(EventService Eventservice, VenueService Venueservice) {
        this.Eventservice = Eventservice;
        this.Venueservice = Venueservice;
    }

    @GetMapping("/")
    public String hello() {
        return "home";
    }

    @GetMapping("/events")
    // Model is a SpringBoot pre-defined class which helps link the backend database
    // entities to its frontend counterpart (when used with thymeleaf)
    public String getEvents(Model model) {
        List<EventDataBase> event = Eventservice.trashData();
        model.addAttribute("events", event);
        return "event";
    }

    @GetMapping("/events/{eventId}")
    public String getEventDetails(@PathVariable Long eventId, Model model) {
        List<EventDataBase> eventDetail = Eventservice.getEventById(eventId);
        model.addAttribute("events", eventDetail);
        return "eventDetails";
    }

    @GetMapping("/venue")
    public String getVenue(Model model) {
        List<VenueDataBase> Venue = Venueservice.GetVenue();
        model.addAttribute("Venues", Venue);
        return "venue";
    }

    @GetMapping("/venue/{id}")
    public String GetVenueById(@PathVariable Long id, Model model) {
        List<VenueDataBase> venue = Venueservice.getVenueById(id);
        model.addAttribute("venue", venue);
        return "venueDetails";
    }

    @GetMapping("/eventhosting")
    public String Eventhosting() {
        return "eventhosting";
    }

    @GetMapping("/venuehosting")
    public String Venuehosting() {
        return "venuehosting";
    }

    @GetMapping("/signin")
    public String signin() {
        return "signin";
    }

    @GetMapping("/signup")
    public String signup() {
        return "signup";
    }

    @GetMapping("/privacy-policy")
    public String policy() {
        return "privacyPolicy";
    }
}
