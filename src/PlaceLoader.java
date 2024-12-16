import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Лучше добавить к классу DefaultTravelGuide
 */
public class PlaceLoader {
    public static void loadPlaces(List<Place> places) {
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
