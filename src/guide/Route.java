package guide;

import java.util.List;

public class Route {
    private String name; // Название маршрута
    private String category; // Категория маршрута
    private List<String> places; // Список описаний мест

    public Route(String name, String category, List<String> places) {
        this.name = name;
        this.category = category;
        this.places = places;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public List<String> getPlaces() {
        return places;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Маршрут: ").append(name).append(" (").append(category).append(")\n");
        for (String place : places) {
            sb.append("- ").append(place).append("\n");
        }
        return sb.toString();
    }
}
