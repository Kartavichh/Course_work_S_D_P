import guide.DefaultTravelGuide;
import guide.Route;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Main {
    private static final Object lock = new Object(); // Блокировка для синхронизации вывода

    public static void main(String[] args) {
        // Использование фасада (Шаблон: Facade)
        DefaultTravelGuide defaultTravelGuide = new DefaultTravelGuide();


        // Имитация работы пользователей
        Runnable user1 = () -> simulateUser("Пользователь 1", defaultTravelGuide);
        Runnable user2 = () -> simulateUser("Пользователь 2", defaultTravelGuide);
        Runnable user3 = () -> simulateUser("Пользователь 3", defaultTravelGuide);
        Runnable user4 = () -> simulateUser("Пользователь 4", defaultTravelGuide);

        // Создаем и запускаем потоки (Шаблон: Thread)
        Thread thread1 = new Thread(user1);
        Thread thread2 = new Thread(user2);
        Thread thread3 = new Thread(user3);
        Thread thread4 = new Thread(user4);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        try {
            // Ожидание завершения потоков
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
        } catch (InterruptedException e) {
            synchronized (lock) {
                System.err.println("Главный поток прерван: " + e.getMessage());
            }
        }
    }

    private static void simulateUser(String userName, DefaultTravelGuide travelGuide) {
        Random random = new Random();
        String[] routeCategories = {"Историческое место", "Архитектура", "Природа", "Культура"};
        String[] routeNames = {"Исторический тур", "Архитектурное наследие", "Природные красоты"};

        for (int i = 0; i < 5; i++) {
            int action = random.nextInt(3) + 1; // Случайное действие: 1, 2 или 3

            synchronized (lock) {
                System.out.println("\n=== " + userName + " ===");
                System.out.println("Время: " + getCurrentTimestamp());

                switch (action) {
                    case 1:
                        // Вывод всех маршрутов
                        System.out.println(userName + " показывает все маршруты:");
                        for (Route route : travelGuide.getRoutes()) {
                            System.out.println(route + "\n");

                        }
                        break;

                    case 2:
                        // Поиск маршрута по названию (Шаблон: Strategy + Singleton)
                        String routeNameQuery = routeNames[random.nextInt(routeNames.length)];
                        System.out.println(userName + " ищет маршрут по названию: " + routeNameQuery);
                        travelGuide.searchRoutes("name", routeNameQuery);
                        break;

                    case 3:
                        // Поиск маршрута по категории (Шаблон: Strategy + Singleton)
                        String routeCategoryQuery = routeCategories[random.nextInt(routeCategories.length)];
                        System.out.println(userName + " ищет маршрут по категории: " + routeCategoryQuery);
                        travelGuide.searchRoutes("category", routeCategoryQuery);
                        break;

                    default:
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
