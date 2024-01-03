package dao;

import entity.film.Film;
import entity.store.Inventory;
import entity.store.Store;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

public class InventoryDAO extends GenericDAO<Inventory> {
    public InventoryDAO(SessionFactory sessionFactory) {
        super(Inventory.class, sessionFactory);
    }

    public void addFilmToInventory(Film film, Store store) {
        Inventory inventory = new Inventory();
        inventory.setFilm(film);
        inventory.setStore(store);

        save(inventory);
    }

    public List<Inventory> getVacantInventoryList() {
        List<Inventory> busyInventories = getCurrentSession().createQuery("select distinct r.inventory from Rental r where r.returnDate is null",Inventory.class).list();
        List<Inventory> allInventories = findAll();
        List<Inventory> vacantInventories = new ArrayList<>();

        for (Inventory inventory : allInventories) {
            if (!busyInventories.contains(inventory)) {
                vacantInventories.add(inventory);
            }
        }
        return vacantInventories;
    }
}
