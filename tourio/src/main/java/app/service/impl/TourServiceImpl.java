package app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.dao.TourDao;
import app.entity.Tour;
import app.service.TourService;

@Component
public class TourServiceImpl implements TourService {
    @Autowired
    private TourDao tourDao;

    @Override
    public List<Tour> getAllTour() {
        return tourDao.getAll();
    }

	@Override
	public Tour getTourById(Integer id) {
		return tourDao.get(id);
	}
    
    
}
