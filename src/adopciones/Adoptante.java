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
public class Adoptante {
    
    private int id_adoptante;
    private String nombre;
    private String apelido_1;
    private String apellido_2;
    private String direccion;
    private String ciudad;
    private String comunidad_autonoma;
    private int codigo_postal;

    public Adoptante() {
    }

    public Adoptante(int id_adoptante, String nombre, String apelido_1, String apellido_2, String direccion, String ciudad, String comunidad_autonoma, int codigo_postal) {
        this.id_adoptante = id_adoptante;
        this.nombre = nombre;
        this.apelido_1 = apelido_1;
        this.apellido_2 = apellido_2;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.comunidad_autonoma = comunidad_autonoma;
        this.codigo_postal = codigo_postal;
    }

    public int getId_adoptante() {
        return id_adoptante;
    }

    public void setId_adoptante(int id_adoptante) {
        this.id_adoptante = id_adoptante;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApelido_1() {
        return apelido_1;
    }

    public void setApelido_1(String apelido_1) {
        this.apelido_1 = apelido_1;
    }

    public String getApellido_2() {
        return apellido_2;
    }

    public void setApellido_2(String apellido_2) {
        this.apellido_2 = apellido_2;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getComunidad_autonoma() {
        return comunidad_autonoma;
    }

    public void setComunidad_autonoma(String comunidad_autonoma) {
        this.comunidad_autonoma = comunidad_autonoma;
    }

    public int getCodigo_postal() {
        return codigo_postal;
    }

    public void setCodigo_postal(int codigo_postal) {
        this.codigo_postal = codigo_postal;
    }
    
    
    
    
}
