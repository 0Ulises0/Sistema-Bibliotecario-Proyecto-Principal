package pantallas;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import LogicasLibro.LibrosControlador;
import componentes.JTextEntero;

//Creando la Pantalla de Registro de Libros
public class PantallaRegistroLibros extends JFrame implements ActionListener{

    private JButton registrar, limpiar, limpiarBuscarTabla, buscarTablaB;
    private JLabel nombreLibro, categoriaLibro, autorLibro, edicionLibro,buscarTabla;
    private JTextField nombreTxt, categoriaTxt, autorTxt, buscarTxt;

    private JLabel idLibroBM, nombreLibroBM, categoriaLibroBM, autorLibroBM, edicionLibroBM;
    private JTextField nombreTxtBM, categoriaTxtBM, autorTxtBM;

    private JTextEntero edicionTxtBM, edicionTxt, idTxtBM;

    private JButton eliminar, modificar;

    private JLabel tituloAlta, tituloBajaModificar;

    private JTable tablaLibros;
    private JScrollPane scrollLibros;

    private JLabel titulo;

    private JPanel contenedorOpcionesEste, contenedorOpcionesOeste, contenedorOpcionesCentro, contenedorOpcionesNorte;

    private final LibrosControlador controlador;

    private final String[] columnas = {"ID", "Nombre", "Categoria", "Autor", "Edicion", "Stock"};

    private static final int ANCHO_VENTANA = 1366;
    private static final int ALTO_VENTANA = 768;
    
    public PantallaRegistroLibros(String titulo){

        this.controlador = new LibrosControlador();

        setTitle(titulo);
        setSize(ANCHO_VENTANA, ALTO_VENTANA);
        setLocationRelativeTo(null);

        contenedorNorte();
        contenedorEste();
        contenedorOeste();
        contenedorCentro();
    }



    //Creando los contenedores (BorderLayout)
    private void contenedorEste(){
        contenedorOpcionesEste = new JPanel();
        contenedorOpcionesEste.setLayout(new GridBagLayout());
        //Se agregan los componentes del metodo tabla en el contenedor
        componentesTabla();
        add(contenedorOpcionesEste, BorderLayout.EAST);
    }
    private void contenedorOeste(){
        contenedorOpcionesOeste = new JPanel();
        contenedorOpcionesOeste.setLayout(new GridBagLayout());
        //Se agregan los componentes para el metodo de registrar en el contenedor
        componentesAlta();
        add(contenedorOpcionesOeste, BorderLayout.WEST);
    }
    private void contenedorCentro(){
        contenedorOpcionesCentro = new JPanel();
        contenedorOpcionesCentro.setLayout(new GridBagLayout());
        //Se agregan los componentes para el metodo de eliminar y modificar en el contenedor
        componentesBajaModificar();
        add(contenedorOpcionesCentro, BorderLayout.CENTER);
    }
    private void contenedorNorte(){
        contenedorOpcionesNorte = new JPanel();
        contenedorOpcionesNorte.setLayout(new GridBagLayout());
        //Se agregan el titulo en el contenedor
        componentesContenedorNorte();
        add(contenedorOpcionesNorte, BorderLayout.NORTH);
    }
    
    //Componentes de los contenedores (GridBagLayout)
    private void componentesAlta(){

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10,10,10,10);

        tituloAlta = new JLabel("REGISTRAR LIBRO");
        tituloAlta.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridx = 0;
        gbc.gridy = 0;
        contenedorOpcionesOeste.add(tituloAlta, gbc);

        nombreLibro = new JLabel("Nombre:");
        nombreTxt = new JTextField(20);
        gbc.gridx = 0;
        gbc.gridy = 1;
        contenedorOpcionesOeste.add(nombreLibro,gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        contenedorOpcionesOeste.add(nombreTxt,gbc);

        categoriaLibro = new JLabel("Categoria:");
        categoriaTxt = new JTextField(20);
        gbc.gridx = 0;
        gbc.gridy = 2;
        contenedorOpcionesOeste.add(categoriaLibro,gbc);
        gbc.gridx = 1;
        gbc.gridy = 2;
        contenedorOpcionesOeste.add(categoriaTxt,gbc);

        autorLibro = new JLabel("Autor:");
        autorTxt = new JTextField(20);
        gbc.gridx = 0;
        gbc.gridy = 3;
        contenedorOpcionesOeste.add(autorLibro,gbc);
        gbc.gridx = 1;
        gbc.gridy = 3;
        contenedorOpcionesOeste.add(autorTxt,gbc);

        edicionLibro = new JLabel("Edicion:");
        edicionTxt = new JTextEntero(20);
        gbc.gridx = 0;
        gbc.gridy = 4;
        contenedorOpcionesOeste.add(edicionLibro,gbc);
        gbc.gridx = 1;
        gbc.gridy = 4;
        contenedorOpcionesOeste.add(edicionTxt,gbc);

        registrar = new JButton("REGISTRAR");
        limpiar = new JButton("LIMPIAR");
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        contenedorOpcionesOeste.add(registrar,gbc);
        gbc.gridx = 0;
        gbc.gridy = 6;
        contenedorOpcionesOeste.add(limpiar,gbc);
        registrar.addActionListener(this);
        limpiar.addActionListener(this);
    }
    private void componentesBajaModificar(){
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.insets = new Insets(10,10,10,10);

        tituloBajaModificar = new JLabel("BAJA Y MODIFICAR");
        tituloBajaModificar.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridx = 0;
        gbc.gridy = 0;
        contenedorOpcionesCentro.add(tituloBajaModificar, gbc);

        idLibroBM = new JLabel("ID:");
        idTxtBM = new JTextEntero(20);
        gbc.gridx = 0;
        gbc.gridy = 1;
        contenedorOpcionesCentro.add(idLibroBM, gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        contenedorOpcionesCentro.add(idTxtBM, gbc);

        nombreLibroBM = new JLabel("Nombre:");
        nombreTxtBM = new JTextField(20);
        gbc.gridx = 0;
        gbc.gridy = 2;
        contenedorOpcionesCentro.add(nombreLibroBM,gbc);
        gbc.gridx = 1;
        gbc.gridy = 2;
        contenedorOpcionesCentro.add(nombreTxtBM,gbc);

        categoriaLibroBM = new JLabel("Categoria:");
        categoriaTxtBM = new JTextField(20);
        gbc.gridx = 0;
        gbc.gridy = 3;
        contenedorOpcionesCentro.add(categoriaLibroBM,gbc);
        gbc.gridx = 1;
        gbc.gridy = 3;
        contenedorOpcionesCentro.add(categoriaTxtBM,gbc);

        autorLibroBM = new JLabel("Autor:");
        autorTxtBM = new JTextField(20);
        gbc.gridx = 0;
        gbc.gridy = 4;
        contenedorOpcionesCentro.add(autorLibroBM,gbc);
        gbc.gridx = 1;
        gbc.gridy = 4;
        contenedorOpcionesCentro.add(autorTxtBM,gbc);

        edicionLibroBM = new JLabel("Edicion:");
        edicionTxtBM = new JTextEntero(20);
        gbc.gridx = 0;
        gbc.gridy = 5;
        contenedorOpcionesCentro.add(edicionLibroBM,gbc);
        gbc.gridx = 1;
        gbc.gridy = 5;
        contenedorOpcionesCentro.add(edicionTxtBM,gbc);

        eliminar = new JButton("ELIMINAR");
        modificar = new JButton("MODIFICAR");
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        contenedorOpcionesCentro.add(eliminar,gbc);
        gbc.gridx = 0;
        gbc.gridy = 7;
        contenedorOpcionesCentro.add(modificar,gbc);
        eliminar.addActionListener(this);
        modificar.addActionListener(this);
    }
    private void componentesTabla(){

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.insets = new Insets(10,10,10,10);

        gbc.gridx = 0;
        gbc.gridy = 0;
        buscarTabla = new JLabel("Buscar:");
        contenedorOpcionesEste.add(buscarTabla, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        buscarTxt =new JTextField(15);
        contenedorOpcionesEste.add(buscarTxt, gbc);

        gbc.gridx = 2;
        gbc.gridy = 0;
        limpiarBuscarTabla = new JButton("LIMPIAR");
        limpiarBuscarTabla.addActionListener(this);
        contenedorOpcionesEste.add(limpiarBuscarTabla, gbc);

        gbc.gridx = 3;
        gbc.gridy = 0;
        buscarTablaB = new JButton("BUSCAR");
        buscarTablaB.addActionListener(this);
        contenedorOpcionesEste.add(buscarTablaB, gbc);

        gbc.gridwidth = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 1;

        tablaLibros = new JTable(controlador.cargarLibrosTabla(),columnas);
        scrollLibros = new JScrollPane(tablaLibros);

        contenedorOpcionesEste.add(scrollLibros, gbc);
    }
    private void componentesContenedorNorte(){
        titulo = new JLabel("Registro de Libros");
        titulo.setFont(new Font("Arial", Font.PLAIN, 36));
        contenedorOpcionesNorte.add(titulo);
    }
    

    public void actualizarTabla(String [][] informacion) {
        tablaLibros.setModel(new DefaultTableModel(informacion, columnas));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Logica para registrar
        if(e.getSource() == registrar){
            String mensaje = controlador.registrarLibro(nombreTxt.getText(),categoriaTxt.getText(),autorTxt.getText(),edicionTxt.getText());
            JOptionPane.showMessageDialog(this, mensaje);

            actualizarTabla(controlador.cargarLibrosTabla());
        }
        
        //Limpiando los campos de texto de registrar
        if(e.getSource() == limpiar){
            nombreTxt.setText("");
            categoriaTxt.setText("");
            autorTxt.setText("");
            edicionTxt.setText("");
        }
        
        //Logica para eliminar
        if(e.getSource() == eliminar){
            int respuesta = JOptionPane.showConfirmDialog(this, "Estas seguro de eliminar?", "ELIMINAR", JOptionPane.YES_NO_OPTION);

            if (respuesta == JOptionPane.YES_OPTION){
                String mensaje = controlador.eliminarLibro(idTxtBM.getText());
                JOptionPane.showMessageDialog(this, mensaje);
                actualizarTabla(controlador.cargarLibrosTabla());
            }
            else if (respuesta == JOptionPane.NO_OPTION){
                JOptionPane.showMessageDialog(this, "Operacion cancelada");
            }
        }
        
        //Logica para modificar
        if(e.getSource() == modificar){
            int respuesta = JOptionPane.showConfirmDialog(this, "Estas seguro de modificar?", "MODIFICAR", JOptionPane.YES_NO_OPTION);

            if (respuesta == JOptionPane.YES_OPTION){
                String mensaje = controlador.modificarLibro(idTxtBM.getText(),nombreTxtBM.getText(),categoriaTxtBM.getText(),autorTxtBM.getText(),edicionTxtBM.getText());
                JOptionPane.showMessageDialog(this, mensaje);
                actualizarTabla(controlador.cargarLibrosTabla());
            }
            else if (respuesta == JOptionPane.NO_OPTION){
                JOptionPane.showMessageDialog(this, "Operacion cancelada");
            }
        }
        
        //Llamando al metodo buscar
        if(e.getSource() == buscarTablaB){
            actualizarTabla(controlador.buscarLibros(buscarTxt.getText()));
        }
        
        //Limpiando el campo de texto buscar
        if(e.getSource() == limpiarBuscarTabla){
            buscarTxt.setText("");
        }
    }
}
