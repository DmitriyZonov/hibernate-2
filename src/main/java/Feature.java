import static java.util.Objects.isNull;

public enum Feature {

    TRAILERS("Trailers"),
    COMMENTARIES("Commentaries"),
    DELETED_SCENES("Deleted Scenes"),
    BEHIND_THE_SCENES("Behind the Scenes");
    private String title;

    Feature(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public static Feature getFeatureByTitle(String title) {
        if(isNull(title) || title.isEmpty()) {
            return null;
        }
        Feature[] features = Feature.values();
        for (Feature feature : features)
            if(feature.title.equals(title)) {
                return feature;
            }
        return null;
    }
}
