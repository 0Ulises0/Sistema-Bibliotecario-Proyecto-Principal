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
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import componentes.JTextEntero;
import objetos.Libro;

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
    
    public PantallaRegistroLibros(String titulo){
        setTitle(titulo);
        setSize(1366,768);
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

        String[] columnas = {"ID", "Nombre", "Categoria", "Autor", "Edicion", "Stock"};

        tablaLibros = new JTable(cargarTabla(),columnas);
        scrollLibros = new JScrollPane(tablaLibros);

        contenedorOpcionesEste.add(scrollLibros, gbc);
    }
    private void componentesContenedorNorte(){
        titulo = new JLabel("Registro de Libros");
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
    //Metodo para retornar array con los libros
    public String[][] cargarTabla(){
        List<Libro> libros =  leerLibrosArchivo();
        String [][] informacion = new String[libros.size()][6];

        for(int i = 0 ; i < libros.size() ; i ++){
            informacion[i] = libros.get(i).toArray();
        }
        return informacion;
    }
    //Metodo para guardar un libro
    public void guardarLibroEnArchivo(Libro libro) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("src/datos/libros.txt", true))) {
            bw.write(String.join(";", libro.toArray()));
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
}
    //Metodo para actualizar la tabla de libros
    public void actualizarTablaDesdeArchivo() {
        String[] columnas = {"ID", "Nombre", "Categoria", "Autor", "Edicion", "Stock"};
        tablaLibros.setModel(new DefaultTableModel(cargarTabla(), columnas));
    }
    //Metodo para eliminar por ID de libro
    public void eliminarLibroPorID(String idAEliminar) {
        List<Libro> libros = leerLibrosArchivo();
        List<Libro> librosActualizados = new ArrayList<>();

        for (Libro libro : libros) {
            if (!libro.getId().equals(idAEliminar)) {
                librosActualizados.add(libro);
            }
        }
        // Sobrescribir el archivo con los libros restantes
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("src/datos/libros.txt", false))) {
            for (Libro libro : librosActualizados) {
                bw.write(String.join(";", libro.toArray()));
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //Modificar libro por ID de libro
    public void modificarLibro(String id, String nombre, String categoria, String autor, String edicion) {
        File archivo = new File("src/datos/libros.txt");
        List<String> lineas = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(";");
                if (partes.length == 6 && partes[0].equals(id)) {
                    // Reemplazar la línea con los nuevos datos
                    linea = id + ";" + nombre + ";" + categoria + ";" + autor + ";" + edicion + ";" + String.valueOf((int)((Math.random()*9)+1));
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
    //Metodo para buscar a personas y actualizar la tabla
    public void buscarLibroPorNombreEnTabla(String nombreBuscado) {
        List<Libro> libros = leerLibrosArchivo();
        String[] columnas = {"ID", "Nombre", "Categoria", "Autor", "Edicion", "Stock"};

        // Filtrar libros cuyo nombre contiene el texto buscado (ignorar mayúsculas/minúsculas)
        List<Libro> resultado = new ArrayList<>();
        String nombreLower = nombreBuscado.toLowerCase();

        for (Libro libro : libros) {
            if (libro.getTitulo().toLowerCase().contains(nombreLower)) {
                resultado.add(libro);
            }
        }

        // Convertir a array para tabla
        String[][] datos;
        if (!resultado.isEmpty()) {
            datos = new String[resultado.size()][6];
            for (int i = 0; i < resultado.size(); i++) {
                datos[i] = resultado.get(i).toArray();
            }
        } else {
            datos = new String[0][6];  // Sin resultados
        }

        // Actualizar modelo de la tabla
        DefaultTableModel modelo = new DefaultTableModel(datos, columnas);
        tablaLibros.setModel(modelo);
    }
    //Metodo para ver si un libro existe
    public boolean libroEncontrado(Libro libro){
        List<Libro> libros = leerLibrosArchivo();
        for (Libro libroExistente : libros) {
            if (libroExistente.getTitulo().equals(libro.getTitulo()) 
                && libroExistente.getCategoria().equals(libro.getCategoria()) 
                && libroExistente.getAutor().equals(libro.getAutor()) 
                && libroExistente.getEdicion().equals(libro.getEdicion())) {
                return true;
            }
        }
        return false;
    }
    //Metodo para ver si un ID ya se encuentra registrado
    public boolean libroEncontradoID(String id){
        List<Libro> libros = leerLibrosArchivo();
        for (Libro libroExistente : libros) {
            if (libroExistente.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        //Logica para registrar
        if(e.getSource() == registrar){
            List<Libro> librosExistentes = leerLibrosArchivo();

            String id = String.valueOf(librosExistentes.size()+1);
            String titulo = nombreTxt.getText();
            String categoria = categoriaTxt.getText();
            String autor = autorTxt.getText();
            String edicion = edicionTxt.getText();
            String stock = String.valueOf((int)((Math.random()*9)+1));

            //Creando el libro
            Libro libro = new Libro(id, titulo, categoria, autor, edicion, stock);

            //Verificar si los campos estan vacios
            if (libro.getTitulo().equals("") 
                && libro.getCategoria().equals("") 
                && libro.getAutor().equals("") 
                && libro.getEdicion().equals("")) {
                JOptionPane.showMessageDialog(this,"Sin datos que guardar");
                return;
            }
            //Comprobar si ya existe
            if(libroEncontrado(libro)){
                JOptionPane.showMessageDialog(this,"Este libro ya esta registrado");
                return;
            }
            //Guardando libro
            //Comprobar que tenga todos los datos
            if(!(libro.getTitulo().isEmpty() 
            || libro.getCategoria().isEmpty() 
            || libro.getAutor().isEmpty() 
            || libro.getEdicion().isEmpty())){
                guardarLibroEnArchivo(libro);
            }
            else{
                JOptionPane.showMessageDialog(this,"Datos faltantes!");
                return;
            }
            JOptionPane.showMessageDialog(this,"Se ha registrado correctamente!");
            actualizarTablaDesdeArchivo();
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

            if(respuesta == JOptionPane.NO_OPTION){
                return;
            }
            if(respuesta == JOptionPane.YES_OPTION){
                if(!libroEncontradoID(idTxtBM.getText())){
                    JOptionPane.showMessageDialog(this,"Este id no esta registrado!");
                    return;
                }
                eliminarLibroPorID(idTxtBM.getText());
                JOptionPane.showMessageDialog(this,"Se ha eliminado correctamente!");
                actualizarTablaDesdeArchivo();
            }
        }
        
        //Logica para modificar
        if(e.getSource() == modificar){
            int respuesta = JOptionPane.showConfirmDialog(this, "Estas seguro de modificar?", "MODIFICAR", JOptionPane.YES_NO_OPTION);

            if(respuesta == JOptionPane.NO_OPTION){
                return;
            }
            if(respuesta == JOptionPane.YES_OPTION){
                if(!libroEncontradoID(idTxtBM.getText())){
                    JOptionPane.showMessageDialog(this,"Este id no esta registrado!");
                    return;
                }
                else if((nombreTxtBM.getText().isEmpty() 
                || categoriaTxtBM.getText().isEmpty() 
                || autorTxtBM.getText().isEmpty() 
                || edicionTxtBM.getText().isEmpty())){
                    JOptionPane.showMessageDialog(this,"Datos faltantes para su modificacion!");
                    return;
                }
                
                modificarLibro(idTxtBM.getText(), nombreTxtBM.getText(), categoriaTxtBM.getText(), autorTxtBM.getText(), edicionTxtBM.getText());
                JOptionPane.showMessageDialog(this,"Se ha modificado correctamente!");
                actualizarTablaDesdeArchivo();
            }
        }
        
        //Llamando al metodo buscar
        if(e.getSource() == buscarTablaB){
            buscarLibroPorNombreEnTabla(buscarTxt.getText());
        }
        
        //Limpiando el campo de texto buscar
        if(e.getSource() == limpiarBuscarTabla){
            buscarTxt.setText("");
        }
    }
}
