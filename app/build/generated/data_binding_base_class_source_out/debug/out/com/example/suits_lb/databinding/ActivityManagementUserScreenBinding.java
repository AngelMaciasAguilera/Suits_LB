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

public final class ActivityManagementUserScreenBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final TextView adsPasswordUser;

  @NonNull
  public final TextView adsPhoneUser;

  @NonNull
  public final TextView adsUserAge;

  @NonNull
  public final TextView adsUserEmail;

  @NonNull
  public final TextView adsUserName;

  @NonNull
  public final Button btCancelUserManagement;

  @NonNull
  public final Button btDeleteUser;

  @NonNull
  public final LinearLayout cabeceraLogIn;

  @NonNull
  public final TextView cabeceraLogin;

  @NonNull
  public final EditText edtmaUserAge;

  @NonNull
  public final EditText edtmaUserEmail;

  @NonNull
  public final EditText edtmaUserName;

  @NonNull
  public final EditText edtmaUserPassword;

  @NonNull
  public final EditText edtmaUserPhone;

  @NonNull
  public final ConstraintLayout main;

  private ActivityManagementUserScreenBinding(@NonNull ConstraintLayout rootView,
      @NonNull TextView adsPasswordUser, @NonNull TextView adsPhoneUser,
      @NonNull TextView adsUserAge, @NonNull TextView adsUserEmail, @NonNull TextView adsUserName,
      @NonNull Button btCancelUserManagement, @NonNull Button btDeleteUser,
      @NonNull LinearLayout cabeceraLogIn, @NonNull TextView cabeceraLogin,
      @NonNull EditText edtmaUserAge, @NonNull EditText edtmaUserEmail,
      @NonNull EditText edtmaUserName, @NonNull EditText edtmaUserPassword,
      @NonNull EditText edtmaUserPhone, @NonNull ConstraintLayout main) {
    this.rootView = rootView;
    this.adsPasswordUser = adsPasswordUser;
    this.adsPhoneUser = adsPhoneUser;
    this.adsUserAge = adsUserAge;
    this.adsUserEmail = adsUserEmail;
    this.adsUserName = adsUserName;
    this.btCancelUserManagement = btCancelUserManagement;
    this.btDeleteUser = btDeleteUser;
    this.cabeceraLogIn = cabeceraLogIn;
    this.cabeceraLogin = cabeceraLogin;
    this.edtmaUserAge = edtmaUserAge;
    this.edtmaUserEmail = edtmaUserEmail;
    this.edtmaUserName = edtmaUserName;
    this.edtmaUserPassword = edtmaUserPassword;
    this.edtmaUserPhone = edtmaUserPhone;
    this.main = main;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityManagementUserScreenBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityManagementUserScreenBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_management_user_screen, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityManagementUserScreenBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.adsPasswordUser;
      TextView adsPasswordUser = ViewBindings.findChildViewById(rootView, id);
      if (adsPasswordUser == null) {
        break missingId;
      }

      id = R.id.adsPhoneUser;
      TextView adsPhoneUser = ViewBindings.findChildViewById(rootView, id);
      if (adsPhoneUser == null) {
        break missingId;
      }

      id = R.id.adsUserAge;
      TextView adsUserAge = ViewBindings.findChildViewById(rootView, id);
      if (adsUserAge == null) {
        break missingId;
      }

      id = R.id.adsUserEmail;
      TextView adsUserEmail = ViewBindings.findChildViewById(rootView, id);
      if (adsUserEmail == null) {
        break missingId;
      }

      id = R.id.adsUserName;
      TextView adsUserName = ViewBindings.findChildViewById(rootView, id);
      if (adsUserName == null) {
        break missingId;
      }

      id = R.id.btCancelUserManagement;
      Button btCancelUserManagement = ViewBindings.findChildViewById(rootView, id);
      if (btCancelUserManagement == null) {
        break missingId;
      }

      id = R.id.btDeleteUser;
      Button btDeleteUser = ViewBindings.findChildViewById(rootView, id);
      if (btDeleteUser == null) {
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

      id = R.id.edtmaUserAge;
      EditText edtmaUserAge = ViewBindings.findChildViewById(rootView, id);
      if (edtmaUserAge == null) {
        break missingId;
      }

      id = R.id.edtmaUserEmail;
      EditText edtmaUserEmail = ViewBindings.findChildViewById(rootView, id);
      if (edtmaUserEmail == null) {
        break missingId;
      }

      id = R.id.edtmaUserName;
      EditText edtmaUserName = ViewBindings.findChildViewById(rootView, id);
      if (edtmaUserName == null) {
        break missingId;
      }

      id = R.id.edtmaUserPassword;
      EditText edtmaUserPassword = ViewBindings.findChildViewById(rootView, id);
      if (edtmaUserPassword == null) {
        break missingId;
      }

      id = R.id.edtmaUserPhone;
      EditText edtmaUserPhone = ViewBindings.findChildViewById(rootView, id);
      if (edtmaUserPhone == null) {
        break missingId;
      }

      ConstraintLayout main = (ConstraintLayout) rootView;

      return new ActivityManagementUserScreenBinding((ConstraintLayout) rootView, adsPasswordUser,
          adsPhoneUser, adsUserAge, adsUserEmail, adsUserName, btCancelUserManagement, btDeleteUser,
          cabeceraLogIn, cabeceraLogin, edtmaUserAge, edtmaUserEmail, edtmaUserName,
          edtmaUserPassword, edtmaUserPhone, main);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}