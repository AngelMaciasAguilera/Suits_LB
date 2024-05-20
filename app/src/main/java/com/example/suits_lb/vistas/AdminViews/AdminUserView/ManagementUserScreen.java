package com.example.suits_lb.vistas.AdminViews.AdminUserView;

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
import com.example.suits_lb.modelos.Cliente;

import java.util.HashMap;
import java.util.Map;

public class ManagementUserScreen extends AppCompatActivity {
    private Button btDeleteUser;
    private Button btCancelManagementUser;

    private EditText edtmaUserEmail;
    private EditText edtmaUserName;
    private EditText edtmaUserAge;
    private EditText edtmaUserPhone;
    private EditText edtmaUserPassword;

    private Cliente cliente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_management_user_screen);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Intent intent = getIntent();
        cliente = (Cliente) intent.getSerializableExtra("cliente");
        edtmaUserEmail = findViewById(R.id.edtmaUserEmail);
        edtmaUserName = findViewById(R.id.edtmaUserName);
        edtmaUserAge = findViewById(R.id.edtmaUserAge);
        edtmaUserPhone = findViewById(R.id.edtmaUserPhone);
        edtmaUserPassword = findViewById(R.id.edtmaUserPassword);

        edtmaUserPassword.setText(cliente.getPassword());
        edtmaUserEmail.setText(cliente.getEmail());
        edtmaUserPhone.setText(String.valueOf(cliente.getTelefono()));
        edtmaUserName.setText(cliente.getNombre());
        edtmaUserAge.setText(String.valueOf(cliente.getEdad()));

        btDeleteUser = findViewById(R.id.btDeleteUser);
        btCancelManagementUser = findViewById(R.id.btCancelUserManagement);



        btDeleteUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteUser();
            }
        });

        btCancelManagementUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToUserManagerActivity();
            }
        });
    }

    private void goToUserManagerActivity(){
        this.startActivity(new Intent(this,MainUserScreenManager.class));
    }

    private void deleteUser(){
        StringRequest request = new StringRequest(Request.Method.POST, conexionSuitsLbDB.DIRECCION_URL_RAIZ + "/adminUsers/eliminarUser.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("DeleteUserScreen",response);
                        if (response.equalsIgnoreCase("datos eliminados")){
                            goToUserManagerActivity();
                        }else{
                            Log.d("Error deleting user",response);
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
                params.put("userEmail",cliente.getEmail());
                return params;
            }

        };
        RequestQueue requestQueue = Volley.newRequestQueue(ManagementUserScreen.this);
        requestQueue.add(request);
    }


}