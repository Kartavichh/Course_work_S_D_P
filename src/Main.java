import java.util.Scanner;

// Основной класс для запуска приложения
public class Main {
    public static void main(String[] args) {
        DefaultTravelGuide defaultTravelGuide = new DefaultTravelGuide(); // Фасад
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n=== Путеводитель по городу ===");
            System.out.println("1. Показать все достопримечательности");
            System.out.println("2. Поиск по названию");
            System.out.println("3. Поиск по категории");
            System.out.println("4. Выйти");
            System.out.print("Введите номер команды: ");

            if (scanner.hasNextInt()) {
                int command = scanner.nextInt();
                switch (command) {
                    case 1:
                        System.out.println("Список достопримечательностей:");
                        for (Place place : defaultTravelGuide.getPlaces()) {
                            System.out.println(place);
                        }
                        break;

                    case 2:
                        System.out.print("Введите название для поиска: ");
                        String nameQuery = scanner.next();
                        defaultTravelGuide.searchPlacesForName(nameQuery); // Использование стратегии поиска по имени
                        break;

                    case 3:
                        System.out.print("Введите категорию для поиска: ");
                        String categoryQuery = scanner.next();
                        defaultTravelGuide.searchPlacesForCategory(categoryQuery); // Использование стратегии поиска по категории
                        break;

                    case 4:
                        running = false;
                        System.out.println("Выход из программы. До свидания!");
                        break;

                    default:
                        System.out.println("Неверная команда, попробуйте снова.");
                }
            } else {
                System.out.println("Неверная команда, попробуйте снова.");
            }
        }
        scanner.close();
    }
}
