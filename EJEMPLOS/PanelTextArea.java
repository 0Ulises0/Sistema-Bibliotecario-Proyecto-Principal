package gUILayer;

import javax.swing.*;
import java.awt.*;

public class PanelTextArea extends JPanel {
    public PanelTextArea() {
        setLayout(new GridLayout(1, 2, 5, 5));
        add(new JLabel("JTextArea"));

        JTextArea txaMultilinea = new JTextArea();
        JScrollPane scroll = new JScrollPane(txaMultilinea);
        add(scroll);
    }
}
