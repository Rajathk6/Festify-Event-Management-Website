package com.Festify.EventManagement.model;

public enum Venuestatus {
    Available,
    Unavailable;

    public static Venuestatus fromString(String status) {
        return Venuestatus.valueOf(status.toUpperCase().replace(" ", "_"));
    }
}
