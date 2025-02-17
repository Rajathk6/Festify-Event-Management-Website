package com.Festify.EventManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Festify.EventManagement.model.EventHostDatabase;

@Repository
public interface EventHostingRepository extends JpaRepository<EventHostDatabase, Long> {

}
