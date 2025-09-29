package pantallas;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import componentes.JTextEntero;
import objetos.Libro;
import objetos.Prestamos;

public class PantallaPrestamoDevolucionLibros extends JFrame implements ActionListener {
    //Creando las partes de la interfaz
    //prestamos
    private JTextEntero idTxtLibroP, idTxtUsuarioP;
    private JLabel tituloP;
    private JButton registrarP;

    //devoluciones
    private JTextEntero idTxtPrestamo, idTxtLibroD, idTxtUsuarioD;
    private JLabel tituloD, lblIDPrestamo, lblidLibro, lblidUsuario;
    private JButton devolverP;

    private JLabel idLibro, idUsuario;

    //Tabla
    private JLabel buscarUsuario, buscarLibro;
    private JTextEntero txtUsuarioB, txtLibroB;
    private JButton limpiarBuscar, buscarLibroB, buscarUsuarioB;
    private JTable tablaPrestamos;
    private JScrollPane scrollPrestamos;

    private JLabel titulo;

    //contenedores
    private JPanel contenedorOpcionesEste, contenedorOpcionesOeste, contenedorOpcionesCentro, contenedorOpcionesNorte;

    Font fuente = new Font("Arial", Font.PLAIN, 12);
    
    
    //Creando la Pantalla para el Préstamo y Devolución de Libros
    public PantallaPrestamoDevolucionLibros(String titulo){
        setTitle(titulo);
        setSize(1024,768);
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
        componentesPrestamos();
        add(contenedorOpcionesOeste, BorderLayout.WEST);
    }
    private void contenedorCentro(){
        contenedorOpcionesCentro = new JPanel();
        contenedorOpcionesCentro.setLayout(new GridBagLayout());
        //Se agregan los componentes para el metodo de eliminar y modificar en el contenedor
        componentesDevoluciones();
        add(contenedorOpcionesCentro, BorderLayout.CENTER);
    }
    private void contenedorNorte(){
        contenedorOpcionesNorte = new JPanel();
        contenedorOpcionesNorte.setLayout(new GridBagLayout());
        //Se agregan el titulo en el contenedor
        componentesContenedorNorte();
        add(contenedorOpcionesNorte, BorderLayout.NORTH);
    }

    private void componentesPrestamos()
    {
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.insets = new Insets(10,10,10,10);

        tituloP = new JLabel("Préstamos");
        gbc.gridx = 0;
        gbc.gridy = 0;
        contenedorOpcionesOeste.add(tituloP, gbc);

        idLibro = new JLabel("ID Libro:");
        idTxtLibroP = new JTextEntero(10);
        gbc.gridx = 0;
        gbc.gridy = 1;
        contenedorOpcionesOeste.add(idLibro, gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        contenedorOpcionesOeste.add(idTxtLibroP, gbc);
        
        idUsuario = new JLabel("ID Usuario:");
        idTxtUsuarioP = new JTextEntero(10);
        gbc.gridx = 0;
        gbc.gridy = 2;
        contenedorOpcionesOeste.add(idUsuario, gbc);
        gbc.gridx = 1;
        gbc.gridy = 2;
        contenedorOpcionesOeste.add(idTxtUsuarioP, gbc);

        registrarP = new JButton("REGISTRAR");
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        contenedorOpcionesOeste.add(registrarP,gbc);
        registrarP.addActionListener(this);
    }

    private void componentesDevoluciones()
    {
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.insets = new Insets(10,10,10,10);

        tituloD = new JLabel("Devoluciones");
        gbc.gridx = 0;
        gbc.gridy = 0;
        contenedorOpcionesCentro.add(tituloD, gbc);

        lblIDPrestamo = new JLabel("ID Prestamo:");
        idTxtPrestamo = new JTextEntero(10);
        gbc.gridx = 0;
        gbc.gridy = 1;
        contenedorOpcionesCentro.add(lblIDPrestamo, gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        contenedorOpcionesCentro.add(idTxtPrestamo, gbc);

        lblidLibro = new JLabel("ID Libro:");
        idTxtLibroD = new JTextEntero(10);
        gbc.gridx = 0;
        gbc.gridy = 2;
        contenedorOpcionesCentro.add(lblidLibro, gbc);
        gbc.gridx = 1;
        gbc.gridy = 2;
        contenedorOpcionesCentro.add(idTxtLibroD, gbc);

        lblidUsuario= new JLabel("ID Usuario:");
        idTxtUsuarioD = new JTextEntero(10);
        gbc.gridx = 0;
        gbc.gridy = 3;
        contenedorOpcionesCentro.add(lblidUsuario, gbc);
        gbc.gridx = 1;
        gbc.gridy = 3;
        contenedorOpcionesCentro.add(idTxtUsuarioD, gbc);

        devolverP = new JButton("ACEPTAR");
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        contenedorOpcionesCentro.add(devolverP, gbc);
        devolverP.addActionListener(this);
    }

    private void componentesTabla()
    {
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.insets = new Insets(10,10,10,10);  
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        buscarUsuario = new JLabel("ID Usuario:");
        contenedorOpcionesEste.add(buscarUsuario, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        txtUsuarioB = new JTextEntero(10);
        contenedorOpcionesEste.add(txtUsuarioB, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        buscarLibro = new JLabel("ID Libro:");
        contenedorOpcionesEste.add(buscarLibro, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        txtLibroB = new JTextEntero(10);
        contenedorOpcionesEste.add(txtLibroB, gbc);

        gbc.gridx = 3;
        gbc.gridy = 1;
        limpiarBuscar = new JButton("LIMPIAR");
        limpiarBuscar.addActionListener(this);
        contenedorOpcionesEste.add(limpiarBuscar, gbc);

        gbc.gridx = 2;
        gbc.gridy = 0;
        buscarUsuarioB = new JButton("BUSCAR");
        buscarUsuarioB.addActionListener(this);
        contenedorOpcionesEste.add(buscarUsuarioB, gbc);
        
        gbc.gridx = 2;
        gbc.gridy = 1;
        buscarLibroB = new JButton("BUSCAR");
        buscarLibroB.addActionListener(this);
        contenedorOpcionesEste.add(buscarLibroB, gbc);

        gbc.gridwidth = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 2;

        String[] columnas = {"ID Préstamo", "ID Usuario", "ID Libro", "Fecha", "Estado"};

        tablaPrestamos = new JTable(cargarTabla(),columnas);
        scrollPrestamos = new JScrollPane(tablaPrestamos);

        contenedorOpcionesEste.add(scrollPrestamos, gbc);
    }

    private void componentesContenedorNorte(){
    titulo = new JLabel("Registro de Prestamos y Devoluciones");
    titulo.setFont(new Font("Arial", Font.PLAIN, 36));
    contenedorOpcionesNorte.add(titulo); 
    }

    //Metodo para leer los libros del archivo libros.txt
    public List<Libro> leerLibrosArchivo(){
        List<Libro> listaLibros = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader("src/datos/libros.txt"))){
            String linea;
            while((linea = br.readLine()) != null){
                String[] partes = linea.split(";");
                if(partes.length == 6){
                    listaLibros.add(new Libro(partes[0],partes[1],partes[2],partes[3],partes[4],partes[5]));
                }
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        return listaLibros;
    }

    public List<Prestamos> leerPrestamosArchivo(){
        List<Prestamos> listaPrestamos = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader("src/datos/prestamos.txt"))){
            String linea;
            while((linea = br.readLine()) != null){
                String[] partes = linea.split(";");
                if(partes.length == 5){
                    listaPrestamos.add(new Prestamos(partes[0],partes[1],partes[2],partes[3],partes[4]));
                }
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        return listaPrestamos;
    }

    //Metodo para guardar un prestamo
    public void guardarPrestamoEnArchivo(Prestamos prestamo) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("src/datos/prestamos.txt", true))) {
            bw.write(String.join(";", prestamo.toArray()));
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Metodo para actualizar la tabla de prestamos
    public void actualizarTablaDesdeArchivo() {
        String[] columnas = {"ID Préstamo", "ID Usuario", "ID Libro", "Fecha", "Estado"};
        tablaPrestamos.setModel(new DefaultTableModel(cargarTabla(), columnas));
    }

    public String[][] cargarTabla()
    {
        List<Prestamos> prestamo = leerPrestamosArchivo();

        String [][] informacion = new String[prestamo.size()][4];

        for(int i = 0 ; i < prestamo.size() ; i ++){
            informacion[i] = prestamo.get(i).toArray();
        }
        return informacion;
    }

    //Devolver prestamo por ID de prestamo
    public void devolverPrestamo(String idP, String idU, String idL, String estado) {
        File archivo = new File("src/datos/prestamos.txt");
        List<String> lineas = new ArrayList<>();
        boolean encontrado = false;

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(";");
                
                if (partes.length == 5 && partes[0].equals(idP)) {
                    if (partes[4].equals("Prestado")) {
                        linea = idP + ";" + idU + ";" + idL + ";" + partes[3] + ";" + estado;
                        encontrado = true;
                    } else {
                        JOptionPane.showMessageDialog(this,"Datos incorrectos o \neste préstamo ya fue devuelto");
                    }
                }
                lineas.add(linea);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo, false))) {
            for (String l : lineas) {
                bw.write(l);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void buscarLibroPorIdLibroPrestamoEnTabla(String idLibro) {
        List<Prestamos> prestamos = leerPrestamosArchivo();
        String[] columnas = {"ID Préstamo", "ID Usuario", "ID Libro", "Fecha", "Estado"};
        List<Prestamos> resultado = new ArrayList<>();

        for (Prestamos prestamo : prestamos) {
            if (prestamo.getIdL().toLowerCase().contains(idLibro)) {
                resultado.add(prestamo);
            }
        }
        // Convertir a array para tabla
        String[][] datos; 
        if (!resultado.isEmpty()) {
            datos = new String[resultado.size()][5];
            for (int i = 0; i < resultado.size(); i++) {
                datos[i] = resultado.get(i).toArray();
            }
        } else {
            datos = new String[0][5];  // Sin resultados
        }

        // Actualizar modelo de la tabla
        DefaultTableModel modelo = new DefaultTableModel(datos, columnas);
        tablaPrestamos.setModel(modelo);
    }
    public void buscarLibroPorIdUsuarioPrestamoEnTabla(String idUsuario) {
        List<Prestamos> prestamos = leerPrestamosArchivo();
        String[] columnas = {"ID Préstamo", "ID Usuario", "ID Libro", "Fecha", "Estado"};
        List<Prestamos> resultado = new ArrayList<>();

        for (Prestamos prestamo : prestamos) {
            if (prestamo.getIdU().toLowerCase().contains(idUsuario)) {
                resultado.add(prestamo);
            }
        }
        // Convertir a array para tabla
        String[][] datos; 
        if (!resultado.isEmpty()) {
            datos = new String[resultado.size()][5];
            for (int i = 0; i < resultado.size(); i++) {
                datos[i] = resultado.get(i).toArray();
            }
        } else {
            datos = new String[0][5];  // Sin resultados
        }

        // Actualizar modelo de la tabla
        DefaultTableModel modelo = new DefaultTableModel(datos, columnas);
        tablaPrestamos.setModel(modelo);
    }

    public String obtenerFecha()
    {
        LocalDate fecha = LocalDate.now();

        return fecha.toString();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == registrarP){
            List<Prestamos> prestamosExistentes = leerPrestamosArchivo();

            String id = String.valueOf(prestamosExistentes.size() + 1);
            String idLibro = idTxtLibroP.getText();
            String idUsuario = idTxtUsuarioP.getText();
            String fechaPrestamo = obtenerFecha();
            String estado = "Prestado";

            Prestamos prestamo = new Prestamos(id, idUsuario, idLibro, fechaPrestamo, estado);

            if(prestamo.getIdL().equals("") && prestamo.getIdU().equals("")){
                JOptionPane.showMessageDialog(this,"Sin datos que guardar");
                return;
            }
            else if(!(prestamo.getIdL().isEmpty() || prestamo.getIdU().isEmpty())){
                guardarPrestamoEnArchivo(prestamo);
                JOptionPane.showMessageDialog(this,"Proceso exitoso!");
                actualizarTablaDesdeArchivo();
            }
            else{
                JOptionPane.showMessageDialog(this,"Faltan datos por ingresar!");
                return;
            }

            
        }

        //Limpiando los campos de busqueda
        if(e.getSource() == limpiarBuscar){
            txtLibroB.setText("");
            txtUsuarioB.setText("");
        }

        if(e.getSource() == devolverP){

            String idP = idTxtPrestamo.getText();
            String idL = idTxtLibroD.getText();
            String idU = idTxtUsuarioD.getText();
            String estado = "Devuelto";

            if(idP.isEmpty() && idL.isEmpty() && idU.isEmpty()){
                JOptionPane.showMessageDialog(this,"Ingresa datos");
                return;
            }
            else if(idP.isEmpty() || idL.isEmpty() || idU.isEmpty()){
                JOptionPane.showMessageDialog(this,"Datos faltantes!");
                return;
            }
            devolverPrestamo(idP, idU, idL, estado);
            actualizarTablaDesdeArchivo();
        }
        if(e.getSource() == buscarLibroB){
            buscarLibroPorIdLibroPrestamoEnTabla(txtLibroB.getText());
        }
        if(e.getSource() == buscarUsuarioB){
            buscarLibroPorIdUsuarioPrestamoEnTabla(txtUsuarioB.getText());
        }
    }
}
