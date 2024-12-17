package rs.aqerd;

import io.github.cdimascio.dotenv.Dotenv;

public class Config {
    private static final Dotenv denv = Dotenv.configure().directory("src/main/resources").filename(".env").load();
    private static final String TELEGRAM_TOKEN = denv.get("TELEGRAM_TOKEN");
    private static final String TELEGRAM_USERNAME = denv.get("TELEGRAM_USERNAME");
    private static final String SPOTIFY_CLIENT_ID = denv.get("SPOTIFY_CLIENT_ID");
    private static final String SPOTIFY_CLIENT_SECRET = denv.get("SPOTIFY_CLIENT_SECRET");
    private static final String APPLE_MUSIC_TOKEN = denv.get("APPLE_MUSIC_TOKEN");
    private static final String YANDEX_MUSIC_TOKEN = denv.get("YANDEX_MUSIC_TOKEN");
    private static final String DEEZER_TOKEN = denv.get("DEEZER_TOKEN");

    public static String getTelegramUsername() {
        return TELEGRAM_USERNAME;
    }

    public static String getTelegramToken() {
        return TELEGRAM_TOKEN;
    }

    public static String getSpotifyClientId() {
        return SPOTIFY_CLIENT_ID;
    }

    public static String getSpotifyClientSecret() {
        return SPOTIFY_CLIENT_SECRET;
    }

    public static String getAppleMusicToken() {
        return APPLE_MUSIC_TOKEN;
    }

    public static String getYandexMusicToken() {
        return YANDEX_MUSIC_TOKEN;
    }

    public static String getDeezerToken() {
        return DEEZER_TOKEN;
    }
}
