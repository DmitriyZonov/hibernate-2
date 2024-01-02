import entity.address.Address;
import entity.address.City;
import entity.store.Customer;
import entity.store.Store;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utility.MovieSessionFactory;

public class Main {
    public static void main(String[] args) {
        MovieSessionFactory sessionFactory = new MovieSessionFactory();

        try(Session session = sessionFactory.getSessionFactory().getCurrentSession()) {
            Transaction transaction = session.beginTransaction();

            City city = sessionFactory.getCityDAO().getByName("Barcelona");
            Address address = sessionFactory.getAddressDAO().createAddress("Noble str, 10", "", "Eixample", city, "08007", "909-878-999");
            Store store = sessionFactory.getStoreDAO().getItems(0, 1).get(0);
            Customer customer = sessionFactory.getCustomerDAO().createCustomer("Andrew", "Weber", "andrewweber@mail.com", store, address);

            transaction.commit();

        }
    }
}
