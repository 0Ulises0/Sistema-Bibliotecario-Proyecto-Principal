package LogicasLibro;

import java.util.ArrayList;
import java.util.List;

import objetos.Libro;
/*
 * Esta clase contiene todos los metodos con las funcionalidades que ofrece la pantalla PantallaRegistroLibro
 * (Registrar, Eliminar, Modificar y Buscar Libros)
 */
public class LibrosControlador {
    private final LibrosAccesoDatos libroAD;
    private List<Libro> listaLibros;

    public LibrosControlador(){
        this.libroAD = new LibrosAccesoDatos();
        this.listaLibros = this.libroAD.leerLibrosArchivo();
    }

    //Metodo auxiliar
    public String[][] cargarLibrosTabla(){
        String [][] informacionLibros = new String[listaLibros.size()][6];

        for(int i = 0 ; i < listaLibros.size() ; i ++){
            informacionLibros[i] = listaLibros.get(i).toArray();
        }
        return informacionLibros;
    }

    //Logica para registrar un libro
    public String registrarLibro (String titulo, String categoria, String autor, String edicion){
        //Verificar que se han llenado todos los datos
        if (titulo.isEmpty() || categoria.isEmpty() || autor.isEmpty() || edicion.isEmpty()){
            //Retornar mensaje de error
            return "E: Todos los campos son obligatorios";
        }

        //Comprobar si un libro existe
        boolean existe = false;
        for (Libro libroExistente : listaLibros) {
            if (libroExistente.getTitulo().equalsIgnoreCase(titulo) &&
                libroExistente.getAutor().equalsIgnoreCase(autor) &&
                libroExistente.getEdicion().equalsIgnoreCase(edicion)) {
                existe = true;
                break; // Si lo encontramos, no necesitamos seguir buscando
            }
        }
        //Retornar menasje de error de que el libro ya existe
        if (existe){
            return "E: Este libro ya existe";
        }


        //Generar el id del Libro
        int maxId = 0;
        for (Libro libro : listaLibros) {
            int idActual = Integer.parseInt(libro.getId());
            if (idActual > maxId) {
                maxId = idActual;
            }
        }
        String nuevoId = String.valueOf(maxId + 1);

        //Registrar el Libro
        String stock = "1";
        Libro nuevoLibro = new Libro(nuevoId, titulo, categoria, autor, edicion, stock);
        this.listaLibros.add(nuevoLibro);
        this.libroAD.guardarLibrosArchivo(this.listaLibros);

        return "Libro registrado correctamente";
    }

    //Logica para eliminar un libro por su ID
    public String eliminarLibro (String id){
        if (id.isEmpty()) {
            return "E: Se necesita un ID para eliminar.";
        }
        //Se busca el libro y se elimina
        Libro libroAEliminar = null;
        for (Libro libro : listaLibros) {
            if (libro.getId().equals(id)) {
                libroAEliminar = libro;
                break;
            }
        }
        
        if (libroAEliminar != null) {
            this.listaLibros.remove(libroAEliminar);
            this.libroAD.guardarLibrosArchivo(this.listaLibros);
            return "Libro eliminado correctamente.";
        } else {
            return "E: No se encontró un libro con ese ID.";
        }
    }

    //Logica para modificar un libro por su ID
    public String modificarLibro(String id, String nuevoTitulo, String nuevaCategoria, String nuevoAutor, String nuevaEdicion) {
        //Verificar que todos los campos estan llenos para su modificacion
        if (id.isEmpty() || nuevoTitulo.isEmpty() || nuevaCategoria.isEmpty() || nuevoAutor.isEmpty() || nuevaEdicion.isEmpty()) {
            return "E: Todos los campos son obligatorios para modificar.";
        }

        //Se busca el libro
        Libro libroAModificar = null;
        for (Libro libro : listaLibros) {
            if (libro.getId().equals(id)) {
                libroAModificar = libro;
                break;
            }
        }
        
        //Si el libro es encontrado, se modifica
        if (libroAModificar != null) {
            libroAModificar.setTitulo(nuevoTitulo);
            libroAModificar.setCategoria(nuevaCategoria);
            libroAModificar.setAutor(nuevoAutor);
            libroAModificar.setEdicion(nuevaEdicion);
            
            this.libroAD.guardarLibrosArchivo(this.listaLibros);
            return "Libro modificado correctamente.";
        } else {
            return "E: No se encontró un libro con ese ID.";
        }
    }

    //Logica para buscar un libro por su nombre o por su autor
    public String[][] buscarLibros(String textoBusqueda) {
        //Si no se busca nada se regresa la informacion de la tabla original
        if (textoBusqueda == null || textoBusqueda.trim().isEmpty()) {
            return cargarLibrosTabla();
        }
        
        String textoMinusculas = textoBusqueda.toLowerCase();

        //Buscar un Libro por su Titulo o por su Autor
        List<Libro> resultados = new ArrayList<>();
        for (Libro libro : listaLibros) {
            if (libro.getTitulo().toLowerCase().contains(textoMinusculas) ||
                libro.getAutor().toLowerCase().contains(textoMinusculas)) {
                resultados.add(libro);
            }
        }
        
        // Convertir lista de resultados a un String[][]
        String[][] datos = new String[resultados.size()][6];
        for (int i = 0; i < resultados.size(); i++) {
            datos[i] = resultados.get(i).toArray();
        }
        return datos;
    }
}
