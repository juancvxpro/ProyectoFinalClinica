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
public class Servicios {

    private int ser_codigo;
    private String ser_nombre;
    private double ser_precio;
    private double ser_iva;

    public Servicios() {
    }

    public Servicios(int ser_codigo, String ser_nombre, double ser_precio, double ser_iva) {
        this.ser_codigo = ser_codigo;
        this.ser_nombre = ser_nombre;
        this.ser_precio = ser_precio;
        this.ser_iva = ser_iva;
    }

    public int getSer_codigo() {
        return ser_codigo;
    }

    public void setSer_codigo(int ser_codigo) {
        this.ser_codigo = ser_codigo;
    }

    public String getSer_nombre() {
        return ser_nombre;
    }

    public void setSer_nombre(String ser_nombre) {
        this.ser_nombre = ser_nombre;
    }

    public double getSer_precio() {
        return ser_precio;
    }

    public void setSer_precio(double ser_precio) {
        this.ser_precio = ser_precio;
    }

    public double getSer_iva() {
        return ser_iva;
    }

    public void setSer_iva(double ser_iva) {
        this.ser_iva = ser_iva;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Servicios{ser_codigo=").append(ser_codigo);
        sb.append(", ser_nombre=").append(ser_nombre);
        sb.append(", ser_precio=").append(ser_precio);
        sb.append(", ser_iva=").append(ser_iva);
        sb.append('}');
        return sb.toString();
    }

}
