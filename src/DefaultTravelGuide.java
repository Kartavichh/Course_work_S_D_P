import java.util.List;

// Основной фасад для работы с приложением
// Шаблон: Facade
public class DefaultTravelGuide {
    PlaceLoader placeLoader = new PlaceLoader(); // Загрузка мест
    SearchStrategy nameSearch = new NameSearch(); // Поиск по названию (Strategy)
    SearchStrategy categorySearch = new CategorySearch(); // Поиск по категории (Strategy)

    public DefaultTravelGuide() {
        loadPlaces(); // Инициализация данных
    }

    public List<Place> getPlaces() {
        return PlaceStorage.INSTANCE.getPlaces(); // Использование Singleton
    }

    public void loadPlaces() {
        placeLoader.loadPlaces(new PlaceFactory(), PlaceStorage.INSTANCE); // Загрузка данных через PlaceLoader
    }

    public void searchPlacesForName(String name) {
        nameSearch.search(PlaceStorage.INSTANCE.getPlaces(), name); // Вызов стратегии поиска по имени
    }

    public void searchPlacesForCategory(String category) {
        categorySearch.search(PlaceStorage.INSTANCE.getPlaces(), category); // Вызов стратегии поиска по категории
    }
}
