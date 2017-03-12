package DTO;

import java.util.*;
import java.text.*;

public class Reporte {

    private int id_reporte;
    private String fecha;
    private String hora;
    private String calle1;
    private String calle2;
    private String coord_x;
    private String coord_y;
    private String cuadrante;
    private String descripcion;
    private Colonia colonia;
    private Delegacion delegacion;
    private Delito delito;
    
    public Reporte(){}

    public Reporte(int id_reporte, String fecha, String hora, String calle1, String calle2, String coord_x, String coord_y, String cuadrante, String descripcion, Colonia colonia, Delegacion delegacion, Delito delito) {
        this.id_reporte = id_reporte;
        this.fecha = fecha;
        this.hora = hora;
        this.calle1 = calle1;
        this.calle2 = calle2;
        this.coord_x = coord_x;
        this.coord_y = coord_y;
        this.cuadrante = cuadrante;
        this.descripcion = descripcion;
        this.colonia = colonia;
        this.delegacion = delegacion;
        this.delito = delito;
    }

    public int getId_reporte() {
        return id_reporte;
    }

    public void setId_reporte(int id_reporte) {
        this.id_reporte = id_reporte;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getCalle1() {
        return calle1;
    }

    public void setCalle1(String calle1) {
        this.calle1 = calle1;
    }

    public String getCalle2() {
        return calle2;
    }

    public void setCalle2(String calle2) {
        this.calle2 = calle2;
    }

    public String getCoord_x() {
        return coord_x;
    }

    public void setCoord_x(String coord_x) {
        this.coord_x = coord_x;
    }

    public String getCoord_y() {
        return coord_y;
    }

    public void setCoord_y(String coord_y) {
        this.coord_y = coord_y;
    }

    public String getCuadrante() {
        return cuadrante;
    }

    public void setCuadrante(String cuadrante) {
        this.cuadrante = cuadrante;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Colonia getColonia() {
        return colonia;
    }

    public void setColonia(Colonia colonia) {
        this.colonia = colonia;
    }

    public Delegacion getDelegacion() {
        return delegacion;
    }

    public void setDelegacion(Delegacion delegacion) {
        this.delegacion = delegacion;
    }

    public Delito getDelito() {
        return delito;
    }

    public void setDelito(Delito delito) {
        this.delito = delito;
    }
    
}
