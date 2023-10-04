package app.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import app.entity.User;
import app.entity.User.Role;
import app.service.BookingService;

@Controller
public class UserController {

    @Autowired
    private BookingService bookingService;

    @GetMapping("/bookings")
    public String booking(Model model, HttpSession session) {
        model.addAttribute("bookings", bookingService.getAllBooking());
        model.addAttribute("session", session);
        return "views/bookings/admin_manage";
    }
    
    @GetMapping("/orders")
    public String order(Model model, HttpSession session) {
    	// Xử lý logic ở đây
    	return "views/bookings/user_manage";
    }
}
