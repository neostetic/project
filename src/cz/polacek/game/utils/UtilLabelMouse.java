package cz.polacek.game.utils;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class UtilLabelMouse {

    public JLabel label;
    /*
    public Function YES/NO EVENT or USE_ITEM EVENT
                        LUCK -ITEM
                        LUCK +ITEM
                    START EASY GAME
                    START MEDIUM GAME
                    START HARD GAME
     */

    public UtilLabelMouse(JLabel label) {
        this.label = label;
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

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }
}
