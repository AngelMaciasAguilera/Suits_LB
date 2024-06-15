package com.example.suits_lb.vistas.UserViews;

import static com.example.suits_lb.vistas.UserViews.HomeApp.emailUser;
import static com.example.suits_lb.vistas.pantallasCarga.SplashCargaUserNotifications.userNotifications;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
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
import com.example.suits_lb.vistas.MainActivity;
import com.example.suits_lb.vistas.UserViews.recyclerViewUserNotifications.ListNotificationsUserAdapter;
import com.example.suits_lb.vistas.pantallasCarga.SplashCargaUserCart;
import com.example.suits_lb.vistas.pantallasCarga.SplashCargaUserNotifications;
import com.example.suits_lb.vistas.pantallasCarga.SplashCargaUserPage;
import com.example.suits_lb.vistas.pantallasCarga.SplashCargaUserProductos;
import com.example.suits_lb.vistas.pantallasCarga.SplashCargaUserProductosFiltrados;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class NotificationsUserView extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private RecyclerView rvUserNotifications;
    private DrawerLayout drawerLayout;
    private ArrayList<String> notificaciones = new ArrayList<>();
    private MenuItem hiddenOption;

    private ListNotificationsUserAdapter lnua;
    private TextView tvwMyAccount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_notifications_user_view);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.drawer_layout_userNotificationsView), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        rvUserNotifications = findViewById(R.id.rvUserProducts_userNotificationsView);
        notificaciones = userNotifications;
        rvUserNotifications.setLayoutManager(new GridLayoutManager(this,1));
        lnua = new ListNotificationsUserAdapter(this, notificaciones);
        rvUserNotifications.setAdapter(lnua);
        NavigationView navigationView = findViewById(R.id.navigation_view_userNotificationsView);
        navigationView.setNavigationItemSelectedListener(this);
        hiddenOption = navigationView.getMenu().findItem(R.id.seeAllProducts);
        hiddenOption.setVisible(true);
        Toolbar toolbar = findViewById(R.id.toolbar_userNotificationsView);
        setSupportActionBar(toolbar);
        drawerLayout = findViewById(R.id.drawer_layout_userNotificationsView);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        tvwMyAccount = findViewById(R.id.tvwGoToAccountUser_userNotificationsView);
        tvwMyAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToUserPage();
            }
        });
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation_view_userNotificationsView);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId() == R.id.nav_cart_userNotifications){
                    startActivity(new Intent(NotificationsUserView.this, SplashCargaUserCart.class));
                }

                if(item.getItemId() == R.id.nav_home_userNotifications){
                    startActivity(new Intent(NotificationsUserView.this, SplashCargaUserProductos.class));
                }

                return true;
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

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }

    private void goToUserPage(){
        this.startActivity(new Intent(this, SplashCargaUserPage.class));
    }
    private void filtrarProductos(String categoriaIntroducida){
        Intent intent = new Intent(this, SplashCargaUserProductosFiltrados.class);
        intent.putExtra("categoriaIntroducida",categoriaIntroducida);
        this.startActivity(intent);
    }
}