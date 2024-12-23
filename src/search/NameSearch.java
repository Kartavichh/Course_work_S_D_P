package search;

import guide.Route;

import java.util.List;

// Реализация стратегии поиска по названию (Шаблон: Strategy)
public class NameSearch implements SearchStrategy {
    @Override
    public void search(List<Route> routes, String query, List<Route> foundRoutes) {
        for (Route route : routes) {
            if (route.getName().toLowerCase().contains(query.toLowerCase())) {
                foundRoutes.add(route); // Добавляем найденный маршрут в список
            }
        }
    }
}
