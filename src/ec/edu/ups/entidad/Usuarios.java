/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.entidad;

/**
 *
 * @author user
 */
public class Usuarios {

    private int usu_codigo;
    private String usu_nombre;
    private String usu_contra;
    private char usu_rol;

    private int usu_codigo_empleado;

    public Usuarios() {
    }

    public Usuarios(int usu_codigo, String usu_nombre, String usu_contra, char usu_rol, int usu_codigo_empleado) {
        this.usu_codigo = usu_codigo;
        this.usu_nombre = usu_nombre;
        this.usu_contra = usu_contra;
        this.usu_rol = usu_rol;
        this.usu_codigo_empleado = usu_codigo_empleado;
    }

    public int getUsu_codigo() {
        return usu_codigo;
    }

    public void setUsu_codigo(int usu_codigo) {
        this.usu_codigo = usu_codigo;
    }

    public String getUsu_nombre() {
        return usu_nombre;
    }

    public void setUsu_nombre(String usu_nombre) {
        this.usu_nombre = usu_nombre;
    }

    public String getUsu_contra() {
        return usu_contra;
    }

    public void setUsu_contra(String usu_contra) {
        this.usu_contra = usu_contra;
    }

    public char getUsu_rol() {
        return usu_rol;
    }

    public void setUsu_rol(char usu_rol) {
        this.usu_rol = usu_rol;
    }


    public int getUsu_codigo_empleado() {
        return usu_codigo_empleado;
    }

    public void setUsu_codigo_empleado(int usu_codigo_empleado) {
        this.usu_codigo_empleado = usu_codigo_empleado;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Usuarios{usu_codigo=").append(usu_codigo);
        sb.append(", usu_nombre=").append(usu_nombre);
        sb.append(", usu_contra=").append(usu_contra);
        sb.append(", usu_rol=").append(usu_rol);
        sb.append('}');
        return sb.toString();
    }

}
