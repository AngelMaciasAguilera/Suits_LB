package com.example.suits_lb.vistas.AdminViews.AdminProductsView;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.suits_lb.R;
import com.example.suits_lb.controladores.conexionSuitsLbDB;
import com.example.suits_lb.modelos.Producto;
import com.example.suits_lb.vistas.AdminViews.AdminProductsView.recyclerView.ListaProductoAdapter;
import com.example.suits_lb.vistas.AdminViews.BackEndSelection;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainProductScreenManager extends AppCompatActivity {
    private RecyclerView rvManagementProducts;
    private ImageButton imgbtSearchProduct;
    private ImageButton imgbtReturnProduct;
    private ListaProductoAdapter listaProductAdapter;
    private ArrayList<Producto> productos;
    private FloatingActionButton ftbAddingProduct;
    private EditText edtBuscarProduct;
    private Button goToBackEndSelection;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_product_screen_manager);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ftbAddingProduct = findViewById(R.id.fbtaddProduct);
        imgbtSearchProduct = findViewById(R.id.imgbSearchProduct);
        rvManagementProducts = findViewById(R.id.rvProducts);
        imgbtReturnProduct = findViewById(R.id.imgbReturnProduct);
        imgbtReturnProduct.setEnabled(false);
        imgbtReturnProduct.setVisibility(View.INVISIBLE);
        goToBackEndSelection = findViewById(R.id.goToBackEndSelection);
        edtBuscarProduct = findViewById(R.id.edtSearchProduct);
        productos = new ArrayList<>();
        listaProductAdapter = new ListaProductoAdapter(this, productos);
        int orientation = getResources().getConfiguration().orientation;
        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            rvManagementProducts.setLayoutManager(new GridLayoutManager(this, 2));
        } else {
            rvManagementProducts.setLayoutManager(new LinearLayoutManager(this));
        }
        rvManagementProducts.setAdapter(listaProductAdapter);
        rellenarRecyclerView();
        imgbtSearchProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        imgbtReturnProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        goToBackEndSelection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToBackEndSelection();
            }
        });

        ftbAddingProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToAddProduct();
            }
        });

        imgbtSearchProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchProduct();
            }
        });

        imgbtReturnProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                returnSearch();
            }
        });
    }

    private void goToAddProduct(){
        this.startActivity(new Intent(this, AddingProductsScreen.class));
    }

    private void goToBackEndSelection(){
        this.startActivity(new Intent(this, BackEndSelection.class));
    }

    public void rellenarRecyclerView() {
        StringRequest request = new StringRequest(Request.Method.POST, conexionSuitsLbDB.DIRECCION_URL_RAIZ + "/adminRopa/mostrarProductosAdmin.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        productos.clear();
                        Log.d("ManagementProductScreen", response);
                        try {

                            JSONObject jsonObject = new JSONObject(response);
                            String exito = jsonObject.getString("exito");
                            JSONArray jsonArray = jsonObject.getJSONArray("productos");
                            if (exito.equals("1")) {
                                for (int i = 0; i < jsonArray.length(); i++) {
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
                                    productos.add(p1);
                                }
                                listaProductAdapter.setProductos(productos);
                                listaProductAdapter.notifyDataSetChanged();
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
        RequestQueue requestQueue = Volley.newRequestQueue(MainProductScreenManager.this);
        requestQueue.add(request);


    }

    private void searchProduct(){
        ArrayList<Producto> productosBuscados = new ArrayList<>();
        String nombreABuscar = String.valueOf(edtBuscarProduct.getText());
        for (Producto p1: productos) {
            if (p1.getNombre().contains(nombreABuscar)){
                productosBuscados.add(p1);
            }
        }
        listaProductAdapter.setProductos(productosBuscados);
        listaProductAdapter.notifyDataSetChanged();
        imgbtReturnProduct.setVisibility(View.VISIBLE);
        imgbtReturnProduct.setEnabled(true);
    }

    private void returnSearch(){
        imgbtReturnProduct.setVisibility(View.INVISIBLE);
        imgbtReturnProduct.setEnabled(false);
        listaProductAdapter.setProductos(productos);
        listaProductAdapter.notifyDataSetChanged();
    }

}