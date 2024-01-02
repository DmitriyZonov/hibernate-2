package entity.film;

import entity.film.Film;
import jakarta.persistence.*;
import org.hibernate.annotations.Type;
import org.hibernate.service.ServiceRegistry;

import java.io.Serializable;

@Entity
@Table(name = "film_text", schema = "movie")
public class FilmText implements Serializable {
    @Id
    @OneToOne
    @JoinColumn(name = "film_id")
    private Film film;
    @Column()
    private String title;
    @Column(columnDefinition = "text")
    @Type(type = "text")
    private String description;

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
