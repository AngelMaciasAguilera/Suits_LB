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

public final class ActivityMainAdminScreenManagerBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final LinearLayout cabeceraLogIn;

  @NonNull
  public final TextView cabeceraLogin;

  @NonNull
  public final EditText edtSearchAdmin;

  @NonNull
  public final FloatingActionButton fbtaddAdmin;

  @NonNull
  public final Button goToBackEndSelection;

  @NonNull
  public final ImageButton imgbReturnAdmin;

  @NonNull
  public final ImageButton imgbSearchAdmin;

  @NonNull
  public final ConstraintLayout main;

  @NonNull
  public final RecyclerView rvAdmins;

  private ActivityMainAdminScreenManagerBinding(@NonNull ConstraintLayout rootView,
      @NonNull LinearLayout cabeceraLogIn, @NonNull TextView cabeceraLogin,
      @NonNull EditText edtSearchAdmin, @NonNull FloatingActionButton fbtaddAdmin,
      @NonNull Button goToBackEndSelection, @NonNull ImageButton imgbReturnAdmin,
      @NonNull ImageButton imgbSearchAdmin, @NonNull ConstraintLayout main,
      @NonNull RecyclerView rvAdmins) {
    this.rootView = rootView;
    this.cabeceraLogIn = cabeceraLogIn;
    this.cabeceraLogin = cabeceraLogin;
    this.edtSearchAdmin = edtSearchAdmin;
    this.fbtaddAdmin = fbtaddAdmin;
    this.goToBackEndSelection = goToBackEndSelection;
    this.imgbReturnAdmin = imgbReturnAdmin;
    this.imgbSearchAdmin = imgbSearchAdmin;
    this.main = main;
    this.rvAdmins = rvAdmins;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityMainAdminScreenManagerBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityMainAdminScreenManagerBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_main_admin_screen_manager, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityMainAdminScreenManagerBinding bind(@NonNull View rootView) {
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

      id = R.id.edtSearchAdmin;
      EditText edtSearchAdmin = ViewBindings.findChildViewById(rootView, id);
      if (edtSearchAdmin == null) {
        break missingId;
      }

      id = R.id.fbtaddAdmin;
      FloatingActionButton fbtaddAdmin = ViewBindings.findChildViewById(rootView, id);
      if (fbtaddAdmin == null) {
        break missingId;
      }

      id = R.id.goToBackEndSelection;
      Button goToBackEndSelection = ViewBindings.findChildViewById(rootView, id);
      if (goToBackEndSelection == null) {
        break missingId;
      }

      id = R.id.imgbReturnAdmin;
      ImageButton imgbReturnAdmin = ViewBindings.findChildViewById(rootView, id);
      if (imgbReturnAdmin == null) {
        break missingId;
      }

      id = R.id.imgbSearchAdmin;
      ImageButton imgbSearchAdmin = ViewBindings.findChildViewById(rootView, id);
      if (imgbSearchAdmin == null) {
        break missingId;
      }

      ConstraintLayout main = (ConstraintLayout) rootView;

      id = R.id.rvAdmins;
      RecyclerView rvAdmins = ViewBindings.findChildViewById(rootView, id);
      if (rvAdmins == null) {
        break missingId;
      }

      return new ActivityMainAdminScreenManagerBinding((ConstraintLayout) rootView, cabeceraLogIn,
          cabeceraLogin, edtSearchAdmin, fbtaddAdmin, goToBackEndSelection, imgbReturnAdmin,
          imgbSearchAdmin, main, rvAdmins);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}