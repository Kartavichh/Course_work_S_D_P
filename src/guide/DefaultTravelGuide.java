package guide;

import util.StrategyRegistry;
import search.SearchStrategy;

import java.util.ArrayList;
import java.util.List;

public class DefaultTravelGuide {
    private final List<Route> routes = new ArrayList<>(); // Список маршрутов

    public DefaultTravelGuide() {
        loadRoutes(); // Инициализация маршрутов
    }

    public List<Route> getRoutes() {
        return routes; // Возвращаем все маршруты
    }

    // Использование Strategy и Decorator
    public void searchRoutes(String strategyName, String query) {
        System.out.println("Результаты поиска маршрутов по " + strategyName + ": " + query);
        SearchStrategy strategy = StrategyRegistry.getInstance().getStrategy(strategyName);
        if (strategy != null) {
            // Находим маршруты через стратегию
            List<Route> foundRoutes = new ArrayList<>();
            strategy.search(routes, query, foundRoutes); // Передаем список для результатов

            // Оборачиваем найденные маршруты в декоратор и выводим
            for (Route route : foundRoutes) {
                Route decoratedRoute = new guide.DescriptionDecorator(
                        route, "приобрести этот тур вы можете здесь: https://t.me/Kartavichhh" + " напишите кодовую фразу: " + route.getName().replace(" ", "_")
                );
                System.out.println(decoratedRoute);
            }
        } else {
            System.out.println("Неизвестная стратегия поиска: " + strategyName);
        }
    }

    private void loadRoutes() {
        routes.add(new Route("Исторический тур", "Историческое место",
                List.of("Кремль: главная достопримечательность",
                        "Музей Истории")));
        routes.add(new Route("Архитектурное наследие", "Архитектура",
                List.of("Чкаловская лестница: лестница с видом на Волгу",
                        "Собор Святой Софии")));
        routes.add(new Route("Обзорный маршрут", "Смешанная категория",
                List.of("Кремль",
                        "Чкаловская лестница",
                        "Собор Святой Софии",
                        "Музей Истории")));
        routes.add(new Route("Природные красоты", "Природа",
                List.of("Заповедник Каменный Город",
                        "Водопад Киин-Кериш")));
        routes.add(new Route("Культурный маршрут", "Культура",
                List.of("Театр имени Горького",
                        "Художественный музей")));
    }
}
