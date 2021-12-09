package cz.polacek.game.view;

import cz.polacek.game.config.Config;
import cz.polacek.game.config.Difficulty;
import cz.polacek.game.config.Language;
import cz.polacek.game.config.difficulties.Easy;
import cz.polacek.game.config.difficulties.Hard;
import cz.polacek.game.config.difficulties.Medium;
import cz.polacek.game.config.languages.English;
import cz.polacek.game.engine.events.EventLogic;
import cz.polacek.game.engine.items.Item;
import cz.polacek.game.utils.BufferImage;
import cz.polacek.game.utils.LabelMouse;
import cz.polacek.game.utils.LabelMouseTypes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class WindowViews {

    public JPanel panel;
    public LabelMouse labelMouse = new LabelMouse(WindowViews.this);
    public Language eventText = new English();
    protected Config config = new Config();
    private EventLogic eventLogic = new EventLogic(this);

    public WindowViews(JPanel panel) {
        this.panel = panel;
    }

    public static boolean notepadSwitcher = false;

    private Easy easy = new Easy();
    private Medium medium = new Medium();
    private Hard hard = new Hard();

    public JLabel title = new BufferImage("ui/menu/title_big.png").toLabel();
    public JLabel menuBackground = new BufferImage("ui/menu/background.png").toLabel();
    public JLabel[] buttons = {
            new BufferImage("ui/buttons/easy.png").toLabel(),
            new BufferImage("ui/buttons/medium.png").toLabel(),
            new BufferImage("ui/buttons/hard.png").toLabel(),
            new BufferImage("ui/menu/github.png").toLabel()
    };

    public JLabel notepad = new BufferImage("ui/game/notepad_blank.png").toLabel();
    public JLabel notepadText = new JLabel("");
    public JLabel notepadButton = new BufferImage("ui/game/notepad_button.png").toLabel();
    public JLabel[] notepadButtons = {
            new BufferImage("ui/game/notepad_button_accept.png").toLabel(),
            new BufferImage("ui/game/notepad_button_sleep.png").toLabel(),
            new BufferImage("ui/game/notepad_button_decline.png").toLabel()
    };

    public JLabel background = new BufferImage("items/background.png").toLabel();
    public JLabel[] shotgun = {
            new BufferImage("items/shotgun.png").toLabel(),
            new BufferImage("items/shotgun_broken.png").toLabel()
    };
    public JLabel[] map = {
            new BufferImage("items/map.png").toLabel(),
            new BufferImage("items/map_broken.png").toLabel()
    };
    public JLabel[] tape = {
            new BufferImage("items/tape.png").toLabel(),
            new BufferImage("items/tape_broken.png").toLabel()
    };
    public JLabel[] medkit = {
            new BufferImage("items/medkit.png").toLabel(),
            new BufferImage("items/medkit_broken.png").toLabel()
    };

    public JLabel[] radio = {
            new BufferImage("items/radio.png").toLabel(),
            new BufferImage("items/radio_broken.png").toLabel()
    };

    public JLabel soupBox = new BufferImage("items/soup_box.png").toLabel();
    public JLabel soupBoxInfo = new JLabel("");
    public JLabel playerBody = new BufferImage("player/player_base.png").toLabel();
    public JLabel[] playerFace = {
            new BufferImage("player/player_face_happy.png").toLabel(),
            new BufferImage("player/player_face_sick.png").toLabel()
    };

    public JLabel gameover = new BufferImage("ui/menu/gameover.png").toLabel();
    public JLabel survived = new BufferImage("ui/menu/survived.png").toLabel();

    public void onClickEvents() {
        labelMouse.toUrl(buttons[3], "https://github.com/neostetic");
        buttons[0].addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                eventLogic.startGame(new Difficulty(easy.player_health_sick, easy.player_thirst, easy.player_hunger, easy.player_luck));
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                buttons[0].setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override public void mouseReleased(MouseEvent e) {}
            @Override public void mousePressed(MouseEvent e) {}
            @Override public void mouseExited(MouseEvent e) {}
        });
        buttons[1].addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                eventLogic.startGame(new Difficulty(medium.player_health_sick, medium.player_thirst, medium.player_hunger, medium.player_luck));
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                buttons[1].setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override public void mouseReleased(MouseEvent e) {}
            @Override public void mousePressed(MouseEvent e) {}
            @Override public void mouseExited(MouseEvent e) {}
        });
        buttons[2].addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                eventLogic.startGame(new Difficulty(hard.player_health_sick, hard.player_thirst, hard.player_hunger, hard.player_luck));
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                buttons[2].setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override public void mouseReleased(MouseEvent e) {}
            @Override public void mousePressed(MouseEvent e) {}
            @Override public void mouseExited(MouseEvent e) {}
        });
        labelMouse.onClick(notepadButton, LabelMouseTypes.NOTEPAD_SWITCH);
        notepadButtons[1].addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                gameOver();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                notepadButtons[1].setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override public void mouseReleased(MouseEvent e) {}
            @Override public void mousePressed(MouseEvent e) {}
            @Override public void mouseExited(MouseEvent e) {}
        });
    }

    public void menu() {
        clearScreen();
        addItem(title, 0, 200, 1280, 69);
        addItem(buttons[0], 0, 280, 1280, 47);
        addItem(buttons[1], 0, 330, 1280, 47);
        addItem(buttons[2], 0, 380, 1280, 47);
        addItem(buttons[3], 0, 500, 1280, 47);
        addItem(menuBackground, 0, 0, 1280, 720);
    }

    public void gameStart() {
        clearScreen();
        panel.setBackground(Color.white);
        addItem(notepadButtons[0], 515, 484, 78, 78);
        addItem(notepadButtons[1], 593, 484, 78, 78);
        addItem(notepadButtons[2], 671, 484, 78, 78);
        addItem(notepadText, 437, 120, 349, 461);
        addItem(notepad, 411, 91, 459, 538);
        notepadButtons[0].setVisible(false);
        notepadButtons[1].setVisible(false);
        notepadButtons[2].setVisible(false);
        notepadText.setVisible(false);
        notepadText.setVerticalAlignment(JLabel.TOP);
        notepadText.setFont(new Font(config.srcOut + config.windows_font, Font.PLAIN, 14));
        notepad.setVisible(false);
        addItem(notepadButton, 1090, 0, 76, 101);
        addItem(soupBoxInfo, 836, 350, 100, 32);
        soupBoxInfo.setText(
                eventText.htmlStart + eventLogic.getPlayer().items[5].getHolding() + " WATER<br>" + eventLogic.getPlayer().items[6].getHolding() + " FOOD" + eventText.htmlEnd
        );
        addItem(soupBox, 786, 360, 197, 132);
        addFromInventory(eventLogic.getPlayer().items[0], shotgun, 252, 318, 47, 202);
        addFromInventory(eventLogic.getPlayer().items[1], map, 422, 209, 179, 139);
        addFromInventory(eventLogic.getPlayer().items[2], tape, 367, 456, 19, 12);
        addFromInventory(eventLogic.getPlayer().items[3], medkit, 1021, 284, 97, 75);
        addFromInventory(eventLogic.getPlayer().items[4], radio, 1018, 492, 150, 118);
        addItem(playerBody, 588, 268, 103, 342);
        addItem(playerFace[faceSwich()], 618, 284, 41, 49);
        addItem(background, 0, 0, 1280, 720);
    }

    public void gameOver() {
        clearScreen();
        JLabel gameOverText = new JLabel("You survived for " + eventLogic.getPlayer().getDay_count() + " days", SwingConstants.CENTER);
        addItem(gameOverText);
        addItem(gameover);
        panel.setBackground(Color.black);
        gameOverText.setFont(new Font(config.srcOut + config.windows_font, Font.PLAIN, 24));
        gameOverText.setForeground(Color.white);
        gameOverText.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                menu();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                gameOverText.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override public void mouseReleased(MouseEvent e) {}
            @Override public void mousePressed(MouseEvent e) {}
            @Override public void mouseExited(MouseEvent e) {}
        });

    }

    public void gameSurvived() {
        clearScreen();
        addItem(survived);
        panel.setBackground(Color.black);
    }

    public int faceSwich() {
        if (eventLogic.getPlayer().getHealth() < eventLogic.getPlayer().getHealth_sick()) {
            return 1;
        }
        return 0;
    }

    public void notepadSwitch() {
        if (notepadSwitcher) {
            notepadButtons[0].setVisible(false);
            notepadButtons[1].setVisible(false);
            notepadButtons[2].setVisible(false);
            notepadText.setVisible(false);
            notepad.setVisible(false);
            notepadSwitcher = false;
        } else {
            notepadButtons[0].setVisible(true);
            notepadButtons[1].setVisible(true);
            notepadButtons[2].setVisible(true);
            notepadText.setVisible(true);
            notepad.setVisible(true);
            notepadSwitcher = true;
        }
    }



    /* Utils */

    public void addFromInventory(Item item, JLabel[] label, int x, int y, int width, int height) {
        if (item.state == Item.ItemState.HOLDING) {
            addItem(label[0], x, y, width, height);
        } else if (item.state == Item.ItemState.BROKEN) {
            addItem(label[1], x, y, width, height);
        }
    }

    public void addItem(JLabel label, int x, int y, int width, int height) {
        panel.add(label);
        label.setLocation(x, y);
        label.setSize(width, height);
    }

    public void addItem(JLabel label) {
        panel.add(label);
        label.setLocation(0, 0);
        label.setSize(config.window_width, config.window_height);
    }

    public void delItem(JLabel label) {
        panel.remove(label);
        panel.validate();
        panel.repaint();
    }

    public void delItem(JLabel[] labels) {
        for (JLabel label : labels) {
            panel.remove(label);
            panel.validate();
            panel.repaint();
        }
    }

    public void clearScreen() {
        panel.removeAll();
        panel.validate();
        panel.repaint();
    }
}
