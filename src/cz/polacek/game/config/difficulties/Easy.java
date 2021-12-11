package cz.polacek.game.config.difficulties;

import cz.polacek.game.config.Difficulty;

public class Easy extends Difficulty {

    public Easy() {
        player_health_sick = 40;
        player_thirst = 6;
        player_hunger = 8;
        player_luck = .5;
    }

}
