package com.example.suits_lb.modelos;

import java.io.Serializable;
import java.util.Objects;

public class CategoriaRopa implements Serializable {
    private String codCategory;
    private String nomCategory;


    public CategoriaRopa(String codCategory, String nomCategory) {
        this.codCategory = codCategory;
        this.nomCategory = nomCategory;
    }

    public String getCodCategory() {
        return codCategory;
    }

    public void setCodCategory(String codCategory) {
        this.codCategory = codCategory;
    }

    public String getNomCategory() {
        return nomCategory;
    }

    public void setNomCategory(String nomCategory) {
        this.nomCategory = nomCategory;
    }

    @Override
    public String toString() {
        return "CategoriaRopa{" +
                "codCategory='" + codCategory + '\'' +
                ", nomCategory='" + nomCategory + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoriaRopa that = (CategoriaRopa) o;
        return Objects.equals(codCategory, that.codCategory) && Objects.equals(nomCategory, that.nomCategory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codCategory, nomCategory);
    }
}
