package app.controller.admin;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import app.service.BookingService;

@Controller
@RequestMapping(value = "/bookings")
public class BookingController extends AdminController {

    @Autowired
    private BookingService bookingService;

    @PostMapping("/{id}/approve")
    public String approveBooking(@PathVariable("id") Integer id, HttpSession session) {
        if (checkAdmin(session)) {
            bookingService.approveBooking(id);
            return "redirect:/bookings";
        } else {
            return "views/error/unauthorized";
        }
    }

    @PostMapping("/{id}/decline")
    public String declineBooking(@PathVariable("id") Integer id, HttpSession session) {
        if (checkAdmin(session)) {
            bookingService.declineBooking(id);
            return "redirect:/bookings";
        } else {
            return "views/error/unauthorized";
        }
    }
}
