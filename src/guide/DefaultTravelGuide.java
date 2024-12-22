package guide;

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

    public void searchRoutes(String strategyName, String query) {
        System.out.println("Результаты поиска маршрутов по " + strategyName + ": " + query);
        for (Route route : routes) {
            if ((strategyName.equals("name") && route.getName().toLowerCase().contains(query.toLowerCase())) ||
                    (strategyName.equals("category") && route.getCategory().toLowerCase().contains(query.toLowerCase()))) {
                System.out.println(route);
            }
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
