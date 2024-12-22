import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Main {
    private static final Object lock = new Object(); // Блокировка для синхронизации вывода

    public static void main(String[] args) {
        DefaultTravelGuide defaultTravelGuide = new DefaultTravelGuide(); // Фасад

        // Создаём два потока для имитации работы двух пользователей
        Runnable user1 = () -> simulateUser("Пользователь 1", defaultTravelGuide);
        Runnable user2 = () -> simulateUser("Пользователь 2", defaultTravelGuide);
        Runnable user3 = () -> simulateUser("Пользователь 3", defaultTravelGuide);
        Runnable user4 = () -> simulateUser("Пользователь 4", defaultTravelGuide);

        Thread thread1 = new Thread(user1);
        Thread thread2 = new Thread(user2);
        Thread thread3 = new Thread(user3);
        Thread thread4 = new Thread(user4);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            synchronized (lock) {
                System.err.println("Главный поток прерван: " + e.getMessage());
            }
        }
    }

    private static void simulateUser(String userName, DefaultTravelGuide travelGuide) {
        Random random = new Random();
        String[] categories = {"Историческое место", "Архитектура"};
        String[] names = {"Кремль", "Чкаловская лестница"};

        for (int i = 0; i < 5; i++) {
            int action = random.nextInt(3) + 1; // Случайное действие: 1, 2 или 3

            synchronized (lock) {
                System.out.println("\n=== " + userName + " ===");
                System.out.println("Время: " + getCurrentTimestamp());
            }

            switch (action) {
                case 1:
                    synchronized (lock) {
                        System.out.println(userName + " показывает все достопримечательности:");
                        for (Place place : travelGuide.getPlaces()) {
                            System.out.println(place);
                        }
                    }
                    break;

                case 2:
                    String nameQuery = names[random.nextInt(names.length)];
                    synchronized (lock) {
                        System.out.println(userName + " ищет по названию: " + nameQuery);
                    }
                    travelGuide.searchPlaces("name", nameQuery);
                    break;

                case 3:
                    String categoryQuery = categories[random.nextInt(categories.length)];
                    synchronized (lock) {
                        System.out.println(userName + " ищет по категории: " + categoryQuery);
                    }
                    travelGuide.searchPlaces("category", categoryQuery);
                    break;

                default:
                    synchronized (lock) {
                        System.out.println(userName + ": неизвестная команда.");
                    }
            }

            try {
                Thread.sleep(1000); // Пауза между действиями
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                synchronized (lock) {
                    System.err.println(userName + " прерван: " + e.getMessage());
                }
            }
        }
    }

    private static String getCurrentTimestamp() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        return sdf.format(new Date());
    }
}
