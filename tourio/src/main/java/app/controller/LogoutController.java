package app.controller;

import java.util.Locale;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LogoutController {

	@GetMapping("/logout")
	public String logout(@RequestParam(name = "page", required = false) Optional<Integer> page, Locale locale,
		    Model model, HttpSession session) {
		session.removeAttribute("user");
		return "redirect:/";
	}
}
