package com.Festify.EventManagement.service;

import org.springframework.stereotype.Service;

import com.Festify.EventManagement.model.EventHostDatabase;
import com.Festify.EventManagement.model.VenueHostDatabase;
import com.Festify.EventManagement.repository.EventHostingRepository;
import com.Festify.EventManagement.repository.VenueHostingRepository;

@Service
public class HostingService {
    EventHostingRepository eventhostrepo;
    VenueHostingRepository venuehostrepo;

    public HostingService(EventHostingRepository eventhostrepo, VenueHostingRepository venuehostrepo) {
        this.eventhostrepo = eventhostrepo;
        this.venuehostrepo = venuehostrepo;
    }

    public void addEventdetails(EventHostDatabase hostdata) {
        eventhostrepo.save(hostdata);
    }

    public void addVenuedetails(VenueHostDatabase hostvenue) {
        venuehostrepo.save(hostvenue);
    }
}
