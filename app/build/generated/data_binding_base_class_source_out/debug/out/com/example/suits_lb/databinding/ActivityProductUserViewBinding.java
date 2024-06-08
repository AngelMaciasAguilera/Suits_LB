// Generated by view binder compiler. Do not edit!
package com.example.suits_lb.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.suits_lb.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityProductUserViewBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Button addToCartButton;

  @NonNull
  public final ImageButton imgbtReturnUserView;

  @NonNull
  public final ImageView imgvwProductAPUV;

  @NonNull
  public final TextView infoUserDescriptionAPUV;

  @NonNull
  public final TextView infoUserPriceAPUV;

  @NonNull
  public final ConstraintLayout main;

  @NonNull
  public final NumberPicker numberPicker;

  @NonNull
  public final TextView textView16;

  @NonNull
  public final TextView textView18;

  @NonNull
  public final TextView tvwInfoNameProductAPUV;

  @NonNull
  public final TextView tvwInfoUserDescriptionProductAPUV;

  private ActivityProductUserViewBinding(@NonNull ConstraintLayout rootView,
      @NonNull Button addToCartButton, @NonNull ImageButton imgbtReturnUserView,
      @NonNull ImageView imgvwProductAPUV, @NonNull TextView infoUserDescriptionAPUV,
      @NonNull TextView infoUserPriceAPUV, @NonNull ConstraintLayout main,
      @NonNull NumberPicker numberPicker, @NonNull TextView textView16,
      @NonNull TextView textView18, @NonNull TextView tvwInfoNameProductAPUV,
      @NonNull TextView tvwInfoUserDescriptionProductAPUV) {
    this.rootView = rootView;
    this.addToCartButton = addToCartButton;
    this.imgbtReturnUserView = imgbtReturnUserView;
    this.imgvwProductAPUV = imgvwProductAPUV;
    this.infoUserDescriptionAPUV = infoUserDescriptionAPUV;
    this.infoUserPriceAPUV = infoUserPriceAPUV;
    this.main = main;
    this.numberPicker = numberPicker;
    this.textView16 = textView16;
    this.textView18 = textView18;
    this.tvwInfoNameProductAPUV = tvwInfoNameProductAPUV;
    this.tvwInfoUserDescriptionProductAPUV = tvwInfoUserDescriptionProductAPUV;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityProductUserViewBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityProductUserViewBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_product_user_view, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityProductUserViewBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.addToCartButton;
      Button addToCartButton = ViewBindings.findChildViewById(rootView, id);
      if (addToCartButton == null) {
        break missingId;
      }

      id = R.id.imgbtReturnUserView;
      ImageButton imgbtReturnUserView = ViewBindings.findChildViewById(rootView, id);
      if (imgbtReturnUserView == null) {
        break missingId;
      }

      id = R.id.imgvwProductAPUV;
      ImageView imgvwProductAPUV = ViewBindings.findChildViewById(rootView, id);
      if (imgvwProductAPUV == null) {
        break missingId;
      }

      id = R.id.infoUserDescriptionAPUV;
      TextView infoUserDescriptionAPUV = ViewBindings.findChildViewById(rootView, id);
      if (infoUserDescriptionAPUV == null) {
        break missingId;
      }

      id = R.id.infoUserPriceAPUV;
      TextView infoUserPriceAPUV = ViewBindings.findChildViewById(rootView, id);
      if (infoUserPriceAPUV == null) {
        break missingId;
      }

      ConstraintLayout main = (ConstraintLayout) rootView;

      id = R.id.numberPicker;
      NumberPicker numberPicker = ViewBindings.findChildViewById(rootView, id);
      if (numberPicker == null) {
        break missingId;
      }

      id = R.id.textView16;
      TextView textView16 = ViewBindings.findChildViewById(rootView, id);
      if (textView16 == null) {
        break missingId;
      }

      id = R.id.textView18;
      TextView textView18 = ViewBindings.findChildViewById(rootView, id);
      if (textView18 == null) {
        break missingId;
      }

      id = R.id.tvwInfoNameProductAPUV;
      TextView tvwInfoNameProductAPUV = ViewBindings.findChildViewById(rootView, id);
      if (tvwInfoNameProductAPUV == null) {
        break missingId;
      }

      id = R.id.tvwInfoUserDescriptionProductAPUV;
      TextView tvwInfoUserDescriptionProductAPUV = ViewBindings.findChildViewById(rootView, id);
      if (tvwInfoUserDescriptionProductAPUV == null) {
        break missingId;
      }

      return new ActivityProductUserViewBinding((ConstraintLayout) rootView, addToCartButton,
          imgbtReturnUserView, imgvwProductAPUV, infoUserDescriptionAPUV, infoUserPriceAPUV, main,
          numberPicker, textView16, textView18, tvwInfoNameProductAPUV,
          tvwInfoUserDescriptionProductAPUV);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}