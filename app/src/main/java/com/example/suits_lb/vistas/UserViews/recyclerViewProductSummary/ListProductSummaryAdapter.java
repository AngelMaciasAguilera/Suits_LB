package com.example.suits_lb.vistas.UserViews.recyclerViewProductSummary;

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
import com.example.suits_lb.modelos.Carrito;
import com.example.suits_lb.vistas.UserViews.userCart.recyclerViewUserCart.rvHolderUserCart;

import java.util.ArrayList;


public class ListProductSummaryAdapter extends RecyclerView.Adapter<rvHolderUserProductSummary> {
    private Context contexto;
    private ArrayList<Carrito> carritoUser;
    private LayoutInflater inflate;

    public ListProductSummaryAdapter(Context contexto, ArrayList<Carrito> carritoUser) {
        this.contexto = contexto;
        this.carritoUser = carritoUser;
        this.inflate = LayoutInflater.from(this.contexto);
    }

    public Context getContexto() {
        return contexto;
    }

    public void setContexto(Context contexto) {
        this.contexto = contexto;
    }

    public ArrayList<Carrito> getCarritoUser() {
        return carritoUser;
    }

    public void setCarritoUser(ArrayList<Carrito> carritoUser) {
        this.carritoUser = carritoUser;
    }

    public LayoutInflater getInflate() {
        return inflate;
    }

    public void setInflate(LayoutInflater inflate) {
        this.inflate = inflate;
    }



    @NonNull
    @Override
    public rvHolderUserProductSummary onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View cartView = inflate.inflate(R.layout.product_view_minimized, parent, false);
        rvHolderUserProductSummary rph = new rvHolderUserProductSummary(cartView,this);
        return rph;
    }

    @Override
    public void onBindViewHolder(@NonNull rvHolderUserProductSummary holder, int position) {
        Carrito prodMin = carritoUser.get(position);
        byte[] bytesProductImage = ConversorImagenProducto.string_to_byte(prodMin.getImgProducto());
        Bitmap bitMapProdcutImage = ConversorImagenProducto.bytes_to_bitmap(bytesProductImage, conexionSuitsLbDB.ancho_imagen,conexionSuitsLbDB.alto_imagen);
        holder.getImgvwProductMIN().setImageBitmap(bitMapProdcutImage);
        holder.getTvwSubtotalMinProduct().setText(String.valueOf(prodMin.getSubtotal()) + "€");
        holder.getTvwStockMinProduct().setText(String.valueOf(prodMin.getCantidad()));
        holder.getTvwProductNameMIN().setText(prodMin.getNomRopa());
    }

    @Override
    public int getItemCount() {
        return carritoUser.size();
    }
}
