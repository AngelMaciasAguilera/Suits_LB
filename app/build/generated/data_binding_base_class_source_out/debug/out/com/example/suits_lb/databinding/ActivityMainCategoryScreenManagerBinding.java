// Generated by view binder compiler. Do not edit!
package com.example.suits_lb.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.suits_lb.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityMainCategoryScreenManagerBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final LinearLayout cabeceraLogIn;

  @NonNull
  public final TextView cabeceraLogin;

  @NonNull
  public final EditText edtSearchCategory;

  @NonNull
  public final FloatingActionButton fbtaddCategory;

  @NonNull
  public final Button goToBackEndSelection;

  @NonNull
  public final ImageButton imgbReturnCategory;

  @NonNull
  public final ImageButton imgbSearchCategory;

  @NonNull
  public final ConstraintLayout main;

  @NonNull
  public final RecyclerView rvCategory;

  private ActivityMainCategoryScreenManagerBinding(@NonNull ConstraintLayout rootView,
      @NonNull LinearLayout cabeceraLogIn, @NonNull TextView cabeceraLogin,
      @NonNull EditText edtSearchCategory, @NonNull FloatingActionButton fbtaddCategory,
      @NonNull Button goToBackEndSelection, @NonNull ImageButton imgbReturnCategory,
      @NonNull ImageButton imgbSearchCategory, @NonNull ConstraintLayout main,
      @NonNull RecyclerView rvCategory) {
    this.rootView = rootView;
    this.cabeceraLogIn = cabeceraLogIn;
    this.cabeceraLogin = cabeceraLogin;
    this.edtSearchCategory = edtSearchCategory;
    this.fbtaddCategory = fbtaddCategory;
    this.goToBackEndSelection = goToBackEndSelection;
    this.imgbReturnCategory = imgbReturnCategory;
    this.imgbSearchCategory = imgbSearchCategory;
    this.main = main;
    this.rvCategory = rvCategory;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityMainCategoryScreenManagerBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityMainCategoryScreenManagerBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_main_category_screen_manager, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityMainCategoryScreenManagerBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
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

      id = R.id.edtSearchCategory;
      EditText edtSearchCategory = ViewBindings.findChildViewById(rootView, id);
      if (edtSearchCategory == null) {
        break missingId;
      }

      id = R.id.fbtaddCategory;
      FloatingActionButton fbtaddCategory = ViewBindings.findChildViewById(rootView, id);
      if (fbtaddCategory == null) {
        break missingId;
      }

      id = R.id.goToBackEndSelection;
      Button goToBackEndSelection = ViewBindings.findChildViewById(rootView, id);
      if (goToBackEndSelection == null) {
        break missingId;
      }

      id = R.id.imgbReturnCategory;
      ImageButton imgbReturnCategory = ViewBindings.findChildViewById(rootView, id);
      if (imgbReturnCategory == null) {
        break missingId;
      }

      id = R.id.imgbSearchCategory;
      ImageButton imgbSearchCategory = ViewBindings.findChildViewById(rootView, id);
      if (imgbSearchCategory == null) {
        break missingId;
      }

      ConstraintLayout main = (ConstraintLayout) rootView;

      id = R.id.rvCategory;
      RecyclerView rvCategory = ViewBindings.findChildViewById(rootView, id);
      if (rvCategory == null) {
        break missingId;
      }

      return new ActivityMainCategoryScreenManagerBinding((ConstraintLayout) rootView,
          cabeceraLogIn, cabeceraLogin, edtSearchCategory, fbtaddCategory, goToBackEndSelection,
          imgbReturnCategory, imgbSearchCategory, main, rvCategory);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}