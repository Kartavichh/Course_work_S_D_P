import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PlaceLoader {
    public void loadPlaces(PlaceFactory placeFactory, PlaceStorage placeStorage) {
        PlaceQueue placeQueue = new PlaceQueue(); // Создание очереди
        PlaceHandler placeHandler = new PlaceHandler(placeQueue.getQueue(), placeStorage); // Обработчик очереди

        System.out.println("Начинаем загрузку данных...");
        try (ExecutorService executor = Executors.newFixedThreadPool(2)) { // Пул из 2 потоков
            executor.execute(() -> {
                placeQueue.addToQueue(placeFactory.createPlace("Кремль", "Историческое место", "Кремль — главная достопримечательность."));
            });

            executor.execute(() -> {
                placeQueue.addToQueue(placeFactory.createPlace("Чкаловская лестница", "Архитектура", "Лестница с видом на Волгу."));
            });

            executor.execute(placeHandler); // Запуск обработчика очереди
            executor.shutdown(); // Завершение работы пула потоков
        } finally {
            System.out.println("Все данные загружены.");
        }
    }
}
