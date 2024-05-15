package com.example.suits_lb.vistas;

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
import com.example.suits_lb.vistas.AdminViews.AdminAdminsView.MainAdminScreenManager;

public class BackEndSelection extends AppCompatActivity {
    Button BESAdminAdmins;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_back_end_selection);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        BESAdminAdmins = findViewById(R.id.btAdminAdmins);
        BESAdminAdmins.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goingToAdminAdmins();
            }
        });
    }

    private void goingToAdminAdmins(){
        this.startActivity( new Intent(this,MainAdminScreenManager.class));
    }
}