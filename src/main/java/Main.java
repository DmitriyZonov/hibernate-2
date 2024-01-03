import entity.address.Address;
import entity.address.City;
import entity.extra.Rating;
import entity.film.Actor;
import entity.film.Category;
import entity.film.Film;
import entity.film.Language;
import entity.store.*;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utility.MovieSessionFactory;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Year;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        MovieSessionFactory sessionFactory = new MovieSessionFactory();

        Main.addCustomer(sessionFactory);
        Main.customerReturnFilm(sessionFactory);
        Main.customerComeToStoreAndRentFilm(sessionFactory);
        Main.newFilmInStore(sessionFactory);
    }

    private static void addCustomer(MovieSessionFactory sessionFactory) {

        try(Session session = sessionFactory.getSessionFactory().getCurrentSession()) {
            Transaction transaction = session.beginTransaction();

            City city = sessionFactory.getCityDAO().getByName("Barcelona");

            Address address = sessionFactory.getAddressDAO().createAddress("Noble str, 10",
                    "",
                    "Eixample",
                    city,
                    "08007",
                    "909-878-999");

            Store store = sessionFactory.getStoreDAO().getItems(0, 1).get(0);

            Customer customer = sessionFactory.getCustomerDAO().createCustomer("Andrew",
                    "Weber",
                    "andrewweber@mail.com",
                    store,
                    address);

            sessionFactory.getCustomerDAO().save(customer);
            transaction.commit();
        }
    }

    private static void customerReturnFilm(MovieSessionFactory sessionFactory) {
        try (Session session = sessionFactory.getSessionFactory().getCurrentSession()) {
            Transaction transaction = session.beginTransaction();
            List<Customer> debtors = sessionFactory.getCustomerDAO().getDebtorCustomerList();
            Customer customer = debtors.get(0);
            Rental rental = sessionFactory.getRentalDAO().getRentalByDebtCustomer(customer);
            rental.setReturnDate(LocalDateTime.now());

            transaction.commit();
        }
    }

    private static void customerComeToStoreAndRentFilm(MovieSessionFactory sessionFactory) {
        try (Session session = sessionFactory.getSessionFactory().getCurrentSession()) {
            Transaction transaction = session.beginTransaction();

            List<Inventory> inventories = sessionFactory.getInventoryDAO().getVacantInventoryList();
            Inventory inventory = inventories.get(0);
            Customer customer = sessionFactory.getCustomerDAO().getNotDebtorCustomerList().get(0);
            Staff staff = sessionFactory.getStaffDAO().getById(1);
            Rental rental = sessionFactory.getRentalDAO().addRental(inventory, customer, staff);
            BigDecimal amount = BigDecimal.valueOf(4.99);
            sessionFactory.getPaymentDAO().createPayment(customer, staff, rental, amount);

            transaction.commit();
        }
    }

    private static void newFilmInStore(MovieSessionFactory sessionFactory) {
        try (Session session = sessionFactory.getSessionFactory().getCurrentSession()){
            Transaction transaction = session.beginTransaction();

            String wonkaDescription = "With dreams of opening a shop in a city renowned for its chocolate, a young and poor Willy Wonka discovers that the industry is run by a cartel of greedy chocolatiers.";
            Language language = sessionFactory.getLanguageDAO().getById(1);
            Year releaseYear = Year.of(2023);
            Short length = 116;
            Set<Actor> actors = new HashSet<>(sessionFactory.getActorDAO().getItems(20, 20));
            Set<Category> categories = new HashSet<>(sessionFactory.getCategoryDAO().getItems(0, 5));

            Film film = sessionFactory.getFilmDAO().addFilm("WONKA", wonkaDescription, releaseYear, actors, categories, language, language, length, Rating.PG);
            Store store = sessionFactory.getStoreDAO().getById(1);
            sessionFactory.getInventoryDAO().addFilmToInventory(film, store);

            transaction.commit();
        }
    }
}
