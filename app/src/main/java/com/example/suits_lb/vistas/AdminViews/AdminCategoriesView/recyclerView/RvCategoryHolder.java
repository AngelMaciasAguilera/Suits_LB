package com.example.suits_lb.vistas.AdminViews.AdminCategoriesView.recyclerView;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.suits_lb.R;
import com.example.suits_lb.modelos.CategoriaRopa;
import com.example.suits_lb.vistas.AdminViews.AdminCategoriesView.ManagementCategoryScreen;


public class RvCategoryHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    private TextView tvwCodCategory;
    private TextView tvwTextCategory;
    private ListaCategoryAdapter fpa;

    public RvCategoryHolder(@NonNull View itemView, ListaCategoryAdapter fpa) {
        super(itemView);
        tvwCodCategory = (TextView) itemView.findViewById(R.id.codCategoryData);
        tvwTextCategory = (TextView) itemView.findViewById(R.id.categoryTextData);
        this.fpa = fpa;
        itemView.setOnClickListener(this);
    }

    public TextView getTvwTextCategory() {
        return tvwTextCategory;
    }

    public void setTvwTextCategory(TextView tvwTextCategory) {
        this.tvwTextCategory = tvwTextCategory;
    }


    public TextView getTvwCodCategory() {
        return tvwCodCategory;
    }

    public void setTvwCodCategory(TextView tvwCodCategory) {
        this.tvwCodCategory = tvwCodCategory;
    }

    public ListaCategoryAdapter getFpa() {
        return fpa;
    }

    public void setFpa(ListaCategoryAdapter fpa) {
        this.fpa = fpa;
    }

    @Override
    public void onClick(View view) {
        int posicion = getLayoutPosition();
        CategoriaRopa categoria = fpa.getCategorias().get(posicion);
        Log.d("category",categoria.toString());
        Intent intent = new Intent(fpa.getContexto(), ManagementCategoryScreen.class);
        intent.putExtra("category",categoria);
        fpa.getContexto().startActivity(intent);

    }
}
