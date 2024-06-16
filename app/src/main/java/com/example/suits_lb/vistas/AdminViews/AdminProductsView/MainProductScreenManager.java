package com.example.suits_lb.vistas.AdminViews.AdminProductsView;

import static com.example.suits_lb.vistas.pantallasCarga.SplashCargaProductosAdmin.adminAllProducts;

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
        productos = adminAllProducts;
        listaProductAdapter = new ListaProductoAdapter(this, productos);
        int orientation = getResources().getConfiguration().orientation;
        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            rvManagementProducts.setLayoutManager(new GridLayoutManager(this, 2));
        } else {
            rvManagementProducts.setLayoutManager(new LinearLayoutManager(this));
        }
        rvManagementProducts.setAdapter(listaProductAdapter);

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