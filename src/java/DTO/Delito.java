package DTO;

public class Delito {

    private int id_delito;
    private String nombre_delito;

    public Delito() {
    }

    public Delito(int id_delito, String nombre_delito) {
        this.id_delito = id_delito;
        this.nombre_delito = nombre_delito;
    }

    public int getId_delito() {
        return id_delito;
    }

    public void setId_delito(int id_delito) {
        this.id_delito = id_delito;
    }

    public String getNombre_delito() {
        return nombre_delito;
    }

    public void setNombre_delito(String nombre_delito) {
        this.nombre_delito = nombre_delito;
    }

}
