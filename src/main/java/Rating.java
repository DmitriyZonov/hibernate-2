import static java.util.Objects.isNull;

public enum Rating {
    G("G"), PG("PG"), PG13("PG-13"), R("R"), NC17("NC-17");

    private String title;

    Rating(String title){
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public static Rating getRatingByTitle(String title) {
        if (isNull(title) || title.isEmpty()) {
            return null;
        }

        Rating[] ratings = Rating.values();
        for(Rating rating : ratings) {
            if (rating.getTitle().equals(title)) {
                return rating;
            }
        }
        return null;
    }
}
