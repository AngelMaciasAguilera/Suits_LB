package com.example.suits_lb.vistas.AdminViews.AdminCategoriesView;

import static com.example.suits_lb.vistas.pantallasCarga.SplashCargaAdminCategories.allCatRopaAdmin;

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
import com.example.suits_lb.modelos.CategoriaRopa;
import com.example.suits_lb.vistas.AdminViews.AdminCategoriesView.recyclerView.ListaCategoryAdapter;
import com.example.suits_lb.vistas.AdminViews.BackEndSelection;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainCategoryScreenManager extends AppCompatActivity {
    private RecyclerView rvManagementCategories;
    private ImageButton imgbtSearchCategory;
    private ImageButton imgbtReturnCategory;
    private ListaCategoryAdapter listaCategoryAdapter;
    private ArrayList<CategoriaRopa> categoriasRopa;
    private FloatingActionButton ftbAddingCategory;
    private EditText edtBuscarCategory;
    private Button goToBackEndSelection;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_category_screen_manager);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        ftbAddingCategory = findViewById(R.id.fbtaddCategory);
        imgbtSearchCategory = findViewById(R.id.imgbSearchCategory);
        rvManagementCategories = findViewById(R.id.rvCategory);
        imgbtReturnCategory = findViewById(R.id.imgbReturnCategory);
        imgbtReturnCategory.setEnabled(false);
        imgbtReturnCategory.setVisibility(View.INVISIBLE);
        goToBackEndSelection = findViewById(R.id.goToBackEndSelection);
        edtBuscarCategory = findViewById(R.id.edtSearchCategory);
        categoriasRopa = allCatRopaAdmin;
        listaCategoryAdapter = new ListaCategoryAdapter(this, categoriasRopa);
        int orientation = getResources().getConfiguration().orientation;
        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            rvManagementCategories.setLayoutManager(new GridLayoutManager(this, 2));
        } else {
            rvManagementCategories.setLayoutManager(new LinearLayoutManager(this));
        }
        rvManagementCategories.setAdapter(listaCategoryAdapter);

        goToBackEndSelection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToBackEndSelection();
            }
        });

        ftbAddingCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToAddCategory();
            }
        });

        imgbtSearchCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchCategory();
            }
        });

        imgbtReturnCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                returnSearch();
            }
        });

    }


    private void goToAddCategory(){
        this.startActivity(new Intent(this, AddingCategoriesScreen.class));
    }

    private void goToBackEndSelection(){
        this.startActivity(new Intent(this, BackEndSelection.class));
    }



    private void searchCategory(){
        imgbtReturnCategory.setEnabled(true);
        imgbtReturnCategory.setVisibility(View.VISIBLE);
        String adminEmailSearched = String.valueOf(edtBuscarCategory.getText());
        ArrayList<CategoriaRopa>catSearched = new ArrayList<>();
        for (CategoriaRopa car: categoriasRopa) {
            if (car.getNomCategory().contains(adminEmailSearched)){
                catSearched.add(car);
            }
        }
        listaCategoryAdapter.setCategorias(catSearched);
        listaCategoryAdapter.notifyDataSetChanged();
    }
    private void returnSearch(){
        imgbtReturnCategory.setEnabled(false);
        imgbtReturnCategory.setVisibility(View.INVISIBLE);
        listaCategoryAdapter.setCategorias(categoriasRopa);
        listaCategoryAdapter.notifyDataSetChanged();
    }


}