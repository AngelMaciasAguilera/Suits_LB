package com.example.suits_lb.vistas.AdminViews.AdminAdminsView;

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

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class AddingAdminsScreen extends AppCompatActivity {
    private EditText edtasEmailAdmin;
    private EditText edtasNameAdmin;
    private EditText edtasPasswordAdmin;
    private EditText edtasAgeAdmin;
    private EditText edtasPhoneAdmin;

    private Button btCancelAddAdmin;
    private Button btAddAdmin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_adding_admins_screen);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        edtasNameAdmin = findViewById(R.id.edtmaAdminName);
        edtasAgeAdmin = findViewById(R.id.edtmaAdminAge);
        edtasPhoneAdmin = findViewById(R.id.edtmaAdminPhone);
        edtasEmailAdmin = findViewById(R.id.edtmaAdminEmail);
        edtasPasswordAdmin = findViewById(R.id.edtmaAdminPassword);

        btAddAdmin = findViewById(R.id.btUpdateAdmin);
        btCancelAddAdmin = findViewById(R.id.btDeleteAdmin);
        btAddAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addAdmin();
            }
        });

        btCancelAddAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancelAddingAdmin();
            }
        });


    }

    private void cancelAddingAdmin(){
        this.startActivity(new Intent(this,MainAdminScreenManager.class));
    }

    private void addAdmin() {
        String nombreAdmin = String.valueOf(edtasNameAdmin.getText());
        String edadAdmin = String.valueOf(edtasAgeAdmin.getText());
        String phoneAdmin = String.valueOf(edtasPhoneAdmin.getText());
        String emailAdmin = String.valueOf(edtasEmailAdmin.getText());
        String password = String.valueOf(edtasPasswordAdmin.getText());
        String passwordAdminEncrypted = encriptarPassword(password);
        StringRequest request = new StringRequest(Request.Method.POST, conexionSuitsLbDB.DIRECCION_URL_RAIZ + "/adminAdmins/insertarAdmin.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("AddingAdminScreen",response);
                        if (response.equalsIgnoreCase("datos insertados")){
                            edtasEmailAdmin.getText().clear();
                            edtasPasswordAdmin.getText().clear();
                            edtasNameAdmin.getText().clear();
                            edtasAgeAdmin.getText().clear();
                            edtasPhoneAdmin.getText().clear();
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
                params.put("adminName",nombreAdmin);
                params.put("adminEmail",emailAdmin);
                params.put("adminPhone",phoneAdmin);
                params.put("adminAge",edadAdmin);
                params.put("adminPassword",passwordAdminEncrypted);
                return params;
            }

        };
        RequestQueue requestQueue = Volley.newRequestQueue(AddingAdminsScreen.this);
        requestQueue.add(request);
    }

    private String encriptarPassword(String password){
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1)
                    hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}