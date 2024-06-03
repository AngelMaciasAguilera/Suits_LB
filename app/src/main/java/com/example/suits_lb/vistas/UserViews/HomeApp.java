package com.example.suits_lb.vistas.UserViews;

import static com.example.suits_lb.vistas.pantallasCarga.SplashCargaUserProductos.productosUser;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
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

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.suits_lb.R;
import com.example.suits_lb.controladores.SQLiteBD.DatabaseHelperUserPr;
import com.example.suits_lb.controladores.SQLiteBD.ProductosContractUser;
import com.example.suits_lb.controladores.conexionSuitsLbDB;
import com.example.suits_lb.modelos.Producto;
import com.example.suits_lb.vistas.UserViews.recyclerViewPrUser.listaUserProductsAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class HomeApp extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    private DrawerLayout drawerLayout;
    private ArrayList<Producto>productos = new ArrayList<>();

    private RecyclerView rvProductosUser;
    private DatabaseHelperUserPr dbUserObtainedProduct;


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
        dbUserObtainedProduct = new DatabaseHelperUserPr(this);
        obtenerProductosBDUser();
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);

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
        listaUserProductsAdapter adapter = new listaUserProductsAdapter(this,productosUser);
        rvProductosUser.setAdapter(adapter);

    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if(itemId == R.id.shoescategory){
            showMessage("Categoria de zapatillas elegida");
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

    private void obtenerProductosBDUser(){
        SQLiteDatabase db = dbUserObtainedProduct.getReadableDatabase();
        Cursor cursor = db.query(
                ProductosContractUser.AuxProductosEntries.TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                null
        );

        while(cursor.moveToNext()){
            String codRopa = cursor.getString(cursor.getColumnIndexOrThrow(ProductosContractUser.AuxProductosEntries.COLUMN_CODROPA));
            String nomRopa = cursor.getString(cursor.getColumnIndexOrThrow(ProductosContractUser.AuxProductosEntries.COLUMN_NOMBREROPA));
            String descripcionRopa = cursor.getString(cursor.getColumnIndexOrThrow(ProductosContractUser.AuxProductosEntries.COLUMN_DESCRIPCION));
            Double precio = cursor.getDouble(cursor.getColumnIndexOrThrow(ProductosContractUser.AuxProductosEntries.COLUMN_PRECIO));
            String categoria = cursor.getString(cursor.getColumnIndexOrThrow(ProductosContractUser.AuxProductosEntries.COLUMN_CATEGORIA));
            Integer stock = cursor.getInt(cursor.getColumnIndexOrThrow(ProductosContractUser.AuxProductosEntries.COLUMN_STOCK));
            String imgProducto = cursor.getString(cursor.getColumnIndexOrThrow(ProductosContractUser.AuxProductosEntries.COLUMN_IMGPRODUCTO));
            String ventaDisponible = cursor.getString((cursor.getColumnIndexOrThrow(ProductosContractUser.AuxProductosEntries.COLUMN_VENTADISPONIBLE)));
            Producto producto = new Producto(codRopa,nomRopa,descripcionRopa,precio,categoria,stock,imgProducto,ventaDisponible);
            Log.d("Productos en SQL",producto.toString());
        }
        cursor.close();
        db.close();

    }

}