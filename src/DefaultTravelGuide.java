import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DefaultTravelGuide {

    // Список мест
    static List<Place> places = new ArrayList<>();

    public DefaultTravelGuide() {
        DefaultTravelGuide.loadPlaces();
    }

    public List<Place> getPlaces() {
        return places;
    }

    public static void loadPlaces() {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        executor.execute(() -> {
            synchronized (places) {
                places.add(PlaceFactory.createPlace("Кремль", "Историческое место", "Кремль — главная достопримечательность Нижнего Новгорода."));
                System.out.println("Загружены данные о Кремле.");
            }
        });

        executor.execute(() -> {
            synchronized (places) {
                places.add(PlaceFactory.createPlace("Чкаловская лестница", "Архитектура", "Лестница с видом на Волгу."));
                System.out.println("Загружены данные о Чкаловской лестнице.");
            }
        });

        executor.shutdown();
        while (!executor.isTerminated()) {
        }
        System.out.println("Все данные загружены.");
    }
}
