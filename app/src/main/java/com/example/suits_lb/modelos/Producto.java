package com.example.suits_lb.modelos;

import java.io.Serializable;
import java.util.Objects;

public class Producto implements Serializable {
    private String codRopa;
    private String nombre;
    private String descripcion;
    private Double precio;
    private String catRopa;
    private String imgProducto;
    private String ventaDisponible;

    public Producto(String codRopa, String nombre, String descripcion, Double precio, String catRopa, String imgProducto, String ventaDisponible) {
        this.codRopa = codRopa;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.catRopa = catRopa;
        this.imgProducto = imgProducto;
        this.ventaDisponible = ventaDisponible;
    }

    public String getVentaDisponible() {
        return ventaDisponible;
    }

    public void setVentaDisponible(String ventaDisponible) {
        this.ventaDisponible = ventaDisponible;
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
        return Objects.equals(getCodRopa(), producto.getCodRopa()) && Objects.equals(getNombre(), producto.getNombre()) && Objects.equals(getDescripcion(), producto.getDescripcion()) && Objects.equals(getPrecio(), producto.getPrecio()) && Objects.equals(getCatRopa(), producto.getCatRopa()) && Objects.equals(getImgProducto(), producto.getImgProducto()) && Objects.equals(getVentaDisponible(), producto.getVentaDisponible());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCodRopa(), getNombre(), getDescripcion(), getPrecio(), getCatRopa(), getImgProducto());
    }

    @Override
    public String toString() {
        return "Producto{" +
                "codRopa='" + codRopa + '\'' +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", precio=" + precio +
                ", catRopa='" + catRopa + '\'' +
                ", imgProducto='" + imgProducto + '\'' +
                ", ventaDisponible='" + ventaDisponible + '\'' +
                '}';
    }
}
