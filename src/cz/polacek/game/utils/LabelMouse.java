package cz.polacek.game.utils;

import cz.polacek.game.config.Difficulty;
import cz.polacek.game.config.difficulties.Easy;
import cz.polacek.game.config.difficulties.Hard;
import cz.polacek.game.config.difficulties.Medium;
import cz.polacek.game.engine.events.EventLogic;
import cz.polacek.game.view.WindowViews;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class LabelMouse {

    private boolean mousePointer;
    private WindowViews views;
    private Easy easy = new Easy();
    private Medium medium = new Medium();
    private Hard hard = new Hard();

    public LabelMouse(WindowViews views) {
        this.views = views;
        mousePointer = true;
    }

    public LabelMouse(WindowViews views, boolean mousePointer) {
        this.views = views;
        this.mousePointer = mousePointer;
    }

    public void toUrl(JLabel label, String url) {
        label.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Desktop.getDesktop().browse(new URI(url));
                } catch (IOException | URISyntaxException ex) {
                    ex.printStackTrace();
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override public void mousePressed(MouseEvent e) {}
            @Override public void mouseReleased(MouseEvent e) {}
            @Override public void mouseExited(MouseEvent e) {}
        });
    }

    public void onClick(JLabel label, LabelMouseTypes mouseTypes) {
        label.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                EventLogic logic = new EventLogic(views);
                switch(mouseTypes) {
                    case START_GAME_EASY:
                        logic.startGame(new Difficulty(easy.player_health_sick, easy.player_thirst, easy.player_hunger, easy.player_luck));
                        break;
                    case START_GAME_MEDIUM:
                        logic.startGame(new Difficulty(medium.player_health_sick, medium.player_thirst, medium.player_hunger, medium.player_luck));
                        break;
                    case START_GAME_HARD:
                        logic.startGame(new Difficulty(hard.player_health_sick, hard.player_thirst, hard.player_hunger, hard.player_luck));
                        break;
                    case EVENT_START:
                        break;
                    case EVENT_SKIP:
                        break;
                    case NOTEPAD_SWITCH:
                        views.notepadSwitch();
                        break;
                    case DIFFERENT:
                    default:
                        System.out.println("Undefined onClick : " + mouseTypes);
                        break;
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                if (mousePointer) label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override public void mousePressed(MouseEvent e) {}
            @Override public void mouseReleased(MouseEvent e) {}
            @Override public void mouseExited(MouseEvent e) {}
        });
    }
}
