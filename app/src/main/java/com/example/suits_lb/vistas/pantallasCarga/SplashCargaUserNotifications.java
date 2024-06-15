package com.example.suits_lb.vistas.pantallasCarga;

import static com.example.suits_lb.vistas.UserViews.HomeApp.emailUser;

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
import com.example.suits_lb.modelos.CategoriaRopa;
import com.example.suits_lb.vistas.AdminViews.AdminProductsView.ManagementProductScreen;
import com.example.suits_lb.vistas.UserViews.NotificationsUserView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SplashCargaUserNotifications extends AppCompatActivity {
    public static ArrayList<String> userNotifications = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splash_carga_user_notifications);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        obtenerNotificaciones();

    }

    private void obtenerNotificaciones(){
        StringRequest request = new StringRequest(Request.Method.POST, conexionSuitsLbDB.DIRECCION_URL_RAIZ + "/adminNotifications/obtenerUserNotifications.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        userNotifications.clear();
                        Log.d("SplashCargaUserNotifications", response);
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            JSONArray jsonArray = jsonObject.getJSONArray("notificaciones");
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject object = jsonArray.getJSONObject(i);
                                String userNotification = object.getString("mensaje");
                                userNotifications.add(userNotification);
                            }
                            startActivity(new Intent(SplashCargaUserNotifications.this, NotificationsUserView.class));
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
        RequestQueue requestQueue = Volley.newRequestQueue(SplashCargaUserNotifications.this);
        requestQueue.add(request);
    }

}