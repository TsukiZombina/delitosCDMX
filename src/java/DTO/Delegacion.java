package DTO;

public class Delegacion {

    private int id_delegacion;
    private String nombre_delegacion;

    public Delegacion() {
    }

    public Delegacion(int id_delegacion, String nombre_delegacion) {
        this.id_delegacion = id_delegacion;
        this.nombre_delegacion = nombre_delegacion;
    }

    public int getid_delegacion() {
        return id_delegacion;
    }

    public void setid_delegacion(int id_delegacion) {
        this.id_delegacion = id_delegacion;
    }

    public String getnombre_delegacion() {
        return nombre_delegacion;
    }

    public void setnombre_delegacion(String nombre_delegacion) {
        this.nombre_delegacion = nombre_delegacion;
    }

}
