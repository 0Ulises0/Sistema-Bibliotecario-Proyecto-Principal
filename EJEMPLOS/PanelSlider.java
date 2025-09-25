package gUILayer;

import javax.swing.*;
import java.awt.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class PanelSlider extends JPanel implements ChangeListener {
    private JLabel lblValor;
    private JSlider slider;

    public PanelSlider() {
        setLayout(new GridLayout(2, 1, 5, 5));
        add(new JLabel("JSlider"));

        slider = new JSlider(0, 100, 50);
        slider.addChangeListener(this);
        add(slider);

        lblValor = new JLabel("Valor: 50");
        add(lblValor);
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        lblValor.setText("Valor: " + slider.getValue());
    }
}
