package com.example.suits_lb.vistas.UserViews;

import static com.example.suits_lb.vistas.pantallasCarga.SplashCargaProductosMinimized.productsMinimized;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.suits_lb.R;
import com.example.suits_lb.modelos.Carrito;
import com.example.suits_lb.vistas.UserViews.recyclerViewProductSummary.ListProductSummaryAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class CheckOutPageUser extends AppCompatActivity {
    private Button btSeeProductsMinimized;
    private Integer idFactura;

    private ArrayList<Carrito>userProducts = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_check_out_page_user);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        userProducts = productsMinimized;
        idFactura = Integer.valueOf(String.valueOf(getIntent().getStringExtra("idFactura")));
        btSeeProductsMinimized = findViewById(R.id.btSeeAllProductsMinimized);
        btSeeProductsMinimized.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showOrderSummaryProducts();
            }
        });

    }

    private void showOrderSummaryProducts() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialog_seeproduct_summary, null);
        builder.setView(dialogView);

        RecyclerView recyclerView = dialogView.findViewById(R.id.recycler_view_order_summary);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ListProductSummaryAdapter listProductSummaryAdapter = new ListProductSummaryAdapter(this,productsMinimized);
        recyclerView.setAdapter(listProductSummaryAdapter);

        builder.setPositiveButton("OK", null);
        builder.create().show();
    }
}