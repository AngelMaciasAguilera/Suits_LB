package com.example.suits_lb.vistas.AdminViews.AdminUserView;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

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
import com.example.suits_lb.vistas.AdminViews.AdminUserView.recyclerViewUsers.ListaUserAdapter;
import com.example.suits_lb.vistas.AdminViews.BackEndSelection;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainUserScreenManager extends AppCompatActivity {
    private RecyclerView rvManagementUsers;
    private ImageButton imgbtSearchUser;
    private ImageButton imgbtReturnUser;
    private ListaUserAdapter listaUserAdapter;
    private ArrayList<Cliente> clientes;
    private EditText edtBuscarUser;
    private Button goToBackEndSelection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_user_screen_manager);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        imgbtSearchUser = findViewById(R.id.imgbSearchUser);
        rvManagementUsers = findViewById(R.id.rvUser);
        imgbtReturnUser = findViewById(R.id.imgbReturnUser);
        imgbtReturnUser.setEnabled(false);
        imgbtReturnUser.setVisibility(View.INVISIBLE);
        edtBuscarUser = findViewById(R.id.edtSearchUser);
        goToBackEndSelection = findViewById(R.id.goToBackEndSelection);
        clientes = new ArrayList<>();
        listaUserAdapter = new ListaUserAdapter(this, clientes);
        int orientation = getResources().getConfiguration().orientation;
        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            rvManagementUsers.setLayoutManager(new GridLayoutManager(this, 2));
        } else {
            rvManagementUsers.setLayoutManager(new LinearLayoutManager(this));
        }
        rvManagementUsers.setAdapter(listaUserAdapter);
        rellenarRecyclerView();

        goToBackEndSelection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoBackEndSelection();
            }

            });

        imgbtSearchUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchUser();
            }
        });
        imgbtReturnUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                returnSearch();
            }
        });
    }

    private void searchUser(){
        imgbtReturnUser.setEnabled(true);
        imgbtReturnUser.setVisibility(View.VISIBLE);
        String userEmailSearched = String.valueOf(edtBuscarUser.getText());
        ArrayList<Cliente>userSearched = new ArrayList<>();
        for (Cliente c: clientes) {
            if (c.getEmail().contains(userEmailSearched)){
                userSearched.add(c);
            }
        }
        listaUserAdapter.setClientes(userSearched);
        listaUserAdapter.notifyDataSetChanged();
    }

    private void returnSearch(){
        imgbtReturnUser.setEnabled(false);
        imgbtReturnUser.setVisibility(View.INVISIBLE);
        listaUserAdapter.setClientes(clientes);
        listaUserAdapter.notifyDataSetChanged();
    }


    public void rellenarRecyclerView() {
        StringRequest request = new StringRequest(Request.Method.POST, conexionSuitsLbDB.DIRECCION_URL_RAIZ + "/adminUsers/mostrarUser.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        clientes.clear();
                        Log.d("ManagementUserScreen", response);
                        try {

                            JSONObject jsonObject = new JSONObject(response);
                            String exito = jsonObject.getString("exito");
                            JSONArray jsonArray = jsonObject.getJSONArray("clientes");
                            if (exito.equals("1")) {
                                for (int i = 0; i < jsonArray.length(); i++) {
                                    JSONObject object = jsonArray.getJSONObject(i);
                                    String adminEmail = object.getString("email");
                                    String adminPassword = object.getString("password");
                                    String adminName = object.getString("nombre");
                                    Integer adminPhone = Integer.parseInt(object.getString("telefono"));
                                    Integer adminAge = Integer.parseInt(object.getString("edad"));

                                    Cliente p1 = new Cliente(adminEmail,adminPassword,adminName,adminPhone,null,"N",adminAge);
                                    clientes.add(p1);
                                }
                                listaUserAdapter.setClientes(clientes);
                                listaUserAdapter.notifyDataSetChanged();
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
        RequestQueue requestQueue = Volley.newRequestQueue(MainUserScreenManager.this);
        requestQueue.add(request);


    }

    private void gotoBackEndSelection(){
        this.startActivity(new Intent(this, BackEndSelection.class));
    }

}