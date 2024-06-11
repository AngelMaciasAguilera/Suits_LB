package com.example.suits_lb.vistas.UserViews.recyclerViewOrderSummary;


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
import com.example.suits_lb.modelos.Pedido;
import java.util.ArrayList;

public class ListaOrdersAdapter extends RecyclerView.Adapter<rvHolderUserOrders>{

    private Context contexto;
    private ArrayList<Pedido> userOrders;
    private LayoutInflater inflate;

    public ListaOrdersAdapter(Context contexto, ArrayList<Pedido> userOrders) {
        this.contexto = contexto;
        this.userOrders = userOrders;
        this.inflate = LayoutInflater.from(this.contexto);
    }

    @NonNull
    @Override
    public rvHolderUserOrders onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View cartView = inflate.inflate(R.layout.user_order_view, parent, false);
        rvHolderUserOrders huo = new rvHolderUserOrders(cartView,this);
        return huo;
    }

    @Override
    public void onBindViewHolder(@NonNull rvHolderUserOrders holder, int position) {
        Pedido order = userOrders.get(position);
        holder.getTvwOrderConcept().setText(order.getConcepto());
        holder.getTvwOrderQuantity().setText(String.valueOf(order.getCantidad()));
        holder.getTvwOrderDirection().setText(order.getDireccion());
        holder.getTvwSubtotalOrder().setText(String.valueOf(order.getSubtotal()) + "€");
        holder.getTvwDateOrder().setText(order.getFechaEstimadaEntrega());
    }

    @Override
    public int getItemCount() {
        return userOrders.size();
    }

    public Context getContexto() {
        return contexto;
    }

    public void setContexto(Context contexto) {
        this.contexto = contexto;
    }

    public ArrayList<Pedido> getUserOrders() {
        return userOrders;
    }

    public void setUserOrders(ArrayList<Pedido> userOrders) {
        this.userOrders = userOrders;
    }

    public LayoutInflater getInflate() {
        return inflate;
    }

    public void setInflate(LayoutInflater inflate) {
        this.inflate = inflate;
    }
}
