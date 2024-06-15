package com.example.suits_lb.vistas.pantallasCarga;

import static com.example.suits_lb.vistas.UserViews.HomeApp.emailUser;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.suits_lb.R;
import com.example.suits_lb.controladores.conexionSuitsLbDB;
import com.example.suits_lb.modelos.Pedido;
import com.example.suits_lb.modelos.Producto;
import com.example.suits_lb.vistas.UserViews.AccountOrderUserPage;
import com.example.suits_lb.vistas.UserViews.HomeApp;
import com.example.suits_lb.vistas.UserViews.recyclerViewOrderSummary.ListaOrdersAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SplashCargaUserOrders extends AppCompatActivity {
    private int SPLASH_TIME_OUT = 3000;
    public static ArrayList<Pedido> pedidosUser = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splash_carga_user_orders);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ImageView firstWave = findViewById(R.id.splash_wave_1_userorders);
        ImageView secondWave = findViewById(R.id.splash_wave_2_userorders);

        Animation expandWave1 = AnimationUtils.loadAnimation(this, R.anim.expand_wave1);
        Animation expandWave2 = AnimationUtils.loadAnimation(this, R.anim.expand_wave2);

        firstWave.setVisibility(View.VISIBLE);
        firstWave.startAnimation(expandWave1);

        secondWave.setVisibility(View.VISIBLE);
        secondWave.startAnimation(expandWave2);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                obtenerUserOrders();
            }
        }, SPLASH_TIME_OUT);
    }

    private void obtenerUserOrders(){
        StringRequest request = new StringRequest(Request.Method.POST, conexionSuitsLbDB.DIRECCION_URL_RAIZ + "/adminOrders/obtenerUserOrders.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        pedidosUser.clear();
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            String exito = jsonObject.getString("exito");
                            JSONArray jsonArray = jsonObject.getJSONArray("orders");
                            Intent intent = new Intent(SplashCargaUserOrders.this, AccountOrderUserPage.class);
                            if (exito.equals("1")) {
                                for (int i = 0; i < jsonArray.length(); i++) {
                                    ContentValues values = new ContentValues();
                                    JSONObject object = jsonArray.getJSONObject(i);
                                    String email = object.getString("email");
                                    String codRopa = object.getString("codRopa");
                                    String concepto = object.getString("concepto");
                                    String direccion = object.getString("direccion");
                                    String fechaEstimadaEntrega = object.getString("estado");
                                    Integer cantidad = object.getInt("cantidad");
                                    Double subtotal = object.getDouble("subtotal");
                                    Pedido order = new Pedido(email,codRopa,concepto,direccion,fechaEstimadaEntrega, cantidad,subtotal);
                                    pedidosUser.add(order);

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
                Log.i("mysql1", "error al pedir los datos");
            }
        }
        ) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();
                params.put("emailUser",emailUser);
                return params;
            }

        };
        RequestQueue requestQueue = Volley.newRequestQueue(SplashCargaUserOrders.this);
        requestQueue.add(request);
    }
}

