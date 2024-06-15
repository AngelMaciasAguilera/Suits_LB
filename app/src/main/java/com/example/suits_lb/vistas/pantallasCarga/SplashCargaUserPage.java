package com.example.suits_lb.vistas.pantallasCarga;

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
import com.example.suits_lb.modelos.Cliente;
import com.example.suits_lb.vistas.UserViews.AccountUserDetails;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class SplashCargaUserPage extends AppCompatActivity {
    private int SPLASH_TIME_OUT = 3000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splash_carga_user_page);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ImageView firstWave = findViewById(R.id.splash_wave_1_userPage);
        ImageView secondWave = findViewById(R.id.splash_wave_2_userPage);

        Animation expandWave1 = AnimationUtils.loadAnimation(this, R.anim.expand_wave1);
        Animation expandWave2 = AnimationUtils.loadAnimation(this, R.anim.expand_wave2);

        firstWave.setVisibility(View.VISIBLE);
        firstWave.startAnimation(expandWave1);

        secondWave.setVisibility(View.VISIBLE);
        secondWave.startAnimation(expandWave2);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                obtenerInfoUser();
            }
        }, SPLASH_TIME_OUT);
    }

    private void obtenerInfoUser(){
        StringRequest request = new StringRequest(Request.Method.POST, conexionSuitsLbDB.DIRECCION_URL_RAIZ + "/adminUsers/mostrarInfoUser.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("Response",response);
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            String userEmail = jsonObject.getString("email");
                            String userPassword = jsonObject.getString("password");
                            String userName = jsonObject.getString("nombre");
                            Integer userPhone = Integer.parseInt(jsonObject.getString("telefono"));
                            Integer userAge = Integer.parseInt(jsonObject.getString("edad"));
                            Cliente cliente = new Cliente(userEmail,userPassword,userName,userPhone,"N",userAge);
                            Intent intent = new Intent(SplashCargaUserPage.this, AccountUserDetails.class).putExtra("usuario",cliente);
                            startActivity(intent);
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
        RequestQueue requestQueue = Volley.newRequestQueue(SplashCargaUserPage.this);
        requestQueue.add(request);
    }



}