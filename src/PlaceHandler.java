import java.util.concurrent.BlockingQueue;

// Обработчик мест из очереди
// Шаблон: Queue-based Processing
public class PlaceHandler implements Runnable {
    private BlockingQueue<Place> queue; // Очередь для обработки
    private PlaceStorage placeStorage; // Хранилище мест (Singleton)

    public PlaceHandler(BlockingQueue<Place> queue, PlaceStorage placeStorage) {
        this.queue = queue;
        this.placeStorage = placeStorage;
    }

    @Override
    public void run() {
        try {
            while (!queue.isEmpty()) {
                Place place = queue.take(); // Извлечение из очереди
                placeStorage.add(place); // Добавление в хранилище
                System.out.println("Processed place: " + place.getName());
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Interrupted while handling place: " + e.getMessage());
        }
    }
}
