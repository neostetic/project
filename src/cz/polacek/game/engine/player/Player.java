package cz.polacek.game.engine.player;

import cz.polacek.game.config.Config;
import cz.polacek.game.config.Difficulty;
import cz.polacek.game.engine.items.Item;
import cz.polacek.game.engine.items.Items;

public class Player {

    protected Config config = new Config();

    private String name;
    private Difficulty difficulty;
    private double health_sick;
    private double thirst;
    private double hunger;
    private double luck;
    private double health = 100;

    public Item[] items = {
            Items.SHOTGUN.getItem(),
            Items.MAP.getItem(),
            Items.TAPE.getItem(),
            Items.MEDKIT.getItem(),
            Items.RADIO.getItem(),
            Items.WATER.getItem(),
            Items.FOOD.getItem()
    };

    public Player(String name, Difficulty difficulty, double health_sick, double thirst, double hunger, double luck) {
        this.name = name;
        this.difficulty = difficulty;
        this.health_sick = health_sick;
        this.thirst = thirst;
        this.hunger = hunger;
        this.luck = luck;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public double getHealth_sick() {
        return health_sick;
    }

    public void setHealth_sick(double health_sick) {
        this.health_sick = health_sick;
    }

    public double getThirst() {
        return thirst;
    }

    public void setThirst(double thirst) {
        this.thirst = thirst;
    }

    public double getHunger() {
        return hunger;
    }

    public void setHunger(double hunger) {
        this.hunger = hunger;
    }

    public double getLuck() {
        return luck;
    }

    public void setLuck(double luck) {
        this.luck = luck;
    }

    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
        this.health = health;
    }
}