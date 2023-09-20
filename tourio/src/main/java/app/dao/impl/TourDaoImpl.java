package app.dao.impl;

import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import app.dao.TourDao;
import app.entity.Tour;

@Repository("tourDaoImpl")
@SuppressWarnings("unchecked")
@Component
public class TourDaoImpl implements TourDao {

    @Autowired
    private HibernateTemplate template;

    @Override
    public Tour getTour(Integer tourId) {
        return template.get(Tour.class, tourId);
    }

    @Override
    public List<Tour> getAllTour() {
        DetachedCriteria dc = DetachedCriteria.forClass(Tour.class);
        return (List<Tour>) template.findByCriteria(dc);
    }

	@Override
	public boolean addTour(Tour tour) {
		return template.save(tour) != null;
	}

	@Override
	public boolean updateTour(Tour tour) {
		return template.save(tour) != null;
	}

	@Override
	public void deleteTour(Long tourId) {
		Tour tour = (Tour) template.load("Tour", tourId, LockMode.PESSIMISTIC_WRITE);
		template.delete(tour);
	}

}
