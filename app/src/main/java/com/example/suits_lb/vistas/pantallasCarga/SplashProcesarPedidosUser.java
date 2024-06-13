package com.example.suits_lb.vistas.pantallasCarga;

import static com.example.suits_lb.vistas.UserViews.HomeApp.emailUser;
import static com.example.suits_lb.vistas.pantallasCarga.SplashCargaUserCart.productosUser;

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
import com.example.suits_lb.modelos.Carrito;
import com.example.suits_lb.vistas.UserViews.HomeApp;
import com.example.suits_lb.vistas.UserViews.OrderProccesedCorrectly;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SplashProcesarPedidosUser extends AppCompatActivity {
    private int newIdFactura;
    private Double totalFactura;
    private String direccion;
    private ArrayList<Carrito> pedidos = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splash_procesar_pedidos_user);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Intent intent = getIntent();
        newIdFactura = intent.getIntExtra("idFactura",0);
        totalFactura = intent.getDoubleExtra("totalFactura",0.0);
        direccion = intent.getStringExtra("direccionUser");
        Log.e("SplashProcesarPedidosUser", "Extras de Intent faltantes");
        Log.e("direccion del usuario", String.valueOf(direccion));
        Log.e("Factura", String.valueOf(newIdFactura));
        Log.e("Total pedido", String.valueOf(totalFactura));
        pedidos = productosUser;
        insertarNewFactura();
    }

    private void insertarNewFactura(){
        StringRequest request = new StringRequest(Request.Method.POST, conexionSuitsLbDB.DIRECCION_URL_RAIZ + "/adminFacturas/insertarFactura.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("AddingAdminScreen",response);
                        if (response.equalsIgnoreCase("factura insertada")){
                            for(int i = 0; i<pedidos.size();i++){
                                insertarPedidos(newIdFactura,pedidos.get(i));
                            }
                            Intent intent = new Intent(SplashProcesarPedidosUser.this, OrderProccesedCorrectly.class);
                            startActivity(intent);
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
                params.put("numPedidos",String.valueOf(pedidos.size()));
                params.put("totalFactura",String.valueOf(totalFactura));
                return params;
            }

        };
        RequestQueue requestQueue = Volley.newRequestQueue(SplashProcesarPedidosUser.this);
        requestQueue.add(request);

    }


    private void insertarPedidos(int newIdFactura,Carrito carrito){
        Carrito c1 = carrito;
        StringRequest request = new StringRequest(Request.Method.POST, conexionSuitsLbDB.DIRECCION_URL_RAIZ + "/adminOrders/insertarPedido.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                startActivity(new Intent(SplashProcesarPedidosUser.this, HomeApp.class));
            }
        }
        ) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();
                params.put("idNewFactura",String.valueOf(newIdFactura));
                params.put("emailUser",emailUser);
                params.put("codRopaUser",carrito.getCodRopa());
                params.put("concepto",carrito.getNomRopa());
                params.put("direccion",direccion);
                params.put("estado","Esperando envio");
                params.put("cantidad",String.valueOf(carrito.getCantidad()));
                params.put("subtotal",String.valueOf(carrito.getSubtotal()));
                return params;
            }

        };
        RequestQueue requestQueue = Volley.newRequestQueue(SplashProcesarPedidosUser.this);
        requestQueue.add(request);
    }






}