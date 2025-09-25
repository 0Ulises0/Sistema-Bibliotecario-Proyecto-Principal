package gUILayer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PanelTextField extends JPanel implements KeyListener {
    private JTextField txtNombre;
    private JLabel lblNombre;

    public PanelTextField() {
        setLayout(new GridLayout(1, 3, 5, 5));
        add(new JLabel("JTextField"));
        txtNombre = new JTextField(5);
        txtNombre.addKeyListener(this);
        add(txtNombre);
        lblNombre = new JLabel();
        add(lblNombre);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getSource() == txtNombre && e.getKeyCode() == KeyEvent.VK_ENTER) {
            lblNombre.setText(txtNombre.getText());
        }
    }
    @Override public void keyReleased(KeyEvent e) {}
    @Override public void keyTyped(KeyEvent e) {}
}
