package cz.polacek.game.engine.events;

import cz.polacek.game.config.Config;
import cz.polacek.game.config.Difficulty;
import cz.polacek.game.config.Language;
import cz.polacek.game.engine.items.Item;
import cz.polacek.game.engine.player.Player;
import cz.polacek.game.utils.UtilRandom;
import cz.polacek.game.view.WindowViews;

import java.util.Random;

public class EventLogic {

    public Config config = new Config();

    protected Language text;
    public Difficulty difficulty;
    public WindowViews views;
    public UtilRandom random;

    public Player player;

    public Player getPlayer() {
        return player;
    }

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
        player = new Player(config.player_name, difficulty, difficulty.player_health_sick, difficulty.player_thirst, difficulty.player_hunger, difficulty.player_luck);
        playerPositive();
        notepadItemGain();
        views.gameStart();
    }

    public void startEvent(Event event) {
        if (event.item == null) {
            if (random.toBoolean(difficulty.player_luck)) {
                eventBoolean(event);
            }
        } else {
            if (event.item.state == Item.ItemState.HOLDING) {
                eventBoolean(event);
            }
        }
        player.setDay_count(player.getDay_count() + 1);
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

    public void playerNegative() {
        itemLose(player.items[0]);
        itemLose(player.items[1]);
        itemLose(player.items[2]);
        itemLose(player.items[3]);
        itemLose(player.items[4]);
        itemLose(player.items[5]);
        itemLose(player.items[6]);
    }

    public void playerPositive() {
        itemGain(player.items[0]);
        itemGain(player.items[1]);
        itemGain(player.items[2]);
        itemGain(player.items[3]);
        itemGain(player.items[4]);
        itemGain(player.items[5]);
        itemGain(player.items[6]);
    }

    public void itemLose(Item item) {
        if (item.getHolding() > 0) {
            Random ran = new Random();
            if (ran.nextInt(100) > player.getLuck() * 100) {
                item.setState(Item.ItemState.BROKEN);
                System.out.println("LOSE: -1 " + item.name);
            }
        }
    }

    public void itemGain(Item item) {
        if (item.getHolding() < item.getMax_holding()) {
            Random ran = new Random();
            if (ran.nextInt(100) < player.getLuck() * 100) {
                item.setState(Item.ItemState.HOLDING);
                item.setHolding(item.getHolding() + 1);
                System.out.println("GAIN: +1 " + item.name);
                views.eventText.gain = views.eventText.gain + " +1 " + item.name + "<br>";
            }
        }
    }

    public void notepadItemGain() {
        views.notepadText.setText(views.eventText.htmlStart + views.eventText.days + views.eventText.start_game + views.eventText.gain + views.eventText.htmlEnd);
    }

    public void notepadClear() {
        views.notepadText.setText("");
    }

}
