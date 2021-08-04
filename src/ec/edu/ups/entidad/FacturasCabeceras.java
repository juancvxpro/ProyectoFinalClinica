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
public class FacturasCabeceras {

    private int fac_num;
    private Date fac_fecha;
    private double fac_subtotal;
    private double fac_iva;
    private double fac_total;
    private int fac_codigo_empleado;
    private int fac_codigo_cliente;

    public FacturasCabeceras(int fac_num, Date fac_fecha, double fac_subtotal, double fac_iva, double fac_total, int fac_codigo_empleado, int fac_codigo_cliente) {
        this.fac_num = fac_num;
        this.fac_fecha = fac_fecha;
        this.fac_subtotal = fac_subtotal;
        this.fac_iva = fac_iva;
        this.fac_total = fac_total;
        this.fac_codigo_empleado = fac_codigo_empleado;
        this.fac_codigo_cliente = fac_codigo_cliente;
    }

    public FacturasCabeceras() {
    }

    public void setFac_num(int fac_num) {
        this.fac_num = fac_num;
    }

    public void setFac_fecha(Date fac_fecha) {
        this.fac_fecha = fac_fecha;
    }

    public void setFac_subtotal(double fac_subtotal) {
        this.fac_subtotal = fac_subtotal;
    }

    public void setFac_iva(double fac_iva) {
        this.fac_iva = fac_iva;
    }

    public void setFac_total(double fac_total) {
        this.fac_total = fac_total;
    }

    public void setFac_codigo_empleado(int fac_codigo_empleado) {
        this.fac_codigo_empleado = fac_codigo_empleado;
    }

    public void setFac_codigo_cliente(int fac_codigo_cliente) {
        this.fac_codigo_cliente = fac_codigo_cliente;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FacturasCabeceras{fac_num=").append(fac_num);
        sb.append(", fac_fecha=").append(fac_fecha);
        sb.append(", fac_subtotal=").append(fac_subtotal);
        sb.append(", fac_iva=").append(fac_iva);
        sb.append(", fac_total=").append(fac_total);
        sb.append(", fac_codigo_empleado=").append(fac_codigo_empleado);
        sb.append(", fac_codigo_cliente=").append(fac_codigo_cliente);
        sb.append('}');
        return sb.toString();
    }

}
