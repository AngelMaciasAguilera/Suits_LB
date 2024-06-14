package com.example.suits_lb.vistas.AdminViews.AdminOrderStatus.recyclerViewOrdersAdmin;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.suits_lb.R;
import com.example.suits_lb.modelos.CategoriaRopa;
import com.example.suits_lb.modelos.Pedido;
import com.example.suits_lb.vistas.AdminViews.AdminCategoriesView.ManagementCategoryScreen;
import com.example.suits_lb.vistas.AdminViews.AdminOrderStatus.ManagementOrdersStatus;

public class rvAdminOrdersHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    private TextView tvwOrderNum,tvwOrderUserEmail,tvwOrderConcept, tvwOrderStatus;
    private ListaAdminOrdersAdapter laoa;

    public rvAdminOrdersHolder(@NonNull View itemView, ListaAdminOrdersAdapter laoa) {
        super(itemView);
        tvwOrderNum = (TextView)itemView.findViewById(R.id.numOrderAOV);
        tvwOrderUserEmail = (TextView) itemView.findViewById(R.id.orderUserEmailAOV);
        tvwOrderConcept = itemView.findViewById(R.id.orderConceptAOV);
        tvwOrderStatus = (TextView)itemView.findViewById(R.id.orderStatusAOV);
        this.laoa = laoa;
        itemView.setOnClickListener(this);
    }

    public TextView getTvwOrderNum() {
        return tvwOrderNum;
    }

    public void setTvwOrderNum(TextView tvwOrderNum) {
        this.tvwOrderNum = tvwOrderNum;
    }

    public TextView getTvwOrderUserEmail() {
        return tvwOrderUserEmail;
    }

    public void setTvwOrderUserEmail(TextView tvwOrderUserEmail) {
        this.tvwOrderUserEmail = tvwOrderUserEmail;
    }

    public TextView getTvwOrderConcept() {
        return tvwOrderConcept;
    }

    public void setTvwOrderConcept(TextView tvwOrderConcept) {
        this.tvwOrderConcept = tvwOrderConcept;
    }

    public TextView getTvwOrderStatus() {
        return tvwOrderStatus;
    }

    public void setTvwOrderStatus(TextView tvwOrderStatus) {
        this.tvwOrderStatus = tvwOrderStatus;
    }

    public ListaAdminOrdersAdapter getLaoa() {
        return laoa;
    }

    public void setLaoa(ListaAdminOrdersAdapter laoa) {
        this.laoa = laoa;
    }

    @Override
    public void onClick(View v) {
        int posicion = getLayoutPosition();
        Pedido pedido = laoa.getUsersOrders().get(posicion);
        Log.d("pedidoSeleccionado",pedido.toString());
        Intent intent = new Intent(laoa.getContexto(), ManagementOrdersStatus.class);
        intent.putExtra("pedidoSeleccionado",pedido);
        laoa.getContexto().startActivity(intent);
    }
}
