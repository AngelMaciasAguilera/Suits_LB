package com.example.suits_lb.vistas.AdminViews.AdminAdminsView;

import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.suits_lb.R;
import com.example.suits_lb.controladores.conexionSuitsLbDB;
import com.example.suits_lb.modelos.Cliente;
import com.example.suits_lb.vistas.AdminViews.AdminAdminsView.recyclerView.ListaAdminAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainAdminScreenManager extends AppCompatActivity {
    RecyclerView rvManagementAdmins;
    ListaAdminAdapter listaAdminAdapter;
    ArrayList<Cliente> administradores;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_admin_screen_manager);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        rvManagementAdmins = findViewById(R.id.rvAdmins);
        administradores = new ArrayList<Cliente>();
        listaAdminAdapter = new ListaAdminAdapter(this, administradores);
        int orientation = getResources().getConfiguration().orientation;
        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            rvManagementAdmins.setLayoutManager(new GridLayoutManager(this, 2));
        } else {
            rvManagementAdmins.setLayoutManager(new LinearLayoutManager(this));
        }
        rvManagementAdmins.setAdapter(listaAdminAdapter);
        rellenarRecyclerView();


    }

    public void rellenarRecyclerView() {
        StringRequest request = new StringRequest(Request.Method.POST, conexionSuitsLbDB.DIRECCION_URL_RAIZ + "/adminAdmins/mostrarAdmin.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        administradores.clear();
                        Log.d("ManagementAdminScreen", response);
                        try {

                            JSONObject jsonObject = new JSONObject(response);
                            String exito = jsonObject.getString("exito");
                            JSONArray jsonArray = jsonObject.getJSONArray("administradores");
                            if (exito.equals("1")) {
                                for (int i = 0; i < jsonArray.length(); i++) {
                                    JSONObject object = jsonArray.getJSONObject(i);
                                    String adminEmail = object.getString("email");
                                    String adminPassword = object.getString("password");
                                    String adminName = object.getString("nombre");
                                    Integer adminPhone = Integer.parseInt(object.getString("telefono"));
                                    Integer adminAge = Integer.parseInt(object.getString("edad"));

                                    Cliente p1 = new Cliente(adminEmail,adminPassword,adminName,adminPhone,null,"S",adminAge);
                                    administradores.add(p1);
                                }
                                listaAdminAdapter.setAdministradores(administradores);
                                listaAdminAdapter.notifyDataSetChanged();
                            }
                        } catch (JSONException ex) {
                            throw new RuntimeException(ex);
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i("mysql1", "error al pedir los datos");
            }
        }
        ) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();
                return params;
            }

        };
        RequestQueue requestQueue = Volley.newRequestQueue(MainAdminScreenManager.this);
        requestQueue.add(request);


    }

}