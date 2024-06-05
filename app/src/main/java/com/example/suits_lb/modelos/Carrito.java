package com.example.suits_lb.modelos;

public class Carrito {
    private String codRopa,email;

    private Integer cantidad;

    private Double subtotal;

    public Carrito(String codRopa, String email, Integer cantidad, Double subtotal) {
        this.codRopa = codRopa;
        this.email = email;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
    }

    public String getCodRopa() {
        return codRopa;
    }

    public void setCodRopa(String codRopa) {
        this.codRopa = codRopa;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
    public String toString() {
        return "Carrito{" +
                "codRopa='" + codRopa + '\'' +
                ", email='" + email + '\'' +
                ", cantidad=" + cantidad +
                ", subtotal=" + subtotal +
                '}';
    }




}
