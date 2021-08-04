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
public class FacturasDetalles {

    private int fdet_codigo;
    private int fdet_cantidad;
    private double fdet_precioUnitario;
    private double fdet_subtotal;
    private double fdet_iva;
    private double fdet_total;
    private int fdet_numFactura;
    private int fdet_codigoServicios;

    public FacturasDetalles() {
    }

    public FacturasDetalles(int fdet_codigo, int fdet_cantidad, double fdet_precioUnitario,
            double fdet_subtotal, double fdet_iva, double fdet_total, int fdet_numFactura, int fdet_codigoServicios) {
        this.fdet_codigo = fdet_codigo;
        this.fdet_cantidad = fdet_cantidad;
        this.fdet_precioUnitario = fdet_precioUnitario;
        this.fdet_subtotal = fdet_subtotal;
        this.fdet_iva = fdet_iva;
        this.fdet_total = fdet_total;
        this.fdet_numFactura = fdet_numFactura;
        this.fdet_codigoServicios = fdet_codigoServicios;
    }

    public int getFdet_codigo() {
        return fdet_codigo;
    }

    public void setFdet_codigo(int fdet_codigo) {
        this.fdet_codigo = fdet_codigo;
    }

    public int getFdet_cantidad() {
        return fdet_cantidad;
    }

    public void setFdet_cantidad(int fdet_cantidad) {
        this.fdet_cantidad = fdet_cantidad;
    }

    public double getFdet_precioUnitario() {
        return fdet_precioUnitario;
    }

    public void setFdet_precioUnitario(double fdet_precioUnitario) {
        this.fdet_precioUnitario = fdet_precioUnitario;
    }

    public double getFdet_subtotal() {
        return fdet_subtotal;
    }

    public void setFdet_subtotal(double fdet_subtotal) {
        this.fdet_subtotal = fdet_subtotal;
    }

    public double getFdet_iva() {
        return fdet_iva;
    }

    public void setFdet_iva(double fdet_iva) {
        this.fdet_iva = fdet_iva;
    }

    public double getFdet_total() {
        return fdet_total;
    }

    public void setFdet_total(double fdet_total) {
        this.fdet_total = fdet_total;
    }

    public int getFdet_numFactura() {
        return fdet_numFactura;
    }

    public void setFdet_numFactura(int fdet_numFactura) {
        this.fdet_numFactura = fdet_numFactura;
    }

    public int getFdet_codigoServicios() {
        return fdet_codigoServicios;
    }

    public void setFdet_codigoServicios(int fdet_codigoServicios) {
        this.fdet_codigoServicios = fdet_codigoServicios;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FacturasDetalles{fdet_codigo=").append(fdet_codigo);
        sb.append(", fdet_cantidad=").append(fdet_cantidad);
        sb.append(", fdet_precioUnitario=").append(fdet_precioUnitario);
        sb.append(", fdet_subtotal=").append(fdet_subtotal);
        sb.append(", fdet_iva=").append(fdet_iva);
        sb.append(", fdet_total=").append(fdet_total);
        sb.append(", fdet_numFactura=").append(fdet_numFactura);
        sb.append(", fdet_codigoServicios").append(fdet_codigoServicios);
        sb.append('}');
        return sb.toString();
    }

}
