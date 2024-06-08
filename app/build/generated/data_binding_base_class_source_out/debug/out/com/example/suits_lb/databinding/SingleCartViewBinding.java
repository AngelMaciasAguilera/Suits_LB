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

public final class SingleCartViewBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final TextView cantidadProductoUserViewCartView;

  @NonNull
  public final ImageView imgrvUserProductViewCartView;

  @NonNull
  public final TextView infoTvwSCVCart;

  @NonNull
  public final TextView infoTvwSCVSubTotalCart;

  @NonNull
  public final TextView nombreProductoUserViewCartView;

  @NonNull
  public final TextView subtotalUserProductViewCartView;

  private SingleCartViewBinding(@NonNull RelativeLayout rootView,
      @NonNull TextView cantidadProductoUserViewCartView,
      @NonNull ImageView imgrvUserProductViewCartView, @NonNull TextView infoTvwSCVCart,
      @NonNull TextView infoTvwSCVSubTotalCart, @NonNull TextView nombreProductoUserViewCartView,
      @NonNull TextView subtotalUserProductViewCartView) {
    this.rootView = rootView;
    this.cantidadProductoUserViewCartView = cantidadProductoUserViewCartView;
    this.imgrvUserProductViewCartView = imgrvUserProductViewCartView;
    this.infoTvwSCVCart = infoTvwSCVCart;
    this.infoTvwSCVSubTotalCart = infoTvwSCVSubTotalCart;
    this.nombreProductoUserViewCartView = nombreProductoUserViewCartView;
    this.subtotalUserProductViewCartView = subtotalUserProductViewCartView;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static SingleCartViewBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static SingleCartViewBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.single_cart_view, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static SingleCartViewBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.cantidadProductoUserView_cartView;
      TextView cantidadProductoUserViewCartView = ViewBindings.findChildViewById(rootView, id);
      if (cantidadProductoUserViewCartView == null) {
        break missingId;
      }

      id = R.id.imgrvUserProductView_cartView;
      ImageView imgrvUserProductViewCartView = ViewBindings.findChildViewById(rootView, id);
      if (imgrvUserProductViewCartView == null) {
        break missingId;
      }

      id = R.id.infoTvwSCVCart;
      TextView infoTvwSCVCart = ViewBindings.findChildViewById(rootView, id);
      if (infoTvwSCVCart == null) {
        break missingId;
      }

      id = R.id.infoTvwSCVSubTotalCart;
      TextView infoTvwSCVSubTotalCart = ViewBindings.findChildViewById(rootView, id);
      if (infoTvwSCVSubTotalCart == null) {
        break missingId;
      }

      id = R.id.nombreProductoUserView_cartView;
      TextView nombreProductoUserViewCartView = ViewBindings.findChildViewById(rootView, id);
      if (nombreProductoUserViewCartView == null) {
        break missingId;
      }

      id = R.id.subtotalUserProductView__cartView;
      TextView subtotalUserProductViewCartView = ViewBindings.findChildViewById(rootView, id);
      if (subtotalUserProductViewCartView == null) {
        break missingId;
      }

      return new SingleCartViewBinding((RelativeLayout) rootView, cantidadProductoUserViewCartView,
          imgrvUserProductViewCartView, infoTvwSCVCart, infoTvwSCVSubTotalCart,
          nombreProductoUserViewCartView, subtotalUserProductViewCartView);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}