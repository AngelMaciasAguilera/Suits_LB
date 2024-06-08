package com.example.suits_lb.vistas.UserViews;

import static com.example.suits_lb.vistas.UserViews.HomeApp.emailUser;
import static com.example.suits_lb.vistas.pantallasCarga.SplashCargaProductosMinimized.productsMinimized;

import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
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

import com.paypal.android.sdk.payments.PayPalConfiguration;
import com.paypal.android.sdk.payments.PayPalPayment;
import com.paypal.android.sdk.payments.PayPalService;
import com.paypal.android.sdk.payments.PaymentActivity;
import com.paypal.android.sdk.payments.PaymentConfirmation;

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

    private final String PAYPAL_CLIENT_ID = "AdDDdD1z9U_RgaS7cE93k8D_ZKogQU0DLmLv9xVCuTQ9KMNxr_kPHeYjQBTj7hmQGt_DEdKSuvghBflB";
    private final int PAYPAL_REQUEST_CODE = 1234;

    private PayPalConfiguration paypalConfig = new PayPalConfiguration().environment(PayPalConfiguration.ENVIRONMENT_SANDBOX).clientId(PAYPAL_CLIENT_ID);

    private  Button btProcceedToPay;


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

        editTextAddress.setOnEditorActionListener((v, actionId, event) -> {
            String address = String.valueOf(editTextAddress.getText());
            Log.d("Ubicacion",editTextAddress.getText().toString());
            updateMapLocation(address);
            return true;
        });


        tvwIvaValue = findViewById(R.id.tvwValueIVA);
        tvwIvaValue.setText(String.valueOf(ivaValue) + "%");
        tvwTotalPrice = findViewById(R.id.tvwPriceTotalUser);
        tvwTotalPrice.setText(String.valueOf(precioTotal) + "€");
        Intent intent = new Intent(this, PayPalService.class);
        intent.putExtra(PayPalService.EXTRA_PAYPAL_CONFIGURATION, paypalConfig);
        startService(intent);
        btProcceedToPay = findViewById(R.id.btProcceedToPay);
        btProcceedToPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processPayment();
            }
        });


    }

    private void processPayment() {
        PayPalPayment payPalPayment = new PayPalPayment(BigDecimal.valueOf(precioTotal), "EUR", "Descripción del pago:", PayPalPayment.PAYMENT_INTENT_SALE);
        payPalPayment.custom(emailUser);
        payPalPayment.custom(editTextAddress.getText().toString());
        Intent intent = new Intent(this, PaymentActivity.class);
        intent.putExtra(PayPalService.EXTRA_PAYPAL_CONFIGURATION, paypalConfig);
        intent.putExtra(PaymentActivity.EXTRA_PAYMENT, payPalPayment);
        startActivityForResult(intent, PAYPAL_REQUEST_CODE);
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
        stopService(new Intent(this, PayPalService.class));
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PAYPAL_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                PaymentConfirmation confirmation = data.getParcelableExtra(PaymentActivity.EXTRA_RESULT_CONFIRMATION);
                if (confirmation != null) {
                    try {
                        String paymentDetails = confirmation.toJSONObject().toString(4);
                        Log.i("paymentExample", paymentDetails);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            } else if (resultCode == RESULT_CANCELED) {
                Log.i("paymentExample", "Pago cancelado");
            } else if (resultCode == PaymentActivity.RESULT_EXTRAS_INVALID) {
                Log.i("paymentExample", "Datos de pago inválidos");
            }
        }
    }



}