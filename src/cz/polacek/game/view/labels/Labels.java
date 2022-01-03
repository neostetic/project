package cz.polacek.game.view.labels;

import cz.polacek.game.config.difficulties.Easy;
import cz.polacek.game.config.difficulties.Hard;
import cz.polacek.game.config.difficulties.Medium;
import cz.polacek.game.engine.events.EventLogic;
import cz.polacek.game.utils.BufferImage;
import cz.polacek.game.utils.UtilMouseListener;
import cz.polacek.game.view.Views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Labels {

    public Views views;
    public EventLogic logic;

    public UtilMouseListener mouse = new UtilMouseListener();

    public Labels(Views views, EventLogic logic) {
        this.views = views;
        this.logic = logic;
        onClickEvents();
    }

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
        mouse.toUrl(buttons[3], "https://github.com/neostetic");
        buttons[0].addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                logic.startGame(new Easy());
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
                logic.startGame(new Medium());
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
                logic.startGame(new Hard());
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                buttons[2].setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override public void mouseReleased(MouseEvent e) {}
            @Override public void mousePressed(MouseEvent e) {}
            @Override public void mouseExited(MouseEvent e) {}
        });
        notepadButtons[0].addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                logic.startEvent(true);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                notepadButtons[1].setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override public void mouseReleased(MouseEvent e) {}
            @Override public void mousePressed(MouseEvent e) {}
            @Override public void mouseExited(MouseEvent e) {}
        });
        notepadButtons[1].addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                logic.startEvent(true);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                notepadButtons[1].setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override public void mouseReleased(MouseEvent e) {}
            @Override public void mousePressed(MouseEvent e) {}
            @Override public void mouseExited(MouseEvent e) {}
        });
        notepadButtons[2].addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                logic.startEvent(false);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                notepadButtons[1].setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override public void mouseReleased(MouseEvent e) {}
            @Override public void mousePressed(MouseEvent e) {}
            @Override public void mouseExited(MouseEvent e) {}
        });
        soupBox.addMouseListener(new MouseListener() {
            @Override
            public void mouseEntered(MouseEvent e) {
                soupBoxInfo.setVisible(true);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                soupBoxInfo.setVisible(false);
            }

            @Override public void mouseClicked(MouseEvent e) {}
            @Override public void mouseReleased(MouseEvent e) {}
            @Override public void mousePressed(MouseEvent e) {}
        });
        notepadButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                views.notepadSwitch();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                notepadButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override public void mousePressed(MouseEvent e) {}
            @Override public void mouseReleased(MouseEvent e) {}
            @Override public void mouseExited(MouseEvent e) {}
        });
    }
}
