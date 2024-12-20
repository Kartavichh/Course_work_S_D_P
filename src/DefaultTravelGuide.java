import java.util.List;

public class DefaultTravelGuide {

    PlaceStorage placeStorage = new PlaceStorage();
    PlaceLoader placeLoader = new PlaceLoader();
    SearchStrategy nameSearch = new NameSearch();
    SearchStrategy categorySearch = new CategorySearch();

    public DefaultTravelGuide() {
        loadPlaces();
    }

    public List<Place> getPlaces() {
        return placeStorage.getPlaces();
    }

    public void loadPlaces() {
       placeLoader.loadPlaces(new PlaceFactory(), placeStorage);
    }

    public void searchPlacesForName(String name) {
        nameSearch.search(placeStorage.getPlaces(), name);
    }

    public void searchPlacesForCategory(String category) {
        categorySearch.search(placeStorage.getPlaces(), category);
    }
}
