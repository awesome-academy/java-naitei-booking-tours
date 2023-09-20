package app.dao;

import java.util.List;

import app.entity.Tour;

public interface TourDao {

    // CRUD operations
	boolean addTour(Tour tour);

    boolean updateTour(Tour tour);

    Tour getTour(Integer tourId);

    void deleteTour(Long tourId);

    // Queries
    List<Tour> getAllTour();
}