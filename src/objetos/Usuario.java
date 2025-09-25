package objetos;

public class Usuario {
    private int id;
    private String nombre;
    private String apellido;
    private int edad;
    private char genero;
    private int telefono;
    private String email;

    public Usuario(int id, String nombre, String apellido, int edad, char genero, int telefono, String email){
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.genero = genero;
        this.telefono = telefono;
        this.email = email;
    }

    public void setId(int id){
        this.id = id;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void setApellido(String apellido){
        this.apellido = apellido;
    }
    public void setEdad(int edad){
        this.edad = edad;
    }
    public void setGenero(char genero){
        this.genero = genero;
    }
    public void setTelefono(int telefono){
        this.telefono = telefono;
    }
    public void setEmail(String email){
        this.email = email;
    }


    public int getId(){
        return this.id;
    }
    public String getNombre(){
        return this.nombre;
    }
    public String getApellido(){
        return this.apellido;
    }
    public int getEdad(){
        return this.edad;
    }
    public char getGenero(){
        return this.genero;
    }
    public int getTelefono(){
        return this.telefono;
    }
    public String getEmail(){
        return this.email;
    }


    public String toString(){
        return id+";"+nombre+";"+apellido+";"+edad+";"+genero+";"+telefono+";"+email;
    }
}
