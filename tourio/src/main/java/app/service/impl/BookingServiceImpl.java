package app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.dao.BookingDao;
import app.entity.Booking;
import app.service.BookingService;

@Component
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingDao bookingDao;

    @Override
    public List<Booking> getAllBooking() {
        return bookingDao.getAll();
    }

    @Override
    public boolean approveBooking(Integer bookingId) {
        Booking booking = bookingDao.get(bookingId);
        booking.setStatus(Booking.Status.APPROVED);
        return bookingDao.update(booking);
    }

    @Override
    public boolean declineBooking(Integer bookingId) {
        Booking booking = bookingDao.get(bookingId);
        booking.setStatus(Booking.Status.DECLINED);
        return bookingDao.update(booking);
    }

}
