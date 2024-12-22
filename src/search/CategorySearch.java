package search;

import guide.Route;

import java.util.List;

// Реализация стратегии поиска по категории
// Шаблон: Strategy
public class CategorySearch implements SearchStrategy {
    @Override
    public void search(List<Route> places, String query) {
        System.out.println("Результаты поиска по категории: " + query);
        for (Route route : places) {
            if (route.getCategory().toLowerCase().contains(query.toLowerCase())) {
                System.out.println(route);
            }
        }
    }
}
