package com.example.suits_lb.vistas.AdminViews.AdminAdminsView.recyclerView;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.marketplace.R;
import com.example.marketplace.controladores.ControladorImagenProducto;
import com.example.marketplace.controladores.ConversorImagenProducto;
import com.example.marketplace.controladores.conexionBDMarketPlace;
import com.example.marketplace.modelos.Producto;
import com.example.marketplace.vistas.SingInScreen;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FotosProductosAdapter extends RecyclerView.Adapter<RvAdminsHolder> {
    private Context contexto;
    private ArrayList<Producto> productos;
    private LayoutInflater inflate;
    private String email;


    public FotosProductosAdapter(Context contexto, ArrayList<Producto> productos, String email) {
        this.contexto = contexto;
        this.productos = productos;
        inflate = LayoutInflater.from(this.contexto);
        this.email = email;
    }




    public Context getContexto() {
        return contexto;
    }

    public void setContexto(Context contexto) {
        this.contexto = contexto;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }

    public LayoutInflater getInflate() {
        return inflate;
    }

    public void setInflate(LayoutInflater inflate) {
        this.inflate = inflate;
    }

    @NonNull
    @Override
    public RvAdminsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View productoView = inflate.inflate(R.layout.item_rv_producto, parent, false);
        RvAdminsHolder rph = new RvAdminsHolder(productoView, this,this.email);
        return rph;
    }

    @Override
    public void onBindViewHolder(@NonNull RvAdminsHolder holder, int position) {
        Producto p = this.getProductos().get(position);
        //----------------------------------------------------------------------
        holder.getTvwNombreProducto().setText("Nombre: " + p.getNombre());
        holder.getTvwPrecioProducto().setText("Precio: " + String.valueOf(p.getPrecio()));
        //---------------------------------------------------------------------
        String idProducto = p.getId();
        descargarImagen(idProducto, holder.getImgrvProducto(), contexto);

    }

    private void descargarImagen(String idProducto, ImageView img_foto, Context contexto) {
        StringRequest request =new StringRequest(Request.Method.POST, conexionBDMarketPlace.DIRECCION_URL_RAIZ+ "/mostrarFotoProducto.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("FotosProductosAdapter",response);
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            String exito=jsonObject.getString("exito");
                            JSONArray jsonArray =jsonObject.getJSONArray("imagenesproducto");
                            if (exito.equals("1")){
                                int longitud = jsonArray.length();
                                if (longitud > 0) {
                                    JSONObject object = jsonArray.getJSONObject(0);
                                    String idProducto = object.getString("idProducto");
                                    String imagenProducto = object.getString("imagenProducto");
                                    byte[] fotobyte = ConversorImagenProducto.string_to_byte(imagenProducto);
                                    Bitmap fotobitmap = ConversorImagenProducto.bytes_to_bitmap(fotobyte, conexionBDMarketPlace.ancho_imagen,conexionBDMarketPlace.alto_imagen);
                                    img_foto.setImageBitmap(fotobitmap);
                                }
                            }
                        }
                        catch (JSONException ex) {
                            throw new RuntimeException(ex);
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // Toast.makeText(MostrarProductosActivity.this,error.getMessage(),Toast.LENGTH_SHORT).show();
                Log.i("mysql1","error al pedir la foto");
            }
        }
        ){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String>params=new HashMap<>();
                params.put("idProducto",idProducto);
                params.put("email",email);
                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(contexto);
        requestQueue.add(request);
    }


    @Override
    public int getItemCount() {
        return this.productos.size();
    }
}
