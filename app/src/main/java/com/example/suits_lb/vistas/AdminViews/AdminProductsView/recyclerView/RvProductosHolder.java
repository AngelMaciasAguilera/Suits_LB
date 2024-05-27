package com.example.suits_lb.vistas.AdminViews.AdminProductsView.recyclerView;

import android.content.Intent;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.suits_lb.R;
import com.example.suits_lb.modelos.Producto;
import com.example.suits_lb.vistas.AdminViews.AdminProductsView.ManagementProductScreen;
import com.example.suits_lb.vistas.pantallasCarga.SplashCargaProductos;

public class RvProductosHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    private TextView tvwNombreProducto;
    private TextView tvwPrecioProducto;
    private TextView tvwCantidadProducto;
    private ImageView imgrvProducto;
    private ListaProductoAdapter lpa;

    public RvProductosHolder(@NonNull View itemView, ListaProductoAdapter lpa) {
        super(itemView);
        tvwNombreProducto = (TextView) itemView.findViewById(R.id.nombreProducto);
        tvwPrecioProducto = (TextView) itemView.findViewById(R.id.precioProducto);
        tvwCantidadProducto = (TextView) itemView.findViewById(R.id.cantidadProducto);
        imgrvProducto = (ImageView) itemView.findViewById(R.id.imgrvProducto);
        this.lpa = lpa;
        itemView.setOnClickListener(this);
    }

    public TextView getTvwNombreProducto() {
        return tvwNombreProducto;
    }

    public void setTvwNombreProducto(TextView tvwNombreProducto) {
        this.tvwNombreProducto = tvwNombreProducto;
    }

    public TextView getTvwPrecioProducto() {
        return tvwPrecioProducto;
    }

    public void setTvwPrecioProducto(TextView tvwPrecioProducto) {
        this.tvwPrecioProducto = tvwPrecioProducto;
    }

    public TextView getTvwCantidadProducto() {
        return tvwCantidadProducto;
    }

    public void setTvwCantidadProducto(TextView tvwCantidadProducto) {
        this.tvwCantidadProducto = tvwCantidadProducto;
    }

    public ImageView getImgrvProducto() {
        return imgrvProducto;
    }

    public void setImgrvProducto(ImageView imgrvProducto) {
        this.imgrvProducto = imgrvProducto;
    }

    public ListaProductoAdapter getLpa() {
        return lpa;
    }

    public void setLpa(ListaProductoAdapter lpa) {
        this.lpa = lpa;
    }



    @Override
    public void onClick(View v) {
        int posicion = getLayoutPosition();
        Producto p = lpa.getProductos().get(posicion);
        Intent intent = new Intent(lpa.getContexto(), SplashCargaProductos.class);
        intent.putExtra("producto",p);
        lpa.getContexto().startActivity(intent);
    }
}
