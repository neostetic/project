package cz.polacek.game.view;

import javax.swing.*;

public class Window {

    protected JFrame frame = new JFrame();
    protected WindowPanel panel = new WindowPanel();
    protected WindowSettings settings = new WindowSettings(frame, panel);
    protected WindowViews views = new WindowViews(panel);

    public Window() {
        views.onClickEvenest();
        views.menu();
        settings.settings();
    }

}
