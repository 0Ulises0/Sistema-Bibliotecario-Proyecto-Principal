package gUILayer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelRadioButton extends JPanel implements ActionListener {
    private JRadioButton rdoOp1, rdoOp2, rdoOp3;
    private JLabel lblRadio;

    public PanelRadioButton() {
        setLayout(new GridLayout(1, 2, 5, 5));
        add(new JLabel("JRadioButton"));

        JPanel jpRadio = new JPanel();
        jpRadio.setLayout(new BoxLayout(jpRadio, BoxLayout.Y_AXIS));

        rdoOp1 = new JRadioButton("Opcion1", true);
        rdoOp2 = new JRadioButton("Opcion2");
        rdoOp3 = new JRadioButton("Opcion3");

        rdoOp1.addActionListener(this);
        rdoOp2.addActionListener(this);
        rdoOp3.addActionListener(this);

        ButtonGroup grupo = new ButtonGroup();
        grupo.add(rdoOp1);
        grupo.add(rdoOp2);
        grupo.add(rdoOp3);

        jpRadio.add(rdoOp1);
        jpRadio.add(rdoOp2);
        jpRadio.add(rdoOp3);

        add(jpRadio);

        lblRadio = new JLabel("Opcion1");
        add(lblRadio);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == rdoOp1) lblRadio.setText("Opcion1");
        if (e.getSource() == rdoOp2) lblRadio.setText("Opcion2");
        if (e.getSource() == rdoOp3) lblRadio.setText("Opcion3");
    }
}
