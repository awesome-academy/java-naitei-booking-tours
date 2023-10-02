package app.service;

import java.util.List;

import app.entity.Booking;

public interface BookingService {
    List<Booking> getAllBooking();
    boolean approveBooking(Integer bookingId);
    boolean declineBooking(Integer bookingId);
}
