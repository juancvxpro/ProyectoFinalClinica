/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class conexionUsuario {

    private static Connection conn = null;
    private static final String login = "empleado_p4";
    private static final String clave = "empleadop4_123";
    private static final String url = "jdbc:oracle:thin:@localhost:1521:xe";

    public static Connection getConnection() {

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(url, login, clave);
            conn.setAutoCommit(false);

            if (conn != null) {
                System.out.println("Conexion Exitosa a Usuario");
            } else {
                System.out.println("Conexion errónea");
            }
        } catch (ClassNotFoundException | SQLException e) {

            JOptionPane.showMessageDialog(null, "Conexion Erroena");
        }

        return conn;
    }

    public void desconexion() {
        try {
            conn.close();
        } catch (SQLException e) {

            System.out.println("Error al desconectar" + e.getMessage());
        }
    }

}
