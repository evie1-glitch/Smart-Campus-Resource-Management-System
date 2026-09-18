package main.java.com.campus.management.service;

import java.util.ArrayList;
import java.util.List;

import main.java.com.campus.management.model.Booking;

public class BookingService {

    private List<Booking> bookings = new ArrayList<>();

    public boolean hasConflict(Booking newBooking) {

        for (Booking booking : bookings) {

            if (booking.getResourceId() == newBooking.getResourceId()
                    && booking.getBookingDate().equals(newBooking.getBookingDate())
                    && booking.getStatus().equals("PENDING")) {

                if (newBooking.getStartTime().compareTo(booking.getEndTime()) < 0
                        && newBooking.getEndTime().compareTo(booking.getStartTime()) > 0) {

                    return true;
                }
            }
        }

        return false;
    }

    public boolean addBooking(Booking booking) {

        if (hasConflict(booking)) {
            return false;
        }

        bookings.add(booking);
        return true;
    }

    public List<Booking> getAllBookings() {
        return bookings;
    }

    public boolean cancelBooking(int bookingId, int userId) {

        for (Booking booking : bookings) {

            if (booking.getId() == bookingId
                    && booking.getUserId() == userId
                    && booking.getStatus().equals("PENDING")) {

                booking.setStatus("CANCELLED");
                return true;
            }
        }

        return false;
    }
}