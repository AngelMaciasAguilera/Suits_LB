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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AddingProductsScreen extends AppCompatActivity {
    private EditText productCodeADScreen;
    private EditText productNameADScreen;
    private EditText productDescriptionADScreen;
    private Spinner productCategoryADScreen;
    private Spinner saleAvailableProductADScreen;
    private EditText priceProductADScreen;

    private ArrayList<CategoriaRopa> catRopa;

    private String[] nombresCategorias;

    private Button btCancelAddingProduct;
    private Button btAddProduct;
    private ImageButton btChangeImageProduct;

    private ImageView imgvwImageProduct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_adding_products_screen);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        catRopa = new ArrayList<>();
        productCodeADScreen = findViewById(R.id.edtProductCodeAddingScreen);
        productNameADScreen = findViewById(R.id.edtProductNameAddingScreen);
        productDescriptionADScreen = findViewById(R.id.edtProductDescriptionAddingScreen);
        productCategoryADScreen = findViewById(R.id.spProductCategoriesAddingScreen);
        btChangeImageProduct = findViewById(R.id.imgbtAddImageProduct);
        saleAvailableProductADScreen = findViewById(R.id.spAvailableSaleAddingScreen);
        imgvwImageProduct= findViewById(R.id.imgvwProductImageAddingScreen);
        priceProductADScreen = findViewById(R.id.edtProductPriceAddingScreen);
        btCancelAddingProduct = findViewById(R.id.btCancelAddingProduct);
        btAddProduct = findViewById(R.id.btAddProduct);

        btCancelAddingProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancelAddingProduct();
            }
        });

        btChangeImageProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cambiarImagen();
            }
        });

        btAddProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addProduct();
            }
        });

        String[] availableOptions = new String[]{"S","N","P"};
        ArrayAdapter availableAdapter = new ArrayAdapter(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,availableOptions);
        saleAvailableProductADScreen.setAdapter(availableAdapter);
        obtenerCategorias();
    }


    private void addProduct(){
        String codRopa = String.valueOf(productCodeADScreen.getText());
        String codCatRopa = (String) productCategoryADScreen.getSelectedItem();
        String nomRopa = String.valueOf(productNameADScreen.getText());
        String descRopa = String.valueOf(productDescriptionADScreen.getText());
        Double priceRopa = Double.valueOf(String.valueOf(priceProductADScreen.getText()));
        String availableSale = (String) saleAvailableProductADScreen.getSelectedItem();
        imgvwImageProduct.buildDrawingCache();
        Bitmap icon_bm = imgvwImageProduct.getDrawingCache();
        byte[] iconbytes = ConversorImagenProducto.bitmap_to_bytes_png(icon_bm);
        String imageProduct = ConversorImagenProducto.byte_to_string(iconbytes);
        CategoriaRopa crp = null;
        for (CategoriaRopa c:catRopa) {
            if(c.getNomCategory().equals(codCatRopa)){
                crp = c;
            }
        }

        Producto p1 = new Producto(codRopa, nomRopa, descRopa, priceRopa, crp.getCodCategory(), imageProduct,availableSale);
        Log.d("Producto a insertar",p1.toString());
        insertarProducto(p1);


        Log.d("Aqui esta la categoria", crp.toString());
    }

    private void insertarProducto(Producto p1) {
        StringRequest request = new StringRequest(Request.Method.POST, conexionSuitsLbDB.DIRECCION_URL_RAIZ + "/adminRopa/insertarProducto.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("AddingProductScreen",response);
                        if (response.equalsIgnoreCase("ropa insertada")){
                              productCodeADScreen.getText().clear();
                              productNameADScreen.getText().clear();
                              productDescriptionADScreen.getText().clear();
                              priceProductADScreen.getText().clear();
                              imgvwImageProduct.setImageResource(R.drawable.ropapredeterminada);
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
                params.put("codRopa",p1.getCodRopa());
                params.put("nombreRopa",p1.getNombre());
                params.put("descripcionRopa",p1.getDescripcion());
                params.put("precioRopa",String.valueOf(p1.getPrecio()));
                params.put("catRopa",p1.getCatRopa());
                params.put("imgRopa",p1.getImgProducto());
                Log.d("Producto disponible",p1.getVentaDisponible());
                params.put("ventaDisponibleRopa",p1.getVentaDisponible());
                return params;
            }

        };
        RequestQueue requestQueue = Volley.newRequestQueue(AddingProductsScreen.this);
        requestQueue.add(request);
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

    private void obtenerCategorias(){
        StringRequest request = new StringRequest(Request.Method.POST, conexionSuitsLbDB.DIRECCION_URL_RAIZ + "/adminCategories/mostrarCategorias.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        catRopa.clear();
                        Log.d("AddingProductScreen", response);
                        try {

                            JSONObject jsonObject = new JSONObject(response);
                            String exito = jsonObject.getString("exito");
                            JSONArray jsonArray = jsonObject.getJSONArray("categorias");
                            if (exito.equals("1")) {
                                for (int i = 0; i < jsonArray.length(); i++) {
                                    JSONObject object = jsonArray.getJSONObject(i);
                                    String codCategoria = object.getString("codCategoria");
                                    String nombreCategoria = object.getString("nombreCategoria");

                                    CategoriaRopa c1 = new CategoriaRopa(codCategoria,nombreCategoria);
                                    catRopa.add(c1);
                                }
                                nombresCategorias = new String[catRopa.size()];
                                for (int i = 0; i < nombresCategorias.length; i++) {
                                    nombresCategorias[i] = catRopa.get(i).getNomCategory();
                                }
                                setProductCategoriesAdapter(nombresCategorias);

                            }
                        } catch (JSONException ex) {
                            throw new RuntimeException(ex);
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
                return params;
            }

        };
        RequestQueue requestQueue = Volley.newRequestQueue(AddingProductsScreen.this);
        requestQueue.add(request);
    }

    private void setProductCategoriesAdapter(String[]array){
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,array);
        productCategoryADScreen.setAdapter(arrayAdapter);
    }

    private void cancelAddingProduct(){
        this.startActivity(new Intent(this, MainProductScreenManager.class));

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == Activity.RESULT_OK) {
            Uri imgSelected = data.getData();
            Bitmap bitmap = null;
            try {
                bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), imgSelected);
                imgvwImageProduct.setImageBitmap(bitmap);

                //---------------------------------------------

            } catch (Exception e) {
                Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
                imgvwImageProduct.setImageResource(R.drawable.imageerror);
            }
        }
    }


}