package com.example.suits_lb.vistas.AdminViews.AdminCategoriesView.recyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.suits_lb.R;
import com.example.suits_lb.modelos.CategoriaRopa;

import java.util.ArrayList;

public class ListaCategoryAdapter extends RecyclerView.Adapter<RvCategoryHolder> {
    private Context contexto;
    private ArrayList<CategoriaRopa> categorias;
    private LayoutInflater inflate;


    public ListaCategoryAdapter(Context contexto, ArrayList<CategoriaRopa> categorias) {
        this.contexto = contexto;
        this.categorias = categorias;
        inflate = LayoutInflater.from(this.contexto);
    }




    public Context getContexto() {
        return contexto;
    }

    public void setContexto(Context contexto) {
        this.contexto = contexto;
    }

    public ArrayList<CategoriaRopa> getCategorias() {
        return categorias;
    }

    public void setCategorias(ArrayList<CategoriaRopa> categorias) {
        this.categorias = categorias;
    }

    public LayoutInflater getInflate() {
        return inflate;
    }

    public void setInflate(LayoutInflater inflate) {
        this.inflate = inflate;
    }

    @NonNull
    @Override
    public RvCategoryHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View adminView = inflate.inflate(R.layout.single_category_view, parent, false);
        RvCategoryHolder rph = new RvCategoryHolder(adminView, this);
        return rph;
    }

    @Override
    public void onBindViewHolder(@NonNull RvCategoryHolder holder, int position) {
        CategoriaRopa categoriaRopa = this.getCategorias().get(position);
        //----------------------------------------------------------------------
        holder.getTvwCodCategory().setText(categoriaRopa.getCodCategory());
        holder.getTvwTextCategory().setText(categoriaRopa.getNomCategory());
        //---------------------------------------------------------------------

    }

    @Override
    public int getItemCount() {
        return this.categorias.size();
    }
}
