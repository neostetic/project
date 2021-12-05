package cz.polacek.game.config;

import cz.polacek.game.config.Config;

public class Language {

    public Config config = new Config();
    public String start_game;
    public String[][] event_text;
    public String day;
    public String days = "<b>" + day + " " + config.game_daycount + "</b><br><br>";
    public String htmlStart = "<html><body>";
    public String htmlEnd = "</body></html>";

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
