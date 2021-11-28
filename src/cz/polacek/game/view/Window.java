package cz.polacek.game.view;

import cz.polacek.game.config.Config;
import cz.polacek.game.utils.UtilBufferImage;
import cz.polacek.game.utils.UtilLabelMouse;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Window {

    private Config config = new Config();
    protected JFrame frame = new JFrame();
    protected WindowPanel panel = new WindowPanel();

    public Window() {
        view();
        settings();
    }

    // Current Window View
    public void view() {
        demo();
    }

    public void demo() {
        JLabel[] buttons = {
            new UtilBufferImage("buttons/btn_easy.png").toLabel(),
            new UtilBufferImage("buttons/btn_medium.png").toLabel(),
            new UtilBufferImage("buttons/btn_hard.png").toLabel()
        };

        new UtilLabelMouse(buttons[0]).onMouse();

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

        panel.add(buttons[0]);
        panel.add(buttons[1]);
        panel.add(buttons[2]);
        panel.add(new UtilBufferImage("placeholder.png").toLabel());
        // panel.removeAll();
    }

    public void settings() {
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(config.window_resizable);
        frame.setTitle(config.window_title);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(config.window_visible);
        frame.setLayout(new BorderLayout());
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
    }

}
