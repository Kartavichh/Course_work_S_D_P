package util;

import search.CategorySearch;
//import search.DescriptionSearch;
import search.NameSearch;
import search.SearchStrategy;

import java.util.HashMap;
import java.util.Map;

// Реестр стратегий поиска
public class StrategyRegistry {
    private static final Map<String, SearchStrategy> strategies = new HashMap<>();

    static {
        // Регистрация стандартных стратегий
        registerStrategy("name", new NameSearch());
        registerStrategy("category", new CategorySearch());
//      registerStrategy("description", new DescriptionSearch());


    }

    public static void registerStrategy(String name, SearchStrategy strategy) {
        strategies.put(name, strategy);
    }

    public static SearchStrategy getStrategy(String name) {
        return strategies.get(name);
    }
}
