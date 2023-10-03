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
        User currentUser = (User) session.getAttribute("user");
        if (currentUser.getRole() == Role.ADMIN) {
            model.addAttribute("bookings", bookingService.getAllBooking());
            return "views/bookings/admin_manage";
        } else {
            return "views/bookings/user_manage";
        }
    }
}
