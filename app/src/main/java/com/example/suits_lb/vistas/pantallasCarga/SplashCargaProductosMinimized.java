package com.example.suits_lb.vistas.pantallasCarga;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
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
import com.example.suits_lb.controladores.SQLiteBD.DatabaseHelperUserCart;
import com.example.suits_lb.controladores.SQLiteBD.ProductosContractCart;
import com.example.suits_lb.controladores.conexionSuitsLbDB;
import com.example.suits_lb.modelos.Carrito;
import com.example.suits_lb.vistas.UserViews.CheckOutPageUser;
import com.example.suits_lb.vistas.UserViews.userCart.UserCartView;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SplashCargaProductosMinimized extends AppCompatActivity {
    private int SPLASH_TIME_OUT = 3000;

    public static ArrayList<Carrito>productsMinimized = new ArrayList<>();

    private int idFactura;
    private DatabaseHelperUserCart dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splash_carga_productos_minimized);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ImageView firstWave = findViewById(R.id.splash_wave_1MINLoad);
        ImageView secondWave = findViewById(R.id.splash_wave_2MINLoad);

        Animation expandWave1 = AnimationUtils.loadAnimation(this, R.anim.expand_wave1);
        Animation expandWave2 = AnimationUtils.loadAnimation(this, R.anim.expand_wave2);

        firstWave.setVisibility(View.VISIBLE);
        firstWave.startAnimation(expandWave1);

        secondWave.setVisibility(View.VISIBLE);
        secondWave.startAnimation(expandWave2);

        dbHelper = new DatabaseHelperUserCart(this);
        this.idFactura = 0;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                obtenerUltimoIdFactura();
            }
        }, SPLASH_TIME_OUT);

    }



    private void obtenerCarritoUser(Integer idFactura) {
        Cursor cursor = dbHelper.getAllCartItems();
        Double precioTotal = 0.0;
        if (cursor != null) {
            while (cursor.moveToNext()) {
                String codRopa = cursor.getString(cursor.getColumnIndexOrThrow(ProductosContractCart.AuxCarritoEntries.COLUMN_CODROPA));
                String email = cursor.getString(cursor.getColumnIndexOrThrow(ProductosContractCart.AuxCarritoEntries.COLUMN_EMAIL));
                String imgRopa = cursor.getString(cursor.getColumnIndexOrThrow(ProductosContractCart.AuxCarritoEntries.COLUMN_IMGROPA));
                String nomRopa = cursor.getString(cursor.getColumnIndexOrThrow(ProductosContractCart.AuxCarritoEntries.COLUMN_NOMROPA));
                Integer cantRopa = cursor.getInt(cursor.getColumnIndexOrThrow(ProductosContractCart.AuxCarritoEntries.COLUMN_CANTIDAD));
                Double subtotalRopa = cursor.getDouble(cursor.getColumnIndexOrThrow(ProductosContractCart.AuxCarritoEntries.COLUMN_SUBTOTAL));
                precioTotal+= subtotalRopa;
                Carrito cart = new Carrito(codRopa,email,imgRopa,nomRopa,cantRopa,subtotalRopa);
                Log.d("Carrito",cart.toString());
                productsMinimized.add(cart);
            }
            cursor.close();
        }
        startActivity(new Intent(SplashCargaProductosMinimized.this, CheckOutPageUser.class).putExtra("idFactura",String.valueOf(idFactura)).putExtra("precioTotal",String.valueOf(precioTotal)));
    }


    private void obtenerUltimoIdFactura(){
        StringRequest request = new StringRequest(Request.Method.POST, conexionSuitsLbDB.DIRECCION_URL_RAIZ + "/adminFacturas/obtenerUltimaFactura.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        Log.d("AddingProductScreen", response);
                        try {
                            Integer idFactura = Integer.valueOf(response);
                            obtenerCarritoUser(idFactura);
                        } catch (Exception ex) {
                            Log.d("Exception carga productos", ex.getMessage());
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
        RequestQueue requestQueue = Volley.newRequestQueue(SplashCargaProductosMinimized.this);
        requestQueue.add(request);
    }

}