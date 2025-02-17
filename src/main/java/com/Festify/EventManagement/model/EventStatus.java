package com.Festify.EventManagement.model;

public enum EventStatus {
    Available,
    Sold_Out,
    Cancelled;

    public static EventStatus fromString(String status) {
        return EventStatus.valueOf(status.toUpperCase().replace(" ", "_"));
    }
}