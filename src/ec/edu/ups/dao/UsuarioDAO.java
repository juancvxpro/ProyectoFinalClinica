/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.dao;

import ec.edu.ups.entidad.Personas;
import ec.edu.ups.entidad.Usuarios;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user
 */
public class UsuarioDAO {
  
    private String mensaje = null;

    public String agregarUsuario(Connection con, Usuarios u,String cedula) {
        if(isSQLExist(con,u.getUsu_nombre())){
         mensaje="USUARIO YA REGISTRADO";
        }else{
         Personas p= buscarPersona(con,cedula);
        PreparedStatement pst = null;
        if(!isUP(con,p.getPer_codigo())){
         if(isExistC(con,cedula)){
            
        if(p.getPer_rol()=='A'||p.getPer_rol()=='O'){
        
       
         String sql = "INSERT INTO  ADMINISTRADOR_P4.DENT_USUARIOS (usu_codigo,usu_nombre,usu_contra,usu_rol,usu_per_codigo) "
                + "VALUES(usu_id_seq.nextval,?,?,?,?)";
            
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, u.getUsu_nombre());
            pst.setString(2, u.getUsu_contra());
            pst.setString(3, u.getUsu_rol()+"");
            pst.setInt(4, p.getPer_codigo());
            System.out.println(sql);
     
            mensaje = "Usuario guardado correctamente";
            pst.execute();
            pst.close();
        } catch (SQLException e) {

            mensaje = "No se pudo guardar correctamente \n " + e.getMessage();
        }
        }else {
            mensaje = "Error se necesita registrar una persona:  EMPLEADO \n " ;
        }
        
        }
        }else{
          mensaje="LA PERSONA YA TIENE UN USUARIO ASIGNADO";
        }
       
        }
        

        return mensaje;
    }

    public String actualizarUsuario(Connection con, Usuarios u, String cedula) {
        if (isSQLExist(con, u.getUsu_nombre())&&isExistC(con,cedula)) {
//        per_codigo,per_cedula,per_nombre,per_apellidos,per_direccion,per_telefono,per_correo,per_rol,per_estado
            PreparedStatement pst=null;
            String sql = "UPDATE ADMINISTRADOR_P4.DENT_USUARIOS SET USU_NOMBRE = ?, USU_CONTRA = ?, USU_ROL = ?, USU_PER_CODIGO = ? WHERE USU_NOMBRE = ?";
            System.out.println(sql);
            try {
                pst = con.prepareStatement(sql);
                pst.setString(1, u.getUsu_nombre());
                pst.setString(2, u.getUsu_contra());
                pst.setString(3, u.getUsu_rol()+"");
                pst.setInt(4, u.getUsu_codigo_empleado());
                pst.setString(5, u.getUsu_nombre());
             
                mensaje = "Usuario actualizado correctamente";
                pst.execute();
                pst.close();
            } catch (SQLException e) {

                mensaje = "No se pudo actualizar correctamente \n " + e.getMessage();
            }

        } else {

            mensaje = "Verifique que los parámetros sean válidos";

        }

        return mensaje;
    }

    public String eliminarUsuario(Connection con, String nombre) {
        if (isSQLExist(con, nombre)) {
            PreparedStatement pst=null;
            String sql = "DELETE FROM ADMINISTRADOR_P4.DENT_USUARIOS WHERE USU_NOMBRE=?";

            try {
                pst = con.prepareStatement(sql);
                pst.setString(1, nombre);
                mensaje = "Usuario  eliminado correctamente";
                pst.execute();
                pst.close();
            } catch (SQLException e) {

                mensaje = "No se pudo eliminar  \n " + e.getMessage();
            }

        } else {
            mensaje = " id no válido";

        }
        return mensaje;
    }

    /**
     *
     * @param con
     * @param u
     * @param t
     * @param p
     */
    public void buscarUsuario(Connection con, Usuarios u, JTable t, String p) {
     
       String sql ="";
        switch (p) {
            case "ID":
                sql = "SELECT * FROM ADMINISTRADOR_P4.DENT_USUARIOS WHERE USU_CODIGO=" + u.getUsu_codigo()+" ORDER BY USU_CODIGO";
                break;
            case "NOMBRE":
                sql = "SELECT * FROM ADMINISTRADOR_P4.DENT_PERSONAS WHERE USU_NOMBRE='" + u.getUsu_nombre()+"' ORDER BY USU_CODIGO";
                break;
            default:
                break;
        }
        DefaultTableModel model;

        String[] columnas = {"ID", "USUARIO", "CONTRASEÑA", "ROL", "DIRECCION", "ESTADO"};
        model = new DefaultTableModel(null, columnas);

        String[] filas = new String[5];

        Statement st = null;
        ResultSet rs = null;
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                for (int i = 0; i < filas.length; i++) {
                    filas[i] = rs.getString(i + 1); 
                }
                model.addRow(filas);
            }
             t.setModel(model);

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "No se puede mostrar la tabla");
        }
    }

    public void listarUsuario(Connection con, JTable t) {
         
        DefaultTableModel model;

       String[] columnas = {"ID", "USUARIO", "CONTRASEÑA", "ROL", "DIRECCION", "ESTADO"};
        model = new DefaultTableModel(null, columnas);

       String sql = "SELECT * FROM ADMINISTRADOR_P4.DENT_USUARIOS";

        String[] filas = new String[5];

        Statement st = null;
        ResultSet rs = null;
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                for (int i = 0; i < filas.length; i++) {
                    filas[i] = rs.getString(i + 1);
                }
                model.addRow(filas);

                t.setModel(model);
            }

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "No se puede mostrar la tabla");
        }

    }

  public void listarUsuarioA(Connection con, JTable t) {
         
        DefaultTableModel model;

       String[] columnas = {"ID", "USUARIO", "CONTRASEÑA", "ROL", "DIRECCION", "ESTADO"};
        model = new DefaultTableModel(null, columnas);

       String sql = "SELECT * FROM ADMINISTRADOR_P4.DENT_USUARIOS WHERE USU_ROL='A' ORDER BY 1";

        String[] filas = new String[5];

        Statement st = null;
        ResultSet rs = null;
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                for (int i = 0; i < filas.length; i++) {
                    filas[i] = rs.getString(i + 1);
                }
                model.addRow(filas);

                t.setModel(model);
            }

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "No se puede mostrar la tabla");
        }

    }
    
   public void listarUsuarioG(Connection con, JTable t) {
         
        DefaultTableModel model;

       String[] columnas = {"ID", "USUARIO", "CONTRASEÑA", "ROL", "DIRECCION", "ESTADO"};
        model = new DefaultTableModel(null, columnas);

       String sql = "SELECT * FROM ADMINISTRADOR_P4.DENT_USUARIOS WHERE USU_ROL='G' ORDER BY 1";

        String[] filas = new String[5];

        Statement st = null;
        ResultSet rs = null;
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                for (int i = 0; i < filas.length; i++) {
                    filas[i] = rs.getString(i + 1);
                }
                model.addRow(filas);

                t.setModel(model);
            }

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "No se puede mostrar la tabla");
        }

    }

    public boolean isSQLExist(Connection con, String nombre) {//Método el cual verifica si existe dicha persona en el sistema
        PreparedStatement pst;
        boolean res = false;
        String verificar = "SELECT USU_NOMBRE FROM ADMINISTRADOR_P4.DENT_USUARIOS WHERE USU_NOMBRE='"+nombre+"'";
        System.out.println(verificar);
        try {
            pst = con.prepareStatement(verificar);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                res = true;
            }
        } catch (SQLException e) {
            System.out.println("Ha ocurrido un error: " + e.getMessage());;
        }

        return res;

    }
    
    public boolean isUP(Connection con, int idPer) {//Método el cual verifica si existe dicha persona en el sistema
        PreparedStatement pst;
        boolean res = false;
        String verificar = "SELECT USU_NOMBRE FROM ADMINISTRADOR_P4.DENT_USUARIOS WHERE USU_PER_CODIGO="+idPer;
        System.out.println(verificar);
        try {
            pst = con.prepareStatement(verificar);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                res = true;
            }
        } catch (SQLException e) {
            System.out.println("Ha ocurrido un error: " + e.getMessage());;
        }

        return res;

    }
    
   
    public boolean isExistC(Connection con, String cedula) {//Método el cual verifica si existe dicha persona en el sistema

        PreparedStatement pst;
        boolean res = false;
        if(cedula!=null){
            String verificar = "SELECT * FROM ADMINISTRADOR_P4.DENT_PERSONAS WHERE PER_CEDULA="+"'"+cedula+"'";
        System.out.println(verificar);
        try {
            pst = con.prepareStatement(verificar);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                res = true;
            }
        } catch (SQLException e) {
            System.out.println("Ha ocurrido un error: " + e.getMessage());;
        }
        }else{
            System.out.println("Parametros nulos");
            res = false;
        
        }
        
        return res;

    }
 
    public Personas buscarPersona (Connection con, String cedula){
    
        PreparedStatement pst;
        Personas p= new Personas();
        if(cedula!=null){
         String verificar = "SELECT * FROM ADMINISTRADOR_P4.DENT_PERSONAS WHERE PER_CEDULA="+"'"+cedula+"'";
        System.out.println(verificar);
        try {
            pst = con.prepareStatement(verificar);
            ResultSet rs = pst.executeQuery();
           rs.next();  
           p.setPer_codigo(rs.getInt("per_codigo"));
           p.setPer_cedula(rs.getString("per_cedula"));
           p.setPer_nombre(rs.getString("per_nombre"));
           p.setPer_apellidos(rs.getString("per_apellidos"));
           p.setPer_direccion(rs.getString("per_direccion"));
           p.setPer_telefono(rs.getString("per_telefono"));
           p.setPer_correo(rs.getString("per_correo"));
           p.setPer_rol(rs.getString("per_rol").charAt(0));
           p.setPer_estado(rs.getString("per_estado").charAt(0));
           
        } catch (SQLException e) {
            System.out.println("Ha ocurrido un error: " + e.getMessage());;
        }
        
        }else{
        
            System.out.println("INGRESE PARAMETROS VALIDOS: CEDULA");
        }
       
        return p;
    
    }
    
    public Usuarios cargar(Connection con, String usuario, String contra){
        PreparedStatement pst;
        Usuarios u= new Usuarios();
         
       
        if(usuario!=null&&contra!=null){
            String verificar = "SELECT * FROM ADMINISTRADOR_P4.DENT_USUARIOS WHERE USU_NOMBRE="+"'"+usuario+"' AND USU_CONTRA="+"'"+contra+"'";
        System.out.println(verificar);
        try {
            pst = con.prepareStatement(verificar);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
              u.setUsu_codigo(rs.getInt("usu_codigo"));
              u.setUsu_nombre(rs.getString("usu_nombre"));
              u.setUsu_contra(rs.getString("usu_contra"));
              u.setUsu_rol(rs.getString("usu_rol").charAt(0));
              u.setUsu_codigo_empleado(rs.getInt("usu_per_codigo"));
            }
        } catch (SQLException e) {
            System.out.println("Ha ocurrido un error: " + e.getMessage());;
        }
        }else{
            System.out.println("Parametros nulos");
           
        
        }
        
        return u;
    
    
    }
    
    public boolean isLogin(Connection con, String usuario, String contra){
        PreparedStatement pst;
         boolean res=false;
       
        if(usuario!=null&&contra!=null){
            String verificar = "SELECT * FROM ADMINISTRADOR_P4.DENT_USUARIOS WHERE USU_NOMBRE='"+usuario+"' AND USU_CONTRA='"+contra+"'";
        System.out.println(verificar);
        try {
            pst = con.prepareStatement(verificar);
            ResultSet rs = pst.executeQuery();
            while(rs.next()) {
             if(rs.getString("usu_nombre").equals(usuario)&&rs.getString("usu_contra").equals(contra)){
             res=true;
             
             }
            }
        } catch (SQLException e) {
            System.out.println("Ha ocurrido un error: " + e.getMessage());;
        }
        }else{
            System.out.println("Parametros nulos");
           
        
        }
        
        return res;
    
    } 
}
