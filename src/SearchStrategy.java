import java.util.List;

// Интерфейс для стратегий поиска
// Шаблон: Strategy
public interface SearchStrategy {
    void search(List<Place> places, String query);
}
