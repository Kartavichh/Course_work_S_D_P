import java.util.ArrayList;
import java.util.List;

public enum PlaceStorage {
    INSTANCE;
    private final List<Place> places = new ArrayList<>();

    public synchronized void add(Place place) {
        places.add(place);
    }

    public List<Place> getPlaces() {
        return places;
    }
}
