package cz.polacek.game.config;

public class ConfigDifficulies {

    /*
        * player_health_sick - Sickness factor : If player_health goes bellow X, sick effect is applied
        * player_thirst - How long can player live without Water
        * player_hunger - How long can player live without Food
        * player_luck = X; // Luck factor : 1 = 100%, .54 = 54%, 0 = 0%
     */

    // Easy Difficulty
    public double easy_player_health_sick = 40;
    public double easy_player_thirst = 5;
    public double easy_player_hunger = 10;
    public double easy_player_luck = .7;

    //Medium Difficulty
    public double medium_player_health_sick = 50;
    public double medium_player_thirst = 3;
    public double medium_player_hunger = 6;
    public double medium_player_luck = .5;

    //Hard Difficulty
    public double hard_player_health_sick = 60;
    public double hard_player_thirst = 2;
    public double hard_player_hunger = 4;
    public double hard_player_luck = .3;

}
