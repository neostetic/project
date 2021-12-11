package cz.polacek.game.config.difficulties;

import cz.polacek.game.config.Difficulty;

public class Medium extends Difficulty {

    public Medium() {
        player_health_sick = 50;
        player_thirst = 4;
        player_hunger = 6;
        player_luck = .45;
    }

}
