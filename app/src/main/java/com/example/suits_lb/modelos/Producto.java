package com.example.suits_lb.modelos;

import java.util.Objects;

public class Producto {
    private String codRopa;
    private String nombre;
    private String descripcion;
    private Double precio;
    private String catRopa;
    private int stock;
    private String imgProducto;


    public Producto(String codRopa, String nombre, String descripcion, Double precio, String catRopa, int stock, String imgProducto) {
        this.codRopa = codRopa;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.catRopa = catRopa;
        this.stock = stock;
        this.imgProducto = imgProducto;
    }

    public String getCodRopa() {
        return codRopa;
    }

    public void setCodRopa(String codRopa) {
        this.codRopa = codRopa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getCatRopa() {
        return catRopa;
    }

    public void setCatRopa(String catRopa) {
        this.catRopa = catRopa;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getImgProducto() {
        return imgProducto;
    }

    public void setImgProducto(String imgProducto) {
        this.imgProducto = imgProducto;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Producto)) return false;
        Producto producto = (Producto) o;
        return getStock() == producto.getStock() && Objects.equals(getCodRopa(), producto.getCodRopa()) && Objects.equals(getNombre(), producto.getNombre()) && Objects.equals(getDescripcion(), producto.getDescripcion()) && Objects.equals(getPrecio(), producto.getPrecio()) && Objects.equals(getCatRopa(), producto.getCatRopa()) && Objects.equals(getImgProducto(), producto.getImgProducto());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCodRopa(), getNombre(), getDescripcion(), getPrecio(), getCatRopa(), getStock(), getImgProducto());
    }

    @Override
    public String toString() {
        return "Producto{" +
                "codRopa='" + codRopa + '\'' +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", precio=" + precio +
                ", catRopa='" + catRopa + '\'' +
                ", stock=" + stock +
                ", imgProducto='" + imgProducto + '\'' +
                '}';
    }
}
