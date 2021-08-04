/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.dao;

import java.sql.Connection;
import ec.edu.ups.entidad.Personas;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user
 */
public class PersonaDAO {

    private String mensaje = null;

    public String agregarPersona(Connection con, Personas per) {
          if(isSQLExistC(con,per.getPer_cedula())){
        mensaje="ESTA PERSONA YA ESTA REGISTRADA";
        }else{
           PreparedStatement pst = null;

        String sql = "INSERT INTO  ADMINISTRADOR_P4.DENT_PERSONAS (per_codigo,per_cedula,per_nombre,per_apellidos,per_direccion,per_telefono,per_correo,per_rol,per_estado) "
                + "VALUES(per_id_seq.nextval,?,?,?,?,?,?,?,?)";

        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, per.getPer_cedula());
            pst.setString(2, per.getPer_nombre());
            pst.setString(3, per.getPer_apellidos());
            pst.setString(4, per.getPer_direccion());
            pst.setString(5, per.getPer_telefono());
            pst.setString(6, per.getPer_correo());
            pst.setString(7, per.getPer_rol() + "");
            pst.setString(8, ""+' ');
            mensaje = "Persona guardada correctamente";
            pst.execute();
            pst.close();
        } catch (SQLException e) {

            mensaje = "No se pudo guardar correctamente \n " + e.getMessage();
        }

          }
       
        return mensaje;
    }

    public String actualizarPersona(Connection con, Personas per) {
        if (isSQLExist(con, per.getPer_codigo())) {
            System.out.println(per);
//        per_codigo,per_cedula,per_nombre,per_apellidos,per_direccion,per_telefono,per_correo,per_rol,per_estado
            PreparedStatement pst;
            String sql = "UPDATE ADMINISTRADOR_P4.DENT_PERSONAS SET PER_CEDULA = ?, PER_NOMBRE = ?, PER_APELLIDOS = ?, PER_DIRECCION = ?, PER_TELEFONO = ?, PER_CORREO = ?, PER_ROL = ?, PER_ESTADO = ? WHERE PER_CODIGO = ?";
            System.out.println(sql);
            try {
                pst = con.prepareStatement(sql);
                pst.setString(1, per.getPer_cedula());
                pst.setString(2, per.getPer_nombre());
                pst.setString(3, per.getPer_apellidos());
                pst.setString(4, per.getPer_direccion());
                pst.setString(5, per.getPer_telefono());
                pst.setString(6, per.getPer_correo());
                pst.setString(7, per.getPer_rol() + "");
                pst.setString(8, per.getPer_estado() + "");
                pst.setInt(9, per.getPer_codigo());
                mensaje = "Persona actualizada correctamente";
                pst.execute();
                pst.close();
            } catch (SQLException e) {

                mensaje = "No se pudo actualizar correctamente \n " + e.getMessage();
            }

        } else {

            mensaje = "Verifique los permisos";

        }

        return mensaje;
    }
      public String eliminarPersona(Connection con, int id) {
         if (isSQLExist(con, id)) {
            PreparedStatement pst=null;
            String sql = "DELETE FROM ADMINISTRADOR_P4.DENT_PERSONAS WHERE PER_CODIGO =?";

            try {
                pst = con.prepareStatement(sql);
                pst.setInt(1, id);
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

    public Personas buscarPersona (Connection con, String cedula){
    
        PreparedStatement pst;
        Personas p= new Personas();
        if(cedula!=null){
        String verificar = "SELECT * FROM ADMINISTRADOR_P4.DENT_PERSONAS WHERE PER_CEDULA='"+cedula+"'";
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
            System.out.println("Ha ocurrido un error: aqui 99 " + e.getMessage());;
        }
        
        }else{
        
            System.out.println("INGRESE PARAMETROS VALIDOS: CEDULA");
        }
       
        return p;
    
    }
  
    /**
     *
     * @param con
     * @param per
     * @param t
     * @param p
     */
    public void buscarPersona(Connection con, Personas per, JTable t, String p) {
     
       String sql ="";
        switch (p) {
            case "ID":
                sql = "SELECT * FROM ADMINISTRADOR_P4.DENT_PERSONAS WHERE PER_CODIGO="+ per.getPer_codigo()+" AND PER_ROL='C' ORDER BY PER_CODIGO";
                break;
            case "CEDULA":
                sql = "SELECT * FROM ADMINISTRADOR_P4.DENT_PERSONAS WHERE PER_CEDULA='"+ per.getPer_cedula()+"' AND PER_ROL='C' ORDER BY PER_CODIGO";
                break;
            case "NOMBRES":
                sql = "SELECT * FROM ADMINISTRADOR_P4.DENT_PERSONAS WHERE PER_NOMBRE= '"+ per.getPer_nombre()+"' AND PER_ROL='C' ORDER BY PER_CODIGO";
                break;
                
            case "DESACTIVOS":
                 sql = "SELECT * FROM ADMINISTRADOR_P4.DENT_PERSONAS WHERE PER_ESTADO='D' AND PER_ROL='C' ORDER BY PER_CODIGO";
                 break;
  
            default:
                break;
        }
        
        DefaultTableModel model;
      System.out.println(sql);
        String[] columnas = {"ID", "CEDULA", "NOMBRES", "APELLIDOS", "DIRECCION", "TELEFONO", "CORREO", "ROL", "ESTADO"};
        model = new DefaultTableModel(null, columnas);

        String[] filas = new String[8];

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

            JOptionPane.showMessageDialog(null, "No se puede mostrar la tabla: "+e.getMessage());
            System.out.println("ERROR BUSQUEDA: "+e.getMessage());
        }
    }
    public void buscarEmpleados(Connection con, Personas per, JTable t, String p) {
     
       String sql ="";
        switch (p) {
            case "ID":
                sql = "SELECT * FROM ADMINISTRADOR_P4.DENT_PERSONAS WHERE PER_CODIGO="+ per.getPer_codigo()+" AND PER_ROL='A' OR PER_ROL='O' ORDER BY PER_CODIGO";
                break;
            case "CEDULA":
                sql = "SELECT * FROM ADMINISTRADOR_P4.DENT_PERSONAS WHERE PER_CEDULA='"+ per.getPer_cedula()+"' AND PER_ROL='A' OR PER_ROL='O' ORDER BY PER_CODIGO";
                break;
  
            default:
                break;
        }
        
        DefaultTableModel model;
      System.out.println(sql);
        String[] columnas = {"ID", "CEDULA", "NOMBRES", "APELLIDOS", "DIRECCION", "TELEFONO", "CORREO", "ROL", "ESTADO"};
        model = new DefaultTableModel(null, columnas);

        String[] filas = new String[8];

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

            JOptionPane.showMessageDialog(null, "No se puede mostrar la tabla: "+e.getMessage());
            System.out.println("ERROR BUSQUEDA: "+e.getMessage());
        }
    }

    public void listarPersona(Connection con, JTable t) {
         
        DefaultTableModel model;

        String[] columnas = {"ID", "CEDULA", "NOMBRES", "APELLIDOS", "DIRECCION", "TELEFONO", "CORREO", "ROL", "ESTADO"};
        model = new DefaultTableModel(null, columnas);

        String sql = "SELECT * FROM ADMINISTRADOR_P4.DENT_PERSONAS WHERE PER_ESTADO=' ' OR PER_ESTADO='A' ORDER BY PER_CODIGO";

        String[] filas = new String[8];

        Statement st = null;
        ResultSet rs = null;
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                if(rs.getString("per_rol").equals("C")){
                for (int i = 0; i < filas.length; i++) {
                    filas[i] = rs.getString(i + 1);
                }
                model.addRow(filas);

                t.setModel(model);
                }
                
            }

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "No se puede mostrar la tabla");
        }

    }
     public void listarPersonaO(Connection con, JTable t) {
         
        DefaultTableModel model;

        String[] columnas = {"ID", "CEDULA", "NOMBRES", "APELLIDOS", "DIRECCION", "TELEFONO", "CORREO", "ROL", "ESTADO"};
        model = new DefaultTableModel(null, columnas);

        String sql = "SELECT * FROM ADMINISTRADOR_P4.DENT_PERSONAS WHERE PER_ESTADO=' ' OR PER_ESTADO='A' ORDER BY PER_CODIGO";

        String[] filas = new String[8];

        Statement st = null;
        ResultSet rs = null;
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                if(rs.getString("per_rol").equals("O")){
                for (int i = 0; i < filas.length; i++) {
                    filas[i] = rs.getString(i + 1);
                }
                model.addRow(filas);

                t.setModel(model);
                }
                
            }

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "No se puede mostrar la tabla");
        }

    }
       public void listarPersonaA(Connection con, JTable t) {
         
        DefaultTableModel model;

        String[] columnas = {"ID", "CEDULA", "NOMBRES", "APELLIDOS", "DIRECCION", "TELEFONO", "CORREO", "ROL", "ESTADO"};
        model = new DefaultTableModel(null, columnas);

        String sql = "SELECT * FROM ADMINISTRADOR_P4.DENT_PERSONAS WHERE PER_ESTADO=' ' OR PER_ESTADO='A' ORDER BY PER_CODIGO";

        String[] filas = new String[8];

        Statement st = null;
        ResultSet rs = null;
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                if(rs.getString("per_rol").equals("A")){
                for (int i = 0; i < filas.length; i++) {
                    filas[i] = rs.getString(i + 1);
                }
                model.addRow(filas);

                t.setModel(model);
                }
                
            }

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "No se puede mostrar la tabla");
        }

    }
           public void listarEmpleados(Connection con, JTable t) {
         
        DefaultTableModel model;

        String[] columnas = {"ID", "CEDULA", "NOMBRES", "APELLIDOS", "DIRECCION", "TELEFONO", "CORREO", "ROL", "ESTADO"};
        model = new DefaultTableModel(null, columnas);

        String sql = "(SELECT * FROM ADMINISTRADOR_P4.DENT_PERSONAS WHERE PER_ROL='A') \n"
                + "UNION ALL \n"
                + "(SELECT * FROM ADMINISTRADOR_P4.DENT_PERSONAS WHERE PER_ROL='O') ORDER BY 1";

        String[] filas = new String[8];

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

            JOptionPane.showMessageDialog(null, "No se puede mostrar la tabla "+e.getMessage());
        }

           }
        
  
    public boolean isSQLExist(Connection con, int id) {//Método el cual verifica si existe dicha persona en el sistema
        PreparedStatement pst;
        boolean res = false;
        String verificar = "SELECT PER_CODIGO FROM ADMINISTRADOR_P4.DENT_PERSONAS WHERE PER_CODIGO="+id;
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
    public boolean isSQLExistC(Connection con, String cedula) {//Método el cual verifica si existe dicha persona en el sistema
        PreparedStatement pst;
        boolean res = false;
        String verificar = "SELECT PER_CODIGO FROM ADMINISTRADOR_P4.DENT_PERSONAS WHERE PER_CEDULA='"+cedula+"'";
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
}
