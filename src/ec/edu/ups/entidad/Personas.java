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
public class Personas {

    private int per_codigo;
    private String per_cedula;
    private String per_nombre;
    private String per_apellidos;
    private String per_direccion;
    private String per_telefono;
    private String per_correo;
    private char per_rol;
    private char per_estado;

    public Personas() {
    }

    public Personas(int per_codigo, String per_cedula, String per_nombre, String per_apellidos, String per_direccion, String per_telefono, String per_correo, char per_rol, char per_estado) {
        this.per_codigo = per_codigo;
        this.per_cedula = per_cedula;
        this.per_nombre = per_nombre;
        this.per_apellidos = per_apellidos;
        this.per_direccion = per_direccion;
        this.per_telefono = per_telefono;
        this.per_correo = per_correo;
        this.per_rol = per_rol;
        this.per_estado = per_estado;
    }

    public int getPer_codigo() {
        return per_codigo;
    }

    public void setPer_codigo(int per_codigo) {
        this.per_codigo = per_codigo;
    }

    public String getPer_cedula() {
        return per_cedula;
    }

    public void setPer_cedula(String per_cedula) {
        this.per_cedula = per_cedula;
    }

    public String getPer_nombre() {
        return per_nombre;
    }

    public void setPer_nombre(String per_nombre) {
        this.per_nombre = per_nombre;
    }

    public String getPer_apellidos() {
        return per_apellidos;
    }

    public void setPer_apellidos(String per_apellidos) {
        this.per_apellidos = per_apellidos;
    }

    public String getPer_direccion() {
        return per_direccion;
    }

    public void setPer_direccion(String per_direccion) {
        this.per_direccion = per_direccion;
    }

    public String getPer_telefono() {
        return per_telefono;
    }

    public void setPer_telefono(String per_telefono) {
        this.per_telefono = per_telefono;
    }

    public String getPer_correo() {
        return per_correo;
    }

    public void setPer_correo(String per_correo) {
        this.per_correo = per_correo;
    }

    public char getPer_rol() {
        return per_rol;
    }

    public void setPer_rol(char per_rol) {
        this.per_rol = per_rol;
    }

    public char getPer_estado() {
        return per_estado;
    }

    public void setPer_estado(char per_estado) {
        this.per_estado = per_estado;
    }

    @Override
    public String toString() {
        return "Personas{" + "per_codigo=" + per_codigo + ", per_cedula=" + per_cedula + ", per_nombre=" + per_nombre + ", per_apellidos=" + per_apellidos + ", per_direccion=" + per_direccion + ", per_telefono=" + per_telefono + ", per_correo=" + per_correo + ", per_rol=" + per_rol + ", per_estado=" + per_estado + '}';
    }

}
