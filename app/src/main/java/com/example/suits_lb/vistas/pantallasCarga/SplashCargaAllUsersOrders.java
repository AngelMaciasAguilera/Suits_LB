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
import com.example.suits_lb.modelos.Pedido;
import com.example.suits_lb.modelos.Producto;
import com.example.suits_lb.vistas.AdminViews.AdminOrderStatus.MainOrdersUsersStatus;
import com.example.suits_lb.vistas.AdminViews.AdminProductsView.MainProductScreenManager;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SplashCargaAllUsersOrders extends AppCompatActivity {
    public static ArrayList<Pedido> allUsersOrdersSplash  = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splash_carga_all_users_orders);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        obtainAllOrders();

    }

    private void obtainAllOrders() {
        StringRequest request = new StringRequest(Request.Method.POST, conexionSuitsLbDB.DIRECCION_URL_RAIZ + "/adminOrders/obtenerAllUsersOrders.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        allUsersOrdersSplash.clear();
                        Log.d("SplashCargaAllUsersOrders", response);
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            String exito = jsonObject.getString("exito");
                            JSONArray arrayOrders = jsonObject.getJSONArray("allOrders");
                            if (exito.equals("1")) {
                                for (int i = 0; i < arrayOrders.length(); i++) {
                                    JSONObject pedido = arrayOrders.getJSONObject(i);
                                    Integer numPedido = pedido.getInt("numPedido");
                                    String email = pedido.getString("email");
                                    String codRopa = pedido.getString("codRopa");
                                    Integer cantidad = pedido.getInt("cantidad");
                                    String concepto = pedido.getString("concepto");
                                    String direccion = pedido.getString("direccion");
                                    Double subtotal = pedido.getDouble("subtotal");
                                    String estadoPedido = pedido.getString("estadoPedido");
                                    Pedido p1 = new Pedido(email,codRopa,concepto,direccion,estadoPedido, cantidad,numPedido,subtotal);
                                    allUsersOrdersSplash.add(p1);
                                }
                                startActivity(new Intent(SplashCargaAllUsersOrders.this, MainOrdersUsersStatus.class));
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
        RequestQueue requestQueue = Volley.newRequestQueue(SplashCargaAllUsersOrders.this);
        requestQueue.add(request);


    }
}
