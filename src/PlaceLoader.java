import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Загрузка данных с использованием очереди задач
// Шаблоны: Template Method, Queue-based Processing
public class PlaceLoader {

    public void loadPlaces(PlaceFactory placeFactory, PlaceStorage placeStorage) {
        PlaceQueue placeQueue = new PlaceQueue(); // Очередь для загрузки данных
        PlaceHandler placeHandler = new PlaceHandler(placeQueue.getQueue(), placeStorage);

        System.out.println("Начинаем загрузку данных...");
        try (ExecutorService executor = Executors.newFixedThreadPool(2)) {
            executor.execute(() -> {
                placeQueue.addToQueue(placeFactory.createPlace("Кремль", "Историческое место", "Кремль — главная достопримечательность Нижнего Новгорода."));
                System.out.println("Added Kremlin to queue.");
            });

            executor.execute(() -> {
                placeQueue.addToQueue(placeFactory.createPlace("Чкаловская лестница", "Архитектура", "Лестница с видом на Волгу."));
                System.out.println("Added Chkalovskaya staircase to queue.");
            });

            executor.execute(placeHandler); // Запуск обработчика
            executor.shutdown();
        } finally {
            System.out.println("All data loaded.");
        }
    }
}
