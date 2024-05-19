package com.example.suits_lb.vistas.AdminViews.AdminUserView.recyclerViewUsers;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.suits_lb.R;
import com.example.suits_lb.modelos.Cliente;

import java.util.ArrayList;

public class ListaUserAdapter extends RecyclerView.Adapter<RvUsersHolder> {
    private Context contexto;
    private ArrayList<Cliente> clientes;
    private LayoutInflater inflate;


    public ListaUserAdapter(Context contexto, ArrayList<Cliente> cliente) {
        this.contexto = contexto;
        this.clientes = cliente;
        inflate = LayoutInflater.from(this.contexto);
    }




    public Context getContexto() {
        return contexto;
    }

    public void setContexto(Context contexto) {
        this.contexto = contexto;
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }

    public LayoutInflater getInflate() {
        return inflate;
    }

    public void setInflate(LayoutInflater inflate) {
        this.inflate = inflate;
    }

    @NonNull
    @Override
    public RvUsersHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View adminView = inflate.inflate(R.layout.single_user_view, parent, false);
        RvUsersHolder rph = new RvUsersHolder(adminView, this);
        return rph;
    }

    @Override
    public void onBindViewHolder(@NonNull RvUsersHolder holder, int position) {
        Cliente cliente = this.getClientes().get(position);
        //----------------------------------------------------------------------
        holder.getTvwNombreUser().setText(cliente.getNombre());
        holder.getTvwEmailUser().setText(cliente.getEmail());
        holder.getTvwPhoneUser().setText(String.valueOf(cliente.getTelefono()));
        holder.getTvwAgeUser().setText(String.valueOf(cliente.getEdad()));
        //---------------------------------------------------------------------

    }

    /*private void descargarImagen(String idProducto, ImageView img_foto, Context contexto) {
        StringRequest request =new StringRequest(Request.Method.POST, conexionBDMarketPlace.DIRECCION_URL_RAIZ+ "/mostrarFotoProducto.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("ListaAdminAdapter",response);
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
    }*/


    @Override
    public int getItemCount() {
        return this.clientes.size();
    }
}
