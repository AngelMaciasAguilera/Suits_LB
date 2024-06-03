// Generated by view binder compiler. Do not edit!
package com.example.suits_lb.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.suits_lb.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class SingleProductViewBeBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final TextView cantidadProducto;

  @NonNull
  public final ImageView imgrvProducto;

  @NonNull
  public final TextView nombreProducto;

  @NonNull
  public final TextView precioProducto;

  private SingleProductViewBeBinding(@NonNull RelativeLayout rootView,
      @NonNull TextView cantidadProducto, @NonNull ImageView imgrvProducto,
      @NonNull TextView nombreProducto, @NonNull TextView precioProducto) {
    this.rootView = rootView;
    this.cantidadProducto = cantidadProducto;
    this.imgrvProducto = imgrvProducto;
    this.nombreProducto = nombreProducto;
    this.precioProducto = precioProducto;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static SingleProductViewBeBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static SingleProductViewBeBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.single_product_view_be, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static SingleProductViewBeBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.cantidadProducto;
      TextView cantidadProducto = ViewBindings.findChildViewById(rootView, id);
      if (cantidadProducto == null) {
        break missingId;
      }

      id = R.id.imgrvProducto;
      ImageView imgrvProducto = ViewBindings.findChildViewById(rootView, id);
      if (imgrvProducto == null) {
        break missingId;
      }

      id = R.id.nombreProducto;
      TextView nombreProducto = ViewBindings.findChildViewById(rootView, id);
      if (nombreProducto == null) {
        break missingId;
      }

      id = R.id.precioProducto;
      TextView precioProducto = ViewBindings.findChildViewById(rootView, id);
      if (precioProducto == null) {
        break missingId;
      }

      return new SingleProductViewBeBinding((RelativeLayout) rootView, cantidadProducto,
          imgrvProducto, nombreProducto, precioProducto);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}