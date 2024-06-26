package com.example.suits_lb.vistas.AdminViews.AdminAdminsView.recyclerView;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.suits_lb.R;
import com.example.suits_lb.modelos.Cliente;
import com.example.suits_lb.vistas.AdminViews.AdminAdminsView.ManagementAdminScreen;
import com.example.suits_lb.vistas.AdminViews.AdminCategoriesView.ManagementCategoryScreen;


public class RvAdminsHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    private TextView tvwNombreAdmin;
    private TextView tvwEmailAdmin;
    private TextView tvwPhoneAdmin;
    private TextView tvwAgeAdmin;
    private ListaAdminAdapter fpa;

    public RvAdminsHolder(@NonNull View itemView, ListaAdminAdapter fpa) {
        super(itemView);
        tvwNombreAdmin = (TextView) itemView.findViewById(R.id.adminNameData);
        tvwEmailAdmin = (TextView) itemView.findViewById(R.id.adminEmailData);
        tvwAgeAdmin = (TextView) itemView.findViewById(R.id.adminAgeData);
        this.tvwPhoneAdmin = (TextView) itemView.findViewById(R.id.adminPhoneData);
        this.fpa = fpa;
        itemView.setOnClickListener(this);
    }

    public TextView getTvwEmailAdmin() {
        return tvwEmailAdmin;
    }

    public void setTvwEmailAdmin(TextView tvwEmailAdmin) {
        this.tvwEmailAdmin = tvwEmailAdmin;
    }

    public TextView getTvwPhoneAdmin() {
        return tvwPhoneAdmin;
    }

    public void setTvwPhoneAdmin(TextView tvwPhoneAdmin) {
        this.tvwPhoneAdmin = tvwPhoneAdmin;
    }

    public TextView getTvwNombreAdmin() {
        return tvwNombreAdmin;
    }

    public void setTvwNombreAdmin(TextView tvwNombreAdmin) {
        this.tvwNombreAdmin = tvwNombreAdmin;
    }

    public TextView getTvwPrecioProducto() {
        return tvwEmailAdmin;
    }

    public void setTvwPrecioProducto(TextView tvwPrecioProducto) {
        this.tvwEmailAdmin = tvwPrecioProducto;
    }

    public TextView getTvwAgeAdmin() {
        return tvwAgeAdmin;
    }

    public void setTvwAgeAdmin(TextView tvwAgeAdmin) {
        this.tvwAgeAdmin = tvwAgeAdmin;
    }

    public ListaAdminAdapter getFpa() {
        return fpa;
    }

    public void setFpa(ListaAdminAdapter fpa) {
        this.fpa = fpa;
    }

    @Override
    public void onClick(View view) {
        int posicion = getLayoutPosition();
        Cliente administrador = fpa.getAdministradores().get(posicion);
        Log.d("administrador",administrador.toString());
        Intent intent = new Intent(fpa.getContexto(), ManagementAdminScreen.class);
        intent.putExtra("administrador",administrador);
        fpa.getContexto().startActivity(intent);

    }
}
