package cz.polacek.game.config;

public class Config {
    // Window/Screen Settings
    public String window_title = "TheGame - v0.1";
    public boolean window_resizable = false;
    public boolean window_visible = true;
    public int window_width = 1280;
    public int window_height = 720;
    public int window_aiscale = 3; // Asset Images Scale factor

    // Player Settings
    public double player_health = 100;
    public int player_max_water = 20;
    public int player_max_food = 20;
    public String player_name = "Jack";

    // Game Settings
    public int game_daycount = 0;

    // Utils Settings
    public String imgSrcOut = "src/cz/polacek/game/assets/"; // I just wanted to have smaller Image Sources
}
