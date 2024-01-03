package dao;

import entity.address.Address;
import entity.store.Customer;
import entity.store.Store;
import org.hibernate.SessionFactory;

import java.time.LocalDateTime;
import java.util.List;

public class CustomerDAO extends GenericDAO<Customer>{
    public CustomerDAO(SessionFactory sessionFactory) {
        super(Customer.class, sessionFactory);
    }

    @Override
    public Customer getById(int id) {
        short customerId = (short) id;
        return getCurrentSession().get(Customer.class, customerId);
    }

    public Customer createCustomer(String firstName, String lastName, String email, Store store, Address address) {
      Customer customer = new Customer();
      customer.setFirstName(firstName);
      customer.setLastName(lastName);
      customer.setEmail(email);
      customer.setStore(store);
      customer.setAddress(address);
      customer.setActive(true);
      customer.setCreateDate(LocalDateTime.now());
      customer.setLastUpdate(LocalDateTime.now());

      return customer;
    }

    public List<Customer> getDebtorCustomerList() {
        return getCurrentSession().createQuery("select r.customer from Rental r where r.returnDate is null", Customer.class).list();
    }
    public List<Customer> getNotDebtorCustomerList() {
        return getCurrentSession().createQuery("select r.customer from Rental r where r.returnDate is not null", Customer.class).list();
    }
}
