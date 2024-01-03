package dao;

import entity.store.Staff;
import entity.store.Store;
import org.hibernate.SessionFactory;

public class StoreDAO extends GenericDAO<Store> {
    public StoreDAO(SessionFactory sessionFactory) {
        super(Store.class, sessionFactory);
    }

    @Override
    public Store getById(int id) {
        byte storeId = (byte) id;
        return getCurrentSession().get(Store.class, storeId);
    }
}
