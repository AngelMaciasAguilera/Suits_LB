package com.example.suits_lb.vistas.UserViews;

import static com.example.suits_lb.vistas.UserViews.HomeApp.emailUser;

import android.content.Intent;
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

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.suits_lb.R;
import com.example.suits_lb.controladores.conexionSuitsLbDB;
import com.example.suits_lb.modelos.Cliente;
import com.example.suits_lb.vistas.AdminViews.AdminUserView.ManagementUserScreen;
import com.example.suits_lb.vistas.MainActivity;
import com.example.suits_lb.vistas.pantallasCarga.SplashCargaUserOrders;

import java.util.HashMap;
import java.util.Map;

public class AccountUserDetails extends AppCompatActivity {
    private EditText edtUserEmail;
    private EditText edtUserName;
    private EditText edtUserPhone;
    private EditText edtUserAge;
    private Cliente usuario;
    private ImageButton btGoToHome;
    private Button btSeeMyOrders;
    private Button btLogOut;

    private Button btDeleteAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_account_user_details);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        usuario = (Cliente) getIntent().getSerializableExtra("usuario");
        edtUserEmail = findViewById(R.id.edtEmailUserAUD);
        edtUserName = findViewById(R.id.edtNameUserAUD);
        edtUserPhone = findViewById(R.id.edtPhoneUserAUD);
        edtUserAge = findViewById(R.id.edtAgeUserAUD);

        //Seteamos los valores del usuario a cada uno de los campos
        edtUserEmail.setText(usuario.getEmail());
        edtUserName.setText(usuario.getNombre());
        edtUserPhone.setText(String.valueOf(usuario.getTelefono()));
        edtUserAge.setText(String.valueOf(usuario.getEdad()));
        btGoToHome = findViewById(R.id.btGoToHomeApp);
        btSeeMyOrders = findViewById(R.id.btSeeMyOrders);
        btLogOut = findViewById(R.id.btLogOut);

        btGoToHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToHomeApp();
            }});

        btSeeMyOrders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToSeeMyOrders();
            }});

        btLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logOut();
            }});


        btDeleteAccount = findViewById(R.id.btDeleteAccountUser);
        btDeleteAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteUser();
            }
        });
    }

    private void goToHomeApp(){
        Intent intent = new Intent(this,HomeApp.class);
        this.startActivity(intent);
    }

    private void  goToSeeMyOrders(){
        Intent intent = new Intent(this, SplashCargaUserOrders.class);
        this.startActivity(intent);
    }

    private void logOut(){
        emailUser = null;
        Intent intent = new Intent(this, MainActivity.class);
        this.startActivity(intent);

    }

    private void deleteUser(){
        StringRequest request = new StringRequest(Request.Method.POST, conexionSuitsLbDB.DIRECCION_URL_RAIZ + "/adminUsers/eliminarUser.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("DeleteUserScreen",response);
                        if (response.equalsIgnoreCase("datos eliminados")){
                            emailUser = null;
                            startActivity(new Intent(AccountUserDetails.this, MainActivity.class));
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
                params.put("userEmail",emailUser);
                return params;
            }

        };
        RequestQueue requestQueue = Volley.newRequestQueue(AccountUserDetails.this);
        requestQueue.add(request);
    }

}