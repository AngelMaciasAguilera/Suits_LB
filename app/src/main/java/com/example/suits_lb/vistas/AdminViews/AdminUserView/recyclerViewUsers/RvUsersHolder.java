package com.example.suits_lb.vistas.AdminViews.AdminUserView.recyclerViewUsers;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.suits_lb.R;
import com.example.suits_lb.modelos.Cliente;
import com.example.suits_lb.vistas.AdminViews.AdminAdminsView.ManagementAdminScreen;
import com.example.suits_lb.vistas.AdminViews.AdminAdminsView.recyclerView.ListaAdminAdapter;
import com.example.suits_lb.vistas.AdminViews.AdminUserView.ManagementUserScreen;

public class RvUsersHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    private TextView tvwNombreUser;
    private TextView tvwEmailUser;
    private TextView tvwPhoneUser;
    private TextView tvwAgeUser;
    private ListaUserAdapter fpa;

    public RvUsersHolder(@NonNull View itemView, ListaUserAdapter fpa) {
        super(itemView);
        tvwNombreUser = (TextView) itemView.findViewById(R.id.userNameData);
        tvwEmailUser = (TextView) itemView.findViewById(R.id.userEmailData);
        tvwAgeUser = (TextView) itemView.findViewById(R.id.userAgeData);
        this.tvwPhoneUser = (TextView) itemView.findViewById(R.id.userPhoneData);
        this.fpa = fpa;
        itemView.setOnClickListener(this);
    }

    public TextView getTvwEmailUser() {
        return tvwEmailUser;
    }

    public void setTvwEmailUser(TextView tvwEmailUser) {
        this.tvwEmailUser = tvwEmailUser;
    }

    public TextView getTvwPhoneUser() {
        return tvwPhoneUser;
    }

    public void setTvwPhoneUser(TextView tvwPhoneUser) {
        this.tvwPhoneUser = tvwPhoneUser;
    }

    public TextView getTvwNombreUser() {
        return tvwNombreUser;
    }

    public void setTvwNombreUser(TextView tvwNombreUser) {
        this.tvwNombreUser = tvwNombreUser;
    }

    public TextView getTvwAgeUser() {
        return tvwAgeUser;
    }

    public void setTvwAgeUser(TextView tvwAgeUser) {
        this.tvwAgeUser = tvwAgeUser;
    }

    public ListaUserAdapter getFpa() {
        return fpa;
    }

    public void setFpa(ListaUserAdapter fpa) {
        this.fpa = fpa;
    }

    @Override
    public void onClick(View view) {
        int posicion = getLayoutPosition();
        Cliente administrador = fpa.getClientes().get(posicion);
        Log.d("administrador",administrador.toString());
        Intent intent = new Intent(fpa.getContexto(), ManagementUserScreen.class);
        intent.putExtra("administrador",administrador);
        fpa.getContexto().startActivity(intent);

    }
}
