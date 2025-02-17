package com.Festify.EventManagement.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Venuedatabase")
public class VenueDataBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Name", nullable = false)
    private String name;

    @Column(name = "Address", nullable = false)
    private String address;

    @Column(name = "City", nullable = false)
    private String city;

    @Column(name = "State", nullable = false)
    private String state;

    @Column(name = "ZipCode", nullable = false)
    private String zipCode;

    @Enumerated(EnumType.STRING)
    @Column(name = "Status", nullable = false)
    private Venuestatus status = Venuestatus.Available;

    @Column(name = "Capacity", nullable = false)
    private Integer capacity;

    @Column(name = "Description")
    private String description;

    @Column(name = "Image_URL", nullable = false)
    private String imageUrl;

    @Column(name = "Price", nullable = false)
    private Double price;
}
