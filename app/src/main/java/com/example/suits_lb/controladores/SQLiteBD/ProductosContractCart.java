package com.example.suits_lb.controladores.SQLiteBD;

public class ProductosContractCart {
    private ProductosContractCart(){}

    public static class AuxCarritoEntries{
        public static final String TABLE_NAME = "carritoUser";
        public static final String COLUMN_CODROPA = "codRopa";
        public static final String COLUMN_EMAIL = "email";
        public static final String COLUMN_CANTIDAD = "cantidad";
        public static final String COLUMN_PRECIO = "precio";
    }
}
