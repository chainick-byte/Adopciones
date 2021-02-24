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
public class AdoptanteDAO implements CRUD {

    Connection conexion;
    PreparedStatement ps;
    ResultSet rs;

    @Override
    public List dameTodo() {
        List<Adoptante> miLista = new ArrayList<>();
        String sql = "select * from adoptante";
        try {
            conexion = new Conexion().getConexion();
            ps = conexion.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Adoptante a = new Adoptante();
                a.setId_adoptante(rs.getInt(1));
                a.setNombre(rs.getString(2));
                a.setApelido_1(rs.getString(3));
                a.setApellido_2(rs.getString(4));
                a.setDireccion(rs.getString(5));
                a.setCiudad(rs.getString(6));
                a.setComunidad_autonoma(rs.getString(7));
                a.setCodigo_postal(rs.getInt(8));
                miLista.add(a);

            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return miLista;
    }

    @Override
    public int actualizar(Object[] o) {
        int result=0;
        String sql = "update adoptante set nombre=?,apellido_1=?,apellido_2=?,direccion=?,ciudad=?, "
                + "comunidad_autonoma=?,codigo_postal=? where id_adoptante=?";
        try {
            conexion = new Conexion().getConexion();
            ps=conexion.prepareStatement(sql);
            ps.setObject(1, o[0]);
            ps.setObject(2, o[1]);
            ps.setObject(3, o[2]);
            ps.setObject(4, o[3]);
            ps.setObject(5, o[4]);
            ps.setObject(6, o[5]);
            ps.setObject(7, o[6]);
            ps.setObject(8, o[7]);
            result=ps.executeUpdate();
            conexion.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    @Override
    public int guardar(Object[] o) {
        int result=0;
        String sql="insert into adoptante values(null, ?,?,?,?,?,?,?)";
        try {
            conexion = new Conexion().getConexion();
            ps=conexion.prepareStatement(sql);
            ps.setObject(1, o[0]);
            ps.setObject(2, o[1]);
            ps.setObject(3, o[2]);
            ps.setObject(4, o[3]);
            ps.setObject(5, o[4]);
            ps.setObject(6, o[5]);
            ps.setObject(7, o[6]);
            result=ps.executeUpdate();
            conexion.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    @Override
    public void eliminar(int id) {
        String sql="delete from adoptante where id_adoptante=?;";
        try {
            conexion = new Conexion().getConexion();
            ps=conexion.prepareStatement(sql);
            ps.setObject(1, id);
            ps.executeUpdate();
            conexion.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
    }
    //aqui van metodos particulares 
    public List dameAdoptantePorId(int id_adoptante) {
        List<Adoptante> miLista = new ArrayList<>();
        String sql = "select * from adoptante where id_adoptante=?";
        try {
            conexion = new Conexion().getConexion();
            ps = conexion.prepareStatement(sql);
            ps.setObject(1, id_adoptante);
            rs = ps.executeQuery();
            while (rs.next()) {
                Adoptante a = new Adoptante();
                a.setId_adoptante(rs.getInt(1));
                a.setNombre(rs.getString(2));
                a.setApelido_1(rs.getString(3));
                a.setApellido_2(rs.getString(4));
                a.setDireccion(rs.getString(5));
                a.setCiudad(rs.getString(6));
                a.setComunidad_autonoma(rs.getString(7));
                a.setCodigo_postal(rs.getInt(8));
                miLista.add(a);

            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return miLista;
    }
    
    
    public List dameBusquedaAdoptante(String sql,String parametroBusqueda){
        List<Adoptante>miLista=new ArrayList<>();
        try {
            conexion = new Conexion().getConexion();
            ps = conexion.prepareStatement(sql);
            ps.setObject(1, parametroBusqueda);
            rs = ps.executeQuery();
            while (rs.next()) {
                Adoptante a = new Adoptante();
                a.setId_adoptante(rs.getInt(1));
                a.setNombre(rs.getString(2));
                a.setApelido_1(rs.getString(3));
                a.setApellido_2(rs.getString(4));
                a.setDireccion(rs.getString(5));
                a.setCiudad(rs.getString(6));
                a.setComunidad_autonoma(rs.getString(7));
                a.setCodigo_postal(rs.getInt(8));
                miLista.add(a);

            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return miLista;

    }

}
