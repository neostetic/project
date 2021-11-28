package cz.polacek.game.utils;

import cz.polacek.game.config.Config;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class UtilBufferImage extends JLabel {

    public String imgSrc;
    public Config config = new Config();

    public UtilBufferImage(String imgSrc) {
        this.imgSrc = config.imgSrcOut + imgSrc;
    }

    public JLabel toLabel() {
        return new JLabel(new ImageIcon(imgSrc));
    }
}
