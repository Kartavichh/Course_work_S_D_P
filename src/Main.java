import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Инициализация списка достопримечательностей
        // Хранить список в DefaultTravelGuide
        List<Place> places = new ArrayList<>();

        // Загрузка данных многопоточно
        /* В качестве примера много поточности лучше использовать задач
         * Задача "Производитель-потребитель"
         * Задача "Читатели-писатели"
         * Задача "Обедающие философы"
         * Проблема спящего брадобрея
         * В твоём случае лучше сделать отдельный GUI на отдельном потоке
         * (можно просто сделать имитацию консоли ввода)
         * в основную консоль писать логи
         */
        System.out.println("Начинаем загрузку данных...");

        PlaceLoader.loadPlaces(places);

        // Интерфейс командной строки
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n=== Путеводитель по городу ===");
            System.out.println("1. Показать все достопримечательности");
            System.out.println("2. Поиск по названию");
            System.out.println("3. Поиск по категории");
            System.out.println("4. Выйти");
            System.out.print("Введите номер команды: ");

            int command = scanner.nextInt();
            scanner.nextLine(); // Очистка ввода

            switch (command) {
                case 1:
                    System.out.println("Список достопримечательностей:");
                    for (Place place : places) {
                        System.out.println(place);
                    }
                    break;

                case 2:
                    System.out.print("Введите название для поиска: ");
                    String nameQuery = scanner.nextLine();
                    SearchStrategy nameSearch = new NameSearch();
                    nameSearch.search(places, nameQuery); // Использовать DefaultTravelGuide
                    break;

                case 3:
                    System.out.print("Введите категорию для поиска: ");
                    String categoryQuery = scanner.nextLine();
                    SearchStrategy categorySearch = new CategorySearch();
                    categorySearch.search(places, categoryQuery);  // Использовать DefaultTravelGuide
                    break;

                case 4:
                    running = false;
                    System.out.println("Выход из программы. До свидания!");
                    break;

                default:
                    System.out.println("Неверная команда, попробуйте снова.");
            }
        }

        scanner.close();
    }
}

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.