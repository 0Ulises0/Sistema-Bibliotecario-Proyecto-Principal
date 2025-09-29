package objetos;

public class Prestamos {
    private String id;
    private String idU;
    private String idL;
    private String fechaPrestamo;
    private String estado;

    public Prestamos(String id, String idU, String idL, String fechaPrestamo, String estado){
        this.id = id;
        this.idU = idU;
        this.idL = idL;
        this.fechaPrestamo = fechaPrestamo;
        this.estado = estado;
    }

    public void setId(String id){
        this.id = id;
    }

    public void setIdU(String idU){
        this.idU = idU;
    }

    public void setIdL(String idL){
        this.idL = idL;
    }

    public void setFechaPrestamo(String fechaPrestamo){
        this.fechaPrestamo = fechaPrestamo;
    }

    public void setEstado(String estado){
        this.estado = estado;
    }

    public String getId(){
        return this.id;
    }

    public String getIdU(){
        return this.idU;
    }

    public String getIdL(){
        return this.idL;
    }

    public String getFechaPrestamo(){
        return this.fechaPrestamo;
    }
  
    public String getEstado(){
        return this.estado;
    }

    
    public String[] toArray(){
        return new String[] {id, idU, idL, fechaPrestamo, estado};
    }
}