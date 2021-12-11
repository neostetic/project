package cz.polacek.game.view;

import cz.polacek.game.config.Config;
import cz.polacek.game.config.Language;
import cz.polacek.game.config.languages.English;
import cz.polacek.game.engine.events.EventLogic;
import cz.polacek.game.engine.items.Item;
import cz.polacek.game.view.labels.Labels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Views {

    public JPanel panel;

    protected Config config = new Config();

    public Language eventText = new English();
    public EventLogic logic = new EventLogic(this);
    public Labels labels = new Labels(this, logic);

    public Views(JPanel panel) {
        this.panel = panel;
    }

    public static boolean notepadSwitcher = false;

    public void menu() {
        clearScreen();
        addItem(labels.title, 0, 200, 1280, 69);
        addItem(labels.buttons[0], 0, 280, 1280, 47);
        addItem(labels.buttons[1], 0, 330, 1280, 47);
        addItem(labels.buttons[2], 0, 380, 1280, 47);
        addItem(labels.buttons[3], 0, 500, 1280, 47);
        addItem(labels.menuBackground, 0, 0, 1280, 720);
    }

    public void gameScreen() {
        clearScreen();
        panel.setBackground(Color.white);
        addItem(labels.notepadButtons[0], 515, 484, 78, 78);
        addItem(labels.notepadButtons[1], 593, 484, 78, 78);
        addItem(labels.notepadButtons[2], 671, 484, 78, 78);
        addItem(labels.notepadText, 437, 120, 349, 461);
        addItem(labels.notepad, 411, 91, 459, 538);
        labels.notepadButtons[0].setVisible(false);
        labels.notepadButtons[1].setVisible(false);
        labels.notepadButtons[2].setVisible(false);
        labels.notepadText.setVisible(false);
        labels.notepadText.setVerticalAlignment(JLabel.TOP);
        labels.notepadText.setFont(new Font(config.srcOut + config.windows_font, Font.PLAIN, 14));
        labels.notepad.setVisible(false);
        addItem(labels.notepadButton, 1090, 0, 76, 101);
        addItem(labels.soupBoxInfo, 836, 350, 100, 32);
        labels.soupBoxInfo.setText(
                eventText.htmlStart + logic.getPlayer().items[5].getHolding() + " WATER<br>" + logic.getPlayer().items[6].getHolding() + " FOOD" + eventText.htmlEnd
        );
        labels.soupBoxInfo.setVisible(false);
        addItem(labels.soupBox, 786, 360, 197, 132);
        addFromInventory(logic.getPlayer().items[0], labels.shotgun, 252, 318, 47, 202);
        addFromInventory(logic.getPlayer().items[1], labels.map, 422, 209, 179, 139);
        addFromInventory(logic.getPlayer().items[2], labels.tape, 367, 456, 19, 12);
        addFromInventory(logic.getPlayer().items[3], labels.medkit, 1021, 284, 97, 75);
        addFromInventory(logic.getPlayer().items[4], labels.radio, 1018, 492, 150, 118);
        addItem(labels.playerBody, 588, 268, 103, 342);
        addItem(labels.playerFace[faceSwich()], 618, 284, 41, 49);
        addItem(labels.background, 0, 0, 1280, 720);
    }

    public void gameOver() {
        clearScreen();
        gameSurvivedDays(false);
        addItem(labels.gameover);
        panel.setBackground(Color.black);

    }

    public void gameSurvived() {
        clearScreen();
        gameSurvivedDays(true);
        addItem(labels.survived);
        panel.setBackground(Color.black);
    }

    public void gameSurvivedDays(Boolean alive) {
        JLabel gameOverText = new JLabel("You survived for " + logic.getPlayer().getDay_count() + " days", SwingConstants.CENTER);
        addItem(gameOverText);
        gameOverText.setFont(new Font(config.srcOut + config.windows_font, Font.PLAIN, 24));
        gameOverText.setForeground(Color.white);
        gameOverText.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (alive) {
                    gameScreen();
                } else {
                    menu();
                }
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

    public int faceSwich() {
        if (logic.getPlayer().getHealth() < logic.getPlayer().getHealth_sick()) {
            return 1;
        }
        return 0;
    }

    public void notepadSwitch() {
        if (notepadSwitcher) {
            labels.notepadButtons[0].setVisible(false);
            labels.notepadButtons[1].setVisible(false);
            labels.notepadButtons[2].setVisible(false);
            labels.notepadText.setVisible(false);
            labels.notepad.setVisible(false);
            notepadSwitcher = false;
        } else {
            if (logic.getPlayer().getDay_count() == 0) {
                labels.notepadButtons[1].setVisible(true);
            } else {
                labels.notepadButtons[0].setVisible(true);
                labels.notepadButtons[2].setVisible(true);
            }
            labels.notepadText.setVisible(true);
            labels.notepad.setVisible(true);
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
