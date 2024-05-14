package com.example.suits_lb.vistas.AdminViews.AdminAdminsView.recyclerView;

import android.content.Intent;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.marketplace.R;
import com.example.marketplace.controladores.ConversorImagenProducto;
import com.example.marketplace.modelos.Producto;
import com.example.marketplace.vistas.MainScreen;
import com.example.marketplace.vistas.MainScreenApp;
import com.example.marketplace.vistas.ManagementProductScreen;

public class RvAdminsHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    public static final String EXTRA_DETALLES_PRODUCTO = "es.com.example.marketplace.vistas.ManagementProductScreen.producto";
    public static final String EXTRA_IMAGEN2_PRODUCTO = "es.com.example.marketplace.vistas.ManagementProductScreen.imagen";
    private TextView tvwNombreProducto;
    private TextView tvwPrecioProducto;
    private String email;
    private ImageView imgrvProducto;
    private FotosProductosAdapter fpa;

    public RvAdminsHolder(@NonNull View itemView, FotosProductosAdapter fpa, String email) {
        super(itemView);
        tvwNombreProducto = (TextView) itemView.findViewById(R.id.nombreProducto);
        tvwPrecioProducto = (TextView) itemView.findViewById(R.id.precioProducto);
        imgrvProducto = (ImageView) itemView.findViewById(R.id.imgrvProducto);
        this.fpa = fpa;
        this.email = email;
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

    public FotosProductosAdapter getFpa() {
        return fpa;
    }

    public void setFpa(FotosProductosAdapter fpa) {
        this.fpa = fpa;
    }

    @Override
    public void onClick(View view) {
        int posicion = getLayoutPosition();
        Producto p = fpa.getProductos().get(posicion);
        Intent intent = new Intent(fpa.getContexto(), ManagementProductScreen.class);
        intent.putExtra(EXTRA_DETALLES_PRODUCTO,p);
        imgrvProducto.buildDrawingCache();
        Bitmap foto_bm = imgrvProducto.getDrawingCache();
        byte[] fotobytes = ConversorImagenProducto.bitmap_to_bytes_png(foto_bm);
        intent.putExtra(EXTRA_IMAGEN2_PRODUCTO,fotobytes );
        intent.putExtra("Email",this.email);
        fpa.getContexto().startActivity(intent);

    }
}
