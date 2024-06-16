package com.example.suits_lb.vistas.UserViews;

import static com.example.suits_lb.vistas.pantallasCarga.SplashCargaUserOrders.pedidosUser;
import static com.example.suits_lb.vistas.UserViews.HomeApp.emailUser;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.suits_lb.R;
import com.example.suits_lb.modelos.Pedido;
import com.example.suits_lb.vistas.MainActivity;
import com.example.suits_lb.vistas.UserViews.recyclerViewOrderSummary.ListaOrdersAdapter;
import com.example.suits_lb.vistas.pantallasCarga.SplashCargaUserPage;
import com.example.suits_lb.vistas.pantallasCarga.SplashCargaUserProductos;

import java.util.ArrayList;

public class AccountOrderUserPage extends AppCompatActivity {
    private RecyclerView rv_userOrders;
    private ListaOrdersAdapter loa;
    private ArrayList<Pedido> pedidos;

    private Button btGoToAccountDetails;
    private Button btGoToHomeAOUP;
    private Button btLogOutAOUP;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_account_order_user_page);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        pedidos = pedidosUser;//Variable estatica de la clase SplashCargaUserOrders
        rv_userOrders = findViewById(R.id.rv_OrdersUser);
        rv_userOrders.setLayoutManager(new LinearLayoutManager(this));
        loa = new ListaOrdersAdapter(this, pedidos);
        rv_userOrders.setAdapter(loa);
        btGoToAccountDetails = findViewById(R.id.btGoToAccountDetailsAOUP);
        btGoToHomeAOUP = findViewById(R.id.btGoToHome_orderUser);
        btLogOutAOUP = findViewById(R.id.btLogOutAOUP);

        btGoToAccountDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToAccountDetails();
            }});

        btGoToHomeAOUP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToHomeApp();
            }});

        btLogOutAOUP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logOut();
            }});


    }

    private void goToHomeApp(){
        Intent intent = new Intent(this, SplashCargaUserProductos.class);
        this.startActivity(intent);
    }

    private void  goToAccountDetails(){
        Intent intent = new Intent(this, SplashCargaUserPage.class);
        this.startActivity(intent);
    }

    private void logOut(){
        emailUser = null;
        Intent intent = new Intent(this, MainActivity.class);
        this.startActivity(intent);

    }

}