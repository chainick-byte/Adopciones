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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rocio
 */
public class AdopcionDAO implements CRUD {

    Connection conexion;
    PreparedStatement ps;
    Statement st;
    ResultSet rs;

    @Override
    public List dameTodo() {
        List<Adopcion> miLista = new ArrayList<>();
        String sql = "select acion.id_adopcion,acion.fecha,p.nombre,ate.nombre,ate.apellido_1,ate.apellido_2,"
                + "ate.direccion from perro as p, adoptante as ate, adopcion as acion "
                + "where p.id_perro=acion.perro_id and ate.id_adoptante=acion.adoptante_id;";
        try {
            conexion = new Conexion().getConexion();
            ps = conexion.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Adopcion a = new Adopcion();
                a.setId_adopcion(rs.getInt(1));
                a.setFecha(rs.getDate(2));
                a.setNombre_perro(rs.getString(3));
                a.setNombre_adoptante(rs.getString(4));
                a.setApellido_1_adoptante(rs.getString(5));
                a.setApellido_2_adoptante(rs.getString(6));
                a.setDireccion_adoptante(rs.getString(7));

                miLista.add(a);
            }
            conexion.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return miLista;
    }

    @Override
    public int actualizar(Object[] o) {
        int result = 0;
        String sql = "update adopcion set perro_id=?,adoptante_id=? where id_adopcion=?";
        try {
            conexion = new Conexion().getConexion();
            ps = conexion.prepareStatement(sql);
            ps.setObject(1, o[0]);
            ps.setObject(2, o[1]);
            ps.setObject(3, o[2]);
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
        String sql = "insert into adopcion values(null, ?,?,now())";
        try {
            conexion = new Conexion().getConexion();
            ps = conexion.prepareStatement(sql);
            ps.setObject(1, o[0]);
            ps.setObject(2, o[1]);
            ps.executeUpdate();
            conexion.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    //transaccion de insert adopcion y hacer que el perro ya no este diponible para adopcion 
    public int guardarActualizar(Object[] o) {
        int result=0;
        String sql1 = "insert into adopcion values(null, ?,?,now())";
        String sql2 = "update perro set estado=true where id_perro=?";
        PreparedStatement ps1;
        PreparedStatement ps2;
        try {
            conexion = new Conexion().getConexion();
            conexion.setAutoCommit(false);
            ps1 = conexion.prepareStatement(sql1);
            ps1.setObject(1, o[0]);
            ps1.setObject(2, o[1]);
            ps1.executeUpdate();
            ps2 = conexion.prepareStatement(sql2);
            ps2.setObject(1, o[0]);
            ps2.executeUpdate();
            conexion.commit();
            System.out.println("paso por aqui <<<<<==============");
            result=1;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            if(conexion!=null){
            try {
                conexion.rollback();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            }
        }
        return result;
    }

    @Override
    public void eliminar(int id) {
        String sql = "delete from adopcion where id_adopcion=?;";
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

}
