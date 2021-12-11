package cz.polacek.game.config;

public class Config {

    // Window/Screen Settings
    public String window_title = "JUSTBUNKER";
    public boolean window_resizable = false;
    public boolean window_visible = true;
    public int window_width = 1280;
    public int window_height = 720;
    public String windows_font = "font/DisposableDroidBB.ttf";

    // Player Settings
    public double player_health = 100;
    public int player_max_water = 20;
    public int player_max_food = 20;
    public String player_name = "Jack";

    // Game Settings
    public int game_daycount = 0;
    public int game_max_damage = 15;

    // Utils Settings
    public String srcOut = "src/cz/polacek/game/assets/"; // I just wanted to have smaller Image Sources

}
