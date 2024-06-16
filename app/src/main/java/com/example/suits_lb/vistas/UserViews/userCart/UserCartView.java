package com.example.suits_lb.vistas.UserViews.userCart;

import static com.example.suits_lb.vistas.UserViews.HomeApp.emailUser;
import static com.example.suits_lb.vistas.pantallasCarga.SplashCargaUserCart.productosUser;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

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
import com.example.suits_lb.modelos.Carrito;
import com.example.suits_lb.modelos.Producto;
import com.example.suits_lb.vistas.MainActivity;
import com.example.suits_lb.vistas.UserViews.AboutUsPage;
import com.example.suits_lb.vistas.UserViews.HomeApp;
import com.example.suits_lb.vistas.UserViews.PrivacyPolitics;
import com.example.suits_lb.vistas.UserViews.recyclerViewPrUser.listaUserProductsAdapter;
import com.example.suits_lb.vistas.UserViews.userCart.recyclerViewUserCart.listaUserCartAdapter;
import com.example.suits_lb.vistas.pantallasCarga.SplashCargaProductosMinimized;
import com.example.suits_lb.vistas.pantallasCarga.SplashCargaUserCart;
import com.example.suits_lb.vistas.pantallasCarga.SplashCargaUserNotifications;
import com.example.suits_lb.vistas.pantallasCarga.SplashCargaUserPage;
import com.example.suits_lb.vistas.pantallasCarga.SplashCargaUserProductos;
import com.example.suits_lb.vistas.pantallasCarga.SplashCargaUserProductosFiltrados;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class UserCartView extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    private RecyclerView rvCartUser;
    private DrawerLayout drawerLayout;
    private ArrayList<Carrito> cartProducts = new ArrayList<>();
    private MenuItem hiddenOption;

    private FloatingActionButton ftbGoToCheckOutPage;
    private listaUserProductsAdapter lupa;
    private TextView tvwMyAccount;

    private Button btStripCart;

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
                if(item.getItemId() == R.id.nav_home_userCartView){
                    startActivity(new Intent(UserCartView.this, SplashCargaUserProductos.class));
                }

                if(item.getItemId() == R.id.nav_notifications_userCartView){
                    startActivity(new Intent(UserCartView.this, SplashCargaUserNotifications.class));
                }

                return true;
            }
        });

        listaUserCartAdapter adapter = new listaUserCartAdapter(this,cartProducts);
        rvCartUser.setLayoutManager(new GridLayoutManager(this,1));
        rvCartUser.setAdapter(adapter);
        ftbGoToCheckOutPage = findViewById(R.id.ftbGoToCheckOutPage);
        ftbGoToCheckOutPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!cartProducts.isEmpty()) {
                    startActivity(new Intent(UserCartView.this, SplashCargaProductosMinimized.class));
                }else{
                    informarAlUsuario("No se puede pagar","Para pagar necesita tener elementos en su carrito");
                }
            }
        });
        tvwMyAccount = findViewById(R.id.tvwGoToAccountUser_userCartView);
        tvwMyAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToUserPage();
            }
        });

        btStripCart = findViewById(R.id.btStripCart);

        if (cartProducts.isEmpty()){
            btStripCart.setEnabled(false);
            btStripCart.setBackgroundColor(getResources().getColor(R.color.darkGray));
        }
        btStripCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseHelperUserCart dbHelperUserCart = new DatabaseHelperUserCart(UserCartView.this);
                dbHelperUserCart.deleteAllItems();
                productosUser.clear();
                startActivity(new Intent(UserCartView.this,SplashCargaUserCart.class));
            }
        });

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

        if (itemId == R.id.privacypolitic){
            startActivity(new Intent(this, PrivacyPolitics.class).putExtra("tipoUsuario","UR"));
        }

        if (itemId == R.id.aboutuspage){
            startActivity(new Intent(this, AboutUsPage.class));
        }

        if (itemId == R.id.logout){
            emailUser = null;
            Intent intent = new Intent(this, MainActivity.class);
            this.startActivity(intent);
        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
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

    private void filtrarProductos(String categoriaIntroducida){
        Intent intent = new Intent(this, SplashCargaUserProductosFiltrados.class);
        intent.putExtra("categoriaIntroducida",categoriaIntroducida);
        this.startActivity(intent);
    }
    private void goToUserPage(){
        this.startActivity(new Intent(this, SplashCargaUserPage.class));
    }

}