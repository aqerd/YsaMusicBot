package rs.aqerd;

import io.github.cdimascio.dotenv.Dotenv;

public class Config {
    static Dotenv dotenv = Dotenv.configure().directory("src/main/resources").filename(".env").load();
    private static final String TELEGRAM_TOKEN = dotenv.get("TELEGRAM_TOKEN");
    private static final String TELEGRAM_USERNAME = dotenv.get("TELEGRAM_USERNAME");

    public static String getTelegramUsername() {
        return TELEGRAM_USERNAME;
    }

    public static String getTelegramToken() {
        return TELEGRAM_TOKEN;
    }
}
