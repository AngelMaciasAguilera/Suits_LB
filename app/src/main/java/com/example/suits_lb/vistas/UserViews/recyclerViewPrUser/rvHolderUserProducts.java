package com.example.suits_lb.vistas.UserViews.recyclerViewPrUser;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.suits_lb.R;
import com.example.suits_lb.modelos.Producto;
import com.example.suits_lb.vistas.AdminViews.AdminProductsView.recyclerView.ListaProductoAdapter;
import com.example.suits_lb.vistas.pantallasCarga.SplashCargaProductos;

public class rvHolderUserProducts extends RecyclerView.ViewHolder implements View.OnClickListener{
    private TextView tvwNombreProducto;
    private TextView tvwPrecioProducto;
    private ImageView imgrvProducto;
    private listaUserProductsAdapter lpa;

    public rvHolderUserProducts(@NonNull View itemView, listaUserProductsAdapter lpa) {
        super(itemView);
        tvwNombreProducto = (TextView) itemView.findViewById(R.id.nombreProductoUserView);
        tvwPrecioProducto = (TextView) itemView.findViewById(R.id.precioProductoUserView);
        imgrvProducto = (ImageView) itemView.findViewById(R.id.imgrvUserProductView);
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

    public ImageView getImgrvProducto() {
        return imgrvProducto;
    }

    public void setImgrvProducto(ImageView imgrvProducto) {
        this.imgrvProducto = imgrvProducto;
    }

    public listaUserProductsAdapter getLpa() {
        return lpa;
    }

    public void setLpa(listaUserProductsAdapter lpa) {
        this.lpa = lpa;
    }



    @Override
    public void onClick(View v) {
        int posicion = getLayoutPosition();
        Producto p = lpa.getProductos().get(posicion);
        /*Intent intent = new Intent(lpa.getContexto(), .class);
        intent.putExtra("producto",p);
        lpa.getContexto().startActivity(intent);*/
    }
}
