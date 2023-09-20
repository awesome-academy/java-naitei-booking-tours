package app.dao;

import java.util.List;

import app.entity.Tour;

public interface TourDao {

    // CRUD operations
    public default void addTour(Tour tour) throws Exception {
        throw new Exception("Method not implemented");
    }

    public default void updateTour(Tour tour) throws Exception {
        throw new Exception("Method not implemented");
    }

    public default Tour getTour(Integer tourId) throws Exception {
        throw new Exception("Method not implemented");
    }

    public default void deleteTour(Tour tourId) throws Exception {
        throw new Exception("Method not implemented");
    }

    // Queries
    public default List<Tour> getAllTour() throws Exception {
        throw new Exception("Method not implemented");
    }
}