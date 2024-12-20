import java.util.List;

public class DefaultTravelGuide {
    PlaceLoader placeLoader = new PlaceLoader();
    SearchStrategy nameSearch = new NameSearch();
    SearchStrategy categorySearch = new CategorySearch();

    public DefaultTravelGuide() {
        loadPlaces();
    }

    public List<Place> getPlaces() {
        return PlaceStorage.INSTANCE.getPlaces();
    }

    public void loadPlaces() {
       placeLoader.loadPlaces(new PlaceFactory(), PlaceStorage.INSTANCE);
    }

    public void searchPlacesForName(String name) {
        nameSearch.search(PlaceStorage.INSTANCE.getPlaces(), name);
    }

    public void searchPlacesForCategory(String category) {
        categorySearch.search(PlaceStorage.INSTANCE.getPlaces(), category);
    }
}
