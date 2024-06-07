// Generated by view binder compiler. Do not edit!
package com.example.suits_lb.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.suits_lb.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ProductViewMinimizedBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final ImageView imgvwProductMIN;

  @NonNull
  public final TextView tvwProductNameMIN;

  @NonNull
  public final TextView tvwProductStockMIN;

  @NonNull
  public final TextView tvwProductSubtotalMIN;

  private ProductViewMinimizedBinding(@NonNull LinearLayout rootView,
      @NonNull ImageView imgvwProductMIN, @NonNull TextView tvwProductNameMIN,
      @NonNull TextView tvwProductStockMIN, @NonNull TextView tvwProductSubtotalMIN) {
    this.rootView = rootView;
    this.imgvwProductMIN = imgvwProductMIN;
    this.tvwProductNameMIN = tvwProductNameMIN;
    this.tvwProductStockMIN = tvwProductStockMIN;
    this.tvwProductSubtotalMIN = tvwProductSubtotalMIN;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ProductViewMinimizedBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ProductViewMinimizedBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.product_view_minimized, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ProductViewMinimizedBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.imgvwProductMIN;
      ImageView imgvwProductMIN = ViewBindings.findChildViewById(rootView, id);
      if (imgvwProductMIN == null) {
        break missingId;
      }

      id = R.id.tvwProductNameMIN;
      TextView tvwProductNameMIN = ViewBindings.findChildViewById(rootView, id);
      if (tvwProductNameMIN == null) {
        break missingId;
      }

      id = R.id.tvwProductStockMIN;
      TextView tvwProductStockMIN = ViewBindings.findChildViewById(rootView, id);
      if (tvwProductStockMIN == null) {
        break missingId;
      }

      id = R.id.tvwProductSubtotalMIN;
      TextView tvwProductSubtotalMIN = ViewBindings.findChildViewById(rootView, id);
      if (tvwProductSubtotalMIN == null) {
        break missingId;
      }

      return new ProductViewMinimizedBinding((LinearLayout) rootView, imgvwProductMIN,
          tvwProductNameMIN, tvwProductStockMIN, tvwProductSubtotalMIN);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
