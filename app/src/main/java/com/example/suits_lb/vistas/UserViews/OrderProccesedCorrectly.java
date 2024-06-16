package com.example.suits_lb.vistas.UserViews;

import static com.example.suits_lb.vistas.UserViews.HomeApp.emailUser;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

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
import com.example.suits_lb.vistas.AdminViews.AdminOrderStatus.ManagementOrdersStatus;
import com.example.suits_lb.vistas.pantallasCarga.SplashCargaUserOrders;

import java.util.HashMap;
import java.util.Map;

public class OrderProccesedCorrectly extends AppCompatActivity {
    private int SPLASH_TIME_OUT = 2000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_order_proccesed_correctly);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                insertarNuevaNotificacion();
            }
        },SPLASH_TIME_OUT);
    }

    private void insertarNuevaNotificacion(){
        StringRequest request = new StringRequest(Request.Method.POST, conexionSuitsLbDB.DIRECCION_URL_RAIZ + "/adminNotifications/insertarNotificacion.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        startActivity(new Intent(OrderProccesedCorrectly.this, SplashCargaUserOrders.class));
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
                params.put("emailUser", emailUser);
                params.put("mensaje","Se ha realizado tu pedido correctamente, mantente alerta del estado de cada pedido");
                return params;
            }

        };
        RequestQueue requestQueue = Volley.newRequestQueue(OrderProccesedCorrectly.this);
        requestQueue.add(request);
    }
}