package pantallas;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.*;
import java.time.LocalDate;
import java.util.ArrayList;

import objetos.Prestamos;
import objetos.Usuario; 
import java.util.List;

public class PantallaRegistroUsuarios extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;

    private JTextField jtNombres, jtApellidos, jtTelefono, jtEmail;
    private JComboBox<String> cbGenero, cbDia, cbMes, cbAnio;
    private JButton btRegistrar, btLimpiar,btVerUsuarios;
    private JLabel titulo;

    public PantallaRegistroUsuarios(String tituloVentana){
        setTitle(tituloVentana);
        setSize(1366, 768);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());

        componentesRegistro();
    }

    private void componentesRegistro()
    {
        Font fuente = new Font("Arial", Font.PLAIN, 12);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JPanel panelTitulo = new JPanel(new BorderLayout());
        panelTitulo.setBackground(new Color(211, 219, 232));
        panelTitulo.setBorder(BorderFactory.createEmptyBorder(10, 50, 10, 50)); 

        titulo = new JLabel("Registro de Usuarios");
        titulo.setFont(new Font("Arial", Font.PLAIN, 20));
        titulo.setForeground(Color.BLACK);
        titulo.setHorizontalAlignment(SwingConstants.CENTER);

        panelTitulo.add(titulo, BorderLayout.CENTER);

        gbc.gridx = 0; 
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        gbc.insets = new Insets(10, 5, 20, 5); 

        add(panelTitulo, gbc);

        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.EAST;
        
        // Nombres
        gbc.gridx = 0; gbc.gridy = 1;
        JLabel lblNombres = new JLabel("Nombres:");
        lblNombres.setFont(fuente);
        add(lblNombres, gbc);

        gbc.gridx = 1;
        jtNombres = new JTextField(20);
        jtNombres.setFont(fuente);
        add(jtNombres, gbc);

        // Apellidos
        gbc.gridx = 0; gbc.gridy = 2;
        JLabel lblApellidos = new JLabel("Apellidos:");
        lblApellidos.setFont(fuente);
        add(lblApellidos, gbc);

        gbc.gridx = 1;
        jtApellidos = new JTextField(20);
        jtApellidos.setFont(fuente);
        add(jtApellidos, gbc);

        // Género
        gbc.gridx = 0; gbc.gridy = 3;
        JLabel lbGenero = new JLabel("Género:");
        lbGenero.setFont(fuente);
        add(lbGenero, gbc);

        gbc.gridx = 1;
        cbGenero = new JComboBox<>(new String[]{"Seleccionar", "Femenino", "Masculino", "Prefiero no decir", "Otro"});
        cbGenero.setFont(fuente);
        add(cbGenero, gbc);

        // Fecha de Nacimiento
        gbc.gridx = 0; gbc.gridy = 4;
        JLabel lblFechaNacimiento = new JLabel("Fecha de Nacimiento:");
        lblFechaNacimiento.setFont(fuente);
        add(lblFechaNacimiento, gbc);

        gbc.gridx = 1;
        JPanel panelFecha = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));

        cbDia = new JComboBox<>();
        cbDia.setFont(fuente);
        cbDia.addItem("Día");
        for (int i = 1; i <= 31; i++) cbDia.addItem(String.valueOf(i));

        cbMes = new JComboBox<>();
        cbMes.setFont(fuente);
        cbMes.addItem("Mes");
        String[] meses = {"Enero","Febrero","Marzo","Abril","Mayo","Junio", 
                          "Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"};
        for (int i = 0; i < meses.length; i++) cbMes.addItem((i+1)+" - "+meses[i]);

        cbAnio = new JComboBox<>();
        cbAnio.setFont(fuente);
        cbAnio.addItem("Año");
        int anioActual = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);
        for (int i = anioActual; i >= 1900; i--) cbAnio.addItem(String.valueOf(i));

        panelFecha.add(cbDia);
        panelFecha.add(cbMes);
        panelFecha.add(cbAnio);
        add(panelFecha, gbc);

        // Teléfono
        gbc.gridx = 0; gbc.gridy = 5;
        JLabel lblTelefono = new JLabel("Teléfono:");
        lblTelefono.setFont(fuente);
        add(lblTelefono, gbc);

        gbc.gridx = 1;
        jtTelefono = new JTextField(15);
        jtTelefono.setFont(fuente);
        add(jtTelefono, gbc);

        // Email
        gbc.gridx = 0; gbc.gridy = 6;
        JLabel lblEmail = new JLabel("E-mail:");
        lblEmail.setFont(fuente);
        add(lblEmail, gbc);

        gbc.gridx = 1;
        jtEmail = new JTextField(20);
        jtEmail.setFont(fuente);
        add(jtEmail, gbc);

        // Botones
        JPanel panelBotones = new JPanel();
        btRegistrar = new JButton("Registrar");
        btRegistrar.setFont(fuente);
        btLimpiar = new JButton("Limpiar");
        btLimpiar.setFont(fuente);
        btVerUsuarios = new JButton("Ver Usuarios"); 
        btVerUsuarios.setFont(fuente);
        panelBotones.add(btRegistrar);
        panelBotones.add(btLimpiar);
        panelBotones.add(btVerUsuarios);

        gbc.gridx = 0; gbc.gridy = 7;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(panelBotones, gbc);

        // Listeners
        btRegistrar.addActionListener(this);
        btLimpiar.addActionListener(this);
        btVerUsuarios.addActionListener(this);
    }

    private String generarId() {
    int maxId = 0;
    try (BufferedReader br = new BufferedReader(new FileReader("src/datos/usuarios.txt"))) {
        String linea;
        while ((linea = br.readLine()) != null) {
            String[] datos = linea.split(";");
            if (datos.length > 0) {
                try {
                    int idExistente = Integer.parseInt(datos[0]);
                    if (idExistente > maxId) {
                        maxId = idExistente;
                    }
                } catch (NumberFormatException e) {
                    // si el archivo tiene datos mal formados, se ignoran
                }
            }
        }
    } catch (IOException e) {
        // si el archivo no existe aún, no pasa nada
    }
    return String.valueOf(maxId + 1);
}


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btRegistrar) {
        	
        	String id = generarId(); 
            String telefonoStr = jtTelefono.getText(), nombre = jtNombres.getText(), apellido = jtApellidos.getText();
            String email = jtEmail.getText();
        	int dia = Integer.parseInt(cbDia.getSelectedItem().toString()), mes = Integer.parseInt(cbMes.getSelectedItem().toString().split(" - ")[0]), anio = Integer.parseInt(cbAnio.getSelectedItem().toString());
            char genero = cbGenero.getSelectedItem().toString().charAt(0);
            
        	if (jtNombres.getText().isEmpty() || jtApellidos.getText().isEmpty() ||
                jtTelefono.getText().isEmpty() || jtEmail.getText().isEmpty() ||
                cbGenero.getSelectedIndex() == 0 || cbDia.getSelectedIndex() == 0 || cbMes.getSelectedIndex() == 0 || cbAnio.getSelectedIndex() == 0) {
                JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            if (!telefonoStr.matches("\\d{10}")) {
                JOptionPane.showMessageDialog(this, "El teléfono debe tener 10 dígitos numéricos", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (!email.contains("@") || !email.contains(".")) {
                JOptionPane.showMessageDialog(this, "El email no es válido", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }     
            LocalDate fechaNacimiento = LocalDate.of(anio, mes, dia);
            if (fechaNacimiento.isAfter(LocalDate.now())) {
                JOptionPane.showMessageDialog(this, "La fecha de nacimiento no existe", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            int edad = java.time.Period.between(fechaNacimiento,LocalDate.now()).getYears();
            if (edad < 12) {
                JOptionPane.showMessageDialog(this, "La edad minima es de 12 años", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (existeUsuarioDuplicado(id, nombre, apellido)) {
                return; 
            }
            Usuario usuario = new Usuario(id, nombre, apellido, edad, genero, telefonoStr, email, fechaNacimiento);
            try (java.io.FileWriter fw = new java.io.FileWriter("src/datos/usuarios.txt", true);
                 java.io.BufferedWriter bw = new java.io.BufferedWriter(fw);
                 java.io.PrintWriter out = new java.io.PrintWriter(bw)) {

                out.println(usuario.toString());
                JOptionPane.showMessageDialog(this, "Registro guardado en usuarios ", "Éxito", JOptionPane.INFORMATION_MESSAGE);

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error al guardar usuario: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
            limpiarCampos();
        } 
        else if (e.getSource() == btLimpiar) {
            limpiarCampos();
        } 
        else if (e.getSource() == btVerUsuarios) {
            new MostrarUsuarios(); 
        }
    }

    private boolean existeUsuarioDuplicado(String id, String nombre, String apellido) {
        try (BufferedReader br = new BufferedReader(new FileReader("src/datos/usuarios.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(";");
                if (datos.length >= 8) { 
                    String idExistente = datos[0],nombreExistente = datos[1],apellidoExistente = datos[2]; 
                    
                    if (idExistente.equals(id)) {
                        JOptionPane.showMessageDialog(this,"Ya existe un usuario con el ID: " + id, "ID duplicado", JOptionPane.ERROR_MESSAGE);
                        return true;
                    }
                    if (nombreExistente.equalsIgnoreCase(nombre) && apellidoExistente.equalsIgnoreCase(apellido)) {
                        JOptionPane.showMessageDialog(this, "Ya existe un usuario con el nombre: " + nombre + " " + apellido, "Nombre duplicado", 
                            JOptionPane.ERROR_MESSAGE);
                        return true;
                    }
                }
            }
        } catch (IOException e) {
        }
        return false;
    }
    private void limpiarCampos() {
        jtNombres.setText(""); jtApellidos.setText(""); jtTelefono.setText("");jtEmail.setText(""); 
        cbGenero.setSelectedIndex(0); cbDia.setSelectedIndex(0); cbMes.setSelectedIndex(0); cbAnio.setSelectedIndex(0); 
    }
}