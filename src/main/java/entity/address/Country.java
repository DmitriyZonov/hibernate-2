package entity.address;

import jakarta.persistence.*;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "country", schema = "movie")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "country_id")
    private Short id;
    @Column(name = "country", nullable = false)
    private String name;
    @UpdateTimestamp
    @Column(name = "last_update", nullable = false)
    private LocalDateTime localDateTime;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }
}
