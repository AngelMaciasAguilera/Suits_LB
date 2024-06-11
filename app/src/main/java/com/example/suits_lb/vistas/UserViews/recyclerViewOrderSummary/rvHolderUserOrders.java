package com.example.suits_lb.vistas.UserViews.recyclerViewOrderSummary;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.suits_lb.R;


public class rvHolderUserOrders extends RecyclerView.ViewHolder implements View.OnClickListener{

    private TextView tvwOrderConcept, tvwOrderQuantity, tvwOrderDirection,tvwSubtotalOrder,tvwDateOrder;
    private ListaOrdersAdapter listaOrdersAdapter;

    public rvHolderUserOrders(@NonNull View itemView,ListaOrdersAdapter loa) {
        super(itemView);
        tvwOrderConcept = (TextView)itemView.findViewById(R.id.orderConcept);
        tvwOrderDirection = (TextView) itemView.findViewById(R.id.orderDirection);
        tvwOrderQuantity = (TextView)itemView.findViewById(R.id.orderQuantity);
        tvwSubtotalOrder = itemView.findViewById(R.id.orderSubtotal);
        tvwDateOrder = itemView.findViewById(R.id.orderDateEstimate);
        this.listaOrdersAdapter = loa;
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

    }

    public TextView getTvwOrderConcept() {
        return tvwOrderConcept;
    }

    public void setTvwOrderConcept(TextView tvwOrderConcept) {
        this.tvwOrderConcept = tvwOrderConcept;
    }

    public TextView getTvwOrderQuantity() {
        return tvwOrderQuantity;
    }

    public void setTvwOrderQuantity(TextView tvwOrderQuantity) {
        this.tvwOrderQuantity = tvwOrderQuantity;
    }

    public TextView getTvwOrderDirection() {
        return tvwOrderDirection;
    }

    public void setTvwOrderDirection(TextView tvwOrderDirection) {
        this.tvwOrderDirection = tvwOrderDirection;
    }

    public TextView getTvwSubtotalOrder() {
        return tvwSubtotalOrder;
    }

    public void setTvwSubtotalOrder(TextView tvwSubtotalOrder) {
        this.tvwSubtotalOrder = tvwSubtotalOrder;
    }

    public TextView getTvwDateOrder() {
        return tvwDateOrder;
    }

    public void setTvwDateOrder(TextView tvwDateOrder) {
        this.tvwDateOrder = tvwDateOrder;
    }

    public ListaOrdersAdapter getListaOrdersAdapter() {
        return listaOrdersAdapter;
    }

    public void setListaOrdersAdapter(ListaOrdersAdapter listaOrdersAdapter) {
        this.listaOrdersAdapter = listaOrdersAdapter;
    }
}
