package com.rperezv365.tests.flightreservation.model;

public record FlightReservationTestData(
        String firstName,
        String lastName,
        String email,
        String password,
        String street,
        String city,
        String zip,
        String passengersCount,
        String expectedPrice
) {
}
