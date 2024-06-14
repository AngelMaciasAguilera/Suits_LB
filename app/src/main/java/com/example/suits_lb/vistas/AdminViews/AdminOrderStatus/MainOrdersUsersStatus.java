package com.example.suits_lb.vistas.AdminViews.AdminOrderStatus;

import static com.example.suits_lb.vistas.pantallasCarga.SplashCargaAllUsersOrders.allUsersOrdersSplash;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.suits_lb.R;
import com.example.suits_lb.modelos.Pedido;
import com.example.suits_lb.vistas.AdminViews.AdminAdminsView.recyclerView.ListaAdminAdapter;
import com.example.suits_lb.vistas.AdminViews.AdminOrderStatus.recyclerViewOrdersAdmin.ListaAdminOrdersAdapter;
import com.example.suits_lb.vistas.AdminViews.BackEndSelection;

import java.util.ArrayList;

public class MainOrdersUsersStatus extends AppCompatActivity {
    private EditText edtSearchOrders;
    private ImageButton imgbtSearchOrders;
    private ArrayList<Pedido> allOrdersUsers;
    private RecyclerView rvOrdersUsers;
    private ListaAdminOrdersAdapter laoa;

    private ImageButton imgbReturnUserMOUS;
    private Button goToBackEndSelectionMOUS;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_orders_users_status);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        rvOrdersUsers = findViewById(R.id.rvOrdersAdmin);
        allOrdersUsers = allUsersOrdersSplash;
        laoa = new ListaAdminOrdersAdapter(this, allOrdersUsers);
        rvOrdersUsers.setLayoutManager(new GridLayoutManager(this, 1));
        rvOrdersUsers.setAdapter(laoa);
        goToBackEndSelectionMOUS = findViewById(R.id.goToBackEndSelectionMOUS);

        imgbReturnUserMOUS = findViewById(R.id.imgbReturnAdminMOUS);
        imgbReturnUserMOUS.setVisibility(View.INVISIBLE);
        imgbReturnUserMOUS.setEnabled(false);
        edtSearchOrders = findViewById(R.id.edtSearchOrders);
        imgbtSearchOrders = findViewById(R.id.imgbtSearchOrders);
        
        imgbtSearchOrders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchOrder();
            }
        });

        imgbReturnUserMOUS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                returnSearch();
            }
        });
        goToBackEndSelectionMOUS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToBackEndSelection();
            }
        });
    }

    private void searchOrder() {
        imgbReturnUserMOUS.setVisibility(View.VISIBLE);
        imgbReturnUserMOUS.setEnabled(true);
        String orderSearched = String.valueOf(edtSearchOrders.getText());
        ArrayList<Pedido> ordersObtained = new ArrayList<>();
        for (Pedido p1:allOrdersUsers) {
            if (p1.getConcepto().toUpperCase().contains(orderSearched.toUpperCase()) || p1.getEmail().toUpperCase().contains(orderSearched.toUpperCase())
                    || p1.getDireccion().toUpperCase().contains(orderSearched.toUpperCase()) || p1.getEstado().toUpperCase().contains(orderSearched.toUpperCase())){
                ordersObtained.add(p1);
            }
        }

        this.laoa.setUsersOrders(ordersObtained);
        this.laoa.notifyDataSetChanged();
    }

    private void returnSearch(){
        imgbReturnUserMOUS.setVisibility(View.INVISIBLE);
        imgbReturnUserMOUS.setEnabled(false);
        this.laoa.setUsersOrders(allOrdersUsers);
        this.laoa.notifyDataSetChanged();
    }

    private void goToBackEndSelection(){
        startActivity(new Intent(this, BackEndSelection.class));
    }
}