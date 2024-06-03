package com.example.suits_lb.controladores.SQLiteBD;

public class ProductosContractUser {
    private ProductosContractUser(){}

    public static class AuxProductosEntries{
        public static final String TABLE_NAME = "productosUser";
        public static final String COLUMN_CODROPA = "codRopa";
        public static final String COLUMN_NOMBREROPA = "nombreRopa";
        public static final String COLUMN_DESCRIPCION = "descripcion";
        public static final String COLUMN_PRECIO = "precio";
        public static final String COLUMN_CATEGORIA = "categoria";
        public static final String COLUMN_STOCK = "stock";
        public static final String COLUMN_IMGPRODUCTO = "imgProducto";
        public static final String COLUMN_VENTADISPONIBLE = "ventaDisponible";
    }
}
