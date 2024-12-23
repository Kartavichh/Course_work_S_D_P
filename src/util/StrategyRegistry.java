package util;

import search.CategorySearch;
//import search.DescriptionSearch;
import search.NameSearch;
import search.SearchStrategy;

import java.util.HashMap;
import java.util.Map;

// Реестр стратегий поиска
public class StrategyRegistry {
    private static final StrategyRegistry INSTANCE = new StrategyRegistry();
    private final Map<String, SearchStrategy> strategies = new HashMap<>();

    private StrategyRegistry() {
        registerStrategy("name", new NameSearch());
        registerStrategy("category", new CategorySearch());
    }

    public static StrategyRegistry getInstance() {
        return INSTANCE;
    }

    public void registerStrategy(String name, SearchStrategy strategy) {
        strategies.put(name, strategy);
    }

    public SearchStrategy getStrategy(String name) {
        return strategies.get(name);
    }
}
