package gUILayer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelButton extends JPanel implements ActionListener {
    private JButton btnSaludo;
    private JLabel lblMensaje;

    public PanelButton() {
        setLayout(new GridLayout(1, 2, 5, 5));
        add(new JLabel("JButton"));

        btnSaludo = new JButton("Haz clic");
        btnSaludo.addActionListener(this);
        add(btnSaludo);

        lblMensaje = new JLabel("Esperando clic...");
        add(lblMensaje);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        lblMensaje.setText("¡Hola desde JButton!");
    }
}
