package cz.polacek.game.config;

public class Config {

    // Window/Screen Settings
    public String window_title = "JUSTBUNKER";
    public boolean window_resizable = false;
    public boolean window_visible = true;
    public int window_width = 1280;
    public int window_height = 720;
    public int window_aiscale = 3; // Asset Images Scale factor
    public String windows_font = "font/DisposableDroidBB.ttf";

    // Player Settings
    public double player_health = 100;
    public int player_max_water = 20;
    public int player_max_food = 20;
    public String player_name = "Jack";

    // Game Settings
    public int game_daycount = 0;
    public double game_luckfactor = 1.1; // Item loose factor : difficulty.player_luck / config.game_luckfactor;

    // Utils Settings
    public String srcOut = "src/cz/polacek/game/assets/"; // I just wanted to have smaller Image Sources

}
