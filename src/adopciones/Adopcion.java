/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adopciones;

import java.util.Date;

/**
 *
 * @author Rocio
 */
public class Adopcion {
    private int id_adopcion;
    private int perro_id;
    private int adoptante_id;
    private Date fecha;
    private String nombre_adoptante;
    private String apellido_1_adoptante;
    private String apellido_2_adoptante;
    private String nombre_perro;
    private String direccion_adoptante;

    public Adopcion() {
    }

    public Adopcion(int id_adopcion, int perro_id, int adoptante_id, Date fecha, String nombre_adoptante, String apellido_1_adoptante, String apellido_2_adoptante, String nombre_perro, String direccion_adoptante) {
        this.id_adopcion = id_adopcion;
        this.perro_id = perro_id;
        this.adoptante_id = adoptante_id;
        this.fecha = fecha;
        this.nombre_adoptante = nombre_adoptante;
        this.apellido_1_adoptante = apellido_1_adoptante;
        this.apellido_2_adoptante = apellido_2_adoptante;
        this.nombre_perro = nombre_perro;
        this.direccion_adoptante = direccion_adoptante;
    }

    public int getId_adopcion() {
        return id_adopcion;
    }

    public void setId_adopcion(int id_adopcion) {
        this.id_adopcion = id_adopcion;
    }

    public int getPerro_id() {
        return perro_id;
    }

    public void setPerro_id(int perro_id) {
        this.perro_id = perro_id;
    }

    public int getAdoptante_id() {
        return adoptante_id;
    }

    public void setAdoptante_id(int adoptante_id) {
        this.adoptante_id = adoptante_id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getNombre_adoptante() {
        return nombre_adoptante;
    }

    public void setNombre_adoptante(String nombre_adoptante) {
        this.nombre_adoptante = nombre_adoptante;
    }

    public String getApellido_1_adoptante() {
        return apellido_1_adoptante;
    }

    public void setApellido_1_adoptante(String apellido_1_adoptante) {
        this.apellido_1_adoptante = apellido_1_adoptante;
    }

    public String getApellido_2_adoptante() {
        return apellido_2_adoptante;
    }

    public void setApellido_2_adoptante(String apellido_2_adoptante) {
        this.apellido_2_adoptante = apellido_2_adoptante;
    }

    public String getNombre_perro() {
        return nombre_perro;
    }

    public void setNombre_perro(String nombre_perro) {
        this.nombre_perro = nombre_perro;
    }

    public String getDireccion_adoptante() {
        return direccion_adoptante;
    }

    public void setDireccion_adoptante(String direccion_adoptante) {
        this.direccion_adoptante = direccion_adoptante;
    }

    
    

   
    
    
}
