package cz.polacek.game.view;

import cz.polacek.game.utils.BufferImage;
import cz.polacek.game.utils.LabelMouse;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class WindowViews {

    JPanel panel;

    public WindowViews(JPanel panel) {
        this.panel = panel;
    }

    public void demo() {
        JLabel title = new BufferImage("ui/menu/title_big.png").toLabel();
        JLabel[] buttons = {
                new BufferImage("ui/buttons/btn_easy.png").toLabel(),
                new BufferImage("ui/buttons/btn_medium.png").toLabel(),
                new BufferImage("ui/buttons/btn_hard.png").toLabel(),
                new BufferImage("ui/menu/github.png").toLabel()
        };

        new LabelMouse(buttons[3]).toUrl("https://github.com/neostetic");

        buttons[0].addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Starting Easy");
            }
            @Override public void mousePressed(MouseEvent e) {}
            @Override public void mouseReleased(MouseEvent e) {}
            @Override public void mouseEntered(MouseEvent e) {}
            @Override public void mouseExited(MouseEvent e) {}
        });

        buttons[1].addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Starting Medium");
            }
            @Override public void mousePressed(MouseEvent e) {}
            @Override public void mouseReleased(MouseEvent e) {}
            @Override public void mouseEntered(MouseEvent e) {}
            @Override public void mouseExited(MouseEvent e) {}
        });

        buttons[2].addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Starting Hard");
            }
            @Override public void mousePressed(MouseEvent e) {}
            @Override public void mouseReleased(MouseEvent e) {}
            @Override public void mouseEntered(MouseEvent e) {}
            @Override public void mouseExited(MouseEvent e) {}
        });
        panel.add(title);
        title.setLocation(0,200);
        title.setSize(1280,69);
        panel.add(buttons[0]);
        panel.add(buttons[1]);
        panel.add(buttons[2]);
        panel.add(buttons[3]);
        buttons[0].setLocation(0,280);
        buttons[0].setSize(1280,47);
        buttons[1].setLocation(0,330);
        buttons[1].setSize(1280,47);
        buttons[2].setLocation(0,380);
        buttons[2].setSize(1280,47);
        buttons[3].setLocation(0,500);
        buttons[3].setSize(1280,47);
        // panel.removeAll();
        gameScreen();
    }

    public void gameScreen() {
        JLabel background = new BufferImage("ui/background.png").toLabel();
        panel.add(background);
        background.setLocation(0,0);
        background.setSize(1280,720);
    }
}
