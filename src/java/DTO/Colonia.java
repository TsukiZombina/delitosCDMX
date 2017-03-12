package DTO;

public class Colonia {

    private int id_colonia;
    private String nombre_colonia;

    public Colonia() {
    }

    public Colonia(int id_colonia, String nombre_colonia) {
        this.id_colonia = id_colonia;
        this.nombre_colonia = nombre_colonia;
    }

    public int getid_colonia() {
        return id_colonia;
    }

    public void setid_colonia(int id_colonia) {
        this.id_colonia = id_colonia;
    }

    public String getnombre_colonia() {
        return nombre_colonia;
    }

    public void setnombre_colonia(String nombre_colonia) {
        this.nombre_colonia = nombre_colonia;
    }
}
