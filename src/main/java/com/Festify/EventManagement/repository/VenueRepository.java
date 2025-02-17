package com.Festify.EventManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Festify.EventManagement.model.VenueDataBase;

@Repository
public interface VenueRepository extends JpaRepository<VenueDataBase, Long> {

}
