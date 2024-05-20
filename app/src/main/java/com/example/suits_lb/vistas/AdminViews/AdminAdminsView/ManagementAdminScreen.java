package com.example.suits_lb.vistas.AdminViews.AdminAdminsView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

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

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class ManagementAdminScreen extends AppCompatActivity {
    private Button btCancelManagementAdmin;
    private Button btDeleteAdmin;
    private Button btUpdateAdmin;
    private Cliente administrador;
    private EditText edtmaAdminAge;
    private EditText edtmaAdminPhone;
    private EditText edtmaAdminPassword;
    private EditText edtmaAdminEmail;
    private EditText edtmaAdminName;
    private String oldPassword;
    Spinner spAdminFeatures;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_management_admin_screen);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        String[] valoresSpinner = new String[]{"S","N"};
        Intent intent = getIntent();
        //Obtenemos al administrador
        administrador = (Cliente) intent.getSerializableExtra("administrador");
        Log.d("El admin",administrador.toString());
        //Enlazamos los campos de texto con la vista
        edtmaAdminName = findViewById(R.id.edtmaAdminName);
        edtmaAdminEmail = findViewById(R.id.edtmaAdminEmail);
        edtmaAdminAge = findViewById(R.id.edtmaAdminAge);
        edtmaAdminPassword = findViewById(R.id.edtmaAdminPassword);
        btUpdateAdmin = findViewById(R.id.btUpdateAdmin);
        btDeleteAdmin = findViewById(R.id.btDeleteAdmin);
        oldPassword = administrador.getPassword();
        edtmaAdminPhone = findViewById(R.id.edtmaAdminPhone);
        spAdminFeatures = findViewById(R.id.spAdminFeatures);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,valoresSpinner);
        spAdminFeatures.setAdapter(arrayAdapter);
        spAdminFeatures.setSelection(arrayAdapter.getPosition(administrador.getEsAdmin()));

        //Alteramos el texto de los campos, introduciendo su valor acorde al administrador seleccionado
        edtmaAdminName.setText(administrador.getNombre());
        edtmaAdminEmail.setText(administrador.getEmail());
        edtmaAdminPassword.setText(administrador.getPassword());
        edtmaAdminPhone.setText(String.valueOf(administrador.getTelefono()));
        edtmaAdminAge.setText(String.valueOf(administrador.getEdad()));


        btCancelManagementAdmin = findViewById(R.id.btCancelAdminManagement);
        btCancelManagementAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startManagementAdmin();
            }
        });
        btDeleteAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteAdmin();
            }
        });

        btUpdateAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateAdmin();
            }
        });




    }

    private void deleteAdmin(){
        StringRequest request = new StringRequest(Request.Method.POST, conexionSuitsLbDB.DIRECCION_URL_RAIZ + "/adminAdmins/eliminarAdmin.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("AddingAdminScreen",response);
                        if (response.equalsIgnoreCase("datos eliminados")){
                            startManagementAdmin();
                        }else{
                            Log.d("Error deleting admin",response);
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
                params.put("adminEmail",administrador.getEmail());
                return params;
            }

        };
        RequestQueue requestQueue = Volley.newRequestQueue(ManagementAdminScreen.this);
        requestQueue.add(request);
    }
    private void updateAdmin(){
        StringRequest request = new StringRequest(Request.Method.POST, conexionSuitsLbDB.DIRECCION_URL_RAIZ + "/adminAdmins/actualizarAdmin.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("AddingAdminScreen",response);
                        if (response.equalsIgnoreCase("datos actualizados")){
                            startManagementAdmin();
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
                String newPassword = String.valueOf(edtmaAdminPassword.getText());
                String adminName = String.valueOf(edtmaAdminName.getText());
                String adminPhone = String.valueOf(edtmaAdminPhone.getText());
                String adminAge = String.valueOf(edtmaAdminAge.getText());
                String adminFeature = String.valueOf(spAdminFeatures.getSelectedItem());

                if (!oldPassword.equals(newPassword)){
                    newPassword = encriptarPassword(newPassword);
                }
                params.put("adminEmail",administrador.getEmail());
                params.put("adminPassword",newPassword);
                params.put("adminName",adminName);
                params.put("adminPhone",adminPhone);
                params.put("adminAge",adminAge);
                params.put("adminProperties",adminFeature);
                return params;
            }

        };
        RequestQueue requestQueue = Volley.newRequestQueue(ManagementAdminScreen.this);
        requestQueue.add(request);
    }

    private void startManagementAdmin(){
        this.startActivity(new Intent(this, MainAdminScreenManager.class));
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