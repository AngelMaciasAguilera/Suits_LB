package com.example.suits_lb.vistas.UserViews.recyclerViewProductSummary;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.suits_lb.modelos.Carrito;

import java.util.ArrayList;


public class ListProductSummaryAdapter extends RecyclerView.Adapter<rvHolderUserProductSummary> {
    private Context contexto;
    private ArrayList<Carrito> carritoUser;
    private LayoutInflater inflate;

    public ListProductSummaryAdapter(Context contexto, ArrayList<Carrito> carritoUser, LayoutInflater inflate) {
        this.contexto = contexto;
        this.carritoUser = carritoUser;
        this.inflate = inflate;
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
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull rvHolderUserProductSummary holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
