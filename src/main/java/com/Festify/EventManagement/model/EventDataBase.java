package com.Festify.EventManagement.model;

import java.time.LocalDate;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="eventdatabase")
public class EventDataBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Event_Name", nullable = false)
    private String eventName;

    @Column(name = "Event_Date", nullable = false)
    
    private LocalDate eventDate;

    @Column(name = "Event_Time", nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss")
    private LocalTime eventTime;

    @Column(name = "Address", nullable = false)
    private String address;

    @Column(name = "City", nullable = false)
    private String city;

    @Column(name = "State", nullable = false)
    private String state;

    @Column(name = "ZipCode", nullable = false)
    private String zipCode;

    @Column(name = "Description")
    private String description;

    @Column(name = "Ticket_Quantity", nullable = false)
    private Integer ticketQuantity;

    @Column(name = "Price", nullable = false)
    private Double price;

    @Enumerated(EnumType.STRING) // Maps the enum to a string column in the database
    @Column(name = "status", nullable = false)
    private EventStatus status;

    @Column(name = "Image_URL", nullable = false)
    private String imageUrl;

    @ManyToOne
    @JoinColumn(name = "Event_Category_Id", nullable = false)
    @JsonManagedReference
    private EventCategory eventCategory;
}
