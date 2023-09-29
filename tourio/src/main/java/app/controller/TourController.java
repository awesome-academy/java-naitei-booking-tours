package app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import app.entity.Tour;
import app.service.TourService;

@Controller("tours")
public class TourController {

    @Autowired
    private TourService tourService;

    @GetMapping(value = "/{id}")
    public String getTourDetails(@PathVariable Integer id, Model model) {
        Tour tour = tourService.getTourById(id);
        model.addAttribute("tour", tour);
        return "views/tours/show"; 
    }
}
