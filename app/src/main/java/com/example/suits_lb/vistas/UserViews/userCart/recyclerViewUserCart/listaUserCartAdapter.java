package com.example.suits_lb.vistas.UserViews.userCart.recyclerViewUserCart;

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
import com.example.suits_lb.modelos.Producto;
import com.example.suits_lb.vistas.UserViews.recyclerViewPrUser.rvHolderUserProducts;

import java.util.ArrayList;

public class listaUserCartAdapter extends RecyclerView.Adapter<rvHolderUserCart>{

    private Context contexto;
    private ArrayList<Carrito> carritoUser;
    private LayoutInflater inflate;


    public listaUserCartAdapter(Context contexto, ArrayList<Carrito> carrito) {
        this.contexto = contexto;
        this.carritoUser = carrito;
        inflate = LayoutInflater.from(this.contexto);
    }


    @NonNull
    @Override
    public rvHolderUserCart onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View cartView = inflate.inflate(R.layout.single_cart_view, parent, false);
        rvHolderUserCart rph = new rvHolderUserCart(cartView,this);
        return rph;
    }

    @Override
    public void onBindViewHolder(@NonNull rvHolderUserCart holder, int position) {
        Carrito cartProduct = this.carritoUser.get(position);
        //----------------------------------------------------------------------
        //Obtenemos la imagen y la seteamos a la vista del cartProduct solo
        byte[] bytesProductImage = ConversorImagenProducto.string_to_byte(cartProduct.getImgProducto());
        Bitmap bitMapProdcutImage = ConversorImagenProducto.bytes_to_bitmap(bytesProductImage, conexionSuitsLbDB.ancho_imagen,conexionSuitsLbDB.alto_imagen);
        holder.getImgrvCartProducto().setImageBitmap(bitMapProdcutImage);
        holder.getTvwSubtotalProducto().setText(String.valueOf(cartProduct.getSubtotal()));
        holder.getTvwCantidadProducto().setText(String.valueOf(cartProduct.getCantidad()));
        holder.getTvwNombreProducto().setText(cartProduct.getNomRopa());
    }



    @Override
    public int getItemCount() {
        return carritoUser.size();
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
}
