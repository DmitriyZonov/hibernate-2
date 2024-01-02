package dao;

import entity.address.Address;
import entity.store.Customer;
import entity.store.Store;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.time.LocalDateTime;

public class CustomerDAO extends GenericDAO<Customer>{
    public CustomerDAO(SessionFactory sessionFactory) {
        super(Customer.class, sessionFactory);
    }

    @Override
    public Customer save(Customer customer) {
        try (Session session = getCurrentSession()) {
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(customer);
            transaction.commit();
            return customer;
        }
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
}
