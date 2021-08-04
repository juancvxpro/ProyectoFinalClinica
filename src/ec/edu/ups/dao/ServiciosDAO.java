/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.dao;

import ec.edu.ups.entidad.Servicios;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author user
 */
public class ServiciosDAO {
    
    private String mensaje = null;
    
    
    
      public String agregarServicio(Connection con, Servicios s) {
          if(isSQLExistS(con,s.getSer_nombre())){
        mensaje="ESTE SERVICIO YA ESTA REGISTRADO";
        }else{
           PreparedStatement pst = null;

        String sql = "INSERT INTO  ADMINISTRADOR_P4.DENT_SERVICIOS (ser_codigo,ser_nombre,ser_precio,ser_iva) "
                + "VALUES(serv_id_seq.nextval,?,?,?)";

        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, s.getSer_nombre());
            pst.setDouble(2, s.getSer_precio());
            pst.setDouble(3, s.getSer_iva());
         
            mensaje = "Servicio guardado correctamente";
            pst.execute();
            pst.close();
        } catch (SQLException e) {

            mensaje = "No se pudo guardar correctamente \n " + e.getMessage();
        }

          }
       
        return mensaje;
    }

    public String actualizarServicio(Connection con, Servicios s) {
        if (isSQLExist(con, s.getSer_codigo())) {
            System.out.println(s);
//        per_codigo,per_cedula,per_nombre,per_apellidos,per_direccion,per_telefono,per_correo,per_rol,per_estado
            PreparedStatement pst;
            String sql = "UPDATE ADMINISTRADOR_P4.DENT_SERVICIOS SET SER_NOMBRE = ?, SER_PRECIO = ?, SER_IVA= ? WHERE SER_CODIGO = ?";
            System.out.println(sql);
            try {
                pst = con.prepareStatement(sql);
                pst.setString(1, s.getSer_nombre());
                pst.setDouble(2, s.getSer_precio());
                pst.setDouble(3, s.getSer_iva());
                pst.setInt(4, s.getSer_codigo());
                
                mensaje = "Servicio actualizado correctamente";
                pst.execute();
                pst.close();
            } catch (SQLException e) {

                mensaje = "No se pudo actualizar correctamente \n " + e.getMessage();
            }

        } else {

            mensaje = "Verifique ";

        }

        return mensaje;
    }
      public String eliminarServicio(Connection con, int id) {
         if (isSQLExist(con, id)) {
            PreparedStatement pst=null;
            String sql = "DELETE FROM ADMINISTRADOR_P4.DENT_SERVICIOS WHERE SER_CODIGO =?";

            try {
                pst = con.prepareStatement(sql);
                pst.setInt(1, id);
                mensaje = "Servicio  eliminado correctamente";
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
      
      public void buscarServicio(Connection con,Servicios s, JTable t, String p) {
     
       String sql ="";
        switch (p) {
            case "ID":
                sql = "SELECT * FROM ADMINISTRADOR_P4.DENT_SERVICIOS WHERE SER_CODIGO="+s.getSer_codigo()+" ORDER BY 1";
                break;
            case "NOMBRE":
                sql = "SELECT * FROM ADMINISTRADOR_P4.DENT_SERVICIOS WHERE SER_NOMBRE='"+ s.getSer_nombre()+"' ORDER BY 1";
                break;
            default:
                break;
        }
        
        DefaultTableModel model;
      System.out.println(sql);
        String[] columnas = {"ID", "NOMBRE", "PRECIO", "IVA"};
        model = new DefaultTableModel(null, columnas);

        String[] filas = new String[4];

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
      
      public void listarServicios (Connection con, JTable t){
      String sql ="";
      sql = "SELECT * FROM ADMINISTRADOR_P4.DENT_SERVICIOS ORDER BY 1";
         DefaultTableModel model;
      System.out.println(sql);
        String[] columnas = {"ID", "NOMBRE", "PRECIO", "IVA"};
        model = new DefaultTableModel(null, columnas);

        String[] filas = new String[4];

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
    public boolean isSQLExistS(Connection con, String nombre) {//Método el cual verifica si existe dicho servicio esta en el sistema
        PreparedStatement pst;
        boolean res = false;
        String verificar = "SELECT SER_CODIGO FROM ADMINISTRADOR_P4.DENT_SERVICIOS WHERE SER_NOMBRE='"+nombre+"'";
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
      public boolean isSQLExist(Connection con, int id) {//Método el cual verifica si existe dicho servicio esta en el sistema
        PreparedStatement pst;
        boolean res = false;
        String verificar = "SELECT SER_CODIGO FROM ADMINISTRADOR_P4.DENT_SERVICIOS WHERE SER_CODIGO="+id;
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
