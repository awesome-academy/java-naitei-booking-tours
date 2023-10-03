package app.controller.admin;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;

import app.entity.User;

@Controller
public class AdminController {

    protected boolean checkAdmin(HttpSession session){
        User currentUser = (User) session.getAttribute("user");
        if (currentUser != null && currentUser.getRole() == User.Role.ADMIN) {
            return true;
        } else {
            return false;
        }
    }
}
