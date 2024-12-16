public class Place {
    private String name;
    private String category;
    private String description;

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
