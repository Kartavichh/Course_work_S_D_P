package guide;

// Шаблон: Decorator
public class DescriptionDecorator extends RouteDecorator {
    private final String description;

    public DescriptionDecorator(Route route, String description) {
        super(route);
        this.description = description;
    }

    @Override
    public String toString() {
        return super.toString() + "\nОписание: " + description; // Добавляем описание
    }
}
