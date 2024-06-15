package com.example.suits_lb.vistas.AdminViews.AdminOrderStatus;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.suits_lb.R;
import com.example.suits_lb.controladores.conexionSuitsLbDB;
import com.example.suits_lb.modelos.Pedido;
import com.example.suits_lb.modelos.Producto;
import com.example.suits_lb.vistas.AdminViews.AdminCategoriesView.ManagementCategoryScreen;
import com.example.suits_lb.vistas.AdminViews.AdminProductsView.AddingProductsScreen;
import com.example.suits_lb.vistas.pantallasCarga.SplashCargaAllUsersOrders;

import java.util.HashMap;
import java.util.Map;

public class ManagementOrdersStatus extends AppCompatActivity {
    private Pedido pedidoSeleccionado;
    private TextView tvwNPedidoMOS,tvwEmailMOS,tvwConceptMOS;
    private Spinner spStatusOrder;
    private Button btUpdateOrderMOS;

    private Button cancelUpdateStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_management_orders_status);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        pedidoSeleccionado = (Pedido) getIntent().getSerializableExtra("pedidoSeleccionado");
        tvwNPedidoMOS = findViewById(R.id.tvwNPedidoMOS);
        tvwEmailMOS = findViewById(R.id.tvwEmailMOS);
        tvwConceptMOS = findViewById(R.id.tvwConceptMOS);
        spStatusOrder = findViewById(R.id.spStatusOrder);
        btUpdateOrderMOS = findViewById(R.id.btUpdateOrderMOS);
        cancelUpdateStatus = findViewById(R.id.btCancelarMOS);

        //Seteamos el valor de cada cosa
        tvwNPedidoMOS.setText(String.valueOf(pedidoSeleccionado.getNumPedido()));
        tvwEmailMOS.setText(String.valueOf(pedidoSeleccionado.getEmail()));
        tvwConceptMOS.setText(String.valueOf(pedidoSeleccionado.getConcepto()));
        String[] opcionesStatus = new String[]{"Esperando envio","Enviado","Entregado"};
        ArrayAdapter spinnerOrderStatus = new ArrayAdapter(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,opcionesStatus);
        spStatusOrder.setAdapter(spinnerOrderStatus);
        spStatusOrder.setSelection(spinnerOrderStatus.getPosition(pedidoSeleccionado.getEstado()));

        btUpdateOrderMOS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateOrderStatus();
            }
        });

        cancelUpdateStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertarNuevaNotificacion();
                goToMainOrdersUsersStatus();
            }
        });

    }

    private void updateOrderStatus(){
        StringRequest request = new StringRequest(Request.Method.POST, conexionSuitsLbDB.DIRECCION_URL_RAIZ + "/adminOrders/updatePedido.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("ManagementCategoryScreen",response);
                        if (response.equalsIgnoreCase("pedido actualizado")){
                            insertarNuevaNotificacion();

                        }else{
                            Log.d("Error updating admin",response);
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i("mysql1", "error al pedir los datos");
            }
        }
        ) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();
                params.put("numPedido",String.valueOf(pedidoSeleccionado.getNumPedido()));
                params.put("estadoPedido",String.valueOf(spStatusOrder.getSelectedItem()));
                return params;
            }

        };
        RequestQueue requestQueue = Volley.newRequestQueue(ManagementOrdersStatus.this);
        requestQueue.add(request);
    }


    private void goToMainOrdersUsersStatusUpdated(){
        this.startActivity(new Intent(this, SplashCargaAllUsersOrders.class));
    }

    private void goToMainOrdersUsersStatus(){
        this.startActivity(new Intent(this, MainOrdersUsersStatus.class));
    }


    private void insertarNuevaNotificacion(){
            StringRequest request = new StringRequest(Request.Method.POST, conexionSuitsLbDB.DIRECCION_URL_RAIZ + "/adminNotifications/insertarNotificacion.php",
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            Log.d("Notificacion: ",response);
                            goToMainOrdersUsersStatusUpdated();
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.i("mysql1", "error al pedir los datos");
                }
            }
            ) {
                @Override
                protected Map<String, String> getParams() {
                    Map<String, String> params = new HashMap<>();
                    params.put("emailUser", pedidoSeleccionado.getEmail());
                    params.put("mensaje","Se ha actualizado el estado de uno de tus pedidos revisalo en mi cuenta");
                    return params;
                }

            };
            RequestQueue requestQueue = Volley.newRequestQueue(ManagementOrdersStatus.this);
            requestQueue.add(request);
        }
    }



