package com.example.suits_lb.vistas.pantallasCarga;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.suits_lb.R;
import com.example.suits_lb.controladores.conexionSuitsLbDB;
import com.example.suits_lb.modelos.Cliente;
import com.example.suits_lb.vistas.AdminViews.AdminUserView.MainUserScreenManager;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SplashCargaUsersAdminView extends AppCompatActivity {
    public static ArrayList<Cliente> allUsersViewAdmin = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splash_carga_users_admin_view);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        obtenerAllUsers();
    }

    private void obtenerAllUsers(){
        StringRequest request = new StringRequest(Request.Method.POST, conexionSuitsLbDB.DIRECCION_URL_RAIZ + "/adminUsers/mostrarUser.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        allUsersViewAdmin.clear();
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

                                    Cliente p1 = new Cliente(adminEmail,adminPassword,adminName,adminPhone, "N",adminAge);
                                    allUsersViewAdmin.add(p1);
                                }
                                startActivity(new Intent(SplashCargaUsersAdminView.this, MainUserScreenManager.class));
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
        RequestQueue requestQueue = Volley.newRequestQueue(SplashCargaUsersAdminView.this);
        requestQueue.add(request);
    }
}