package app.controller;

import java.util.List;
import java.util.Locale;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import app.entity.Tour;
import app.service.TourService;

@Controller
public class HomeController {

    @Autowired
    private TourService tourService;

    @GetMapping(value = "/")
    public String index(@RequestParam(name = "page", required = false) Optional<Integer> page, Locale locale,
            Model model, HttpSession session) {
        List<Tour> tours = tourService.getAllTour();
        model.addAttribute("tours", tours);
        return "views/statics-page/home";
    }
}
