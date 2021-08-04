/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.bo;
import ec.edu.ups.dao.CitasDAO;
import java.sql.Connection;
import ec.edu.ups.conexion.conexionAdmin;
import ec.edu.ups.conexion.conexionUsuario;
import ec.edu.ups.entidad.Citas;
import ec.edu.ups.entidad.Usuarios;
import java.sql.SQLException;
import javax.swing.JTable;
public class CitasBO {
      private String mensaje = "";

    private CitasDAO citasDAO;
    
    private Connection con;

    public CitasBO() {
    }

    public CitasBO(CitasDAO serviciosDAO) {
        this.citasDAO = serviciosDAO;
       
    }
   
    

    public String agregarCita(Citas c, Usuarios u) {
       
        System.out.println(c);
        if (u.getUsu_rol() == 'A') {
            con = conexionAdmin.getConnection();
        } else if (u.getUsu_rol() == 'G') {
            con = conexionUsuario.getConnection();
        }
        if (con != null) {

            mensaje = citasDAO.agregarCita(con, c);

            try {
                if (con != null) {

                    con.close();
                }
            } catch (SQLException e) {

                mensaje = mensaje + " " + e.getMessage();

            }
        }

        return mensaje;
    }

    public String actualizarCita(Citas c, Usuarios u) {

        if (u.getUsu_rol() == 'A') {
            con = conexionAdmin.getConnection();
        } else {
            con = conexionUsuario.getConnection();
        }

        mensaje = citasDAO.actualizarCita(con, c);
        try {
            if (con != null) {

                con.close();
            }
        } catch (SQLException e) {

            mensaje = mensaje + " " + e.getMessage();
        }

        return mensaje;
    }

    public String eliminarCita(int id, Usuarios u) {
     
    if (u.getUsu_rol() == 'A') {
            con = conexionAdmin.getConnection();
        } else if (u.getUsu_rol() == 'G') {
            con = conexionUsuario.getConnection();
        }
        mensaje = citasDAO.eliminarCita(con, id);
        try {
            if (con != null) {

                con.close();
            }
        } catch (SQLException e) {

            mensaje = mensaje + " " + e.getMessage();
        }

        return mensaje;
    }


    
       public String buscarCitas( Citas c,Usuarios u, JTable t, String param) {
        
        if (u.getUsu_rol() == 'A') {
            con = conexionAdmin.getConnection();
        } else if (u.getUsu_rol() == 'G') {
            con = conexionUsuario.getConnection();
        }
        citasDAO.buscarCita(con, c, t, param);
        try {      
            con.close();
        } catch (SQLException ex) {
            System.out.println("ERROR "+ex.getMessage());
        }
        return mensaje;
    }

    public void listarCitas(JTable t) {
       
       
            con = conexionAdmin.getConnection();
       
        citasDAO.listarCitas(con, t);
        
        
        try {
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
