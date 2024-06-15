package com.example.suits_lb.vistas.UserViews;

import static com.example.suits_lb.vistas.pantallasCarga.SplashCargaUserNotifications.userNotifications;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.suits_lb.R;
import com.example.suits_lb.vistas.UserViews.recyclerViewUserNotifications.ListNotificationsUserAdapter;

import java.util.ArrayList;

public class NotificationsUserView extends AppCompatActivity {
    private RecyclerView rvUserNotifications;
    private DrawerLayout drawerLayout;
    private ArrayList<String> notificaciones = new ArrayList<>();
    private MenuItem hiddenOption;
    private ImageButton imgbtSearchProducts;

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
    }


}