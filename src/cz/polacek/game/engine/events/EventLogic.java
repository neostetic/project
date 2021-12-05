package cz.polacek.game.engine.events;

import cz.polacek.game.config.Config;
import cz.polacek.game.config.Difficulty;
import cz.polacek.game.config.Language;
import cz.polacek.game.engine.items.Item;
import cz.polacek.game.engine.items.Items;
import cz.polacek.game.utils.UtilRandom;
import cz.polacek.game.view.WindowViews;

public class EventLogic {

    public Config config = new Config();

    protected Language text;
    public Difficulty difficulty;
    public WindowViews views;
    public UtilRandom random;

    /*
        private Event[] events = {
                new Event(text.event_text[1][1], text.event_text[1][2], text.event_text[1][3], text.event_text[1][4])
        };
    */

    public EventLogic(WindowViews views) {
        this.views = views;
    }

    public void startGame(Difficulty difficulty) {
        this.difficulty = difficulty;
        views.gameStart();
    }

    public void startEvent(Event event) {
        if (event.item1 == null) {
            if (random.toBoolean(difficulty.player_luck)) {
                eventBoolean(event);
            }
        } else {
            if (event.item1.getItem().state == Item.ItemState.HOLDING) {
                eventBoolean(event);
            }
        }
    }

    private void eventBoolean(Event event) {
        if (random.toBoolean(difficulty.player_luck)) {
            System.out.println(event.eventAcceptPositive);
            playerPositive();
        } else {
            System.out.println(event.eventAcceptNegative);
            playerNegative();
        }
    }

    private void playerNegative() {
        itemLose(Items.SHOTGUN.getItem());
        itemLose(Items.MAP.getItem());
        itemLose(Items.TAPE.getItem());
        itemLose(Items.MEDKIT.getItem());
        itemLose(Items.RADIO.getItem());
        itemLose(Items.WATER.getItem());
        itemLose(Items.FOOD.getItem());
    }

    private void playerPositive() {
        itemGain(Items.SHOTGUN.getItem());
        itemGain(Items.MAP.getItem());
        itemGain(Items.TAPE.getItem());
        itemGain(Items.MEDKIT.getItem());
        itemGain(Items.RADIO.getItem());
        itemGain(Items.WATER.getItem());
        itemGain(Items.FOOD.getItem());
    }

    public void itemLose(Item item) {
        System.out.println("Lose: " + item.getName() + " ; " + item.getHolding());
        if (item.getHolding() >= 1) {
            if (!random.toBoolean(difficulty.player_luck)) {
                item.setHolding(item.getHolding() - 1);
                if (item.getHolding() == 0) {
                    item.setState(Item.ItemState.BROKEN);
                }
            }
        }
        System.out.println("- STATE: " + item.getState());
    }

    public void itemGain(Item item) {
        System.out.println("Gain: " + item.getName() + " ; " + item.getHolding());
        if (random.toBoolean(difficulty.player_luck / config.game_luckfactor) && item.getMax_holding() < item.getHolding()) {
            item.setHolding(item.getHolding() - 1);
            if (item.getHolding() > 0) {
                item.setState(Item.ItemState.HOLDING);
            }
        }
        System.out.println("- " + item.getState());
    }

}
