package com.example.suits_lb.vistas.pantallasCarga;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.ArrayAdapter;

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
import com.example.suits_lb.modelos.Producto;
import com.example.suits_lb.vistas.AdminViews.AdminProductsView.ManagementProductScreen;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SplashCargaProductos extends AppCompatActivity {
    private ArrayList<CategoriaRopa> catRopa = new ArrayList<>();
    private String[] nombresCategorias;
    private Producto prtopass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splash_carga_productos);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Intent intent = getIntent();
        prtopass = (Producto) intent.getSerializableExtra("producto");
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                obtenerCategorias();
            }
        },3000);
    }


    private void obtenerCategorias(){
        StringRequest request = new StringRequest(Request.Method.POST, conexionSuitsLbDB.DIRECCION_URL_RAIZ + "/adminCategories/mostrarCategorias.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        catRopa.clear();
                        Log.d("AddingProductScreen", response);
                        try {

                            JSONObject jsonObject = new JSONObject(response);
                            String exito = jsonObject.getString("exito");
                            JSONArray jsonArray = jsonObject.getJSONArray("categorias");
                            if (exito.equals("1")) {
                                for (int i = 0; i < jsonArray.length(); i++) {
                                    JSONObject object = jsonArray.getJSONObject(i);
                                    String codCategoria = object.getString("codCategoria");
                                    String nombreCategoria = object.getString("nombreCategoria");

                                    CategoriaRopa c1 = new CategoriaRopa(codCategoria,nombreCategoria);
                                    catRopa.add(c1);
                                }
                                nombresCategorias = new String[catRopa.size()];
                                for (int i = 0; i < nombresCategorias.length; i++) {
                                    nombresCategorias[i] = catRopa.get(i).getNomCategory();
                                }
                                Intent intent = new Intent(SplashCargaProductos.this, ManagementProductScreen.class);
                                intent.putExtra("nombreCategorias",nombresCategorias);
                                intent.putExtra("categoriasRopa",catRopa);
                                intent.putExtra("producto",prtopass);
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
        RequestQueue requestQueue = Volley.newRequestQueue(SplashCargaProductos.this);
        requestQueue.add(request);
    }


}