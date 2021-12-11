package cz.polacek.game.engine.events;

import cz.polacek.game.config.Config;
import cz.polacek.game.config.Difficulty;
import cz.polacek.game.config.Language;
import cz.polacek.game.config.languages.English;
import cz.polacek.game.engine.items.Item;
import cz.polacek.game.engine.player.Player;
import cz.polacek.game.view.Views;

import java.util.Random;

public class EventLogic {

    public Config config = new Config();

    protected Language text = new English();
    public Difficulty difficulty;
    public Views views;
    public Random ran = new Random();

    public Player player;

    public Player getPlayer() {
        return player;
    }

    private Event[] common_events = {
            new Event(text.event_text[0][1], text.event_text[0][2], text.event_text[0][3], text.event_text[0][4])
    };
    private Event[] special_events = {
            new Event(text.event_text[0][1], text.event_text[0][2], text.event_text[0][3], text.event_text[0][4])
    };
    private Event fix_event = new Event(text.event_text[0][1], text.event_text[0][2], text.event_text[0][3], text.event_text[0][4]);

    private Event latest_event;
    private Event last_event = new Event();

    public EventLogic(Views views) {
        this.views = views;
    }

    public void startGame(Difficulty difficulty) {
        this.difficulty = difficulty;
        player = new Player(config.player_name, difficulty, difficulty.player_health_sick, difficulty.player_thirst, difficulty.player_hunger, difficulty.player_luck);
        System.out.println("GAME START:");
        System.out.println(" - Player Heath Sick : " + player.getHealth_sick());
        System.out.println(" - Player Thirst : " + player.getThirst());
        System.out.println(" - Player Hunger : " + player.getHunger());
        System.out.println(" - Player Luck : " + player.getLuck());
        playerEffect(true);
        notepadWrite();
        views.gameScreen();
    }


    // This is broken! FIX FIX FIX
    public void startEvent(Boolean playerChoice) {
        boolean isTrue = ran.nextInt(2) == 1;
        player.setDay_count(player.getDay_count() + 1);
        views.eventText.itemUpdate = "";

        if (playerChoice) {
            playerEffect(isTrue);
        }

        latest_event = chooseEvent();
        notepadWrite(playerChoice, isTrue);
        last_event = latest_event;

        if (player.getHealth_sick() <= 0) {
            views.gameOver();
        } else {
            views.gameSurvived();
        }
    }

    public void starEventFromZero() {
        player.setDay_count(player.getDay_count() + 1);
        notepadWrite();
        if (player.getHealth_sick() <= 0) {
            views.gameOver();
        } else {
            views.gameSurvived();
        }
    }

    public Event chooseEvent() {
        if (ran.nextInt(2) == 0) {
            if (ran.nextInt(2) == 0 && player.items[2].getState() == Item.ItemState.HOLDING && doYouHave(Item.ItemState.BROKEN)) {
                System.out.println("EVENT: Fix Event");
                return fix_event;
            } else {
                System.out.println("EVENT: Special Event");
                return special_events[ran.nextInt(special_events.length)];
            }
        } else {
            System.out.println("EVENT: Common Event");
            return common_events[ran.nextInt(common_events.length)];
        }
    }
    // fix fix fix

    public void playerEffect(Boolean effect) {
        if (effect) {
            System.out.println(" - Positive");
            itemGain(player.items[0]);
            itemGain(player.items[1]);
            itemGain(player.items[2]);
            itemGain(player.items[3]);
            itemGain(player.items[4]);
            itemGain(player.items[5]);
            itemGain(player.items[6]);
        } else {
            System.out.println(" - Negative");
            itemLose(player.items[0]);
            itemLose(player.items[1]);
            itemLose(player.items[2]);
            itemLose(player.items[3]);
            itemLose(player.items[4]);
            itemLose(player.items[5]);
            itemLose(player.items[6]);
            playerDamage();
        }
    }

    public void playerDamage() {
        int dmg = ran.nextInt(config.game_max_damage);
        player.setHealth(player.getHealth() - dmg);
        System.out.println("LOSE: -" + dmg + " (" + player.getHealth() + ")");
    }

    public void itemLose(Item item) {
        if (item.getHolding() > 0) {
            if (ran.nextInt(100) > player.getLuck() * 100) {
                item.setState(Item.ItemState.BROKEN);
                System.out.println("LOSE: -1 " + item.name);
                views.eventText.itemUpdate = views.eventText.itemUpdate + " -1 " + item.name + "<br>";
            }
        }
    }

    public void itemGain(Item item) {
        if (item.getHolding() < item.getMax_holding()) {
            if (ran.nextInt(100) < player.getLuck() * 100) {
                item.setState(Item.ItemState.HOLDING);
                item.setHolding(item.getHolding() + 1);
                System.out.println("GAIN: +1 " + item.name);
                views.eventText.itemUpdate = views.eventText.itemUpdate + " +1 " + item.name + "<br>";
            }
        }
    }

    public boolean doYouHave(Item.ItemState state) {
        for (int i = 0; i < player.items.length; i++) {
            if (player.items[i].getState() == state) {
                return true;
            }
        }
        return false;
    }

    public void notepadWrite() {
        views.labels.notepadText.setText(views.eventText.htmlStart + views.eventText.day_start + views.eventText.day + player.getDay_count() + views.eventText.day_end + views.eventText.start_game + views.eventText.br + views.eventText.gain + views.eventText.br + views.eventText.itemUpdate + views.eventText.htmlEnd);
    }

    public void notepadWrite(Boolean playerChoice, Boolean result) {
        if (playerChoice) {
            if (result) {
                views.labels.notepadText.setText(views.eventText.htmlStart + views.eventText.day_start + views.eventText.day + player.getDay_count() + views.eventText.day_end + last_event.eventAcceptPositive + views.eventText.br + views.eventText.gain + views.eventText.br + views.eventText.itemUpdate + views.eventText.br + latest_event.eventTextInfo + views.eventText.htmlEnd);
            } else {
                views.labels.notepadText.setText(views.eventText.htmlStart + views.eventText.day_start + views.eventText.day + player.getDay_count() + views.eventText.day_end + last_event.eventAcceptNegative + views.eventText.br + views.eventText.lose + views.eventText.br + views.eventText.itemUpdate + views.eventText.br + latest_event.eventTextInfo + views.eventText.htmlEnd);
            }
        } else {
            views.labels.notepadText.setText(views.eventText.htmlStart + views.eventText.day_start + views.eventText.day + player.getDay_count() + views.eventText.day_end + last_event.eventDecline + views.eventText.br + views.eventText.itemUpdate + views.eventText.br + latest_event.eventTextInfo + views.eventText.htmlEnd);
        }
    }


}
