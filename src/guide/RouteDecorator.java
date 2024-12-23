package guide;

// Шаблон: Decorator
public abstract class RouteDecorator extends Route {
    protected Route decoratedRoute;

    public RouteDecorator(Route route) {
        super(route.getName(), route.getCategory(), route.getPlaces());
        this.decoratedRoute = route;
    }

    @Override
    public String toString() {
        return decoratedRoute.toString(); // Базовый вывод
    }
}