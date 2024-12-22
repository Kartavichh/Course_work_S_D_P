package search;

import guide.Route;

import java.util.List;

// Реализация стратегии поиска по названию
// Шаблон: Strategy
public class NameSearch implements SearchStrategy {
    @Override
    public void search(List<Route> places, String query) {
        System.out.println("Результаты поиска по названию: " + query);
        for (Route route : places) {
            if (route.getName().toLowerCase().contains(query.toLowerCase())) {
                System.out.println(route);
            }
        }
    }
}
