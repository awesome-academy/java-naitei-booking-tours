package app.program;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import app.config.AppConfig;
import app.dao.TourDao;
import app.entity.Tour;

public class TestingHibernateTemplate {

    public static void main(String[] args) throws Exception {

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        TourDao tourDao = ctx.getBean("tourDaoImpl", TourDao.class);
        System.out.println("tourDao is an instance of" + tourDao.getClass().getName());

        List<Tour> tours = tourDao.getAllTour();
        System.out.println("There are " + tours.size() + " tours.");
        for (Tour tour : tours) {
            System.out.println(tour.toString());
        }

        Tour tour = tourDao.getTour(2);
        System.out.println(tour.toString());

        ctx.close();
    }

}
