package guide;

import util.StrategyRegistry;
import search.SearchStrategy;

import java.util.ArrayList;
import java.util.List;

// Шаблон: Facade
public class DefaultTravelGuide {
    private final List<Route> routes = new ArrayList<>(); // Список маршрутов

    public DefaultTravelGuide() {
        loadRoutes(); // Инициализация маршрутов
    }

    public List<Route> getRoutes() {
        return routes; // Возвращаем все маршруты
    }

    // Использование StrategyRegistry (Шаблон: Strategy + Singleton)
    public void searchRoutes(String strategyName, String query) {
        SearchStrategy strategy = StrategyRegistry.getInstance().getStrategy(strategyName);
        if (strategy != null) {
            strategy.search(routes, query); // Динамический выбор стратегии
        } else {
            System.out.println("Неизвестная стратегия поиска: " + strategyName);
        }
    }

    private void loadRoutes() {
        routes.add(new Route("Исторический тур", "Историческое место",
                List.of("Нижегородский Кремль","Дмитриевская башня","Нижегородская ярмарка",
                        "Музей истории ГАЗ")));
        routes.add(new Route("Архитектурное наследие", "Архитектура",
                List.of("Государственный банк", "Нижегородский Кремль",
                        "Чкаловская лестница", "Рождественская улица")));
        routes.add(new Route("Обзорный маршрут", "Смешанная категория",
                List.of("пл. Минина и Пожарского",
                        "пл. Горького",
                        "Чкаловская лестница",
                        "Речной вокзал", "Собор Александра Невского", "Нижегородская ярмарка")));
        routes.add(new Route("Природные красоты", "Природа",
                List.of("Дубрава Ботанического сада университета","Щелоковский хутор","Парк Швейцария")));
        routes.add(new Route("Культурный маршрут", "Культура",
                List.of("Театр оперы и балета имени Пушкина",
                        "Усадьба Рукавишниковых", "Музей: Нижегородский Кремль")));
    }
}
