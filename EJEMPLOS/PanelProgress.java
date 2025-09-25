package gUILayer;

import javax.swing.*;
import java.awt.*;

public class PanelProgress extends JPanel {
    public PanelProgress() {
        setLayout(new GridLayout(2, 1, 5, 5));
        add(new JLabel("JProgressBar"));

        JProgressBar barra = new JProgressBar(0, 100);
        barra.setValue(70);
        barra.setStringPainted(true);
        add(barra);
    }
}
