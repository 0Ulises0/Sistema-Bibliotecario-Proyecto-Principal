package LogicasPrestamo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import objetos.Prestamos;

public class PrestamosAccesoDatos {
    private final String RUTA_ARCHIVO = "src/datos/prestamos.txt";

    public List<Prestamos> leerPrestamosArchivo() throws IOException {
        List<Prestamos> listaPrestamos = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(RUTA_ARCHIVO))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(";");
                if (partes.length == 5) {
                    listaPrestamos.add(new Prestamos(partes[0], partes[1], partes[2], partes[3], partes[4]));
                }
            }
        }
        return listaPrestamos;
    }

    public void guardarPrestamosArchivo(List<Prestamos> prestamos) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(RUTA_ARCHIVO, false))) {
            for (Prestamos prestamo : prestamos) {
                bw.write(String.join(";", prestamo.toArray()));
                bw.newLine();
            }
        }
    }
}
