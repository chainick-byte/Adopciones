package adopciones;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Rocio
 */
public class Conexion {

    Connection conexion = null;

    public Conexion() {

        try {
            String url = "jdbc:mysql://192.168.182.144/adopcion?serverTimezone=UTC";
            String user = "root";
            String password = "";

            conexion = DriverManager.getConnection(url, user, password);

            if (conexion != null) {
                System.out.println("se ha producido la conexion");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("se ha producido un error de conexion");
        }

    }

    public int abreConexion() {
        if (conexion != null) {
            return 1;
        } else {
            return -1;
        }
    }
    public int cierraConexion(){
        try {
            conexion.close();
            return 1;
        } catch (SQLException e) {
            return -1;
        }
    }

    public Connection getConexion() {
        return conexion;
    }

    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }

}
