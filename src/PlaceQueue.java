import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class PlaceQueue {
    private BlockingQueue<Place> queue;

    public PlaceQueue() {
        this.queue = new LinkedBlockingQueue<>();
    }

    public void addToQueue(Place place) {
        try {
            queue.put(place); // Add place to the queue
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Interrupted while adding to place queue: " + e.getMessage());
        }
    }

    public BlockingQueue<Place> getQueue() {
        return queue;
    }
}
