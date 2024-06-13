// Generated by view binder compiler. Do not edit!
package com.example.suits_lb.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.suits_lb.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class UserCardDialogBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final EditText edtCVC;

  @NonNull
  public final EditText edtCardNumber;

  @NonNull
  public final EditText edtExpiryDate;

  private UserCardDialogBinding(@NonNull LinearLayout rootView, @NonNull EditText edtCVC,
      @NonNull EditText edtCardNumber, @NonNull EditText edtExpiryDate) {
    this.rootView = rootView;
    this.edtCVC = edtCVC;
    this.edtCardNumber = edtCardNumber;
    this.edtExpiryDate = edtExpiryDate;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static UserCardDialogBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static UserCardDialogBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.user_card_dialog, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static UserCardDialogBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.edtCVC;
      EditText edtCVC = ViewBindings.findChildViewById(rootView, id);
      if (edtCVC == null) {
        break missingId;
      }

      id = R.id.edtCardNumber;
      EditText edtCardNumber = ViewBindings.findChildViewById(rootView, id);
      if (edtCardNumber == null) {
        break missingId;
      }

      id = R.id.edtExpiryDate;
      EditText edtExpiryDate = ViewBindings.findChildViewById(rootView, id);
      if (edtExpiryDate == null) {
        break missingId;
      }

      return new UserCardDialogBinding((LinearLayout) rootView, edtCVC, edtCardNumber,
          edtExpiryDate);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
