package utility;

import entity.extra.Rating;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import static java.util.Objects.isNull;

@Converter(autoApply = true)
public class RatingConverter implements AttributeConverter<Rating, String> {

    @Override
    public String convertToDatabaseColumn(Rating rating) {

        return rating.getTitle();
    }

    @Override
    public Rating convertToEntityAttribute(String s) {
        if (isNull(s) || s.isEmpty()) {
            return null;
        }
        Rating[] ratings = Rating.values();
        for(Rating rating : ratings) {
            if (rating.getTitle().equals(s)) {
                return rating;
            }
        }
        return null;
    }
}
