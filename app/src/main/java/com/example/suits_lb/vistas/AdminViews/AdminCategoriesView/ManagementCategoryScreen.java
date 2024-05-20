package com.example.suits_lb.vistas.AdminViews.AdminCategoriesView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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
import com.example.suits_lb.vistas.AdminViews.AdminAdminsView.ManagementAdminScreen;

import java.util.HashMap;
import java.util.Map;

public class ManagementCategoryScreen extends AppCompatActivity {
    private EditText edtmcCodCategory;
    private EditText edtmcNameCategory;
    private CategoriaRopa catRopa;
    private Button btCancelManagementCategory;
    private Button btDeleteCategory;
    private Button btUpdateCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_management_category_screen);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Intent intent = getIntent();
        catRopa = (CategoriaRopa) intent.getSerializableExtra("category");
        edtmcCodCategory = findViewById(R.id.edtmcCodCategory);
        edtmcNameCategory = findViewById(R.id.edtmcNameCategory);
        edtmcNameCategory.setText(catRopa.getNomCategory());
        edtmcCodCategory.setText(catRopa.getCodCategory());
        btCancelManagementCategory = findViewById(R.id.btCancelCategoryManagement);
        btDeleteCategory = findViewById(R.id.btDeleteCategory);
        btUpdateCategory = findViewById(R.id.btUpdateCategory);
        btCancelManagementCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToMainCategoryScreenManager();
            }
        });
        btDeleteCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteCategory();
            }
        });

        btUpdateCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateCategory();
            }
        });
    }


    private void goToMainCategoryScreenManager(){
        this.startActivity(new Intent(this, MainCategoryScreenManager.class));
    }


    private void updateCategory(){
        StringRequest request = new StringRequest(Request.Method.POST, conexionSuitsLbDB.DIRECCION_URL_RAIZ + "/adminCategories/actualizarCategoria.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("ManagementCategoryScreen",response);
                        if (response.equalsIgnoreCase("datos actualizados")){
                            goToMainCategoryScreenManager();
                        }else{
                            Log.d("Error updating admin",response);
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
                String codCategoria = String.valueOf(edtmcCodCategory.getText());
                String nombreCategoria = String.valueOf(edtmcNameCategory.getText());
                params.put("codCategoria",codCategoria);
                params.put("nombreCategoria",nombreCategoria);
                return params;
            }

        };
        RequestQueue requestQueue = Volley.newRequestQueue(ManagementCategoryScreen.this);
        requestQueue.add(request);
    }

    private void deleteCategory(){
        StringRequest request = new StringRequest(Request.Method.POST, conexionSuitsLbDB.DIRECCION_URL_RAIZ + "/adminCategories/eliminarCategoria.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("ManagementCategoryScreen",response);
                        if (response.equalsIgnoreCase("datos eliminados")){
                            goToMainCategoryScreenManager();
                        }else{
                            Log.d("Error deleting category",response);
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
                params.put("codCategory",catRopa.getCodCategory());
                return params;
            }

        };
        RequestQueue requestQueue = Volley.newRequestQueue(ManagementCategoryScreen.this);
        requestQueue.add(request);
    }

}