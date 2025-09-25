package objetos;

public class Usuario {
    private String id;
    private String nombre;
    private String apellido;
    private String edad;
    private String genero;
    private String telefono;
    private String email;

    public Usuario(String id, String nombre, String apellido, String edad, String genero, String telefono, String email){
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.genero = genero;
        this.telefono = telefono;
        this.email = email;
    }

    public void setId(String id){
        this.id = id;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void setApellido(String apellido){
        this.apellido = apellido;
    }
    public void setEdad(String edad){
        this.edad = edad;
    }
    public void setGenero(String genero){
        this.genero = genero;
    }
    public void setTelefono(String telefono){
        this.telefono = telefono;
    }
    public void setEmail(String email){
        this.email = email;
    }


    public String getId(){
        return this.id;
    }
    public String getNombre(){
        return this.nombre;
    }
    public String getApellido(){
        return this.apellido;
    }
    public String getEdad(){
        return this.edad;
    }
    public String getGenero(){
        return this.genero;
    }
    public String getTelefono(){
        return this.telefono;
    }
    public String getEmail(){
        return this.email;
    }


    public String[] toArray(){
        return new String[] {id,nombre,apellido,edad,genero,telefono,email};
    }
}
