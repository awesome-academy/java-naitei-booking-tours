package app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import app.entity.User;
import app.entity.User.Role;
import app.service.UserService;
import app.validator.RegisterValidator;

@Controller
public class RegisterController {

    @Autowired
    private UserService userService;
    @Autowired
    private RegisterValidator validator;

    @GetMapping(value = "/register")
    public String showRegisterForm(Model model) {
        User user = new User();
        user.setRole(Role.USER);
        model.addAttribute("user", user); // add user for html form
        return "views/statics-page/register";
    }

    @PostMapping(value = "/register")
    public String submitRegisterForm(@ModelAttribute("user") User user, BindingResult errors) {

        validator.validate(user, errors);

        if (errors.hasErrors()) {
            return "views/statics-page/register";
        }
        userService.registerUser(user);
        return "redirect:/login";
    }

}
