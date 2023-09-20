package app.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import app.dao.TourDao;
import app.entity.Tour;

@Repository("tourDaoImpl")
@SuppressWarnings("unchecked")
public class TourDaoImpl implements TourDao {

    @Autowired
    private HibernateTemplate template;

    @Override
    public Tour getTour(Integer tourId) throws Exception {
        return template.get(Tour.class, tourId);
    }

    @Override
    public List<Tour> getAllTour() throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(Tour.class);
        return (List<Tour>) template.findByCriteria(dc);
    }

}
