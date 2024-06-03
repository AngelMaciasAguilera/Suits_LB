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

public final class SingleProductUserViewBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final ImageView imgrvUserProductView;

  @NonNull
  public final TextView nombreProductoUserView;

  @NonNull
  public final TextView precioProductoUserView;

  private SingleProductUserViewBinding(@NonNull RelativeLayout rootView,
      @NonNull ImageView imgrvUserProductView, @NonNull TextView nombreProductoUserView,
      @NonNull TextView precioProductoUserView) {
    this.rootView = rootView;
    this.imgrvUserProductView = imgrvUserProductView;
    this.nombreProductoUserView = nombreProductoUserView;
    this.precioProductoUserView = precioProductoUserView;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static SingleProductUserViewBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static SingleProductUserViewBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.single_product_user_view, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static SingleProductUserViewBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.imgrvUserProductView;
      ImageView imgrvUserProductView = ViewBindings.findChildViewById(rootView, id);
      if (imgrvUserProductView == null) {
        break missingId;
      }

      id = R.id.nombreProductoUserView;
      TextView nombreProductoUserView = ViewBindings.findChildViewById(rootView, id);
      if (nombreProductoUserView == null) {
        break missingId;
      }

      id = R.id.precioProductoUserView;
      TextView precioProductoUserView = ViewBindings.findChildViewById(rootView, id);
      if (precioProductoUserView == null) {
        break missingId;
      }

      return new SingleProductUserViewBinding((RelativeLayout) rootView, imgrvUserProductView,
          nombreProductoUserView, precioProductoUserView);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
