package com.example.suits_lb.vistas;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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
import com.example.suits_lb.controladores.ConversorImagenProducto;
import com.example.suits_lb.controladores.conexionSuitsLbDB;
import com.example.suits_lb.modelos.Cliente;
import com.example.suits_lb.vistas.UserViews.PrivacyPolitics;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class SignInPage extends AppCompatActivity{
    private Button cancelSignIn;
    private Button btSignIn;
    private EditText edtUserEmailSignIn;
    private EditText edtUserNameSignIn;
    private EditText edtUserAgeSignIn;
    private EditText edtUserPasswordSignIn;
    private EditText edtUserPhoneSignIn;
    private CheckBox cbPrivacyPolitics;
    private TextView goToPrivacyPolitics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sign_in_page);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        cancelSignIn = findViewById(R.id.btCancelSignIn);
        btSignIn = findViewById(R.id.btSignIn);
        edtUserEmailSignIn = findViewById(R.id.edtEmailUserSignIn);
        edtUserNameSignIn = findViewById(R.id.edtSignInNameUser);
        edtUserAgeSignIn = findViewById(R.id.edtUserAgeSignIn);
        edtUserPhoneSignIn  = findViewById(R.id.edtPhoneUserSignInPage);
        edtUserPasswordSignIn = findViewById(R.id.edtUserPasswordSignIn);
        cbPrivacyPolitics = findViewById(R.id.cbPrivacyPolitics);
        goToPrivacyPolitics = findViewById(R.id.tvwGoToPrivacyPolitics);
        cancelSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancelSignIn();
            }
        });

        btSignIn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                signInUser();
            }
        });

        goToPrivacyPolitics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToReadPrivacyPolitics();
            }
        });
    }

    private void goToReadPrivacyPolitics(){
        Intent intent = new Intent(this, PrivacyPolitics.class);
        intent.putExtra("tipoUsuario","UNR");
        this.startActivity(intent);
    }



    private void cancelSignIn(){
        this.startActivity(new Intent(this, MainActivity.class));
    }
    private void signInUser(){
        String email = edtUserEmailSignIn.getText().toString();
        String name = edtUserNameSignIn.getText().toString();
        String edad = edtUserAgeSignIn.getText().toString();
        String password = edtUserPasswordSignIn.getText().toString();
        String phone = String.valueOf(edtUserPhoneSignIn.getText());
        if (!edtUserAgeSignIn.getText().toString().isEmpty() && !edtUserNameSignIn.getText().toString().isEmpty() && !edtUserPhoneSignIn.getText().toString().isEmpty()){

            if(email.contains("@")){
                if(password.length() >= 8){
                    if(!cbPrivacyPolitics.isChecked()){
                        //Encripto la contraseña
                        String passwordEncrypted = encriptarPassword(password);
                        Cliente cliente = new Cliente(email,passwordEncrypted,name,Integer.parseInt(phone), "N",Integer.parseInt(edad));
                        insertarCliente(cliente);
                        this.startActivity(new Intent(this,MainActivity.class));
                    }else{
                        informarAlUsuario("Informe de error","Debe aceptar nuestros terminos de condiciones de uso");
                    }
                }else{
                    informarAlUsuario("Informe de error","Su contraseña debe tener 8 o mas carácteres");
                }
            }else{
                informarAlUsuario("Informe de error","Debe introducir un email correcto");
            }
        }else{
            informarAlUsuario("Informe de error","Todos los campos deben estar rellenos");
        }


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

    private void insertarCliente(Cliente cliente){
        StringRequest request = new StringRequest(Request.Method.POST, conexionSuitsLbDB.DIRECCION_URL_RAIZ + "/SignIn.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        Log.d("SignInPage", s);
                        if (s.equalsIgnoreCase("datos insertados")) {
                            Toast.makeText(SignInPage.this, "registrado correctamente", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(SignInPage.this, s, Toast.LENGTH_SHORT).show();
                        }
                    }

                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Log.i("Prueba de que funciona","Llega hasta aqui");
                Log.d("Respuesta de la red",  String.valueOf(volleyError.networkResponse));
                edtUserNameSignIn.setText(volleyError.getMessage());
            }
        }
        ){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<>();
                params.put("email",cliente.getEmail());
                params.put("password",cliente.getPassword());
                params.put("nombre",cliente.getNombre());
                params.put("phone", String.valueOf(cliente.getTelefono()));
                params.put("edad",String.valueOf(cliente.getEdad()));
                return params;
            }
        };
        RequestQueue requestQueu= Volley.newRequestQueue(SignInPage.this);
        requestQueu.add(request);
    }
}