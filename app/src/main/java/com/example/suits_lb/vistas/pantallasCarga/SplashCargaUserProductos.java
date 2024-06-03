package com.example.suits_lb.vistas.pantallasCarga;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
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
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.suits_lb.R;
import com.example.suits_lb.controladores.SQLiteBD.DatabaseHelperUserPr;
import com.example.suits_lb.controladores.SQLiteBD.ProductosContractUser;
import com.example.suits_lb.controladores.conexionSuitsLbDB;
import com.example.suits_lb.modelos.Producto;
import com.example.suits_lb.vistas.UserViews.HomeApp;
import com.example.suits_lb.vistas.UserViews.recyclerViewPrUser.listaUserProductsAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SplashCargaUserProductos extends AppCompatActivity {
    private static int SPLASH_TIME_OUT =4000;

    public static ArrayList productosUser = new ArrayList();
    private DatabaseHelperUserPr dbHelperUserPr;
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
        dbHelperUserPr = new DatabaseHelperUserPr(this);
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
        SQLiteDatabase db = dbHelperUserPr.getWritableDatabase();
        db.execSQL("DELETE FROM productosUser");
        StringRequest request = new StringRequest(Request.Method.POST, conexionSuitsLbDB.DIRECCION_URL_RAIZ + "/adminRopa/mostrarProductosUser.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        productosUser.clear();
                        try {

                            JSONObject jsonObject = new JSONObject(response);
                            String exito = jsonObject.getString("exito");
                            JSONArray jsonArray = jsonObject.getJSONArray("productos");
                            if (exito.equals("1")) {
                                Intent intent = new Intent(SplashCargaUserProductos.this, HomeApp.class);
                                for (int i = 0; i < jsonArray.length(); i++) {
                                    ContentValues values = new ContentValues();
                                    JSONObject object = jsonArray.getJSONObject(i);
                                    String codRopa = object.getString("codRopa");
                                    String nombreRopa = object.getString("nombre");
                                    String descripcion = object.getString("descripcion");
                                    Double precio = object.getDouble("precio");
                                    String categoria = object.getString("categoria");
                                    Integer stock = object.getInt("stock");
                                    String ventaDisponible = object.getString("ventaDisponible");
                                    String imgProducto = object.getString("imgProducto");
                                    Producto p1 = new Producto(codRopa,nombreRopa,descripcion,precio,categoria,stock,imgProducto,ventaDisponible);
                                    values.put(ProductosContractUser.AuxProductosEntries.COLUMN_CODROPA,codRopa);
                                    values.put(ProductosContractUser.AuxProductosEntries.COLUMN_NOMBREROPA,nombreRopa);
                                    values.put(ProductosContractUser.AuxProductosEntries.COLUMN_DESCRIPCION,descripcion);
                                    values.put(ProductosContractUser.AuxProductosEntries.COLUMN_PRECIO,precio);
                                    values.put(ProductosContractUser.AuxProductosEntries.COLUMN_CATEGORIA,categoria);
                                    values.put(ProductosContractUser.AuxProductosEntries.COLUMN_STOCK,stock);
                                    values.put(ProductosContractUser.AuxProductosEntries.COLUMN_IMGPRODUCTO,imgProducto);
                                    values.put(ProductosContractUser.AuxProductosEntries.COLUMN_VENTADISPONIBLE,ventaDisponible);
                                    db.insert(ProductosContractUser.AuxProductosEntries.TABLE_NAME,null,values);
                                    productosUser.add(p1);

                                }

                                db.close();
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
                return params;
            }

        };
        RequestQueue requestQueue = Volley.newRequestQueue(SplashCargaUserProductos.this);
        requestQueue.add(request);
    }


}