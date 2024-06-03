// Generated by view binder compiler. Do not edit!
package com.example.suits_lb.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
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

public final class ActivityManagementProductScreenBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Button btCancelManagingProduct;

  @NonNull
  public final Button btDeleteProduct;

  @NonNull
  public final Button btUpdateProduct;

  @NonNull
  public final LinearLayout cabeceraLogIn;

  @NonNull
  public final TextView cabeceraLogin;

  @NonNull
  public final EditText edtClothCodeMAScreen;

  @NonNull
  public final EditText edtClothNameMAScreen;

  @NonNull
  public final EditText edtProductDescriptionMAScreen;

  @NonNull
  public final EditText edtProductPriceMAScreen;

  @NonNull
  public final EditText edtStockProductMAScreen;

  @NonNull
  public final ImageButton imgbtMAScreenProduct;

  @NonNull
  public final ImageView imgvwMAScreenProduct;

  @NonNull
  public final TextView infoTvwProductCategoryMAScreen;

  @NonNull
  public final TextView infotvwPriceProductMAScreen;

  @NonNull
  public final TextView infotvwProductCodeMAScreen;

  @NonNull
  public final TextView infotvwProductDescriptionMAScreen;

  @NonNull
  public final TextView infotvwProductNameMAScreen;

  @NonNull
  public final TextView infotvwProductSaleAvailableMAScreen;

  @NonNull
  public final TextView infotvwStockProductMAScreen;

  @NonNull
  public final ConstraintLayout main;

  @NonNull
  public final Spinner spAvailableSaleMAScreen;

  @NonNull
  public final Spinner spProductCategoriesMAScreen;

  @NonNull
  public final TextView txtImageMAScreenProduct;

  private ActivityManagementProductScreenBinding(@NonNull ConstraintLayout rootView,
      @NonNull Button btCancelManagingProduct, @NonNull Button btDeleteProduct,
      @NonNull Button btUpdateProduct, @NonNull LinearLayout cabeceraLogIn,
      @NonNull TextView cabeceraLogin, @NonNull EditText edtClothCodeMAScreen,
      @NonNull EditText edtClothNameMAScreen, @NonNull EditText edtProductDescriptionMAScreen,
      @NonNull EditText edtProductPriceMAScreen, @NonNull EditText edtStockProductMAScreen,
      @NonNull ImageButton imgbtMAScreenProduct, @NonNull ImageView imgvwMAScreenProduct,
      @NonNull TextView infoTvwProductCategoryMAScreen,
      @NonNull TextView infotvwPriceProductMAScreen, @NonNull TextView infotvwProductCodeMAScreen,
      @NonNull TextView infotvwProductDescriptionMAScreen,
      @NonNull TextView infotvwProductNameMAScreen,
      @NonNull TextView infotvwProductSaleAvailableMAScreen,
      @NonNull TextView infotvwStockProductMAScreen, @NonNull ConstraintLayout main,
      @NonNull Spinner spAvailableSaleMAScreen, @NonNull Spinner spProductCategoriesMAScreen,
      @NonNull TextView txtImageMAScreenProduct) {
    this.rootView = rootView;
    this.btCancelManagingProduct = btCancelManagingProduct;
    this.btDeleteProduct = btDeleteProduct;
    this.btUpdateProduct = btUpdateProduct;
    this.cabeceraLogIn = cabeceraLogIn;
    this.cabeceraLogin = cabeceraLogin;
    this.edtClothCodeMAScreen = edtClothCodeMAScreen;
    this.edtClothNameMAScreen = edtClothNameMAScreen;
    this.edtProductDescriptionMAScreen = edtProductDescriptionMAScreen;
    this.edtProductPriceMAScreen = edtProductPriceMAScreen;
    this.edtStockProductMAScreen = edtStockProductMAScreen;
    this.imgbtMAScreenProduct = imgbtMAScreenProduct;
    this.imgvwMAScreenProduct = imgvwMAScreenProduct;
    this.infoTvwProductCategoryMAScreen = infoTvwProductCategoryMAScreen;
    this.infotvwPriceProductMAScreen = infotvwPriceProductMAScreen;
    this.infotvwProductCodeMAScreen = infotvwProductCodeMAScreen;
    this.infotvwProductDescriptionMAScreen = infotvwProductDescriptionMAScreen;
    this.infotvwProductNameMAScreen = infotvwProductNameMAScreen;
    this.infotvwProductSaleAvailableMAScreen = infotvwProductSaleAvailableMAScreen;
    this.infotvwStockProductMAScreen = infotvwStockProductMAScreen;
    this.main = main;
    this.spAvailableSaleMAScreen = spAvailableSaleMAScreen;
    this.spProductCategoriesMAScreen = spProductCategoriesMAScreen;
    this.txtImageMAScreenProduct = txtImageMAScreenProduct;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityManagementProductScreenBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityManagementProductScreenBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_management_product_screen, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityManagementProductScreenBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btCancelManagingProduct;
      Button btCancelManagingProduct = ViewBindings.findChildViewById(rootView, id);
      if (btCancelManagingProduct == null) {
        break missingId;
      }

      id = R.id.btDeleteProduct;
      Button btDeleteProduct = ViewBindings.findChildViewById(rootView, id);
      if (btDeleteProduct == null) {
        break missingId;
      }

      id = R.id.btUpdateProduct;
      Button btUpdateProduct = ViewBindings.findChildViewById(rootView, id);
      if (btUpdateProduct == null) {
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

      id = R.id.edtClothCodeMAScreen;
      EditText edtClothCodeMAScreen = ViewBindings.findChildViewById(rootView, id);
      if (edtClothCodeMAScreen == null) {
        break missingId;
      }

      id = R.id.edtClothNameMAScreen;
      EditText edtClothNameMAScreen = ViewBindings.findChildViewById(rootView, id);
      if (edtClothNameMAScreen == null) {
        break missingId;
      }

      id = R.id.edtProductDescriptionMAScreen;
      EditText edtProductDescriptionMAScreen = ViewBindings.findChildViewById(rootView, id);
      if (edtProductDescriptionMAScreen == null) {
        break missingId;
      }

      id = R.id.edtProductPriceMAScreen;
      EditText edtProductPriceMAScreen = ViewBindings.findChildViewById(rootView, id);
      if (edtProductPriceMAScreen == null) {
        break missingId;
      }

      id = R.id.edtStockProductMAScreen;
      EditText edtStockProductMAScreen = ViewBindings.findChildViewById(rootView, id);
      if (edtStockProductMAScreen == null) {
        break missingId;
      }

      id = R.id.imgbtMAScreenProduct;
      ImageButton imgbtMAScreenProduct = ViewBindings.findChildViewById(rootView, id);
      if (imgbtMAScreenProduct == null) {
        break missingId;
      }

      id = R.id.imgvwMAScreenProduct;
      ImageView imgvwMAScreenProduct = ViewBindings.findChildViewById(rootView, id);
      if (imgvwMAScreenProduct == null) {
        break missingId;
      }

      id = R.id.infoTvwProductCategoryMAScreen;
      TextView infoTvwProductCategoryMAScreen = ViewBindings.findChildViewById(rootView, id);
      if (infoTvwProductCategoryMAScreen == null) {
        break missingId;
      }

      id = R.id.infotvwPriceProductMAScreen;
      TextView infotvwPriceProductMAScreen = ViewBindings.findChildViewById(rootView, id);
      if (infotvwPriceProductMAScreen == null) {
        break missingId;
      }

      id = R.id.infotvwProductCodeMAScreen;
      TextView infotvwProductCodeMAScreen = ViewBindings.findChildViewById(rootView, id);
      if (infotvwProductCodeMAScreen == null) {
        break missingId;
      }

      id = R.id.infotvwProductDescriptionMAScreen;
      TextView infotvwProductDescriptionMAScreen = ViewBindings.findChildViewById(rootView, id);
      if (infotvwProductDescriptionMAScreen == null) {
        break missingId;
      }

      id = R.id.infotvwProductNameMAScreen;
      TextView infotvwProductNameMAScreen = ViewBindings.findChildViewById(rootView, id);
      if (infotvwProductNameMAScreen == null) {
        break missingId;
      }

      id = R.id.infotvwProductSaleAvailableMAScreen;
      TextView infotvwProductSaleAvailableMAScreen = ViewBindings.findChildViewById(rootView, id);
      if (infotvwProductSaleAvailableMAScreen == null) {
        break missingId;
      }

      id = R.id.infotvwStockProductMAScreen;
      TextView infotvwStockProductMAScreen = ViewBindings.findChildViewById(rootView, id);
      if (infotvwStockProductMAScreen == null) {
        break missingId;
      }

      ConstraintLayout main = (ConstraintLayout) rootView;

      id = R.id.spAvailableSaleMAScreen;
      Spinner spAvailableSaleMAScreen = ViewBindings.findChildViewById(rootView, id);
      if (spAvailableSaleMAScreen == null) {
        break missingId;
      }

      id = R.id.spProductCategoriesMAScreen;
      Spinner spProductCategoriesMAScreen = ViewBindings.findChildViewById(rootView, id);
      if (spProductCategoriesMAScreen == null) {
        break missingId;
      }

      id = R.id.txtImageMAScreenProduct;
      TextView txtImageMAScreenProduct = ViewBindings.findChildViewById(rootView, id);
      if (txtImageMAScreenProduct == null) {
        break missingId;
      }

      return new ActivityManagementProductScreenBinding((ConstraintLayout) rootView,
          btCancelManagingProduct, btDeleteProduct, btUpdateProduct, cabeceraLogIn, cabeceraLogin,
          edtClothCodeMAScreen, edtClothNameMAScreen, edtProductDescriptionMAScreen,
          edtProductPriceMAScreen, edtStockProductMAScreen, imgbtMAScreenProduct,
          imgvwMAScreenProduct, infoTvwProductCategoryMAScreen, infotvwPriceProductMAScreen,
          infotvwProductCodeMAScreen, infotvwProductDescriptionMAScreen, infotvwProductNameMAScreen,
          infotvwProductSaleAvailableMAScreen, infotvwStockProductMAScreen, main,
          spAvailableSaleMAScreen, spProductCategoriesMAScreen, txtImageMAScreenProduct);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
