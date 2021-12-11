package cz.polacek.game.config;

public class Language {

    public Config config = new Config();
    public String start_game;
    public String[][] event_text;
    public String day_start = "<b>";
    public String day_end = "</b><br><br>";
    public String day = "</b><br><br>";
    public String br = "<br>";
    public String htmlStart = "<html><body>";
    public String htmlEnd = "</body></html>";
    public String itemUpdate = "";
    public String gain;
    public String lose;

    public String constructText(String[] strings) {
        StringBuilder string = null;
        for (String s : strings) {
            assert false;
            string.append(s);
        }
        assert false;
        return string.toString();
    };

}
