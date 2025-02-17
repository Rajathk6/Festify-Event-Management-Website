package com.Festify.EventManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Festify.EventManagement.model.VenueHostDatabase;

public interface VenueHostingRepository extends JpaRepository<VenueHostDatabase, Long> {

}
