// Generated by view binder compiler. Do not edit!
package com.example.suits_lb.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
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

public final class ActivityAboutUsPageBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final LinearLayout cabeceraLogIn;

  @NonNull
  public final TextView cabeceraLogin;

  @NonNull
  public final Button goToHomeABUP;

  @NonNull
  public final ImageView imgvwAboutUsPage;

  @NonNull
  public final ConstraintLayout main;

  @NonNull
  public final TextView tvwAboutUsPage;

  private ActivityAboutUsPageBinding(@NonNull ConstraintLayout rootView,
      @NonNull LinearLayout cabeceraLogIn, @NonNull TextView cabeceraLogin,
      @NonNull Button goToHomeABUP, @NonNull ImageView imgvwAboutUsPage,
      @NonNull ConstraintLayout main, @NonNull TextView tvwAboutUsPage) {
    this.rootView = rootView;
    this.cabeceraLogIn = cabeceraLogIn;
    this.cabeceraLogin = cabeceraLogin;
    this.goToHomeABUP = goToHomeABUP;
    this.imgvwAboutUsPage = imgvwAboutUsPage;
    this.main = main;
    this.tvwAboutUsPage = tvwAboutUsPage;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityAboutUsPageBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityAboutUsPageBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_about_us_page, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityAboutUsPageBinding bind(@NonNull View rootView) {
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

      id = R.id.goToHomeABUP;
      Button goToHomeABUP = ViewBindings.findChildViewById(rootView, id);
      if (goToHomeABUP == null) {
        break missingId;
      }

      id = R.id.imgvwAboutUsPage;
      ImageView imgvwAboutUsPage = ViewBindings.findChildViewById(rootView, id);
      if (imgvwAboutUsPage == null) {
        break missingId;
      }

      ConstraintLayout main = (ConstraintLayout) rootView;

      id = R.id.tvwAboutUsPage;
      TextView tvwAboutUsPage = ViewBindings.findChildViewById(rootView, id);
      if (tvwAboutUsPage == null) {
        break missingId;
      }

      return new ActivityAboutUsPageBinding((ConstraintLayout) rootView, cabeceraLogIn,
          cabeceraLogin, goToHomeABUP, imgvwAboutUsPage, main, tvwAboutUsPage);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}