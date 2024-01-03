package dao;

import entity.store.Customer;
import entity.store.Inventory;
import entity.store.Rental;
import entity.store.Staff;
import org.hibernate.SessionFactory;

import java.time.LocalDateTime;
import java.util.List;

public class RentalDAO extends GenericDAO<Rental> {
    public RentalDAO(SessionFactory sessionFactory) {
        super(Rental.class, sessionFactory);
    }

    public Rental getRentalByDebtCustomer(Customer customer) {
        Rental neededRental = new Rental();
        List<Rental> rentals = getCurrentSession().createQuery("select r from Rental r where r.returnDate is null", Rental.class).list();

        for (Rental rental : rentals) {
            if (rental.getCustomer() == customer) {
                neededRental = rental;
            }
        }
        return neededRental;
    }
    public Rental addRental(Inventory inventory, Customer customer, Staff staff) {
        Rental rental = new Rental();
        rental.setInventory(inventory);
        rental.setCustomer(customer);
        rental.setStaff(staff);
        rental.setRentalDate(LocalDateTime.now());

        save(rental);

        return rental;
    }
}
