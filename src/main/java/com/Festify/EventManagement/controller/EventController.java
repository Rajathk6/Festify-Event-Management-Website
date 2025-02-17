package com.Festify.EventManagement.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Festify.EventManagement.model.EventDataBase;
import com.Festify.EventManagement.service.EventService;

@RequestMapping("/eventapi")
@RestController
public class EventController {
    EventService service;
    public EventController(EventService service) {
        this.service = service;
    }

    // DISPLAYS THE EVENTS PRESENT IN THE EVENT DATABASE
    @GetMapping("/data")
    public List<EventDataBase> getName() {
        return service.trashData();
    }
}
