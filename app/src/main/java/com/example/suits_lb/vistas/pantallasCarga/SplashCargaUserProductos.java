package com.example.suits_lb.vistas.pantallasCarga;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
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
import com.example.suits_lb.vistas.MainActivity;
import com.example.suits_lb.vistas.UserViews.HomeApp;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SplashCargaUserProductos extends AppCompatActivity {
    private static int SPLASH_TIME_OUT =4000;

    public static ArrayList<Producto> productos = new ArrayList();

    private String emailUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splash_carga_user_productos);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        emailUser = getIntent().getStringExtra("emailUsuario");

        ImageView firstWave = findViewById(R.id.splash_wave_1);
        ImageView secondWave = findViewById(R.id.splash_wave_2);

        Animation expandWave1 = AnimationUtils.loadAnimation(this, R.anim.expand_wave1);
        Animation expandWave2 = AnimationUtils.loadAnimation(this, R.anim.expand_wave2);

        firstWave.setVisibility(View.VISIBLE);
        firstWave.startAnimation(expandWave1);

        secondWave.setVisibility(View.VISIBLE);
        secondWave.startAnimation(expandWave2);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                obtenerRopaUser();
            }
        }, SPLASH_TIME_OUT);

    }


    private void obtenerRopaUser(){
        StringRequest request = new StringRequest(Request.Method.POST, conexionSuitsLbDB.DIRECCION_URL_RAIZ + "/adminRopa/mostrarProductosUser.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        productos.clear();
                        try {

                            JSONObject jsonObject = new JSONObject(response);
                            String exito = jsonObject.getString("exito");
                            JSONArray jsonArray = jsonObject.getJSONArray("productos");
                            if (exito.equals("1")) {
                                Intent intent = new Intent(SplashCargaUserProductos.this, HomeApp.class);
                                intent.putExtra("emailUsuario",emailUser);
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
                                    productos.add(p1);

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
                startActivity(new Intent(SplashCargaUserProductos.this, MainActivity.class).putExtra("EAC","EAC"));
            }
        }
        ) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();
                return params;
            }

        };
        RequestQueue requestQueue = Volley.newRequestQueue(SplashCargaUserProductos.this);
        requestQueue.add(request);
    }
}