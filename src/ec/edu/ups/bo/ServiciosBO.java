/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.bo;

import java.sql.Connection;
import ec.edu.ups.conexion.conexionAdmin;
import ec.edu.ups.conexion.conexionUsuario;
import ec.edu.ups.dao.ServiciosDAO;
import ec.edu.ups.entidad.Servicios;
import ec.edu.ups.entidad.Usuarios;
import javax.swing.JTable;
import java.sql.SQLException;

/**
 *
 * @author user
 */
public class ServiciosBO {
    private String mensaje = "";

    private ServiciosDAO serviciosDAO;
    
    private Connection con;
    public ServiciosBO(ServiciosDAO serviciosDAO) {
        this.serviciosDAO=serviciosDAO;
       this.con=null;
    }

    public ServiciosBO() {
    }
    
    

    public String agregarServicio(Servicios s, Usuarios u) {
       
        System.out.println(s);
        if (u.getUsu_rol() == 'A') {
            con = conexionAdmin.getConnection();
        } else if (u.getUsu_rol() == 'G') {
            con = conexionUsuario.getConnection();
        }
        if (con != null) {

            mensaje = serviciosDAO.agregarServicio(con, s);
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

    public String actualizarServicio(Servicios s, Usuarios u) {

        if (u.getUsu_rol() == 'A') {
            con = conexionAdmin.getConnection();
        } else {
            con = conexionUsuario.getConnection();
        }

        mensaje = serviciosDAO.actualizarServicio(con, s);
        try {
            if (con != null) {

                con.close();
            }
        } catch (SQLException e) {

            mensaje = mensaje + " " + e.getMessage();
        }

        return mensaje;
    }

    public String eliminarServicio(int id, Usuarios u) {
     
    if (u.getUsu_rol() == 'A') {
            con = conexionAdmin.getConnection();
        } else if (u.getUsu_rol() == 'G') {
            con = conexionUsuario.getConnection();
        }
        mensaje = serviciosDAO.eliminarServicio(con, id);
        try {
            if (con != null) {

                con.close();
            }
        } catch (SQLException e) {

            mensaje = mensaje + " " + e.getMessage();
        }

        return mensaje;
    }


    
       public String buscarServicios( Servicios s,Usuarios u, JTable t, String param) {
        
        if (u.getUsu_rol() == 'A') {
            con = conexionAdmin.getConnection();
        } else if (u.getUsu_rol() == 'G') {
            con = conexionUsuario.getConnection();
        }
        serviciosDAO.buscarServicio(con, s, t, param);
        try {      
            con.close();
        } catch (SQLException ex) {
            System.out.println("ERROR "+ex.getMessage());
        }
        return mensaje;
    }

    public void listarServicios(JTable t) {
       
       
            con = conexionAdmin.getConnection();
       
        serviciosDAO.listarServicios(con, t);
        
        
        try {
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

}

