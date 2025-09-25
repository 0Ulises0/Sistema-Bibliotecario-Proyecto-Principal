package gUILayer;

import javax.swing.*;   // JFrame, JPanel, JScrollPane, SwingUtilities
import java.awt.*;      // Layouts

public class Principal extends JFrame {
    private static final long serialVersionUID = 1L;

    public Principal(String title) {
        super(title);

        // Configuración de la ventana
        setSize(1000, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Panel contenedor principal con BoxLayout (vertical)
        JPanel contenedor = new JPanel();
        contenedor.setLayout(new BoxLayout(contenedor, BoxLayout.Y_AXIS));

        // Agregamos todos los paneles de ejemplo
        contenedor.add(new PanelTextField());
        contenedor.add(new PanelComboBox());
        contenedor.add(new PanelCheckBox());
        contenedor.add(new PanelRadioButton());
        contenedor.add(new PanelTextArea());
        contenedor.add(new PanelList());
        contenedor.add(new PanelButton());
        contenedor.add(new PanelLabel());
        contenedor.add(new PanelTable());
        contenedor.add(new PanelProgress());
        contenedor.add(new PanelSlider());
        contenedor.add(new PanelDialog());

        // Scroll para poder ver todo si no cabe en la ventana
        JScrollPane scroll = new JScrollPane(contenedor);
        add(scroll);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Principal("Ejemplo completo de Swing").setVisible(true);
        });
    }
}
