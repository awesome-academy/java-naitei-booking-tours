package app.service;

import java.util.List;

import app.entity.Tour;

public interface TourService {
	List<Tour> getAllTour();
	
	Tour getTourById(Integer id);
}
