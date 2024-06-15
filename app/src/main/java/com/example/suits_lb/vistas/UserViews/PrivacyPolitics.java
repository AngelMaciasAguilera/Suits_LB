package com.example.suits_lb.vistas.UserViews;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.suits_lb.R;
import com.example.suits_lb.vistas.SignInPage;
import com.example.suits_lb.vistas.pantallasCarga.SplashCargaUserProductos;

public class PrivacyPolitics extends AppCompatActivity {
    private String tipoUsuario;
    private Button goBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_privacy_politics);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        tipoUsuario = getIntent().getStringExtra("tipoUsuario");

        goBack = findViewById(R.id.btExitPrivacyPolitics);

        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exitPrivacyPolitics();
            }
        });

    }

    private void exitPrivacyPolitics(){
        Intent intent;
        if(tipoUsuario.equals("UNR")){
            intent = new Intent(this, SignInPage.class);
        }else{
            intent = new Intent(this, SplashCargaUserProductos.class);
        }
        this.startActivity(intent);
    }
}