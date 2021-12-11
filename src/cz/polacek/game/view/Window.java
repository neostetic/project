package cz.polacek.game.view;

import javax.swing.*;

public class Window {

    protected JFrame frame = new JFrame();
    protected Panel panel = new Panel();
    protected Settings settings = new Settings(frame, panel);
    protected Views views = new Views(panel);

    public Window() {
        views.menu();
        settings.settings();
    }

}
