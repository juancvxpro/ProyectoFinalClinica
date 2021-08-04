package ec.edu.ups.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class conexionAdmin {

    private static Connection conn = null;
    private static String login = "administrador_p4";
    private static String clave = "adminp4_123";
    private static String url = "jdbc:oracle:thin:@localhost:1521:xe";

    public static Connection getConnection() {

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(url, login, clave);
            conn.setAutoCommit(false);

            if (conn != null) {
                System.out.println("Conexion Exitosa Admin");
            } else {
                System.out.println("Conexion errónea");
            }
        } catch (ClassNotFoundException | SQLException e) {

            JOptionPane.showMessageDialog(null, "Conexion Erroena");
            System.out.println("" + e.getMessage());
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
