package dao;

import entity.address.City;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class CityDAO extends GenericDAO<City> {
    public CityDAO(SessionFactory sessionFactory) {
        super(City.class, sessionFactory);
    }

    public City getByName(String name) {

            Query<City> query = getCurrentSession().createQuery("select c from City c where c.name = :NAME", City.class);
            query.setParameter("NAME", name);

            return query.getSingleResult();
    }
}
