package gUILayer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelComboBox extends JPanel implements ActionListener {
    private JComboBox<String> cmbColor;
    private JLabel lblColor;

    public PanelComboBox() {
        setLayout(new GridLayout(1, 2, 5, 5));
        add(new JLabel("JComboBox"));
        cmbColor = new JComboBox<>(new String[]{"Rojo", "Blanco", "Verde", "Amarillo"});
        cmbColor.addActionListener(this);
        add(cmbColor);
        lblColor = new JLabel();
        add(lblColor);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        lblColor.setText(cmbColor.getSelectedItem().toString());
    }
}
