package com.example.suits_lb.vistas.pantallasCarga;

import android.content.ContentValues;
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
import com.example.suits_lb.modelos.Producto;
import com.example.suits_lb.vistas.AdminViews.AdminProductsView.MainProductScreenManager;
import com.example.suits_lb.vistas.AdminViews.BackEndSelection;
import com.example.suits_lb.vistas.MainActivity;
import com.example.suits_lb.vistas.UserViews.HomeApp;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SplashCargaProductosAdmin extends AppCompatActivity {
    public static ArrayList<Producto> adminAllProducts = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splash_carga_productos_admin);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        obtenerRopaUser();
    }

    private void obtenerRopaUser(){
        StringRequest request = new StringRequest(Request.Method.POST, conexionSuitsLbDB.DIRECCION_URL_RAIZ + "/adminRopa/mostrarProductosUser.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        adminAllProducts.clear();
                        try {

                            JSONObject jsonObject = new JSONObject(response);
                            String exito = jsonObject.getString("exito");
                            JSONArray jsonArray = jsonObject.getJSONArray("productos");
                            if (exito.equals("1")) {
                                Intent intent = new Intent(SplashCargaProductosAdmin.this, MainProductScreenManager.class);
                                for (int i = 0; i < jsonArray.length(); i++) {
                                    ContentValues values = new ContentValues();
                                    JSONObject object = jsonArray.getJSONObject(i);
                                    String codRopa = object.getString("codRopa");
                                    String nombreRopa = object.getString("nombre");
                                    String descripcion = object.getString("descripcion");
                                    Double precio = object.getDouble("precio");
                                    String categoria = object.getString("categoria");
                                    String ventaDisponible = object.getString("ventaDisponible");
                                    String imgProducto = object.getString("imgProducto");
                                    Producto p1 = new Producto(codRopa,nombreRopa,descripcion,precio,categoria, imgProducto,ventaDisponible);
                                    adminAllProducts.add(p1);

                                }
                                startActivity(intent);
                                finish();

                            }
                        } catch (JSONException ex) {
                            throw new RuntimeException(ex);
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i("mysql1", "error al cargar los datos");
                startActivity(new Intent(SplashCargaProductosAdmin.this, BackEndSelection.class));
            }
        }
        ) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();
                return params;
            }

        };
        RequestQueue requestQueue = Volley.newRequestQueue(SplashCargaProductosAdmin.this);
        requestQueue.add(request);
    }
}