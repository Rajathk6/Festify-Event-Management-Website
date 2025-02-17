package com.Festify.EventManagement.service;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import com.Festify.EventManagement.model.EventDataBase;
import com.Festify.EventManagement.repository.EventRepository;

@Service

public class EventService {
    // constructor injection
    EventRepository EventRepo;

    public EventService(EventRepository EventRepo) {
        this.EventRepo = EventRepo;
    }

    // LISTS ALL THE EVENTS IN THE EVENT DATABASE
    public List<EventDataBase> trashData() {
        List<EventDataBase> events = EventRepo.findAll();
        return events;
    }

    // ADDS A NEW EVENT FROM THE CLIENT SIDE TO THE DATABASE
    public void addEvent(EventDataBase newEvent) {
        EventRepo.save(newEvent);
    }

    public List<EventDataBase> getEventById(Long eventId) {
        return EventRepo.findById(eventId).map(Collections::singletonList) .orElseGet(Collections::emptyList);
    }
}
