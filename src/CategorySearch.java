import java.util.List;

// Реализация стратегии поиска по категории
// Шаблон: Strategy
public class CategorySearch implements SearchStrategy {
    @Override
    public void search(List<Place> places, String query) {
        System.out.println("Результаты поиска по категории: " + query);
        for (Place place : places) {
            if (place.getCategory().toLowerCase().contains(query.toLowerCase())) {
                System.out.println(place);
            }
        }
    }
}
