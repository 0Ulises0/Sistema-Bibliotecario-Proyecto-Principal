package gUILayer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelDialog extends JPanel implements ActionListener {
    private JButton btnDialog;

    public PanelDialog() {
        setLayout(new GridLayout(1, 2, 5, 5));
        add(new JLabel("JOptionPane"));

        btnDialog = new JButton("Mostrar mensaje");
        btnDialog.addActionListener(this);
        add(btnDialog);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(this, "Hola, soy un JOptionPane", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
    }
}
