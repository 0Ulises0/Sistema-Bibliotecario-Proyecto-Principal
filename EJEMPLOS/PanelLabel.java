package gUILayer;

import javax.swing.*;
import java.awt.*;

public class PanelLabel extends JPanel {
    public PanelLabel() {
        setLayout(new GridLayout(1, 2, 5, 5));
        add(new JLabel("JLabel con icono"));

        // Cambia la ruta a una imagen que tengas
        ImageIcon icono = new ImageIcon("icon.png");
        JLabel lblIcono = new JLabel("Texto + Icono", icono, JLabel.CENTER);
        add(lblIcono);
    }
}
