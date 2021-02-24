/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adopciones;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rocio
 */
public class PerroDAO implements CRUD {

    Connection conexion;
    PreparedStatement ps;
    ResultSet rs;
//selecciono toda la tabla de perros, ordenado por el estado si el estado es false, significa que no esta adoptado
    @Override
    public List dameTodo() {
        List<Perro> miList = new ArrayList<>();
        String sql = "select * from perro order by estado asc;";
        try {
            conexion = new Conexion().getConexion();
            ps = conexion.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Perro p = new Perro();
                p.setId_perro(rs.getInt(1));
                p.setNombre(rs.getString(2));
                p.setRaza(rs.getString(3));
                p.setAnno(rs.getInt(4));
                p.setDireccion(rs.getString(5));
                p.setEstado(rs.getBoolean(6));
                miList.add(p);
            }
            conexion.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return miList;
    }

    @Override
    public int actualizar(Object[] o) {
        int result = 0;
        String sql = "update perro set nombre=?,raza=?,anno_nacimiento=?,direccion_perrera=? where id_perro=?;";
        try {
            conexion = new Conexion().getConexion();
            ps = conexion.prepareStatement(sql);
            ps.setObject(1, o[0]);
            ps.setObject(2, o[1]);
            ps.setObject(3, o[2]);
            ps.setObject(4, o[3]);
            ps.setObject(5, o[4]);
            result = ps.executeUpdate();
            conexion.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    @Override
    public int guardar(Object[] o) {
        int result = 0;
        String sql = "insert into perro values(null,?,?,?,?)";
        try {
            conexion = new Conexion().getConexion();
            ps = conexion.prepareStatement(sql);
            ps.setObject(1, o[0]);
            ps.setObject(2, o[1]);
            ps.setObject(3, o[2]);
            ps.setObject(4, o[3]);
            result = ps.executeUpdate();
            conexion.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    @Override
    public void eliminar(int id) {
        String sql = "delete from perro where id_perro=?;";
        try {
            conexion = new Conexion().getConexion();
            ps = conexion.prepareStatement(sql);
            ps.setObject(1, id);
            ps.executeUpdate();
            conexion.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    //genero metodo que me busca solo un perro 
    public List damePerroPorId(int id_perro) {
        List<Perro> miList = new ArrayList<>();
        String sql = "select * from perro where id_perro=?;";
        try {
            conexion = new Conexion().getConexion();
            ps = conexion.prepareStatement(sql);
            ps.setObject(1, id_perro);
            rs = ps.executeQuery();
            if (rs.next()) {
                Perro p = new Perro();
                p.setId_perro(rs.getInt(1));
                p.setNombre(rs.getString(2));
                p.setRaza(rs.getString(3));
                p.setAnno(rs.getInt(4));
                p.setDireccion(rs.getString(5));
                miList.add(p);
            }
            conexion.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return miList;
    }
    //hago un metodo para buscar perros, al cual paso tanto la querry, como parametro de busqueda, y paso querry
    //desde la vista con el parametro busado

    public List dameBusquedaPerro(String sql, String parametroBusqueda) {
        List<Perro> miLista = new ArrayList<>();
        try {
            conexion = new Conexion().getConexion();
            ps = conexion.prepareStatement(sql);
            ps.setObject(1, parametroBusqueda);
            rs = ps.executeQuery();
            while (rs.next()) {
                Perro p = new Perro();
                p.setId_perro(rs.getInt(1));
                p.setNombre(rs.getString(2));
                p.setRaza(rs.getString(3));
                p.setAnno(rs.getInt(4));
                p.setDireccion(rs.getString(5));
                p.setEstado(rs.getBoolean(6));
                miLista.add(p);
            }
            conexion.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return miLista;

    }

}
