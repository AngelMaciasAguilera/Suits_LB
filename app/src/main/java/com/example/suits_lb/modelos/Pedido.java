package com.example.suits_lb.modelos;

import java.io.Serializable;
import java.util.Objects;

public class Pedido implements Serializable {
    private String email,codRopa,concepto,direccion, estado;
    private Integer cantidad,numPedido;
    private Double subtotal;

    public Pedido(String email, String codRopa, String concepto, String direccion, String estado, Integer cantidad, Double subtotal) {
        this.email = email;
        this.codRopa = codRopa;
        this.concepto = concepto;
        this.direccion = direccion;
        this.estado = estado;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
    }

    public Pedido(String email, String codRopa, String concepto, String direccion, String estado, Integer cantidad, Integer numPedido, Double subtotal) {
        this.email = email;
        this.codRopa = codRopa;
        this.concepto = concepto;
        this.direccion = direccion;
        this.estado = estado;
        this.cantidad = cantidad;
        this.numPedido = numPedido;
        this.subtotal = subtotal;
    }

    public Integer getNumPedido() {
        return numPedido;
    }

    public void setNumPedido(Integer numPedido) {
        this.numPedido = numPedido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCodRopa() {
        return codRopa;
    }

    public void setCodRopa(String codRopa) {
        this.codRopa = codRopa;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pedido)) return false;
        Pedido pedido = (Pedido) o;
        return Objects.equals(getEmail(), pedido.getEmail()) && Objects.equals(getCodRopa(), pedido.getCodRopa()) && Objects.equals(getConcepto(), pedido.getConcepto()) && Objects.equals(getDireccion(), pedido.getDireccion()) && Objects.equals(getEstado(), pedido.getEstado()) && Objects.equals(getCantidad(), pedido.getCantidad()) && Objects.equals(getSubtotal(), pedido.getSubtotal());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEmail(), getCodRopa(), getConcepto(), getDireccion(), getEstado(), getCantidad(), getSubtotal());
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "email='" + email + '\'' +
                ", codRopa='" + codRopa + '\'' +
                ", concepto='" + concepto + '\'' +
                ", direccion='" + direccion + '\'' +
                ", fechaEstimadaEntrega='" + estado + '\'' +
                ", cantidad=" + cantidad +
                ", subtotal=" + subtotal +
                '}';
    }
}
