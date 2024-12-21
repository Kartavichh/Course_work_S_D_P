// Модель данных для представления достопримечательностей
public class Place {
    private String name; // Название места
    private String category; // Категория места
    private String description; // Описание места

    public Place(String name, String category, String description) {
        this.name = name;
        this.category = category;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "Достопримечательность: " + name + " (" + category + ")\n" + description;
    }
}
