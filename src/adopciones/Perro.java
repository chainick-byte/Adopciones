/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adopciones;

/**
 *
 * @author Rocio
 */
public class Perro {
    
    private int id_perro;
    private String nombre;
    private String raza;
    private int anno;
    private String direccion;
    private Boolean estado;

    public Perro() {
    }

    public Perro(int id_perro, String nombre, String raza, int anno, String direccion, Boolean estado) {
        this.id_perro = id_perro;
        this.nombre = nombre;
        this.raza = raza;
        this.anno = anno;
        this.direccion = direccion;
        this.estado = estado;
    }

    public int getId_perro() {
        return id_perro;
    }

    public void setId_perro(int id_perro) {
        this.id_perro = id_perro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public int getAnno() {
        return anno;
    }

    public void setAnno(int anno) {
        this.anno = anno;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

   
    
}
