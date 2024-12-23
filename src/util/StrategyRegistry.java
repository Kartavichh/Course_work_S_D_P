package util;

import search.CategorySearch;
import search.NameSearch;
import search.SearchStrategy;

import java.util.HashMap;
import java.util.Map;

// Реестр стратегий поиска (Шаблон: Singleton)
public class StrategyRegistry {
    private static final StrategyRegistry INSTANCE = new StrategyRegistry(); // Одиночка
    private final Map<String, SearchStrategy> strategies = new HashMap<>();

    private StrategyRegistry() {
        // Регистрация стандартных стратегий
        registerStrategy("name", new NameSearch());
        registerStrategy("category", new CategorySearch());
    }

    public static StrategyRegistry getInstance() {
        return INSTANCE; // Возвращает единственный экземпляр
    }

    public void registerStrategy(String name, SearchStrategy strategy) {
        strategies.put(name, strategy);
    }

    public SearchStrategy getStrategy(String name) {
        return strategies.get(name);
    }
}
