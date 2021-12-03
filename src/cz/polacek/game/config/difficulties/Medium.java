package cz.polacek.game.config.difficulties;

import cz.polacek.game.config.ConfigDifficulty;

public class Medium extends ConfigDifficulty {

    /*
     * player_health_sick - Sickness factor : If player_health goes bellow X, sick effect is applied
     * player_thirst - How long can player live without Water
     * player_hunger - How long can player live without Food
     * player_luck = X; // Luck factor : 1 = 100%, .54 = 54%, 0 = 0%
     */

    public double player_health_sick = 50;
    public double player_thirst = 3;
    public double player_hunger = 6;
    public double player_luck = .5;

}
