package gUILayer;

import javax.swing.*;
import java.awt.*;

public class PanelTable extends JPanel {
    public PanelTable() {
        setLayout(new BorderLayout());
        add(new JLabel("JTable"), BorderLayout.NORTH);

        String[][] data = {
            {"1", "Juan", "20"},
            {"2", "Ana", "22"},
            {"3", "Luis", "19"},
            {"1", "Juan", "20"},
            {"2", "Ana", "22"},
            {"3", "Luis", "19"},
            {"1", "Juan", "20"},
            {"2", "Ana", "22"},
            {"3", "Luis", "19"},
            {"1", "Juan", "20"},
            {"2", "Ana", "22"},
            {"3", "Luis", "19"}
        };
        String[] columnas = {"ID", "Nombre", "Edad"};
        
        
        JTable tabla = new JTable(data, columnas);
        JScrollPane scroll = new JScrollPane(tabla);

        add(scroll, BorderLayout.CENTER);
    }
}
