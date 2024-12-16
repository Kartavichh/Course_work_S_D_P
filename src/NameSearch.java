import java.util.List;

/**
 * Лучше добавить к классу DefaultTravelGuide
 */
public class NameSearch implements SearchStrategy {
    @Override
    public void search(List<Place> places, String query) {
        System.out.println("Результаты поиска по названию: " + query);
        for (Place place : places) {
            if (place.getName().toLowerCase().contains(query.toLowerCase())) {
                System.out.println(place);
            }
        }
    }
}
