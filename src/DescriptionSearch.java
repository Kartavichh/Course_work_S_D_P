import java.util.List;

// Реализация стратегии поиска по описанию
public class DescriptionSearch implements SearchStrategy {
    @Override
    public void search(List<Place> places, String query) {
        System.out.println("Результаты поиска по описанию: " + query);
        for (Place place : places) {
            if (place.toString().toLowerCase().contains(query.toLowerCase())) {
                System.out.println(place);
            }
        }
    }
}
