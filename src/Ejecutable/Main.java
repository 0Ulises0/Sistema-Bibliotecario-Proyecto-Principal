package Ejecutable;

import javax.swing.SwingUtilities;
import pantallas.PantallaPrincipal;

public class Main {
    public static void main(String[] args) {
    // Versión moderna con lambda
        SwingUtilities.invokeLater(() -> {
            PantallaPrincipal pp = new PantallaPrincipal("Sistema Bibliotecario");
            pp.setVisible(true);
        });
    }
}