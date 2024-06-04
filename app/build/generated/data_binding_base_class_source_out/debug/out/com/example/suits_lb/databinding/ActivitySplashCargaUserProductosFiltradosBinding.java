// Generated by view binder compiler. Do not edit!
package com.example.suits_lb.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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

public final class ActivitySplashCargaUserProductosFiltradosBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ImageView imageView3;

  @NonNull
  public final TextView infoUserCargaFiltrada;

  @NonNull
  public final ConstraintLayout main;

  @NonNull
  public final ImageView splashWaveFiltered1;

  @NonNull
  public final ImageView splashWaveFiltered2;

  private ActivitySplashCargaUserProductosFiltradosBinding(@NonNull ConstraintLayout rootView,
      @NonNull ImageView imageView3, @NonNull TextView infoUserCargaFiltrada,
      @NonNull ConstraintLayout main, @NonNull ImageView splashWaveFiltered1,
      @NonNull ImageView splashWaveFiltered2) {
    this.rootView = rootView;
    this.imageView3 = imageView3;
    this.infoUserCargaFiltrada = infoUserCargaFiltrada;
    this.main = main;
    this.splashWaveFiltered1 = splashWaveFiltered1;
    this.splashWaveFiltered2 = splashWaveFiltered2;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivitySplashCargaUserProductosFiltradosBinding inflate(
      @NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivitySplashCargaUserProductosFiltradosBinding inflate(
      @NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_splash_carga_user_productos_filtrados, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivitySplashCargaUserProductosFiltradosBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.imageView3;
      ImageView imageView3 = ViewBindings.findChildViewById(rootView, id);
      if (imageView3 == null) {
        break missingId;
      }

      id = R.id.infoUserCargaFiltrada;
      TextView infoUserCargaFiltrada = ViewBindings.findChildViewById(rootView, id);
      if (infoUserCargaFiltrada == null) {
        break missingId;
      }

      ConstraintLayout main = (ConstraintLayout) rootView;

      id = R.id.splash_wave_filtered_1;
      ImageView splashWaveFiltered1 = ViewBindings.findChildViewById(rootView, id);
      if (splashWaveFiltered1 == null) {
        break missingId;
      }

      id = R.id.splash_wave_filtered_2;
      ImageView splashWaveFiltered2 = ViewBindings.findChildViewById(rootView, id);
      if (splashWaveFiltered2 == null) {
        break missingId;
      }

      return new ActivitySplashCargaUserProductosFiltradosBinding((ConstraintLayout) rootView,
          imageView3, infoUserCargaFiltrada, main, splashWaveFiltered1, splashWaveFiltered2);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
