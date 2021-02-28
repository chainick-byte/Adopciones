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
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conexion = DriverManager.getConnection("jdbc:oracle:thin:@192.168.56.1:1521:XE","SYSTEM","root");
            System.out.println("se ha producido la conexion");
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Error en la conexión de la base de datos");
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
