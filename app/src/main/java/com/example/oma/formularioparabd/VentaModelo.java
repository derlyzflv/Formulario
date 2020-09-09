package com.example.oma.formularioparabd;

public class VentaModelo {
    private String codigo,nombre,fecha,producto,cantidad,total;


    public VentaModelo() {
    }

    public VentaModelo(String codigo, String nombre, String fecha, String producto, String cantidad, String total) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.fecha = fecha;
        this.producto = producto;
        this.cantidad = cantidad;
        this.total = total;

    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }


}
