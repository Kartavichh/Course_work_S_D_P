import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class PlaceQueue {
    private BlockingQueue<Place> queue;

    public PlaceQueue() {
        this.queue = new LinkedBlockingQueue<>(); // Потокобезопасная очередь
    }

    public void addToQueue(Place place) {
        try {
            queue.put(place); // Добавление в очередь
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Восстановление статуса прерывания
            System.err.println("Interrupted while adding to place queue: " + e.getMessage());
        }
    }

    public BlockingQueue<Place> getQueue() {
        return queue; // Получение очереди
    }
}
