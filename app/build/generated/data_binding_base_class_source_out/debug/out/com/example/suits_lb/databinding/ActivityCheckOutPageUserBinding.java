// Generated by view binder compiler. Do not edit!
package com.example.suits_lb.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.suits_lb.R;
import com.google.android.gms.maps.MapView;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityCheckOutPageUserBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Button btGoToUserCart;

  @NonNull
  public final Button btProcceedToPay;

  @NonNull
  public final Button btSeeAllProductsMinimized;

  @NonNull
  public final LinearLayout cabeceraLogIn;

  @NonNull
  public final TextView cabeceraLogin;

  @NonNull
  public final EditText editTextAddressCUP;

  @NonNull
  public final TextView edtEmailUserCP;

  @NonNull
  public final EditText edtEmailUserCUP;

  @NonNull
  public final TextView infoUserCheckOutPageAddress;

  @NonNull
  public final TextView infoUserCheckOutPageTotalPrice;

  @NonNull
  public final ConstraintLayout main;

  @NonNull
  public final MapView mapView;

  @NonNull
  public final TextView tvwPriceTotalUser;

  private ActivityCheckOutPageUserBinding(@NonNull ConstraintLayout rootView,
      @NonNull Button btGoToUserCart, @NonNull Button btProcceedToPay,
      @NonNull Button btSeeAllProductsMinimized, @NonNull LinearLayout cabeceraLogIn,
      @NonNull TextView cabeceraLogin, @NonNull EditText editTextAddressCUP,
      @NonNull TextView edtEmailUserCP, @NonNull EditText edtEmailUserCUP,
      @NonNull TextView infoUserCheckOutPageAddress,
      @NonNull TextView infoUserCheckOutPageTotalPrice, @NonNull ConstraintLayout main,
      @NonNull MapView mapView, @NonNull TextView tvwPriceTotalUser) {
    this.rootView = rootView;
    this.btGoToUserCart = btGoToUserCart;
    this.btProcceedToPay = btProcceedToPay;
    this.btSeeAllProductsMinimized = btSeeAllProductsMinimized;
    this.cabeceraLogIn = cabeceraLogIn;
    this.cabeceraLogin = cabeceraLogin;
    this.editTextAddressCUP = editTextAddressCUP;
    this.edtEmailUserCP = edtEmailUserCP;
    this.edtEmailUserCUP = edtEmailUserCUP;
    this.infoUserCheckOutPageAddress = infoUserCheckOutPageAddress;
    this.infoUserCheckOutPageTotalPrice = infoUserCheckOutPageTotalPrice;
    this.main = main;
    this.mapView = mapView;
    this.tvwPriceTotalUser = tvwPriceTotalUser;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityCheckOutPageUserBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityCheckOutPageUserBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_check_out_page_user, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityCheckOutPageUserBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btGoToUserCart;
      Button btGoToUserCart = ViewBindings.findChildViewById(rootView, id);
      if (btGoToUserCart == null) {
        break missingId;
      }

      id = R.id.btProcceedToPay;
      Button btProcceedToPay = ViewBindings.findChildViewById(rootView, id);
      if (btProcceedToPay == null) {
        break missingId;
      }

      id = R.id.btSeeAllProductsMinimized;
      Button btSeeAllProductsMinimized = ViewBindings.findChildViewById(rootView, id);
      if (btSeeAllProductsMinimized == null) {
        break missingId;
      }

      id = R.id.cabeceraLogIn;
      LinearLayout cabeceraLogIn = ViewBindings.findChildViewById(rootView, id);
      if (cabeceraLogIn == null) {
        break missingId;
      }

      id = R.id.cabeceraLogin;
      TextView cabeceraLogin = ViewBindings.findChildViewById(rootView, id);
      if (cabeceraLogin == null) {
        break missingId;
      }

      id = R.id.editTextAddressCUP;
      EditText editTextAddressCUP = ViewBindings.findChildViewById(rootView, id);
      if (editTextAddressCUP == null) {
        break missingId;
      }

      id = R.id.edtEmailUserCP;
      TextView edtEmailUserCP = ViewBindings.findChildViewById(rootView, id);
      if (edtEmailUserCP == null) {
        break missingId;
      }

      id = R.id.edtEmailUserCUP;
      EditText edtEmailUserCUP = ViewBindings.findChildViewById(rootView, id);
      if (edtEmailUserCUP == null) {
        break missingId;
      }

      id = R.id.infoUserCheckOutPageAddress;
      TextView infoUserCheckOutPageAddress = ViewBindings.findChildViewById(rootView, id);
      if (infoUserCheckOutPageAddress == null) {
        break missingId;
      }

      id = R.id.infoUserCheckOutPageTotalPrice;
      TextView infoUserCheckOutPageTotalPrice = ViewBindings.findChildViewById(rootView, id);
      if (infoUserCheckOutPageTotalPrice == null) {
        break missingId;
      }

      ConstraintLayout main = (ConstraintLayout) rootView;

      id = R.id.mapView;
      MapView mapView = ViewBindings.findChildViewById(rootView, id);
      if (mapView == null) {
        break missingId;
      }

      id = R.id.tvwPriceTotalUser;
      TextView tvwPriceTotalUser = ViewBindings.findChildViewById(rootView, id);
      if (tvwPriceTotalUser == null) {
        break missingId;
      }

      return new ActivityCheckOutPageUserBinding((ConstraintLayout) rootView, btGoToUserCart,
          btProcceedToPay, btSeeAllProductsMinimized, cabeceraLogIn, cabeceraLogin,
          editTextAddressCUP, edtEmailUserCP, edtEmailUserCUP, infoUserCheckOutPageAddress,
          infoUserCheckOutPageTotalPrice, main, mapView, tvwPriceTotalUser);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
