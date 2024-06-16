package com.example.suits_lb.vistas.UserViews;

import static com.example.suits_lb.vistas.UserViews.HomeApp.emailUser;
import static com.example.suits_lb.vistas.pantallasCarga.SplashCargaProductosMinimized.productsMinimized;

import android.content.DialogInterface;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.suits_lb.R;
import com.example.suits_lb.modelos.Carrito;
import com.example.suits_lb.vistas.UserViews.recyclerViewProductSummary.ListProductSummaryAdapter;
import com.example.suits_lb.vistas.pantallasCarga.SplashCargaUserCart;
import com.example.suits_lb.vistas.pantallasCarga.SplashProcesarPedidosUser;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


import org.json.JSONException;

public class CheckOutPageUser extends AppCompatActivity implements OnMapReadyCallback {
    private Button btSeeProductsMinimized;
    private Integer idFactura;

    private ArrayList<Carrito>userProducts = new ArrayList<>();

    private MapView mapView;
    private GoogleMap googleMap;
    private EditText editTextAddress;
    private Geocoder geocoder;

    private Double ivaValue = 21.0;

    private Double precioTotal = 0.0;

    private TextView tvwIvaValue;

    private TextView tvwTotalPrice;

    private  Button btProcceedToPay;

    private EditText edtEmailUserCUP;

    private Button goToCartUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_check_out_page_user);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        userProducts = productsMinimized;
        idFactura = Integer.valueOf(String.valueOf(getIntent().getStringExtra("idFactura")));
        precioTotal = Double.valueOf(getIntent().getStringExtra("precioTotal"));
        Log.d("precioTotal",String.valueOf(precioTotal));
        btSeeProductsMinimized = findViewById(R.id.btSeeAllProductsMinimized);
        btSeeProductsMinimized.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showOrderSummaryProducts();
            }
        });

        mapView = findViewById(R.id.mapView);
        editTextAddress = findViewById(R.id.editTextAddressCUP);
        geocoder = new Geocoder(this);

        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(this);
        edtEmailUserCUP = findViewById(R.id.edtEmailUserCUP);
        edtEmailUserCUP.setText(emailUser);
        editTextAddress.setOnEditorActionListener((v, actionId, event) -> {
            String address = String.valueOf(editTextAddress.getText());
            Log.d("Ubicacion",editTextAddress.getText().toString());
            updateMapLocation(address);
            return true;
        });

        tvwTotalPrice = findViewById(R.id.tvwPriceTotalUser);
        tvwTotalPrice.setText(String.valueOf(precioTotal) + "€");
        btProcceedToPay = findViewById(R.id.btProcceedToPay);
        btProcceedToPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPaymentDialog();
            }
        });

        goToCartUser = findViewById(R.id.btGoToUserCart);
        goToCartUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CheckOutPageUser.this, SplashCargaUserCart.class));
            }
        });

    }

    private void showPaymentDialog() {
        if(!String.valueOf(editTextAddress.getText()).isEmpty()) {
            LayoutInflater inflater = LayoutInflater.from(this);
            View dialogView = inflater.inflate(R.layout.user_card_dialog, null);

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setView(dialogView);
            builder.setTitle("Pago con tarjeta");

            builder.setPositiveButton("Pagar", null);
            builder.setNegativeButton("Cancelar", null);
            builder.setIcon(R.drawable.logo);
            AlertDialog dialog = builder.create();

            dialog.show();

            Window window = dialog.getWindow();
            if (window != null) {
                window.setLayout((int) (getResources().getDisplayMetrics().widthPixels * 0.99), WindowManager.LayoutParams.WRAP_CONTENT);
            }

            EditText edtCardNumber = dialogView.findViewById(R.id.edtCardNumber);
            EditText edtCardExpiryDate = dialogView.findViewById(R.id.edtExpiryDate);
            EditText edtCVC = dialogView.findViewById(R.id.edtCVC);
            edtCardExpiryDate.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence date, int start, int before, int count) {
                    String fecCadCard = String.valueOf(date);
                    if (fecCadCard.length() == 4) {
                        String fecCadCardFormatted = fecCadCard.substring(0, 2) + "/" + fecCadCard.substring(2, 4);
                        edtCardExpiryDate.setText(fecCadCardFormatted);
                    }

                }

                @Override
                public void afterTextChanged(Editable s) {

                }
            });
            dialog.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String cardNumber = String.valueOf(edtCardNumber.getText());
                    String cardDate = String.valueOf(edtCardExpiryDate.getText());
                    String cvc = String.valueOf(edtCVC.getText());
                    if (isValidCardLength(cardNumber) && isValidLuhn(cardNumber) && isValidDateCard(cardDate) && isValidCVCCard(cvc)) {
                        Intent intent = new Intent(CheckOutPageUser.this, SplashProcesarPedidosUser.class);
                        intent.putExtra("idFactura", idFactura);
                        intent.putExtra("totalFactura", precioTotal);
                        intent.putExtra("direccionUser", String.valueOf(editTextAddress.getText()));
                        startActivity(intent);
                    } else {
                        informarAlUsuario("Error de pago", "La tarjeta que has introducido no es correcta");
                    }

                    dialog.dismiss();
                }
            });
        }else{
            informarAlUsuario("Direccion no insertada", "No has insertado ninguna direccion a la que enviar tu pedido");
        }

    }

    //Metodo que utiliza el algoritmo de Luhm para validar la tarjeta de credito
    private boolean isValidLuhn(String cardNumber) {
        int sum = 0;
        boolean esPar = false;
        for (int i = cardNumber.length() - 1; i >= 0; i--) {
            int digito = Integer.parseInt(cardNumber.substring(i, i + 1));
            if (esPar) {
                digito *= 2;
                if (digito > 9) {
                    digito = (digito % 10) + 1;
                }
            }
            sum += digito;
            esPar = !esPar;
        }
        return (sum % 10 == 0);
    }

    //Metodo para validar si la longitud del numero de tarjeta es valido o no
    private boolean isValidCardLength(String cardNumber) {
        return cardNumber.length() == 16 || cardNumber.length() == 15;
    }

    //Este metodo se utilizara para comprobar que la longitud de la fecha sea 5
    //El porque es debido a que para que sea una fecha valida de tarjeta de credito debe ser: 01/04 por ejemplo
    //Pues teniendo en cuenta la barra, la longitud que deberia tener es de 5 caracteres no mas
    private boolean isValidDateCard(String date){
        return date.length() == 5;
    }

    private boolean isValidCVCCard(String cvc){
        return cvc.length() == 3 || cvc.length() == 4;
    }





    private void showOrderSummaryProducts() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialog_seeproduct_summary, null);
        builder.setView(dialogView);

        RecyclerView recyclerView = dialogView.findViewById(R.id.recycler_view_order_summary);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ListProductSummaryAdapter listProductSummaryAdapter = new ListProductSummaryAdapter(this,productsMinimized);
        recyclerView.setAdapter(listProductSummaryAdapter);

        builder.setPositiveButton("OK", null);
        builder.create().show();
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        this.googleMap = googleMap;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }

    private void updateMapLocation(String address) {
        try {
            List<Address> addresses = geocoder.getFromLocationName(address, 1);
            if (addresses != null && !addresses.isEmpty()) {
                Address location = addresses.get(0);
                LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());
                googleMap.clear();
                googleMap.addMarker(new MarkerOptions().position(latLng).title("Lugar de recogida"));
                googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 15));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }


    private void informarAlUsuario(String titulo, String mensajeDialogo){
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
        builder.setTitle(titulo);
        builder.setMessage(mensajeDialogo);
        builder.setPositiveButton("Ok",new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        android.app.AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}