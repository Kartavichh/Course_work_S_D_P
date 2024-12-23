package search;

import guide.Route;

import java.util.List;

// Реализация стратегии поиска по категории (Шаблон: Strategy)
public class CategorySearch implements SearchStrategy {
    @Override
    public void search(List<Route> routes, String query, List<Route> foundRoutes) {
        for (Route route : routes) {
            if (route.getCategory().toLowerCase().contains(query.toLowerCase())) {
                foundRoutes.add(route); // Добавляем найденный маршрут в список
            }
        }
    }
}
