package objetos;

public class Prestamos {
    private String fechaPrestamo;
    private String fechaDevolucion;
    private String estado;

    public Prestamos(String fechaPrestamo, String fechaDevolucion, String estado){
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
        this.estado = estado;
    }

    public void setFechaPrestamo(String fechaPrestamo){
        this.fechaPrestamo = fechaPrestamo;
    }
    public void setFechaDevolucion(String fechaDevolucion){
        this.fechaDevolucion = fechaDevolucion;
    }
    public void setEstado(String estado){
        this.estado = estado;
    }


    public String getFechaPrestamo(){
        return this.fechaPrestamo;
    }
    public String getFechaDevolucion(){
        return this.fechaDevolucion;
    }
    public String getEstado(){
        return this.estado;
    }

    
    public String toString(){
        return fechaPrestamo+";"+fechaDevolucion+";"+estado;
    }
}
