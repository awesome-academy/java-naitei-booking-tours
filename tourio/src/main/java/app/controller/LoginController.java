package app.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import app.entity.User;
import app.service.UserService;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/login")
    public String showLoginForm(Model model) {
        return "views/statics-page/login";
    }

    @PostMapping(value = "/login")
    public String submitLoginForm(@RequestParam("email") String email, @RequestParam("password") String password,
            HttpSession session, Model model) {

        User user = userService.getUser(email, password);
        if (user == null) {
            model.addAttribute("error", "Email or password is incorrect.");
            return "views/statics-page/login";
        }
        if (user.getRole() == User.Role.USER) session.setAttribute("user", user);
        else if (user.getRole() == User.Role.ADMIN) session.setAttribute("admin", user);
        return "redirect:/";
    }

}
