/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.dao;
import ec.edu.ups.entidad.Citas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author user
 */
public class CitasDAO {
    String  mensaje="";
    
     public String agregarCita(Connection con, Citas c) {
      
              if(!isSQLExistCancel(con,c.getCita_fecha(),c.getCita_hora())){
              
               PreparedStatement pst = null;

        String sql = "INSERT INTO  ADMINISTRADOR_P4.DENT_CITAS (cita_codigo,cita_fecha,cita_hora,cita_estado,cita_per_codigo_cliente,cita_per_codigo_odontologo) "
                + "VALUES(cita_id_seq.nextval,?,?,?,?,?)";

        try {
            pst = con.prepareStatement(sql);
            pst.setDate(1, (java.sql.Date) c.getCita_fecha());
            pst.setString(2, c.getCita_hora());
            pst.setString(3, c.getEstado()+"");
            pst.setInt(4, c.getCita_codigoCliente());
            pst.setInt(5, c.getCita_codigoEmpleadoO());
            mensaje = "Cita generada correctamente";
            pst.execute();
            pst.close();
        } catch (SQLException e) {

            mensaje = "No se pudo guardar correctamente \n " + e.getMessage();
        }
      }else{
              mensaje="LA CITA ESTA REGISTRADA Y NO ESTA CANCELADA";
              
              }

        return mensaje;
    }

    public String actualizarCita(Connection con, Citas c) {

              if(isSQLExistC(con,c.getCita_fecha(),c.getCita_hora())){
              
               PreparedStatement pst = null;

      String sql = "UPDATE ADMINISTRADOR_P4.DENT_CITAS SET CITA_FECHA = ?, CITA_HORA= ?, CITA_ESTADO= ?, CITA_PER_CODIGO_CLIENTE= ?, CITA_PER_CODIGO_ODONTOLOGO= ? "
              + "WHERE CITA_CODIGO = ?";
            System.out.println(sql);

        try {
            pst = con.prepareStatement(sql);
            pst.setDate(1, (java.sql.Date) c.getCita_fecha());
            pst.setString(2, c.getCita_hora());
            pst.setString(3, c.getEstado()+"");
            pst.setInt(4, c.getCita_codigoCliente());
            pst.setInt(5, c.getCita_codigoEmpleadoO());
            pst.setInt(6, c.getCita_codigo());
            mensaje = "Cita actualizada correctamente";
            pst.execute();
            pst.close();
        } catch (SQLException e) {

            mensaje = "No se pudo guardar correctamente \n " + e.getMessage();
        }
      }else{
              mensaje="NO SE PUDO ENCONRAR LA CITA INGRESADA";
              
              }

        return mensaje;
        
    }
      public String eliminarCita(Connection con, int id) {
         if (isSQLExist(con, id)) {
            PreparedStatement pst=null;
            String sql = "DELETE FROM ADMINISTRADOR_P4.DENT_CITAS WHERE CITA_CODIGO =?";

            try {
                pst = con.prepareStatement(sql);
                pst.setInt(1, id);
                mensaje = "Cita eliminada correctamente";
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
      
      public void buscarCita(Connection con,Citas c, JTable t, String p) {
     
       String sql ="";
        switch (p) {
            case "FECHA":
                sql = "SELECT * FROM ADMINISTRADOR_P4.DENT_CITAS WHERE CITA_FECHA='"+c.getCita_fecha()+"' ORDER BY 1";
                break;
            case "CLIENTES":
                sql = "SELECT * FROM ADMINISTRADOR_P4.DENT_CITAS WHERE CITA_PER_CODIGO_CLIENTE="+ c.getCita_codigoCliente()+" ORDER BY 1";
                break;
                
            case "CANCELADAS":
                sql = "SELECT * FROM ADMINISTRADOR_P4.DENT_CITAS WHERE CITA_ESTADO='C' ORDER BY 1";
                break;
            default:
                break;
        }
        
        DefaultTableModel model;
      System.out.println(sql);
        String[] columnas = {"ID", "FECHA", "HORA", "ESTADO","ID_PERSONA","ID_ODONTOLOGO"};
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

            JOptionPane.showMessageDialog(null, "No se puede mostrar la tabla: "+e.getMessage());
            System.out.println("ERROR BUSQUEDA: "+e.getMessage());
        }
        
    }
      
      public void listarCitas (Connection con, JTable t){
      String sql ="";
      sql = "SELECT * FROM ADMINISTRADOR_P4.DENT_SERVICIOS ORDER BY 1";
         DefaultTableModel model;
      System.out.println(sql);
         String[] columnas = {"ID", "FECHA", "HORA", "ESTADO","ID_PERSONA","ID_ODONTOLOGO"};
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

            JOptionPane.showMessageDialog(null, "No se puede mostrar la tabla: "+e.getMessage());
            System.out.println("ERROR BUSQUEDA: "+e.getMessage());
        }
        
      }
    public boolean isSQLExistC(Connection con, Date fecha, String hora) {//Método el cual verifica si existe dicho servicio ya existe
        PreparedStatement pst;
        boolean res = false;
        String verificar = "SELECT CITA_CODIGO FROM ADMINISTRADOR_P4.DENT_CITAS WHERE CITA_FECHA='"+fecha+"' AND CITA_HORA='"+hora+"'";
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
      public boolean isSQLExistCancel(Connection con, Date fecha, String hora) {//Método el cual verifica si la cita esta cancelada para poder ser generada
        PreparedStatement pst;
        boolean res = false;
        String verificar = "SELECT CITA_CODIGO FROM ADMINISTRADOR_P4.DENT_CITAS WHERE CITA_FECHA='"+fecha+"' AND CITA_HORA='"+hora+"'AND CITA_ESTADO='C'";
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
       public boolean isSQLExist(Connection con, int id) {//Método el cual verifica si la cita existe
        PreparedStatement pst;
        boolean res = false;
        String verificar = "SELECT CITA_CODIGO FROM ADMINISTRADOR_P4.DENT_CITAS WHERE CITA_codigo="+id;
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
