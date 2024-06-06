package com.example.suits_lb.vistas.pantallasCarga;

import android.content.Intent;
import android.database.Cursor;
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

import com.example.suits_lb.R;
import com.example.suits_lb.controladores.SQLiteBD.DatabaseHelperUserCart;
import com.example.suits_lb.controladores.SQLiteBD.ProductosContractCart;
import com.example.suits_lb.modelos.Carrito;
import com.example.suits_lb.vistas.UserViews.userCart.UserCartView;

import java.util.ArrayList;

public class SplashCargaUserCart extends AppCompatActivity {
    private int SPLASH_TIME_OUT =2500;
    public static ArrayList<Carrito> productosUser = new ArrayList<>();
    private DatabaseHelperUserCart dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splash_carga_user_cart);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ImageView firstWave = findViewById(R.id.splash_wave_cart_1);
        ImageView secondWave = findViewById(R.id.splash_wave_cart_2);

        Animation expandWave1 = AnimationUtils.loadAnimation(this, R.anim.expand_wave1);
        Animation expandWave2 = AnimationUtils.loadAnimation(this, R.anim.expand_wave2);

        firstWave.setVisibility(View.VISIBLE);
        firstWave.startAnimation(expandWave1);

        secondWave.setVisibility(View.VISIBLE);
        secondWave.startAnimation(expandWave2);

        dbHelper = new DatabaseHelperUserCart(this);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                obtenerCarritoUser();
            }
        }, SPLASH_TIME_OUT);

    }

    private void obtenerCarritoUser() {
        Cursor cursor = dbHelper.getAllCartItems();
        if (cursor != null) {
            while (cursor.moveToNext()) {
                String codRopa = cursor.getString(cursor.getColumnIndexOrThrow(ProductosContractCart.AuxCarritoEntries.COLUMN_CODROPA));
                String email = cursor.getString(cursor.getColumnIndexOrThrow(ProductosContractCart.AuxCarritoEntries.COLUMN_EMAIL));
                String imgRopa = cursor.getString(cursor.getColumnIndexOrThrow(ProductosContractCart.AuxCarritoEntries.COLUMN_IMGROPA));
                String nomRopa = cursor.getString(cursor.getColumnIndexOrThrow(ProductosContractCart.AuxCarritoEntries.COLUMN_NOMROPA));
                Integer cantRopa = cursor.getInt(cursor.getColumnIndexOrThrow(ProductosContractCart.AuxCarritoEntries.COLUMN_CANTIDAD));
                Double subtotalRopa = cursor.getDouble(cursor.getColumnIndexOrThrow(ProductosContractCart.AuxCarritoEntries.COLUMN_SUBTOTAL));
                Carrito cart = new Carrito(codRopa,email,imgRopa,nomRopa,cantRopa,subtotalRopa);
                Log.d("Carrito",cart.toString());
                productosUser.add(cart);
            }
            cursor.close();
        }

        startActivity(new Intent(this, UserCartView.class));

    }
}
