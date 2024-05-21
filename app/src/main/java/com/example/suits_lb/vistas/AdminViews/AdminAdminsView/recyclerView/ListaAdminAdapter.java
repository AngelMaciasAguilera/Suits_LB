package com.example.suits_lb.vistas.AdminViews.AdminAdminsView.recyclerView;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.suits_lb.R;
import com.example.suits_lb.modelos.Cliente;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ListaAdminAdapter extends RecyclerView.Adapter<RvAdminsHolder> {
    private Context contexto;
    private ArrayList<Cliente> administradores;
    private LayoutInflater inflate;


    public ListaAdminAdapter(Context contexto, ArrayList<Cliente> administradores) {
        this.contexto = contexto;
        this.administradores = administradores;
        inflate = LayoutInflater.from(this.contexto);
    }




    public Context getContexto() {
        return contexto;
    }

    public void setContexto(Context contexto) {
        this.contexto = contexto;
    }

    public ArrayList<Cliente> getAdministradores() {
        return administradores;
    }

    public void setAdministradores(ArrayList<Cliente> administradores) {
        this.administradores = administradores;
    }

    public LayoutInflater getInflate() {
        return inflate;
    }

    public void setInflate(LayoutInflater inflate) {
        this.inflate = inflate;
    }

    @NonNull
    @Override
    public RvAdminsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View adminView = inflate.inflate(R.layout.single_admin_view, parent, false);
        RvAdminsHolder rph = new RvAdminsHolder(adminView, this);
        return rph;
    }

    @Override
    public void onBindViewHolder(@NonNull RvAdminsHolder holder, int position) {
        Cliente cliente = this.getAdministradores().get(position);
        //----------------------------------------------------------------------
        holder.getTvwNombreAdmin().setText(cliente.getNombre());
        holder.getTvwEmailAdmin().setText(cliente.getEmail());
        holder.getTvwPhoneAdmin().setText(String.valueOf(cliente.getTelefono()));
        holder.getTvwAgeAdmin().setText(String.valueOf(cliente.getEdad()));
        //---------------------------------------------------------------------

    }


    @Override
    public int getItemCount() {
        return this.administradores.size();
    }
}
