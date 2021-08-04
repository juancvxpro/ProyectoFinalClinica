/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.entidad;

import java.util.Date;

/**
 *
 * @author user
 */
public class Citas {

    private int cita_codigo;
    private Date cita_fecha;
    private String cita_hora;
    private char estado;
    private int cita_codigoCliente;
    private int cita_codigoEmpleadoO;

    public Citas() {
    }

    public Citas(int cita_codigo, Date cita_fecha, String cita_hora, char estado, int cita_codigoCliente, int cita_codigoEmpleadoO) {
        this.cita_codigo = cita_codigo;
        this.cita_fecha = cita_fecha;
        this.cita_hora = cita_hora;
        this.estado = estado;
        this.cita_codigoCliente = cita_codigoCliente;
        this.cita_codigoEmpleadoO = cita_codigoEmpleadoO;
    }

    public int getCita_codigoCliente() {
        return cita_codigoCliente;
    }

    public void setCita_codigoCliente(int cita_codigoCliente) {
        this.cita_codigoCliente = cita_codigoCliente;
    }

    public int getCita_codigoEmpleadoO() {
        return cita_codigoEmpleadoO;
    }

    public void setCita_codigoEmpleadoO(int cita_codigoEmpleadoO) {
        this.cita_codigoEmpleadoO = cita_codigoEmpleadoO;
    }

    public int getCita_codigo() {
        return cita_codigo;
    }

    public void setCita_codigo(int cita_codigo) {
        this.cita_codigo = cita_codigo;
    }

    public Date getCita_fecha() {
        return cita_fecha;
    }

    public void setCita_fecha(Date cita_fecha) {
        this.cita_fecha = cita_fecha;
    }

    public String getCita_hora() {
        return cita_hora;
    }

    public void setCita_hora(String cita_hora) {
        this.cita_hora = cita_hora;
    }

    public char getEstado() {
        return estado;
    }

    public void setEstado(char estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Citas{cita_codigo=").append(cita_codigo);
        sb.append(", cita_fecha=").append(cita_fecha);
        sb.append(", cita_hora=").append(cita_hora);
        sb.append(", estado=").append(estado);
        sb.append('}');
        return sb.toString();
    }

}
