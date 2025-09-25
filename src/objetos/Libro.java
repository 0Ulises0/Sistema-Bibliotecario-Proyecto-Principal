package objetos;

public class Libro {
    private String id;
    private String titulo;
    private String categoria;
    private String autor;
    private String edicion;
    private String stock;

    public Libro(String id, String titulo, String categoria, String autor, String edicion, String stock){
        this.id = id;
        this.titulo = titulo;
        this.categoria = categoria;
        this.autor = autor;
        this.edicion = edicion;
        this.stock = stock;
    }

    public void setId(String id){
        this.id = id;
    }
    public void setTitulo(String titulo){
        this.titulo = titulo;
    }
    public void setCategoria(String categoria){
        this.categoria = categoria;
    }
    public void setAutor(String autor){
        this.autor = autor;
    }
    public void setEdicion(String edicion){
        this.edicion = edicion;
    }
    public void setStock(String stock){
        this.stock =stock;
    }


    public String getId(){
        return this.id;
    }
    public String getTitulo(){
        return this.titulo;
    }
    public String getCategoria(){
        return this.categoria;
    }
    public String getAutor(){
        return this.autor;
    }
    public String getEdicion(){
        return this.edicion;
    }
    public String getStock(){
        return this.stock;
    }


    public String[] toArray(){
        return new String[] {id,titulo,categoria,autor,edicion,stock};
    }
}
