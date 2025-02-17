package com.Festify.EventManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Festify.EventManagement.model.EventDataBase;

@Repository
public interface EventRepository extends JpaRepository<EventDataBase, Long> {

}
