package dao;

import entity.extra.Feature;
import entity.extra.Rating;
import entity.film.Actor;
import entity.film.Category;
import entity.film.Film;
import entity.film.Language;
import org.hibernate.SessionFactory;

import java.math.BigDecimal;
import java.time.Year;
import java.util.HashSet;
import java.util.Set;

public class FilmDAO extends GenericDAO<Film> {
    public FilmDAO(SessionFactory sessionFactory) {
        super(Film.class, sessionFactory);
    }

    public Film addFilm(String title, String description, Year releaseYear, Set<Actor> actors, Set<Category> categories, Language language, Language originalLanguage, Short length, Rating rating) {
        Film film = new Film();
        Byte rentalDuration = 3;
        BigDecimal rentalRate = BigDecimal.valueOf(4.99);
        BigDecimal replacementCost = BigDecimal.valueOf(19.99);
        Set<Feature> features = new HashSet<>();
        features.add(Feature.TRAILERS);
        features.add(Feature.BEHIND_THE_SCENES);
        features.add(Feature.COMMENTARIES);

        film.setTitle(title);
        film.setDescription(description);
        film.setReleaseYear(releaseYear);
        film.setActors(actors);
        film.setCategories(categories);
        film.setLanguage(language);
        film.setOriginalLanguage(originalLanguage);
        film.setLength(length);
        film.setRating(rating);
        film.setRentalDuration(rentalDuration);
        film.setRentalRate(rentalRate);
        film.setReplacementCost(replacementCost);
        film.setSpecialFeatures(features);

        save(film);

        return film;
    }
}
