package cz.polacek.game.view;

import cz.polacek.game.config.Config;

import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel {

    final Config config = new Config();

    public Panel() {
        this.setPreferredSize(new Dimension(config.window_width, config.window_height));
        this.setBackground(Color.WHITE);
        this.setDoubleBuffered(true); // Better render
        this.setLayout(null);
    }
}
