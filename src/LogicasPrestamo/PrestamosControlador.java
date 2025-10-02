package LogicasPrestamo;

import LogicasLibro.LibrosAccesoDatos;
import LogicasPrestamo.PrestamosAccesoDatos;
import datos.UsuarioDAO;
import objetos.Libro;
import objetos.Prestamos;
import objetos.Usuario;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PrestamosControlador {

    private final PrestamosAccesoDatos prestamoAD;
    private final LibrosAccesoDatos libroAD;
    private final UsuarioDAO usuarioDAO;

    private List<Prestamos> listaPrestamos;
    private List<Libro> listaLibros;
    private List<Usuario> listaUsuarios;

    public PrestamosControlador() {
        this.prestamoAD = new PrestamosAccesoDatos();
        this.libroAD = new LibrosAccesoDatos();
        this.usuarioDAO = new UsuarioDAO();

        try {
            this.listaPrestamos = prestamoAD.leerPrestamosArchivo();
            this.listaLibros = libroAD.leerLibrosArchivo();
            this.listaUsuarios = usuarioDAO.leerTodos();
        } catch (IOException e) {
            // En una aplicación real, mostrarías un error fatal aquí.
            System.err.println("Error fatal al cargar los datos: " + e.getMessage());
            this.listaPrestamos = new ArrayList<>();
            this.listaLibros = new ArrayList<>();
            this.listaUsuarios = new ArrayList<>();
        }
    }

    public String[][] cargarPrestamosTabla() {
        String[][] datos = new String[listaPrestamos.size()][5];
        for (int i = 0; i < listaPrestamos.size(); i++) {
            datos[i] = listaPrestamos.get(i).toArray();
        }
        return datos;
    }

    public String registrarPrestamo(String idUsuarioStr, String idLibroStr) {
        // 1. Validaciones básicas
        if (idUsuarioStr.isEmpty() || idLibroStr.isEmpty()) {
            return "Error: Los IDs de usuario y libro son obligatorios.";
        }
        
        // 2. Validar existencia de Usuario
        Usuario usuario = null;
        for (Usuario u : listaUsuarios) {
            if (u.getId().equals(idUsuarioStr)) {
                usuario = u;
                break;
            }
        }
        if (usuario == null) {
            return "Error: El usuario con ID " + idUsuarioStr + " no existe.";
        }

        // 3. Validar existencia y stock de Libro
        Libro libro = null;
        for (Libro l : listaLibros) {
            if (l.getId().equals(idLibroStr)) {
                libro = l;
                break;
            }
        }
        if (libro == null) {
            return "Error: El libro con ID " + idLibroStr + " no existe.";
        }
        if (Integer.parseInt(libro.getStock()) <= 0) {
            return "Error: No hay stock disponible para el libro '" + libro.getTitulo() + "'.";
        }
        
        // 4. Lógica de negocio
        int maxId = 0;
        for (Prestamos p : listaPrestamos) {
            maxId = Math.max(maxId, Integer.parseInt(p.getId()));
        }
        String nuevoId = String.valueOf(maxId + 1);
        String fecha = LocalDate.now().toString();

        Prestamos nuevoPrestamo = new Prestamos(nuevoId, idUsuarioStr, idLibroStr, fecha, "Prestado");
        listaPrestamos.add(nuevoPrestamo);

        // Actualizar stock
        libro.setStock(String.valueOf(Integer.parseInt(libro.getStock()) - 1));

        // 5. Persistir cambios
        try {
            prestamoAD.guardarPrestamosArchivo(listaPrestamos);
            libroAD.guardarLibrosArchivo(listaLibros); // ¡Importante guardar los cambios en libros también!
        } catch (IOException e) {
            return "Error al guardar los datos: " + e.getMessage();
        }

        return "Préstamo registrado con éxito.";
    }

    public String devolverPrestamo(String idPrestamoStr) {
        if (idPrestamoStr.isEmpty()) {
            return "Error: El ID del préstamo es obligatorio.";
        }

        Prestamos prestamoADevolver = null;
        for (Prestamos p : listaPrestamos) {
            if (p.getId().equals(idPrestamoStr)) {
                prestamoADevolver = p;
                break;
            }
        }
        
        if (prestamoADevolver == null) {
            return "Error: No se encontró un préstamo con el ID " + idPrestamoStr + ".";
        }
        if (prestamoADevolver.getEstado().equals("Devuelto")) {
            return "Aviso: Este préstamo ya ha sido devuelto anteriormente.";
        }

        prestamoADevolver.setEstado("Devuelto");
        
        // Actualizar stock del libro correspondiente
        Libro libroDevuelto = null;
        for (Libro l : listaLibros) {
            if (l.getId().equals(prestamoADevolver.getIdL())) {
                libroDevuelto = l;
                break;
            }
        }
        if (libroDevuelto != null) {
            libroDevuelto.setStock(String.valueOf(Integer.parseInt(libroDevuelto.getStock()) + 1));
        }

        try {
            prestamoAD.guardarPrestamosArchivo(listaPrestamos);
            libroAD.guardarLibrosArchivo(listaLibros);
        } catch (IOException e) {
            return "Error al guardar los datos: " + e.getMessage();
        }

        return "Libro devuelto con éxito.";
    }
}
