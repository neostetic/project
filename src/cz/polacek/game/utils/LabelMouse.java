package cz.polacek.game.utils;

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
                switch(mouseTypes) {
                    case START_GAME_EASY:
                        views.gameStart();
                        break;
                    case START_GAME_MEDIUM:
                        views.gameStart();
                        break;
                    case START_GAME_HARD:
                        views.gameStart();
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
