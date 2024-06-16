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

public final class ActivityAccountUserDetailsBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Button btDeleteAccountUser;

  @NonNull
  public final Button btGoToAccountDetails;

  @NonNull
  public final Button btGoToHomeUserDetails;

  @NonNull
  public final Button btLogOut;

  @NonNull
  public final Button btSeeMyOrders;

  @NonNull
  public final LinearLayout cabeceraLogIn;

  @NonNull
  public final TextView cabeceraLogin;

  @NonNull
  public final EditText edtAgeUserAUD;

  @NonNull
  public final EditText edtEmailUserAUD;

  @NonNull
  public final EditText edtNameUserAUD;

  @NonNull
  public final EditText edtPhoneUserAUD;

  @NonNull
  public final ConstraintLayout main;

  @NonNull
  public final TextView textView10;

  @NonNull
  public final TextView textView12;

  @NonNull
  public final TextView textView5;

  @NonNull
  public final TextView textView9;

  private ActivityAccountUserDetailsBinding(@NonNull ConstraintLayout rootView,
      @NonNull Button btDeleteAccountUser, @NonNull Button btGoToAccountDetails,
      @NonNull Button btGoToHomeUserDetails, @NonNull Button btLogOut,
      @NonNull Button btSeeMyOrders, @NonNull LinearLayout cabeceraLogIn,
      @NonNull TextView cabeceraLogin, @NonNull EditText edtAgeUserAUD,
      @NonNull EditText edtEmailUserAUD, @NonNull EditText edtNameUserAUD,
      @NonNull EditText edtPhoneUserAUD, @NonNull ConstraintLayout main,
      @NonNull TextView textView10, @NonNull TextView textView12, @NonNull TextView textView5,
      @NonNull TextView textView9) {
    this.rootView = rootView;
    this.btDeleteAccountUser = btDeleteAccountUser;
    this.btGoToAccountDetails = btGoToAccountDetails;
    this.btGoToHomeUserDetails = btGoToHomeUserDetails;
    this.btLogOut = btLogOut;
    this.btSeeMyOrders = btSeeMyOrders;
    this.cabeceraLogIn = cabeceraLogIn;
    this.cabeceraLogin = cabeceraLogin;
    this.edtAgeUserAUD = edtAgeUserAUD;
    this.edtEmailUserAUD = edtEmailUserAUD;
    this.edtNameUserAUD = edtNameUserAUD;
    this.edtPhoneUserAUD = edtPhoneUserAUD;
    this.main = main;
    this.textView10 = textView10;
    this.textView12 = textView12;
    this.textView5 = textView5;
    this.textView9 = textView9;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityAccountUserDetailsBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityAccountUserDetailsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_account_user_details, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityAccountUserDetailsBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btDeleteAccountUser;
      Button btDeleteAccountUser = ViewBindings.findChildViewById(rootView, id);
      if (btDeleteAccountUser == null) {
        break missingId;
      }

      id = R.id.btGoToAccountDetails;
      Button btGoToAccountDetails = ViewBindings.findChildViewById(rootView, id);
      if (btGoToAccountDetails == null) {
        break missingId;
      }

      id = R.id.btGoToHome_userDetails;
      Button btGoToHomeUserDetails = ViewBindings.findChildViewById(rootView, id);
      if (btGoToHomeUserDetails == null) {
        break missingId;
      }

      id = R.id.btLogOut;
      Button btLogOut = ViewBindings.findChildViewById(rootView, id);
      if (btLogOut == null) {
        break missingId;
      }

      id = R.id.btSeeMyOrders;
      Button btSeeMyOrders = ViewBindings.findChildViewById(rootView, id);
      if (btSeeMyOrders == null) {
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

      id = R.id.edtAgeUserAUD;
      EditText edtAgeUserAUD = ViewBindings.findChildViewById(rootView, id);
      if (edtAgeUserAUD == null) {
        break missingId;
      }

      id = R.id.edtEmailUserAUD;
      EditText edtEmailUserAUD = ViewBindings.findChildViewById(rootView, id);
      if (edtEmailUserAUD == null) {
        break missingId;
      }

      id = R.id.edtNameUserAUD;
      EditText edtNameUserAUD = ViewBindings.findChildViewById(rootView, id);
      if (edtNameUserAUD == null) {
        break missingId;
      }

      id = R.id.edtPhoneUserAUD;
      EditText edtPhoneUserAUD = ViewBindings.findChildViewById(rootView, id);
      if (edtPhoneUserAUD == null) {
        break missingId;
      }

      ConstraintLayout main = (ConstraintLayout) rootView;

      id = R.id.textView10;
      TextView textView10 = ViewBindings.findChildViewById(rootView, id);
      if (textView10 == null) {
        break missingId;
      }

      id = R.id.textView12;
      TextView textView12 = ViewBindings.findChildViewById(rootView, id);
      if (textView12 == null) {
        break missingId;
      }

      id = R.id.textView5;
      TextView textView5 = ViewBindings.findChildViewById(rootView, id);
      if (textView5 == null) {
        break missingId;
      }

      id = R.id.textView9;
      TextView textView9 = ViewBindings.findChildViewById(rootView, id);
      if (textView9 == null) {
        break missingId;
      }

      return new ActivityAccountUserDetailsBinding((ConstraintLayout) rootView, btDeleteAccountUser,
          btGoToAccountDetails, btGoToHomeUserDetails, btLogOut, btSeeMyOrders, cabeceraLogIn,
          cabeceraLogin, edtAgeUserAUD, edtEmailUserAUD, edtNameUserAUD, edtPhoneUserAUD, main,
          textView10, textView12, textView5, textView9);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
