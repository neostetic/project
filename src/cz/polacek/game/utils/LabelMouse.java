package cz.polacek.game.utils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class LabelMouse {

    public JLabel label;
    private boolean mousePointer;
    private String imgHoverUrl;
    /*
    public Function YES/NO EVENT or USE_ITEM EVENT
                        LUCK -ITEM
                        LUCK +ITEM
                    START EASY GAME
                          MEDIUM GAME
                          HARD GAME
                             CHANGE IMG SRC
     */

    public LabelMouse(JLabel label) {
        this.label = label;
        mousePointer = false;
        imgHoverUrl = null;
    }

    public LabelMouse(JLabel label, boolean mousePointer) {
        this.label = label;
        this.mousePointer = mousePointer;
        imgHoverUrl = null;
    }

    public LabelMouse(JLabel label, boolean mousePointer, String imgHoverUrl) {
        this.label = label;
        this.mousePointer = mousePointer;
        this.imgHoverUrl = imgHoverUrl;
    }

    public void toUrl(String url) {
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
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }

    public void onMouse() {
        label.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                if (mousePointer) label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }
}
