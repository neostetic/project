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
            new Event(text.event_text[1][1], text.event_text[1][2], text.event_text[1][3], text.event_text[1][4]),
            new Event(text.event_text[2][1], text.event_text[2][2], text.event_text[2][3], text.event_text[2][4]),
            new Event(text.event_text[3][1], text.event_text[3][2], text.event_text[3][3], text.event_text[3][4]),
            new Event(text.event_text[4][1], text.event_text[4][2], text.event_text[4][3], text.event_text[4][4]),
            new Event(text.event_text[5][1], text.event_text[5][2], text.event_text[5][3], text.event_text[5][4]),
            new Event(text.event_text[6][1], text.event_text[6][2], text.event_text[6][3], text.event_text[6][4])
    };
    private Event fix_event = new Event(text.event_fix_text[0][1], text.event_fix_text[0][2], text.event_fix_text[0][3], text.event_fix_text[0][4]);

    private Event latest_event;
    private Event last_event = new Event();

    private enum event {
        FIX_EVENT,
        SPECIAL_EVENT,
        COMMON_EVENT;
    };

    public event last_event_type;

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

    public void startEvent(Boolean playerChoice) {
        boolean isTrue = ran.nextInt(100) < player.getDifficulty().player_luck * 100;
        player.setDay_count(player.getDay_count() + 1);
        views.eventText.itemUpdate = "";

        if (player.getDay_count() == 0) {
            notepadWrite();
        } else {
            if (player.getDay_count() != 1) {
                if (last_event_type == event.COMMON_EVENT) {
                    if (playerChoice) {
                        playerEffect(isTrue);
                    }
                } else if (last_event_type == event.FIX_EVENT) {
                    if (playerChoice) {
                        isTrue = true;
                        itemGain(player.items[whichItemBroken()], true);
                    }
                } else if (last_event_type == event.SPECIAL_EVENT) {
                    if (playerChoice) {
                        playerEffect(isTrue);
                        playerEffect(isTrue);
                    }
                }
            }

            latest_event = chooseEvent();
            notepadWrite(playerChoice, isTrue);
            last_event = latest_event;

        }

        if (player.getDay_count() % player.getDifficulty().player_hunger == 0) {
            System.out.print("HUNGER: ");
            if (player.items[6].getHolding() > 0) {
                player.items[6].setHolding(player.items[6].getHolding() - 1);
                System.out.println("0 (" + player.getHealth() + ")");
            } else {
                int dmg = ran.nextInt(15) + 5;
                player.setHealth(player.getHealth() - dmg);
                System.out.println("-" + dmg + " (" + player.getHealth() + ")");
            }
        }

        if (player.getDay_count() % player.getDifficulty().player_thirst == 0) {
            System.out.print("THIRST: ");
            if (player.items[5].getHolding() > 0) {
                player.items[5].setHolding(player.items[5].getHolding() - 1);
                System.out.println("0 (" + player.getHealth() + ")");
            } else {
                int dmg = ran.nextInt(15) + 5;
                player.setHealth(player.getHealth() - dmg);
                System.out.println("-" + dmg + " (" + player.getHealth() + ")");
            }
        }

        if (player.getHealth() <= 0) {
            views.gameOver();
        } else {
            views.gameSurvived();
        }

    }

    public Event chooseEvent() {
        if (ran.nextInt(2) == 0) {
            if (ran.nextInt(2) == 0 && player.items[2].getState() == Item.ItemState.HOLDING && doYouHave(Item.ItemState.BROKEN)) {
                System.out.println("EVENT: Fix Event");
                last_event_type = event.FIX_EVENT;
                return fix_event;
            } else {
                System.out.println("EVENT: Special Event");
                last_event_type = event.SPECIAL_EVENT;
                return common_events[ran.nextInt(common_events.length)];
            }
        } else {
            System.out.println("EVENT: Common Event");
            last_event_type = event.COMMON_EVENT;
            return common_events[ran.nextInt(common_events.length)];
        }
    }

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
                if (item.getMax_holding() > 1) {
                    item.setHolding(item.getHolding() - 1);
                } else {
                    item.setState(Item.ItemState.BROKEN);
                }
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

    public void itemGain(Item item, boolean skipRandom) {
        if (item.getHolding() < item.getMax_holding()) {
            item.setState(Item.ItemState.HOLDING);
            item.setHolding(item.getHolding() + 1);
            System.out.println("GAIN: +1 " + item.name);
            views.eventText.itemUpdate = views.eventText.itemUpdate + " +1 " + item.name + "<br>";
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

    public int whichItemBroken() {
        for (int i = 0; i < player.items.length; i++) {
            if (player.items[i].getState() == Item.ItemState.BROKEN) {
                System.out.println(" - " + player.items[i].name);
                return i;
            }
        }
        System.out.println(" - ERROR = Default: 0");
        return 0;
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
