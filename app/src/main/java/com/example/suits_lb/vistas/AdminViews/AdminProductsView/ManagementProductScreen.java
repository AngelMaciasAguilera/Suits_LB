package com.example.suits_lb.vistas.AdminViews.AdminProductsView;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
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
import com.example.suits_lb.controladores.ConversorImagenProducto;
import com.example.suits_lb.controladores.conexionSuitsLbDB;
import com.example.suits_lb.modelos.CategoriaRopa;
import com.example.suits_lb.modelos.Producto;
import com.example.suits_lb.vistas.AdminViews.AdminAdminsView.ManagementAdminScreen;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ManagementProductScreen extends AppCompatActivity {
    private Button btCancelManagement;
    private Button btDeleteProduct;
    private Button btUpdateProduct;
    private ArrayList<CategoriaRopa> catRopa;
    private String[] nombresCategorias;
    private ImageView imgvwMSProduct;
    private ImageButton imgbtMSProduct;
    private EditText edtProductCodeMS;
    private EditText edtProductNameMS;
    private EditText edtProductDescriptionMS;
    private Spinner spProductCategoryMS;
    private EditText edtProductQuantityMS;
    private Spinner spAvailableSaleProductMS;
    private EditText edtProductPriceMS;

    private Producto pselected;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_management_product_screen);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        spProductCategoryMS = findViewById(R.id.spProductCategoriesMAScreen);
        Intent intent = getIntent();
        pselected = (Producto) intent.getSerializableExtra("producto");
        nombresCategorias = intent.getStringArrayExtra("nombreCategorias");
        catRopa = (ArrayList<CategoriaRopa>) intent.getSerializableExtra("categoriasRopa");
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,nombresCategorias);
        spProductCategoryMS.setAdapter(arrayAdapter);

        btCancelManagement = findViewById(R.id.btCancelManagingProduct);
        imgvwMSProduct = findViewById(R.id.imgvwMAScreenProduct);
        imgbtMSProduct = findViewById(R.id.imgbtMAScreenProduct);
        edtProductCodeMS = findViewById(R.id.edtClothCodeMAScreen);
        edtProductNameMS = findViewById(R.id.edtClothNameMAScreen);
        edtProductDescriptionMS = findViewById(R.id.edtProductDescriptionMAScreen);
        edtProductQuantityMS = findViewById(R.id.edtStockProductMAScreen);
        spAvailableSaleProductMS = findViewById(R.id.spAvailableSaleMAScreen);
        edtProductPriceMS = findViewById(R.id.edtProductPriceMAScreen);
        btDeleteProduct = findViewById(R.id.btDeleteProduct);
        btUpdateProduct = findViewById(R.id.btUpdateProduct);

        //Seteamos cada campo con los valores del producto correspondiente
        edtProductCodeMS.setText(pselected.getCodRopa());
        edtProductNameMS.setText(pselected.getNombre());
        edtProductDescriptionMS.setText(pselected.getDescripcion());
        edtProductPriceMS.setText(String.valueOf(pselected.getPrecio()));
        edtProductQuantityMS.setText(String.valueOf(pselected.getStock()));
        for (int i = 0;i < nombresCategorias.length;i++){
            if (nombresCategorias[i].equals(pselected.getCodRopa())){
                int categoryPosition = arrayAdapter.getPosition(nombresCategorias[i]);
                spProductCategoryMS.setSelection(categoryPosition);
            }
        }
        String[] availableOptions = new String[]{"S","N","P"};
        ArrayAdapter availableAdapter = new ArrayAdapter(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,availableOptions);
        spAvailableSaleProductMS.setAdapter(availableAdapter);
        spAvailableSaleProductMS.setSelection(availableAdapter.getPosition(pselected.getVentaDisponible()));

        String blobImage = pselected.getImgProducto();
        byte[]bytesImage = ConversorImagenProducto.string_to_byte(blobImage);
        Bitmap bitmapImage = ConversorImagenProducto.bytes_to_bitmap(bytesImage,conexionSuitsLbDB.alto_imagen,conexionSuitsLbDB.ancho_imagen);
        imgvwMSProduct.setImageBitmap(bitmapImage);

        btDeleteProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteProduct();
            }
        });

        imgbtMSProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cambiarImagen();
            }
        });

        btCancelManagement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancelManagement();
            }
        });



    }


    private void deleteProduct(){
        StringRequest request = new StringRequest(Request.Method.POST, conexionSuitsLbDB.DIRECCION_URL_RAIZ + "/adminRopa/eliminarProducto.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("ManagementProductScreen",response);
                        if (response.equalsIgnoreCase("ropa eliminada")){
                            startActivity(new Intent(ManagementProductScreen.this,MainProductScreenManager.class));
                        }else{
                            Log.d("Error deleting product",response);
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
                params.put("codRopa",pselected.getCodRopa());
                return params;
            }

        };
        RequestQueue requestQueue = Volley.newRequestQueue(ManagementProductScreen.this);
        requestQueue.add(request);
    }

    private void cancelManagement(){
        this.startActivity(new Intent(this, MainProductScreenManager.class));
    }

    private void cambiarImagen(){
        Intent getIntent = new Intent(Intent.ACTION_GET_CONTENT);
        getIntent.setType("image/*");

        Intent pickIntent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        pickIntent.setType("image/*");

        Intent chooserIntent = Intent.createChooser(getIntent, "Selecciona una imagen");
        chooserIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS, new Intent[]{pickIntent});
        startActivityForResult(chooserIntent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == Activity.RESULT_OK) {
            Uri imgSelected = data.getData();
            Bitmap bitmap = null;
            try {
                bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), imgSelected);
                imgvwMSProduct.setImageBitmap(bitmap);

                //---------------------------------------------

            } catch (Exception e) {
                Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
                imgvwMSProduct.setImageResource(R.drawable.imageerror);
            }
        }
    }


}