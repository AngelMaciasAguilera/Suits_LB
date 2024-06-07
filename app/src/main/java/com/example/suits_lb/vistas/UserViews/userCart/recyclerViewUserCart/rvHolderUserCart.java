package com.example.suits_lb.vistas.UserViews.userCart.recyclerViewUserCart;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.suits_lb.R;

public class rvHolderUserCart extends RecyclerView.ViewHolder implements View.OnClickListener{
    private TextView tvwNombreProducto;
    private TextView tvwCantidadProducto;
    private TextView tvwSubtotalProducto;
    private ImageView imgrvCartProducto;
    private listaUserCartAdapter luca;

    public rvHolderUserCart(@NonNull View itemView , listaUserCartAdapter luca) {
        super(itemView);
        tvwNombreProducto = (TextView) itemView.findViewById(R.id.nombreProductoUserView_cartView);
        tvwCantidadProducto = (TextView) itemView.findViewById(R.id.cantidadProductoUserView_cartView);
        tvwSubtotalProducto = (TextView) itemView.findViewById(R.id.subtotalUserProductView__cartView);
        imgrvCartProducto = (ImageView) itemView.findViewById(R.id.imgrvUserProductView_cartView);
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

    }

    public TextView getTvwNombreProducto() {
        return tvwNombreProducto;
    }

    public void setTvwNombreProducto(TextView tvwNombreProducto) {
        this.tvwNombreProducto = tvwNombreProducto;
    }

    public TextView getTvwCantidadProducto() {
        return tvwCantidadProducto;
    }

    public void setTvwCantidadProducto(TextView tvwCantidadProducto) {
        this.tvwCantidadProducto = tvwCantidadProducto;
    }

    public TextView getTvwSubtotalProducto() {
        return tvwSubtotalProducto;
    }

    public void setTvwSubtotalProducto(TextView tvwSubtotalProducto) {
        this.tvwSubtotalProducto = tvwSubtotalProducto;
    }

    public ImageView getImgrvCartProducto() {
        return imgrvCartProducto;
    }

    public void setImgrvCartProducto(ImageView imgrvCartProducto) {
        this.imgrvCartProducto = imgrvCartProducto;
    }

    public listaUserCartAdapter getLuca() {
        return luca;
    }

    public void setLuca(listaUserCartAdapter luca) {
        this.luca = luca;
    }
}
