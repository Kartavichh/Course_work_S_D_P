import java.util.List;

// Основной фасад для работы с приложением
// Шаблон: Facade
public class DefaultTravelGuide {
    PlaceLoader placeLoader = new PlaceLoader(); // Загрузка мест

    public DefaultTravelGuide() {
        loadPlaces(); // Инициализация данных
    }

    public List<Place> getPlaces() {
        return PlaceStorage.INSTANCE.getPlaces(); // Использование Singleton
    }

    public void loadPlaces() {
        placeLoader.loadPlaces(new PlaceFactory(), PlaceStorage.INSTANCE); // Загрузка данных через PlaceLoader
    }

    public void searchPlaces(String strategyName, String query) {
        SearchStrategy strategy = StrategyRegistry.getStrategy(strategyName); // Получение стратегии из реестра
        if (strategy != null) {
            strategy.search(PlaceStorage.INSTANCE.getPlaces(), query);
        } else {
            System.out.println("Стратегия " + strategyName + " не найдена.");
        }
    }
}
