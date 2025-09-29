package pantallas;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MostrarUsuarios extends JFrame implements ActionListener {
    private JTable tabla;
    private JButton btEliminar, btCerrar;
    private DefaultTableModel modeloTabla;

    public MostrarUsuarios() {
        setTitle("Usuarios Registrados");
        setSize(900, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // Crear tabla
        String[] columnNames = {"ID", "Nombres", "Apellidos", "Edad", "Género", "Teléfono", "Email",  "Fecha Nacimiento"};
        modeloTabla = new DefaultTableModel(columnNames, 0);
        tabla = new JTable(modeloTabla);
        tabla.setFont(new Font("Consolas", Font.PLAIN, 12));
        tabla.setRowHeight(25);

        JScrollPane scrollPane = new JScrollPane(tabla);

        JPanel panelBotones = new JPanel();
        btEliminar = new JButton("Eliminar Usuario Seleccionado");
        btCerrar = new JButton("Cerrar");
        btEliminar.setFont(new Font("Consolas", Font.PLAIN, 12));
        btCerrar.setFont(new Font("Consolas", Font.PLAIN, 12));

        panelBotones.add(btEliminar);
        panelBotones.add(btCerrar);

        add(scrollPane, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);

        btEliminar.addActionListener(this);
        btCerrar.addActionListener(this);

        cargarUsuarios();

        setVisible(true);
    }

    private void cargarUsuarios() {
        modeloTabla.setRowCount(0);

        try (BufferedReader br = new BufferedReader(new FileReader("src/datos/usuarios.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(";");
                // CORREGIDO: cambiar de >= 9 a >= 8
                if (datos.length >= 8) {
                    modeloTabla.addRow(datos);
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error al cargar usuarios: " + e.getMessage(), 
                "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void eliminarUsuario() {
        int filaSeleccionada = tabla.getSelectedRow();
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un usuario para eliminar", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String idEliminar = tabla.getValueAt(filaSeleccionada, 0).toString();
        String nombreUsuario = tabla.getValueAt(filaSeleccionada, 1).toString();

        int confirmar = JOptionPane.showConfirmDialog(this, "¿Está seguro de eliminar al usuario?\nID: " + idEliminar + "\nNombre: " + nombreUsuario, "Confirmar Eliminación", JOptionPane.YES_NO_OPTION);

        if (confirmar == JOptionPane.YES_OPTION) {
            if (eliminarUsuarioArchivo(idEliminar)) {
                JOptionPane.showMessageDialog(this, "Usuario eliminado correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                cargarUsuarios(); 
            } else {
                JOptionPane.showMessageDialog(this, "Error al eliminar usuario", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private boolean eliminarUsuarioArchivo(String idEliminar) {
        List<String> lineas = new ArrayList<>();
        boolean encontrado = false;

        try (BufferedReader br = new BufferedReader(new FileReader("src/datos/usuarios.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(";");
                if (datos.length > 0 && !datos[0].equals(idEliminar)) {
                    lineas.add(linea);
                } else {
                    encontrado = true;
                }
            }
        } catch (IOException e) {
            return false;
        }

        if (encontrado) {
            try (PrintWriter out = new PrintWriter(new FileWriter("src/datos/usuarios.txt"))) {
                for (String linea : lineas) {
                    out.println(linea);
                }
                return true;
            } catch (IOException e) {
                return false;
            }
        }
        return false;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btEliminar) {
            eliminarUsuario();
        } else if (e.getSource() == btCerrar) {
            dispose(); 
        }
    }
}