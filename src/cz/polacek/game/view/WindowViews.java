package cz.polacek.game.view;

import cz.polacek.game.config.Config;
import cz.polacek.game.config.Language;
import cz.polacek.game.config.languages.English;
import cz.polacek.game.engine.items.Item;
import cz.polacek.game.engine.items.Items;
import cz.polacek.game.utils.BufferImage;
import cz.polacek.game.utils.LabelMouse;
import cz.polacek.game.utils.LabelMouseTypes;

import javax.swing.*;
import java.awt.*;

public class WindowViews {

    public JPanel panel;
    public LabelMouse labelMouse = new LabelMouse(WindowViews.this);
    public Language eventText = new English();
    protected Config config = new Config();

    public WindowViews(JPanel panel) {
        this.panel = panel;
    }

    public static boolean notepadSwitcher = false;

    public JLabel title = new BufferImage("ui/menu/title_big.png").toLabel();
    public JLabel menuBackground = new BufferImage("ui/menu/background.png").toLabel();
    public JLabel[] buttons = {
            new BufferImage("ui/buttons/easy.png").toLabel(),
            new BufferImage("ui/buttons/medium.png").toLabel(),
            new BufferImage("ui/buttons/hard.png").toLabel(),
            new BufferImage("ui/menu/github.png").toLabel()
    };

    public JLabel notepad = new BufferImage("ui/game/notepad_blank.png").toLabel();
    public JLabel notepadButton = new BufferImage("ui/game/notepad_button.png").toLabel();
    public JLabel notepadText = new JLabel(eventText.htmlStart + eventText.days + eventText.start_game + eventText.htmlEnd);

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
    public JLabel soupBox = new BufferImage("items/soup_box.png").toLabel();
    public JLabel playerBody = new BufferImage("player/player_base.png").toLabel();
    public JLabel playerFaceHappy = new BufferImage("player/player_face_happy.png").toLabel();

    public void onClickEvents() {
        labelMouse.toUrl(buttons[3], "https://github.com/neostetic");
        labelMouse.onClick(buttons[0], LabelMouseTypes.START_GAME_EASY);
        labelMouse.onClick(buttons[1], LabelMouseTypes.START_GAME_MEDIUM);
        labelMouse.onClick(buttons[2], LabelMouseTypes.START_GAME_HARD);
        labelMouse.onClick(notepadButton, LabelMouseTypes.NOTEPAD_SWITCH);
    }

    public void menu() {
        addItem(title, 0, 200, 1280, 69);
        addItem(buttons[0], 0, 280, 1280, 47);
        addItem(buttons[1], 0, 330, 1280, 47);
        addItem(buttons[2], 0, 380, 1280, 47);
        addItem(buttons[3], 0, 500, 1280, 47);
        addItem(menuBackground, 0, 0, 1280, 720);
    }

    public void gameStart() {
        clearScreen();
        addItem(notepadText, 437, 120, 349, 461);
        addItem(notepad, 411, 91, 459, 538);
        notepadText.setVisible(false);
        notepadText.setVerticalAlignment(JLabel.TOP);
        notepadText.setFont(new Font(config.srcOut + config.windows_font, Font.PLAIN, 16));
        notepad.setVisible(false);
        addItem(notepadButton, 1090, 0, 76, 101);
        addItem(soupBox, 786, 360, 197, 132);
        addFromInventory(Items.SHOTGUN, shotgun, 252, 318, 47, 202);
        addFromInventory(Items.MAP, map, 422, 209, 179, 139);
        addFromInventory(Items.TAPE, tape, 367, 456, 19, 12);
        addFromInventory(Items.MEDKIT, medkit, 1021, 284, 97, 75);
        addItem(playerBody, 588, 268, 103, 342);
        addItem(playerFaceHappy, 618, 284, 41, 49);
        addItem(background, 0, 0, 1280, 720);
    }

    public void notepadSwitch() {
        if (notepadSwitcher) {
            notepadText.setVisible(false);
            notepad.setVisible(false);
            notepadSwitcher = false;
        } else {
            notepadText.setVisible(true);
            notepad.setVisible(true);
            notepadSwitcher = true;
        }
    }


    /* Utils */

    public void addFromInventory(Items item, JLabel[] label, int x, int y, int width, int height) {
        if (item.getItem().state == Item.ItemState.HOLDING) {
            addItem(label[0], x, y, width, height);
        } else if (item.getItem().state == Item.ItemState.BROKEN) {
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
