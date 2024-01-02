package utility;

import dao.*;
import entity.address.Address;
import entity.address.City;
import entity.address.Country;
import entity.film.*;
import entity.store.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MovieSessionFactory {
    private SessionFactory sessionFactory;
    private ActorDAO actorDAO;
    private AddressDAO addressDAO;
    private CategoryDAO categoryDAO;
    private CityDAO cityDAO;
    private CountryDAO countryDAO;
    private CustomerDAO customerDAO;
    private FilmDAO filmDAO;
    private FilmTextDAO filmTextDAO;
    private InventoryDAO inventoryDAO;
    private LanguageDAO languageDAO;
    private PaymentDAO paymentDAO;
    private RentalDAO rentalDAO;
    private StaffDAO staffDAO;
    private StoreDAO storeDAO;

    public MovieSessionFactory() {
        sessionFactory = new Configuration()
                .addAnnotatedClass(Actor.class)
                .addAnnotatedClass(Address.class)
                .addAnnotatedClass(Category.class)
                .addAnnotatedClass(City.class)
                .addAnnotatedClass(Country.class)
                .addAnnotatedClass(Customer.class)
                .addAnnotatedClass(Film.class)
                .addAnnotatedClass(FilmText.class)
                .addAnnotatedClass(Inventory.class)
                .addAnnotatedClass(Language.class)
                .addAnnotatedClass(Payment.class)
                .addAnnotatedClass(Rental.class)
                .addAnnotatedClass(Staff.class)
                .addAnnotatedClass(Store.class)
                .buildSessionFactory();

        actorDAO = new ActorDAO(sessionFactory);
        addressDAO = new AddressDAO(sessionFactory);
        categoryDAO = new CategoryDAO(sessionFactory);
        cityDAO = new CityDAO(sessionFactory);
        countryDAO = new CountryDAO(sessionFactory);
        customerDAO = new CustomerDAO(sessionFactory);
        filmDAO = new FilmDAO(sessionFactory);
        filmTextDAO = new FilmTextDAO(sessionFactory);
        inventoryDAO = new InventoryDAO(sessionFactory);
        languageDAO = new LanguageDAO(sessionFactory);
        paymentDAO = new PaymentDAO(sessionFactory);
        rentalDAO = new RentalDAO(sessionFactory);
        staffDAO = new StaffDAO(sessionFactory);
        storeDAO = new StoreDAO(sessionFactory);
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public ActorDAO getActorDAO() {
        return actorDAO;
    }

    public AddressDAO getAddressDAO() {
        return addressDAO;
    }

    public CategoryDAO getCategoryDAO() {
        return categoryDAO;
    }

    public CityDAO getCityDAO() {
        return cityDAO;
    }

    public CountryDAO getCountryDAO() {
        return countryDAO;
    }

    public CustomerDAO getCustomerDAO() {
        return customerDAO;
    }

    public FilmDAO getFilmDAO() {
        return filmDAO;
    }

    public FilmTextDAO getFilmTextDAO() {
        return filmTextDAO;
    }

    public InventoryDAO getInventoryDAO() {
        return inventoryDAO;
    }

    public LanguageDAO getLanguageDAO() {
        return languageDAO;
    }

    public PaymentDAO getPaymentDAO() {
        return paymentDAO;
    }

    public RentalDAO getRentalDAO() {
        return rentalDAO;
    }

    public StaffDAO getStaffDAO() {
        return staffDAO;
    }

    public StoreDAO getStoreDAO() {
        return storeDAO;
    }
}