package cz.polacek.game.view;

import javax.swing.*;

public class WindowError {
    public String error;

    public WindowError(String error) {
        this.error = error;
        JOptionPane.showMessageDialog(null, error,"Something went wrong!", JOptionPane.ERROR_MESSAGE);
    }

    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, null,"Something went wrong!", JOptionPane.ERROR_MESSAGE);
    }

}
