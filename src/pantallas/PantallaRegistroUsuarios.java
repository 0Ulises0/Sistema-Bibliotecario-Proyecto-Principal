package pantallas;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PantallaRegistroUsuarios extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	
	private JTextField jtCodigo, jtNombres, jtApellidos, jtTelefono, jtEmail;
    private JPasswordField jpContrasena, jpConfirmarContrasena;
    private JComboBox<String> cbGenero, cbDia,cbMes, cbAnio;
    private JRadioButton rbAdmin, rbUsuario;
    private JButton btRegistrar, btLimpiar, btCancelar;
    private ButtonGroup grupoNivel;
    private JLabel titulo;
    
    public PantallaRegistroUsuarios(String tituloVentana){
        setTitle(tituloVentana);
        setSize(500, 500);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());
        Font consola = new Font("Consolas", Font.PLAIN, 12);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JPanel panelTitulo = new JPanel(new BorderLayout());
        panelTitulo.setBackground(new Color(211, 219, 232));
        panelTitulo.setBorder(BorderFactory.createEmptyBorder(10, 50, 10, 50)); 

        titulo = new JLabel("Registro de Usuarios");
        titulo.setFont(new Font("Consolas", Font.PLAIN, 20));
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
        
        // Código de usuario
        gbc.gridx = 0; gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx = 0;
        JLabel lblCodigo = new JLabel("Código de Usuario:");
        lblCodigo.setFont(consola);
        add(lblCodigo, gbc);

        gbc.gridx = 1; gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1;
        jtCodigo = new JTextField(15);
        jtCodigo.setFont(consola);
        add(jtCodigo, gbc);

        // Nivel de usuario 
        gbc.gridx = 0; gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx = 0;
        JLabel lblNivel = new JLabel("Nivel de Usuario:");
        lblNivel.setFont(consola);
        add(lblNivel, gbc);

        gbc.gridx = 1; gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx = 1;
        JPanel panelNivel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
        rbAdmin = new JRadioButton("Administrador");
        rbAdmin.setFont(consola);
        rbUsuario = new JRadioButton("Usuario");
        rbUsuario.setFont(consola);
        grupoNivel = new ButtonGroup();
        grupoNivel.add(rbAdmin);
        grupoNivel.add(rbUsuario);
        panelNivel.add(rbAdmin);
        panelNivel.add(rbUsuario);
        add(panelNivel, gbc);

        // Contraseña
        gbc.gridx = 0; gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx = 0;
        JLabel lblContrasena = new JLabel("Contraseña:");
        lblContrasena.setFont(consola);
        add(lblContrasena, gbc);

        gbc.gridx = 1; gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1;
        jpContrasena = new JPasswordField(15);
        jpContrasena.setFont(consola);
        add(jpContrasena, gbc);

        // Confirmar contraseña
        gbc.gridx = 0; gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx = 0;
        JLabel lblConfirmarContrasena = new JLabel("Confirmar Contraseña:");
        lblConfirmarContrasena.setFont(consola);
        add(lblConfirmarContrasena, gbc);

        gbc.gridx = 1; gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1;
        jpConfirmarContrasena = new JPasswordField(15);
        jpConfirmarContrasena.setFont(consola);
        add(jpConfirmarContrasena, gbc);

        // Nombres
        gbc.gridx = 0; gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx = 0;
        JLabel lblNombres = new JLabel("Nombres:");
        lblNombres.setFont(consola);
        add(lblNombres, gbc);

        gbc.gridx = 1; gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1;
        jtNombres = new JTextField(20);
        jtNombres.setFont(consola);
        add(jtNombres, gbc);

        // Apellidos
        gbc.gridx = 0; gbc.gridy = 6;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx = 0;
        JLabel lblApellidos = new JLabel("Apellidos:");
        lblApellidos.setFont(consola);
        add(lblApellidos, gbc);

        gbc.gridx = 1; gbc.gridy = 6;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1;
        jtApellidos = new JTextField(20);
        jtApellidos.setFont(consola);
        add(jtApellidos, gbc);

        // Género
        gbc.gridx = 0; gbc.gridy = 7;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx = 0;
        JLabel lbGenero = new JLabel("Género:");
        lbGenero.setFont(consola);
        add(lbGenero, gbc);

        gbc.gridx = 1; gbc.gridy = 7;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx = 1;
        JPanel panelGenero = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
        cbGenero = new JComboBox<>(new String[]{"Femenino", "Masculino", "Prefiero no decir", "Otro"});
        cbGenero.insertItemAt("Seleccionar", 0);  
        cbGenero.setSelectedIndex(0); 
        cbGenero.setFont(consola);
        panelGenero.add(cbGenero);
        add(panelGenero, gbc);
        
        // Fecha de Nacimiento
        gbc.gridx = 0; gbc.gridy = 8;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx = 0;
        JLabel lblFechaNacimiento = new JLabel("Fecha de Nacimiento:");
        lblFechaNacimiento.setFont(consola);
        add(lblFechaNacimiento, gbc);

        gbc.gridx = 1; gbc.gridy = 8;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx = 1;

        JPanel panelFecha = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));

        // Día 
        cbDia = new JComboBox<>();
        cbDia.setFont(consola);
        cbDia.addItem("Día");
        for (int i = 1; i <= 31; i++) {
            cbDia.addItem(String.format("%02d", i));
        }

        // Mes 
        cbMes = new JComboBox<>();
        cbMes.setFont(consola);
        cbMes.addItem("Mes");
        String[] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", 
                        "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
        for (int i = 0; i < meses.length; i++) {
            cbMes.addItem(String.format("%02d - %s", i+1, meses[i]));
        }

        // Año 
        cbAnio = new JComboBox<>();
        cbAnio.setFont(consola);
        cbAnio.addItem("Año");
        int añoActual = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);
        for (int i = añoActual; i >= 1900; i--) {
            cbAnio.addItem(String.valueOf(i));
        }

        panelFecha.add(cbDia);
        panelFecha.add(cbMes);
        panelFecha.add(cbAnio);
        add(panelFecha, gbc);

        // Teléfono
        gbc.gridx = 0; gbc.gridy = 9;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx = 0;
        JLabel lblTelefono = new JLabel("Teléfono:");
        lblTelefono.setFont(consola);
        add(lblTelefono, gbc);

        gbc.gridx = 1; gbc.gridy = 9;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1;
        jtTelefono = new JTextField(15);
        jtTelefono.setFont(consola);
        add(jtTelefono, gbc);

        // Email
        gbc.gridx = 0; gbc.gridy = 10;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx = 0;
        JLabel lblEmail = new JLabel("E-mail:");
        lblEmail.setFont(consola);
        add(lblEmail, gbc);

        gbc.gridx = 1; gbc.gridy = 10;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1;
        jtEmail = new JTextField(20);
        jtEmail.setFont(consola);
        add(jtEmail, gbc);

        // Botones
        JPanel panelBotones = new JPanel();
        btRegistrar = new JButton("Registrar");
        btRegistrar.setFont(consola);
        btLimpiar = new JButton("Limpiar");
        btLimpiar.setFont(consola);
        btCancelar = new JButton("Cancelar");
        btCancelar.setFont(consola);
        panelBotones.add(btRegistrar);
        panelBotones.add(btLimpiar);
        panelBotones.add(btCancelar);

        gbc.gridx = 0; gbc.gridy = 11;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.NONE;
        add(panelBotones, gbc);

        // Listeners
        btRegistrar.addActionListener(this);
        btLimpiar.addActionListener(this);
        btCancelar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btRegistrar) {
            String contrasena = new String(jpContrasena.getPassword());
            String confirmarContrasena = new String(jpConfirmarContrasena.getPassword());
            
            if (jtCodigo.getText().isEmpty() || jtNombres.getText().isEmpty() || jtApellidos.getText().isEmpty() || 
                jtTelefono.getText().isEmpty() || jtEmail.getText().isEmpty() || 
                contrasena.isEmpty() || confirmarContrasena.isEmpty() || cbGenero.getSelectedIndex() == 0 || 
                cbDia.getSelectedIndex() == 0 || cbMes.getSelectedIndex() == 0 || cbAnio.getSelectedIndex() == 0 || 
                (!rbAdmin.isSelected() && !rbUsuario.isSelected())) { 
                JOptionPane.showMessageDialog(this, "Por favor, ingrese sus datos en todos los campos.", "Campos vacíos", JOptionPane.WARNING_MESSAGE);
            } else if (!contrasena.equals(confirmarContrasena)) {
                JOptionPane.showMessageDialog(this, "Las contraseñas son diferentes.", "Error contraseña", JOptionPane.ERROR_MESSAGE);
            } else if (!jtTelefono.getText().matches("\\d{10}")) {
                JOptionPane.showMessageDialog(this, "Número de teléfono inválido. Se necesitan 10 dígitos.", "Error de validación", JOptionPane.ERROR_MESSAGE);
            } else if (!jtEmail.getText().matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")) {
                JOptionPane.showMessageDialog(this, "Correo electrónico inválido.", "Error de validación", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Registro completo: " + jtNombres.getText() + " " + jtApellidos.getText(), "Registro completado", JOptionPane.INFORMATION_MESSAGE);
            }
        } else if (e.getSource() == btLimpiar) {
            jtCodigo.setText("");
            jtNombres.setText("");
            jtApellidos.setText("");
            jtTelefono.setText("");
            jtEmail.setText("");
            jpContrasena.setText("");
            jpConfirmarContrasena.setText("");
            cbGenero.setSelectedIndex(0);
            cbDia.setSelectedIndex(0);
            cbMes.setSelectedIndex(0);
            cbAnio.setSelectedIndex(0);
            grupoNivel.clearSelection();
        } else if (e.getSource() == btCancelar) {
            dispose();
        }
    }
}