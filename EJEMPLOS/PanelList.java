package gUILayer;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;

public class PanelList extends JPanel implements ListSelectionListener {
    private JList<String> lstLista;
    private JLabel lblLista;

    public PanelList() {
        setLayout(new GridLayout(1, 2, 5, 5));
        add(new JLabel("JList"));

        String[] opciones = {"Teclado", "Mouse", "Monitor"};
        lstLista = new JList<>(opciones);
        lstLista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        lstLista.addListSelectionListener(this);

        JScrollPane scroll = new JScrollPane(lstLista);
        add(scroll);

        lblLista = new JLabel();
        add(lblLista);
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) {
            lblLista.setText(lstLista.getSelectedValue());
        }
    }
}
