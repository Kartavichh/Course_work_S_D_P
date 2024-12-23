package search;

import guide.Route;

import java.util.List;

// Интерфейс стратегии поиска (Шаблон: Strategy)
public interface SearchStrategy {
    void search(List<Route> places, String query, List<Route> foundRoutes);
}
