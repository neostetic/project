package cz.polacek.game.view;

import cz.polacek.game.config.Config;

import javax.swing.*;

public class Settings {

    private Config config = new Config();
    JFrame frame;
    Panel panel;

    public Settings(JFrame frame, Panel panel) {
        this.frame = frame;
        this.panel = panel;
    }

    public void settings() {
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(config.window_resizable);
        frame.setTitle(config.window_title);
        frame.add(panel);
        frame.setSize(config.window_width, config.window_height);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(config.window_visible);
        frame.setLayout(null);
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
    }
}
