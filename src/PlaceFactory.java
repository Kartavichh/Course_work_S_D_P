public class PlaceFactory {
    public Place createPlace(String name, String category, String description) {
        return new Place(name, category, description);
    }
}
