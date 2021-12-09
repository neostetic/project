package cz.polacek.game.config;

public class Difficulty {

    /*
     * player_health_sick - Sickness factor : If player_health goes bellow X, sick effect is applied
     * player_thirst - How long can player live without Water
     * player_hunger - How long can player live without Food
     * player_luck = X; // Luck factor : 1 = 100%, .54 = 54%, 0 = 0%
     */

    public double player_health_sick;
    public double player_thirst;
    public double player_hunger;
    public double player_luck;

    public Difficulty(double player_health_sick, double player_thirst, double player_hunger, double player_luck) {
        this.player_health_sick = player_health_sick;
        this.player_thirst = player_thirst;
        this.player_hunger = player_hunger;
        this.player_luck = player_luck;
    }
}