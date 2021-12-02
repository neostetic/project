package cz.polacek.game.view;

import cz.polacek.game.utils.BufferImage;
import cz.polacek.game.utils.LabelMouse;
import cz.polacek.game.utils.LabelMouseTypes;

import javax.swing.*;

public class WindowViews {

    public JPanel panel;
    public LabelMouse labelMouse = new LabelMouse(WindowViews.this);

    public WindowViews(JPanel panel) {
        this.panel = panel;
    }

    public static boolean notepadSwitcher = false;

    public JLabel title = new BufferImage("ui/menu/title_big.png").toLabel();
    public JLabel menuBackground = new BufferImage("ui/menu/background.png").toLabel();
    public JLabel[] buttons = {
            new BufferImage("ui/buttons/btn_easy.png").toLabel(),
            new BufferImage("ui/buttons/btn_medium.png").toLabel(),
            new BufferImage("ui/buttons/btn_hard.png").toLabel(),
            new BufferImage("ui/menu/github.png").toLabel()
    };
    public JLabel notepad = new BufferImage("ui/game/notepad_blank.png").toLabel();
    public JLabel notepadButton = new BufferImage("ui/game/notepad_button.png").toLabel();
    public JLabel background = new BufferImage("items/background.png").toLabel();
    public JLabel shotgun = new BufferImage("items/shotgun.png").toLabel();
    public JLabel map = new BufferImage("items/map.png").toLabel();
    public JLabel tape = new BufferImage("items/tape.png").toLabel();
    public JLabel medkit = new BufferImage("items/medkit_broken.png").toLabel();
    public JLabel soupBox = new BufferImage("items/soup_box.png").toLabel();
    public JLabel playerBody = new BufferImage("player/player_base.png").toLabel();
    public JLabel playerFaceHappy = new BufferImage("player/player_face_sick.png").toLabel();

    public void onClickEvenest() {
        labelMouse.toUrl(buttons[3],"https://github.com/neostetic");
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
        addItem(notepad, 411, 91, 459, 538);
        notepad.setVisible(false);
        addItem(notepadButton, 1090, 0, 76, 101);
        addItem(soupBox, 786, 360, 197, 132);
        addItem(shotgun, 252, 318, 47, 202);
        addItem(map, 422, 209, 179, 139);
        addItem(tape, 367, 456, 19, 12);
        addItem(medkit, 1021, 284, 97, 75);
        addItem(playerBody, 588, 268, 103, 342);
        addItem(playerFaceHappy, 618, 284, 41, 49);
        addItem(background, 0, 0, 1280, 720);
    }

    public void notepadSwitch() {
        if (notepadSwitcher) {
            notepad.setVisible(false);
            notepadSwitcher = false;
        } else {
            notepad.setVisible(true);
            notepadSwitcher = true;
        }
    }


    /* Utils */

    public void addItem(JLabel label, int x, int y, int width, int height) {
        panel.add(label);
        label.setLocation(x,y);
        label.setSize(width,height);
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
