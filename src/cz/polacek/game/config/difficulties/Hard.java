package cz.polacek.game.config.difficulties;

public class Hard {

    /*
     * player_health_sick - Sickness factor : If player_health goes bellow X, sick effect is applied
     * player_thirst - How long can player live without Water
     * player_hunger - How long can player live without Food
     * player_luck = X; // Luck factor : 1 = 100%, .54 = 54%, 0 = 0%
     */

    public double player_health_sick = 60;
    public double player_thirst = 2;
    public double player_hunger = 4;
    public double player_luck = .3;

}
