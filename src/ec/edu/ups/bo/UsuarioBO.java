/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.bo;

import ec.edu.ups.conexion.conexionAdmin;
import ec.edu.ups.dao.UsuarioDAO;
import ec.edu.ups.entidad.Personas;
import ec.edu.ups.entidad.Usuarios;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JTable;

/**
 *
 * @author user
 */
public class UsuarioBO {
       private String mensaje = "";

    private UsuarioDAO usuarioDAO;

    public UsuarioBO() {
    }

    public UsuarioBO(UsuarioDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }


    public String agregarUsuario(String cedula, Usuarios u) {
      Connection  con = conexionAdmin.getConnection();
        if (con != null) {
            System.out.println(u+" "+cedula);
            mensaje = usuarioDAO.agregarUsuario(con, u, cedula);
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

    public String actualizarUsuario(String cedula, Usuarios u) {

       Connection  con = conexionAdmin.getConnection();
        if (con != null) {

            mensaje = usuarioDAO.actualizarUsuario(con, u, cedula);
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

    public String eliminarUsuario(String nombreUsuario, Usuarios u) {

      Connection  con = conexionAdmin.getConnection();
        mensaje = usuarioDAO.eliminarUsuario(con, nombreUsuario);
        try {
            if (con != null) {

                con.close();
            }
        } catch (SQLException e) {

            mensaje = mensaje + " " + e.getMessage();
        }

        return mensaje;
    }

    public String buscarUsuario( Usuarios u, JTable t, String param) {
     
          Connection  con = conexionAdmin.getConnection();
        
        usuarioDAO.buscarUsuario(con, u, t, param);
        try {
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    public void listarUsuarios(JTable t, Usuarios u) {
        Connection con = null;
       
            con = conexionAdmin.getConnection();
    
        
        usuarioDAO.listarUsuario(con, t);
        try {
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public void listarUsuariosA(JTable t, Usuarios u) {
        Connection con = null;
       
            con = conexionAdmin.getConnection();
    
        
        usuarioDAO.listarUsuarioA(con, t);
        try {
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
     public void listarUsuariosG(JTable t, Usuarios u) {
        Connection con = null;
       
            con = conexionAdmin.getConnection();
    
        
        usuarioDAO.listarUsuarioG(con, t);
        try {
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public Usuarios cargarUsuario(String nombre, String pass){
         Connection con = null;
           Usuarios u = new Usuarios();
            con = conexionAdmin.getConnection();
          u=usuarioDAO.cargar(con, nombre, pass);
        
        try {
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
           return u;
    
    }
   public boolean isLogin(String usuario, String contrasena){
          Connection con = null;
            con = conexionAdmin.getConnection();
          if(usuarioDAO.isLogin(con,usuario,contrasena)){
          return true;
          }
        try {
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
   
           return false;
   
   
   }
   
   public Personas buscarPeraona(String cedula){
   Connection con = null;
           Personas  p = new Personas();
            con = conexionAdmin.getConnection();
          p=usuarioDAO.buscarPersona(con, cedula);
        
        try {
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
           return p;
   
   }
}
