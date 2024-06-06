package com.example.suits_lb.vistas;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.suits_lb.R;
import com.example.suits_lb.controladores.SQLiteBD.DatabaseHelperUserCart;
import com.example.suits_lb.controladores.conexionSuitsLbDB;
import com.example.suits_lb.vistas.AdminViews.BackEndSelection;
import com.example.suits_lb.vistas.UserViews.HomeApp;
import com.example.suits_lb.vistas.pantallasCarga.SplashCargaUserProductos;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private TextView tvwLinkSignInPage;
    private Button  btRealizarLogIn;

    private EditText edtEmailUsuario;
    private EditText edtPasswordUsuario;

    private DatabaseHelperUserCart dbHelperUserCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        tvwLinkSignInPage = findViewById(R.id.tvwLinkToSILogin);
        tvwLinkSignInPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               startSignInPage();
            }
        });

        btRealizarLogIn = findViewById(R.id.btAdminUsers);
        edtEmailUsuario = findViewById(R.id.edtLoginEmail);
        edtPasswordUsuario = findViewById(R.id.edtPasswordLogin);
        btRealizarLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                realizarLogIn();
            }
        });

        edtEmailUsuario.setText("kuanfrna@gmaul.com");
        edtPasswordUsuario.setText("12345678");
        dbHelperUserCart = new DatabaseHelperUserCart(this);
        dbHelperUserCart.deleteAllItems();

    }

    private void startSignInPage(){
        Intent linkToSignInPage = new Intent(this,SignInPage.class);
        this.startActivity(linkToSignInPage);

    }

    private void realizarLogIn(){
        String email = String.valueOf(edtEmailUsuario.getText());
        String password = String.valueOf(edtPasswordUsuario.getText());
        if (!email.isEmpty() && !password.isEmpty()){
            String passwordEncrypted = encriptarPassword(password);
            comprobarUsuario(email,passwordEncrypted);

        }else{
            informarAlUsuario("Campos vacios","Debes rellenar los campos para iniciar sesion");
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

    private void comprobarUsuario(String emailPassed, String passwordEncrypted){
        StringRequest request = new StringRequest(Request.Method.POST, conexionSuitsLbDB.DIRECCION_URL_RAIZ + "/LogIn.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        Log.d("SignInPage", s);
                        Integer answerQuery = Integer.parseInt(s);
                        if (answerQuery == 1){
                            startUsersScreen(emailPassed);
                        }else if(answerQuery == 2){
                            startAdminScreen();
                        }else{
                            informarAlUsuario("Usuario no encontrado","El usuario con los valores introducidos no existe");
                        }
                    }

                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Log.i("Prueba de que funciona","Llega hasta aqui");
                Log.d("Respuesta de la red",  String.valueOf(volleyError.networkResponse));
                edtEmailUsuario.setText(volleyError.getMessage());
            }
        }
        ){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<>();
                params.put("email",emailPassed);
                params.put("password",passwordEncrypted);
                return params;
            }
        };
        RequestQueue requestQueu= Volley.newRequestQueue(MainActivity.this);
        requestQueu.add(request);
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

    private void startAdminScreen(){
        this.startActivity(new Intent(this, BackEndSelection.class));
    }

    private void startUsersScreen(String emailUser){
        Log.d("MainActivity",emailUser);
        this.startActivity(new Intent(this, SplashCargaUserProductos.class).putExtra("emailUsuario",emailUser));
    }

}