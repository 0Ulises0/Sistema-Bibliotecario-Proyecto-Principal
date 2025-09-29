package objetos;

import java.time.LocalDate;

public class Usuario {
    private String id;
    private String nombre;
    private String apellido;
    private int edad;
    private char genero;
    private String telefono;
    private String email;
    private LocalDate fechaNacimiento; 

    public Usuario(String id, String nombre, String apellido, int edad, char genero, 
                String telefono, String email, LocalDate fechaNacimiento) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.genero = genero;
        this.telefono = telefono;
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;
    }


    public void setId(String id){ this.id = id; }
    public void setNombre(String nombre){ this.nombre = nombre; }
    public void setApellido(String apellido){ this.apellido = apellido; }
    public void setEdad(int edad){ this.edad = edad; }
    public void setGenero(char genero){ this.genero = genero; }
    public void setTelefono(String telefono){ this.telefono = telefono; }
    public void setEmail(String email){ this.email = email; }
    public void setFechaNacimiento(LocalDate fechaNacimiento){ this.fechaNacimiento = fechaNacimiento; }


    public String getId(){ return this.id; }
    public String getNombre(){ return this.nombre; }
    public String getApellido(){ return this.apellido; }
    public int getEdad(){ return this.edad; }
    public char getGenero(){ return this.genero; }
    public String getTelefono(){ return this.telefono; }
    public String getEmail(){ return this.email; }
    public LocalDate getFechaNacimiento(){ return this.fechaNacimiento; }

    @Override
    public String toString(){
        return id + ";" + nombre + ";" + apellido + ";" + edad + ";" + genero + ";" +
            telefono + ";" + email + ";" + fechaNacimiento;
    }
}