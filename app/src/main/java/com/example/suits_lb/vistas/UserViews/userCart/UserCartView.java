package com.example.suits_lb.vistas.UserViews.userCart;

import static com.example.suits_lb.vistas.pantallasCarga.SplashCargaUserCart.productosUser;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.suits_lb.R;
import com.example.suits_lb.modelos.Carrito;
import com.example.suits_lb.modelos.Producto;
import com.example.suits_lb.vistas.UserViews.HomeApp;
import com.example.suits_lb.vistas.UserViews.recyclerViewPrUser.listaUserProductsAdapter;
import com.example.suits_lb.vistas.UserViews.userCart.recyclerViewUserCart.listaUserCartAdapter;
import com.example.suits_lb.vistas.pantallasCarga.SplashCargaUserCart;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class UserCartView extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    private RecyclerView rvCartUser;
    private DrawerLayout drawerLayout;
    private ArrayList<Carrito> cartProducts = new ArrayList<>();
    private MenuItem hiddenOption;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_user_cart_view);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.drawer_layout_userCartView), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        rvCartUser = findViewById(R.id.rvUserProducts_userCartView);
        cartProducts = productosUser;
        NavigationView nav_view_cartView = findViewById(R.id.navigation_view_userCartView);
        nav_view_cartView.setNavigationItemSelectedListener(this);
        hiddenOption = nav_view_cartView.getMenu().findItem(R.id.seeAllProducts);

        Toolbar toolbar = findViewById(R.id.toolbar_userCartView);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawer_layout_userCartView);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation_view_userCartView);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                /*if(item.getItemId() == R.id.nav_cart){
                    startActivity(new Intent(HomeApp.this, SplashCargaUserCart.class));
                }
                */
                return true;
            }
        });

        listaUserCartAdapter adapter = new listaUserCartAdapter(this,cartProducts);
        rvCartUser.setLayoutManager(new GridLayoutManager(this,1));
        rvCartUser.setAdapter(adapter);

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        return false;
    }
}