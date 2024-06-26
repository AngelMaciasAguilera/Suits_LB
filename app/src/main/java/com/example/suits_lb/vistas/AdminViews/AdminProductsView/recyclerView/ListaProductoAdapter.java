package com.example.suits_lb.vistas.AdminViews.AdminProductsView.recyclerView;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.suits_lb.R;
import com.example.suits_lb.controladores.ConversorImagenProducto;
import com.example.suits_lb.controladores.conexionSuitsLbDB;
import com.example.suits_lb.modelos.Cliente;
import com.example.suits_lb.modelos.Producto;
import com.example.suits_lb.vistas.AdminViews.AdminAdminsView.recyclerView.RvAdminsHolder;

import java.util.ArrayList;

public class ListaProductoAdapter extends RecyclerView.Adapter<RvProductosHolder>{

    private Context contexto;
    private ArrayList<Producto> productos;

    private LayoutInflater inflate;


    public ListaProductoAdapter(Context contexto, ArrayList<Producto> productos) {
        this.contexto = contexto;
        this.productos = productos;
        inflate = LayoutInflater.from(this.contexto);
    }

    public Context getContexto() {
        return contexto;
    }

    public void setContexto(Context contexto) {
        this.contexto = contexto;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }

    public LayoutInflater getInflate() {
        return inflate;
    }

    public void setInflate(LayoutInflater inflate) {
        this.inflate = inflate;
    }

    @NonNull
    @Override
    public RvProductosHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View productView = inflate.inflate(R.layout.single_product_view_be, parent, false);
        RvProductosHolder rph = new RvProductosHolder(productView, this);
        return rph;
    }

    @Override
    public void onBindViewHolder(@NonNull RvProductosHolder holder, int position) {
        Producto producto = this.getProductos().get(position);
        //----------------------------------------------------------------------
        //Obtenemos la imagen y la seteamos a la vista del producto solo
        byte[] bytesProductImage = ConversorImagenProducto.string_to_byte(producto.getImgProducto());
        Bitmap bitMapProdcutImage = ConversorImagenProducto.bytes_to_bitmap(bytesProductImage, conexionSuitsLbDB.ancho_imagen,conexionSuitsLbDB.alto_imagen);
        holder.getImgrvProducto().setImageBitmap(bitMapProdcutImage);
        holder.getTvwPrecioProducto().setText(String.valueOf(producto.getPrecio()) + "€");
        holder.getTvwNombreProducto().setText(producto.getNombre());
        //---------------------------------------------------------------------

    }

    @Override
    public int getItemCount() {
        return productos.size();
    }

}
