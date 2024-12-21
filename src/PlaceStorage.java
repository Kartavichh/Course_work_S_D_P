import java.util.ArrayList;
import java.util.List;

// Хранилище данных для мест
// Шаблон: Singleton
public enum PlaceStorage {
    INSTANCE; // Единственный экземпляр

    private final List<Place> places = new ArrayList<>();

    public synchronized void add(Place place) {
        places.add(place); // Добавление в хранилище
    }

    public List<Place> getPlaces() {
        return places; // Получение списка мест
    }
}
