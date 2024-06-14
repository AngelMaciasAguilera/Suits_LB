package com.example.suits_lb.vistas.AdminViews.AdminOrderStatus.recyclerViewOrdersAdmin;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.suits_lb.R;
import com.example.suits_lb.modelos.Pedido;
import com.example.suits_lb.vistas.AdminViews.AdminCategoriesView.recyclerView.RvCategoryHolder;

import java.util.ArrayList;

public class ListaAdminOrdersAdapter extends RecyclerView.Adapter<rvAdminOrdersHolder>{
    private Context contexto;
    private ArrayList<Pedido> usersOrders;
    private LayoutInflater inflate;
    public ListaAdminOrdersAdapter(Context contexto, ArrayList<Pedido> usersOrders) {
        this.contexto = contexto;
        this.usersOrders = usersOrders;
        this.inflate = LayoutInflater.from(this.contexto);
    }


    @NonNull
    @Override
    public rvAdminOrdersHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View adminView = inflate.inflate(R.layout.admin_status_orders_single_view, parent, false);
        rvAdminOrdersHolder raoh = new rvAdminOrdersHolder(adminView, this);
        return raoh;
    }

    @Override
    public void onBindViewHolder(@NonNull rvAdminOrdersHolder holder, int position) {
        Pedido p1 = usersOrders.get(position);
        holder.getTvwOrderConcept().setText(p1.getConcepto());
        holder.getTvwOrderNum().setText(String.valueOf(p1.getNumPedido()));
        holder.getTvwOrderStatus().setText(p1.getEstado());
        holder.getTvwOrderUserEmail().setText(p1.getEmail());
    }

    @Override
    public int getItemCount() {
        return usersOrders.size();
    }

    public Context getContexto() {
        return contexto;
    }

    public void setContexto(Context contexto) {
        this.contexto = contexto;
    }

    public ArrayList<Pedido> getUsersOrders() {
        return usersOrders;
    }

    public void setUsersOrders(ArrayList<Pedido> usersOrders) {
        this.usersOrders = usersOrders;
    }

    public LayoutInflater getInflate() {
        return inflate;
    }

    public void setInflate(LayoutInflater inflate) {
        this.inflate = inflate;
    }
}
