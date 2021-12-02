package cz.polacek.game.config.difficulties;

public class Easy {

    /*
     * player_health_sick - Sickness factor : If player_health goes bellow X, sick effect is applied
     * player_thirst - How long can player live without Water
     * player_hunger - How long can player live without Food
     * player_luck = X; // Luck factor : 1 = 100%, .54 = 54%, 0 = 0%
     */

    public double player_health_sick = 40;
    public double player_thirst = 5;
    public double player_hunger = 10;
    public double player_luck = .7;
}
