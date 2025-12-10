package com.java.interview.designPatterns.structuralPattern.facadePattern;

public class TravelFacade {

    private final HotelService hotelService = new HotelService();
    private final FlightService flightService = new FlightService();
    private final PaymentService paymentService = new PaymentService();

    public void bookTrip(String hotelName, String flightNumber, double amount) {
        System.out.println("Starting booking process...");
        flightService.bookFlight(flightNumber);
        hotelService.bookHotel(hotelName);
        paymentService.processPayment(amount);
        System.out.println("Booking complete!");
    }
}
