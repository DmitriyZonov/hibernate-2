package dao;

import entity.store.Staff;
import org.hibernate.SessionFactory;

public class StaffDAO extends GenericDAO<Staff> {
    public StaffDAO(SessionFactory sessionFactory) {
        super(Staff.class, sessionFactory);
    }

    @Override
    public Staff getById(int id) {
        byte staffId = (byte) id;
        return getCurrentSession().get(Staff.class, staffId);
    }
}
