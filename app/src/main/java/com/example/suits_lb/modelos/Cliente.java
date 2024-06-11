package com.example.suits_lb.modelos;

import java.io.Serializable;
import java.util.Objects;

public class Cliente implements Serializable {
    private String email;
    private String password;
    private String nombre;
    private int telefono;
    private int edad;
    private String esAdmin;

    public Cliente(String email, String password, String nombre, int telefono, String esAdmin, int edad) {
        this.email = email;
        this.password = password;
        this.nombre = nombre;
        this.telefono = telefono;
        this.esAdmin = esAdmin;
        this.edad = edad;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getEsAdmin() {
        return esAdmin;
    }

    public void setEsAdmin(String esAdmin) {
        this.esAdmin = esAdmin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return telefono == cliente.telefono && Objects.equals(email, cliente.email) && Objects.equals(password, cliente.password) && Objects.equals(nombre, cliente.nombre) && Objects.equals(esAdmin, cliente.esAdmin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, password, nombre, telefono, esAdmin);
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", nombre='" + nombre + '\'' +
                ", telefono=" + telefono +
                ", esAdmin='" + esAdmin + '\'' +
                '}';
    }
}
