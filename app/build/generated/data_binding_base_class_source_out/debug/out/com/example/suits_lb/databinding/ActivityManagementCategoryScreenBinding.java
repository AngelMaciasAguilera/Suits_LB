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
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityManagementCategoryScreenBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Button btCancelCategoryManagement;

  @NonNull
  public final Button btDeleteCategory;

  @NonNull
  public final Button btUpdateCategory;

  @NonNull
  public final LinearLayout cabeceraLogIn;

  @NonNull
  public final TextView cabeceraLogin;

  @NonNull
  public final EditText edtmcCodCategory;

  @NonNull
  public final EditText edtmcNameCategory;

  @NonNull
  public final TextView maccpCategoryName;

  @NonNull
  public final TextView maccpCodCategory;

  @NonNull
  public final ConstraintLayout main;

  private ActivityManagementCategoryScreenBinding(@NonNull ConstraintLayout rootView,
      @NonNull Button btCancelCategoryManagement, @NonNull Button btDeleteCategory,
      @NonNull Button btUpdateCategory, @NonNull LinearLayout cabeceraLogIn,
      @NonNull TextView cabeceraLogin, @NonNull EditText edtmcCodCategory,
      @NonNull EditText edtmcNameCategory, @NonNull TextView maccpCategoryName,
      @NonNull TextView maccpCodCategory, @NonNull ConstraintLayout main) {
    this.rootView = rootView;
    this.btCancelCategoryManagement = btCancelCategoryManagement;
    this.btDeleteCategory = btDeleteCategory;
    this.btUpdateCategory = btUpdateCategory;
    this.cabeceraLogIn = cabeceraLogIn;
    this.cabeceraLogin = cabeceraLogin;
    this.edtmcCodCategory = edtmcCodCategory;
    this.edtmcNameCategory = edtmcNameCategory;
    this.maccpCategoryName = maccpCategoryName;
    this.maccpCodCategory = maccpCodCategory;
    this.main = main;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityManagementCategoryScreenBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityManagementCategoryScreenBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_management_category_screen, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityManagementCategoryScreenBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btCancelCategoryManagement;
      Button btCancelCategoryManagement = ViewBindings.findChildViewById(rootView, id);
      if (btCancelCategoryManagement == null) {
        break missingId;
      }

      id = R.id.btDeleteCategory;
      Button btDeleteCategory = ViewBindings.findChildViewById(rootView, id);
      if (btDeleteCategory == null) {
        break missingId;
      }

      id = R.id.btUpdateCategory;
      Button btUpdateCategory = ViewBindings.findChildViewById(rootView, id);
      if (btUpdateCategory == null) {
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

      id = R.id.edtmcCodCategory;
      EditText edtmcCodCategory = ViewBindings.findChildViewById(rootView, id);
      if (edtmcCodCategory == null) {
        break missingId;
      }

      id = R.id.edtmcNameCategory;
      EditText edtmcNameCategory = ViewBindings.findChildViewById(rootView, id);
      if (edtmcNameCategory == null) {
        break missingId;
      }

      id = R.id.maccpCategoryName;
      TextView maccpCategoryName = ViewBindings.findChildViewById(rootView, id);
      if (maccpCategoryName == null) {
        break missingId;
      }

      id = R.id.maccpCodCategory;
      TextView maccpCodCategory = ViewBindings.findChildViewById(rootView, id);
      if (maccpCodCategory == null) {
        break missingId;
      }

      ConstraintLayout main = (ConstraintLayout) rootView;

      return new ActivityManagementCategoryScreenBinding((ConstraintLayout) rootView,
          btCancelCategoryManagement, btDeleteCategory, btUpdateCategory, cabeceraLogIn,
          cabeceraLogin, edtmcCodCategory, edtmcNameCategory, maccpCategoryName, maccpCodCategory,
          main);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
