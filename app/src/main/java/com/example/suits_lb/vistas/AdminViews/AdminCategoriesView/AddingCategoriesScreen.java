package com.example.suits_lb.vistas.AdminViews.AdminCategoriesView;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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
import com.example.suits_lb.vistas.AdminViews.AdminAdminsView.AddingAdminsScreen;

import java.util.HashMap;
import java.util.Map;

public class AddingCategoriesScreen extends AppCompatActivity {
    private EditText edtmaCodCategory;
    private EditText edtmaNameCategory;

    private Button btCancelAdding;

    private Button btAddCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_adding_categories_screen);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btCancelAdding = findViewById(R.id.btCancelAddingCategory);
        btAddCategory = findViewById(R.id.btAddCategory);
        edtmaCodCategory = findViewById(R.id.edtmaCodCategory);
        edtmaNameCategory = findViewById(R.id.edtmaNameCategory);


        btAddCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addCategory();
            }
        });

        btCancelAdding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToMainCategoryScreenManager();
            }
        });

    }

    private void goToMainCategoryScreenManager(){
        this.startActivity(new Intent(this,MainCategoryScreenManager.class));
    }

    private void addCategory(){
        String codCategory = String.valueOf(edtmaCodCategory.getText());
        String nameCategory = String.valueOf(edtmaNameCategory.getText());

        if(!codCategory.isEmpty() && !nameCategory.isEmpty()){
            StringRequest request = new StringRequest(Request.Method.POST, conexionSuitsLbDB.DIRECCION_URL_RAIZ + "/adminCategories/insertarCategoria.php",
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            Log.d("AddingAdminScreen",response);
                            if (response.equalsIgnoreCase("categoria insertada")){
                                edtmaCodCategory.getText().clear();
                                edtmaNameCategory.getText().clear();
                                Toast.makeText(AddingCategoriesScreen.this,"Categoria insertada correctamente",Toast.LENGTH_SHORT).show();

                            }else{
                                informarAlUsuario("Codigo de categoria existente","El codigo de categoria a insertar ya existe");
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
                    params.put("codCategory",codCategory);
                    params.put("nameCategory",nameCategory);
                    return params;
                }

            };
            RequestQueue requestQueue = Volley.newRequestQueue(AddingCategoriesScreen.this);
            requestQueue.add(request);
        }else{
            informarAlUsuario("Informe de error","Debes rellenar todos los campos");
        }

    }

    private void informarAlUsuario(String titulo, String mensajeDialogo){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(titulo);
        builder.setMessage(mensajeDialogo);
        builder.setPositiveButton("Ok",new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

}