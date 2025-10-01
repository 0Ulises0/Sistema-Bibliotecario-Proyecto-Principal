package LogicasLibro;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import objetos.Libro;

public class LibrosAccesoDatos {

    private final String RUTA_ARCHIVO = "src/datos/libros.txt";

    public List<Libro> leerLibrosArchivo(){
        List<Libro> listaLibros = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(RUTA_ARCHIVO))){
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

    public void guardarTodos(List<Libro> libros) {
        // Usar 'false' en FileWriter para sobrescribir el archivo por completo
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(RUTA_ARCHIVO, false))) {
            for (Libro libro : libros) {
                bw.write(String.join(";", libro.toArray()));
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
