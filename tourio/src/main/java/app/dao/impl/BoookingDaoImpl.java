package app.dao.impl;

import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import app.dao.BookingDao;
import app.entity.Booking;

@Repository
@SuppressWarnings("unchecked")
public class BoookingDaoImpl implements BookingDao {

    @Autowired
    private HibernateTemplate template;

    @Override
    public boolean add(Booking booking) {
        return template.save(booking) != null;
    }

    @Override
    public boolean update(Booking booking) {
        return template.merge(booking) != null;
    }

    @Override
    public Booking get(Integer bookingId) {
        return template.get(Booking.class, bookingId);
    }

    @Override
    public void delete(Integer userId) {
        Booking booking = (Booking) template.load("Booking", userId, LockMode.PESSIMISTIC_WRITE);
        template.delete(booking);
    }

    @Override
    public List<Booking> getAll() {
        DetachedCriteria dc = DetachedCriteria.forClass(Booking.class);
        return (List<Booking>) template.findByCriteria(dc);
    }
}
