package cz.polacek.game.config.difficulties;

import cz.polacek.game.config.Difficulty;

public class Hard extends Difficulty {

    public Hard() {
        player_health_sick = 60;
        player_thirst = 3;
        player_hunger = 5;
        player_luck = .4;
    }

}
