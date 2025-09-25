package gUILayer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelCheckBox extends JPanel implements ActionListener {
    private JCheckBox chkAM, chkPM;
    private JLabel lblCheck;

    public PanelCheckBox() {
        setLayout(new GridLayout(1, 2, 5, 5));
        add(new JLabel("JCheckBox"));

        JPanel jpCheck = new JPanel();
        jpCheck.setLayout(new BoxLayout(jpCheck, BoxLayout.Y_AXIS));

        chkAM = new JCheckBox("AM");
        chkPM = new JCheckBox("PM");
        chkAM.addActionListener(this);
        chkPM.addActionListener(this);

        jpCheck.add(chkAM);
        jpCheck.add(chkPM);
        add(jpCheck);

        lblCheck = new JLabel();
        add(lblCheck);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String texto = "";
        if (chkAM.isSelected()) texto = "AM";
        if (chkPM.isSelected()) texto += texto.isEmpty() ? "PM" : ", PM";
        lblCheck.setText(texto);
    }
}
