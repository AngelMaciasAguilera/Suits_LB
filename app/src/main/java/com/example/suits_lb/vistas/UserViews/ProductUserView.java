package com.example.suits_lb.vistas.UserViews;

import static com.example.suits_lb.controladores.ConversorImagenProducto.string_to_byte;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.suits_lb.R;
import com.example.suits_lb.controladores.ConversorImagenProducto;
import com.example.suits_lb.controladores.SQLiteBD.DatabaseHelperUserCart;
import com.example.suits_lb.controladores.SQLiteBD.ProductosContractCart;
import com.example.suits_lb.modelos.Carrito;
import com.example.suits_lb.modelos.Producto;

public class ProductUserView extends AppCompatActivity {
    Producto producto;

    private NumberPicker numberPicker;
    private TextView tvwNombreProduct;

    private TextView tvwPrecioProduct;

    private TextView tvwDescripcionProduct;
    private ImageView imgvwProductAPUV;

    private Button addToCartButton;

    private String emailUser;

    private DatabaseHelperUserCart databaseHelperUserCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_product_user_view);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        databaseHelperUserCart = new DatabaseHelperUserCart(this);
        emailUser = getIntent().getStringExtra("emailUsuario");
        producto = (Producto) getIntent().getSerializableExtra("productChosen");
        numberPicker = findViewById(R.id.numberPicker);
        tvwNombreProduct = findViewById(R.id.tvwInfoNameProductAPUV);
        tvwNombreProduct.setText(producto.getNombre());
        tvwPrecioProduct = findViewById(R.id.infoUserPriceAPUV);
        Log.d("precioProducto:",String.valueOf(producto.getPrecio()));
        tvwPrecioProduct.setText(String.valueOf(producto.getPrecio()));
        tvwDescripcionProduct = findViewById(R.id.tvwInfoUserDescriptionProductAPUV);
        tvwDescripcionProduct.setText(producto.getDescripcion());
        imgvwProductAPUV = findViewById(R.id.imgvwProductAPUV);
        Log.d("Ancho imagen:",String.valueOf(imgvwProductAPUV.getWidth()));
        byte[] bytesProductUser = ConversorImagenProducto.string_to_byte(producto.getImgProducto());
        Bitmap bitmapProductUser = ConversorImagenProducto.bytes_to_bitmap(bytesProductUser,147,140);
        imgvwProductAPUV.setImageBitmap(bitmapProductUser);
        addToCartButton = findViewById(R.id.addToCartButton);

        ImageButton imgbtReturnUserProduct = findViewById(R.id.imgbtReturnUserView);
        imgbtReturnUserProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ProductUserView.this, HomeApp.class).putExtra("emailUsuario",emailUser));
            }
        });

        // Configurar límites
        numberPicker.setMinValue(1); // Valor mínimo
        numberPicker.setMaxValue(producto.getStock()); // Valor máximo

        // Opcional: Cambiar el valor inicial
        numberPicker.setValue(1);

        addToCartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Carrito carrito = new Carrito(producto.getCodRopa(),emailUser,numberPicker.getValue(),calcularSubTotal());
                addToCart(carrito);

            }
        });
        Log.d("Este es el usuario:" ,String.valueOf(emailUser));

    }

    private void addToCart(Carrito carrito) {
        ContentValues contentValues = new ContentValues();
        SQLiteDatabase db = databaseHelperUserCart.getWritableDatabase();

        contentValues.put(ProductosContractCart.AuxCarritoEntries.COLUMN_CODROPA, carrito.getCodRopa());
        contentValues.put(ProductosContractCart.AuxCarritoEntries.COLUMN_EMAIL, emailUser);
        contentValues.put(ProductosContractCart.AuxCarritoEntries.COLUMN_CANTIDAD, numberPicker.getValue());
        contentValues.put(ProductosContractCart.AuxCarritoEntries.COLUMN_PRECIO, calcularSubTotal());

        db.insert(ProductosContractCart.AuxCarritoEntries.TABLE_NAME,null,contentValues);
        db.close();

    }

    private Double calcularSubTotal(){
        double subTotal = 0.0;
        subTotal = producto.getPrecio()*numberPicker.getValue();
        return subTotal;
    }
}