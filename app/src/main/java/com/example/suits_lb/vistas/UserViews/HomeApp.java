package com.example.suits_lb.vistas.UserViews;

import static com.example.suits_lb.vistas.pantallasCarga.SplashCargaUserProductos.productosUser;
import static com.example.suits_lb.vistas.pantallasCarga.SplashCargaUserProductosFiltrados.productosUserFiltrados;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.suits_lb.R;
import com.example.suits_lb.controladores.SQLiteBD.DatabaseHelperUserCart;
import com.example.suits_lb.modelos.Producto;
import com.example.suits_lb.vistas.UserViews.recyclerViewPrUser.listaUserProductsAdapter;
import com.example.suits_lb.vistas.pantallasCarga.SplashCargaUserProductos;
import com.example.suits_lb.vistas.pantallasCarga.SplashCargaUserProductosFiltrados;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class HomeApp extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    private DrawerLayout drawerLayout;
    private ArrayList<Producto>productos = new ArrayList<>();

    private RecyclerView rvProductosUser;

    private MenuItem hiddenOption;

    private String emailUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home_app);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.drawer_layout), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        emailUser = getIntent().getStringExtra("emailUsuario");
        Log.d("Email del usuario",String.valueOf(emailUser));
        NavigationView navigationView = findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);
        hiddenOption = navigationView.getMenu().findItem(R.id.seeAllProducts);

        if(getIntent().getStringExtra("productosFiltrados") != null){
            productos = productosUserFiltrados;
            hiddenOption.setVisible(true);
        }else{
            productos = productosUser;
            hiddenOption.setVisible(false);
        }


        Log.d("Cantidad de productos",String.valueOf(productos.size()));
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();


        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation_view);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                return true;
            }
        });

        rvProductosUser = findViewById(R.id.rvUserProducts);
        rvProductosUser.setLayoutManager(new GridLayoutManager(this,2));
        listaUserProductsAdapter adapter = new listaUserProductsAdapter(this,productos);
        adapter.setEmailUser(emailUser);
        rvProductosUser.setAdapter(adapter);

    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if(itemId == R.id.seeAllProducts){
            Intent intent = new Intent(this, SplashCargaUserProductos.class);
            intent.putExtra("emailUsuario",emailUser);
            hiddenOption.setVisible(false);
            startActivity(intent);
        }


        if(itemId == R.id.shoescategory){
            String codZap = "ROPZAP";
            filtrarProductos(codZap);
        }
        if (itemId == R.id.suitscategory){
            String codSuit = "ROPTRAJ";
            filtrarProductos(codSuit);
        }

        if (itemId == R.id.tshirtcategory){
            String codCam = "ROPCAM";
            filtrarProductos(codCam);
        }

        if (itemId == R.id.pantscategory){
            String codPant = "ROPPANT";
            filtrarProductos(codPant);
        }

        if (itemId == R.id.hoodiescategory){
            String codHood = "ROPHOOD";
            filtrarProductos(codHood);
        }


        //drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else{
            super.onBackPressed();
        }
    }

    private void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }

    private void filtrarProductos(String categoriaIntroducida){
        Intent intent = new Intent(this, SplashCargaUserProductosFiltrados.class);
        intent.putExtra("categoriaIntroducida",categoriaIntroducida).putExtra("emailUsuario",emailUser);
        this.startActivity(intent);
    }

}