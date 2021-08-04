          /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.bo;

import ec.edu.ups.conexion.conexionAdmin;
import ec.edu.ups.conexion.conexionUsuario;
import java.sql.Connection;
import ec.edu.ups.dao.PersonaDAO;
import ec.edu.ups.entidad.Personas;
import ec.edu.ups.entidad.Usuarios;
import java.sql.SQLException;
import javax.swing.JTable;

/**
 *
 * @author user
 */
public class PersonaBO {

    private String mensaje = "";

    private PersonaDAO personaDao;
    
    private Connection con;
    public PersonaBO(PersonaDAO personaDao) {
        this.personaDao = personaDao;
       this.con=null;
    }

    public PersonaBO() {
    }
    
    

    public String agregarPersona(Personas per, Usuarios u) {
       
        System.out.println(per);
        if (u.getUsu_rol() == 'A') {
            con = conexionAdmin.getConnection();
        } else if (u.getUsu_rol() == 'G') {
            con = conexionUsuario.getConnection();
        }
        if (con != null) {

            mensaje = personaDao.agregarPersona(con, per);
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

    public String actualizarPersona(Personas per, Usuarios u) {

        if (u.getUsu_rol() == 'A') {
            con = conexionAdmin.getConnection();
        } else {
            con = conexionUsuario.getConnection();
        }

        mensaje = personaDao.actualizarPersona(con, per);
        try {
            if (con != null) {

                con.close();
            }
        } catch (SQLException e) {

            mensaje = mensaje + " " + e.getMessage();
        }

        return mensaje;
    }

    public String eliminarPersona(int id, Usuarios u) {
     
    if (u.getUsu_rol() == 'A') {
            con = conexionAdmin.getConnection();
        } else if (u.getUsu_rol() == 'G') {
            con = conexionUsuario.getConnection();
        }
        mensaje = personaDao.eliminarPersona(con, id);
        try {
            if (con != null) {

                con.close();
            }
        } catch (SQLException e) {

            mensaje = mensaje + " " + e.getMessage();
        }

        return mensaje;
    }

    public String buscarPersona(Personas p, Usuarios u, JTable t, String param) {
      
        if (u.getUsu_rol() == 'A') {
            con = conexionAdmin.getConnection();
        } else if (u.getUsu_rol() == 'G') {
            con = conexionUsuario.getConnection();
        }
        personaDao.buscarPersona(con, p, t, param);
        try {
            con.close();
        } catch (SQLException ex) {
            mensaje=""+ex.getMessage();
        }
        return mensaje;
    }
    
       public String buscarEmpleados(Personas p, Usuarios u, JTable t, String param) {
        
        if (u.getUsu_rol() == 'A') {
            con = conexionAdmin.getConnection();
        } else if (u.getUsu_rol() == 'G') {
            con = conexionUsuario.getConnection();
        }
        personaDao.buscarEmpleados(con, p, t, param);
        try {
            con.close();
        } catch (SQLException ex) {
            mensaje=""+ex.getMessage();
        }
        return mensaje;
    }

    public void listarPersona(JTable t) {
       
       
            con = conexionAdmin.getConnection();
       
        personaDao.listarPersona(con,t);
        
        
        try {
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
  public Personas buscarPersonaO( String cedula){
        
       
            con = conexionAdmin.getConnection();
       
        Personas p=personaDao.buscarPersona(con, cedula.trim());
        
        
        try {
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
       if(p!=null){
       return p;
       }
        
  return null;
  
  }
  
   public void listarPersonaA(JTable t) {
        
       
            con = conexionAdmin.getConnection();
       
        personaDao.listarPersonaA(con,t);
        
        
        try {
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
   
   public void listarPersonaO(JTable t) {
        
       
            con = conexionAdmin.getConnection();
       
        personaDao.listarPersonaO(con,t);
        
        
        try {
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
   
     public void listarEmpleados(JTable t) {
        Connection con = null;
       
            con = conexionAdmin.getConnection();
       
        personaDao.listarEmpleados(con,t);
        
        
        try {
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }  
     
 
}
