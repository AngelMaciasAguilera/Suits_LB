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
import com.example.suits_lb.vistas.AdminViews.AdminUserView.MainUserScreenManager;

public class BackEndSelection extends AppCompatActivity {
    Button BESAdminAdmins;
    Button BESAdminUsers;
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
        BESAdminUsers = findViewById(R.id.btAdminUsers);
        BESAdminAdmins.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goingToAdminAdmins();
            }
        });

        BESAdminUsers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goingToAdminUsers();
            }
        });

    }

    private void goingToAdminAdmins(){
        this.startActivity( new Intent(this,MainAdminScreenManager.class));
    }

    private void goingToAdminUsers(){
        this.startActivity(new Intent(this, MainUserScreenManager.class));
    }
}