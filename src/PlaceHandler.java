import java.util.concurrent.BlockingQueue;

public class PlaceHandler implements Runnable {
    private BlockingQueue<Place> queue;
    private PlaceStorage placeStorage;

    public PlaceHandler(BlockingQueue<Place> queue, PlaceStorage placeStorage) {
        this.queue = queue;
        this.placeStorage = placeStorage;
    }

    @Override
    public void run() {
        try {
            while (!queue.isEmpty()) {
                Place place = queue.take(); // Retrieves and removes from the head of the queue
                placeStorage.add(place); // Add place to the storage
                System.out.println("Processed place: " + place.getName());
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Interrupted while handling place: " + e.getMessage());
        }
    }
}
