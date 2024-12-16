public class CityGuideConfig {
    private static CityGuideConfig instance;

    private CityGuideConfig() {
        // Конфигурация приложения
    }

    public static synchronized CityGuideConfig getInstance() {
        if (instance == null) {
            instance = new CityGuideConfig();
        }
        return instance;
    }
}
