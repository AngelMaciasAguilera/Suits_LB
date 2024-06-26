// Generated by view binder compiler. Do not edit!
package com.example.suits_lb.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.suits_lb.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityUserCartViewBinding implements ViewBinding {
  @NonNull
  private final DrawerLayout rootView;

  @NonNull
  public final BottomNavigationView bottomNavigationViewUserCartView;

  @NonNull
  public final Button btStripCart;

  @NonNull
  public final DrawerLayout drawerLayoutUserCartView;

  @NonNull
  public final FloatingActionButton ftbGoToCheckOutPage;

  @NonNull
  public final NavigationView navigationViewUserCartView;

  @NonNull
  public final RecyclerView rvUserProductsUserCartView;

  @NonNull
  public final TextView toolbarTitle;

  @NonNull
  public final Toolbar toolbarUserCartView;

  @NonNull
  public final TextView tvwGoToAccountUserUserCartView;

  private ActivityUserCartViewBinding(@NonNull DrawerLayout rootView,
      @NonNull BottomNavigationView bottomNavigationViewUserCartView, @NonNull Button btStripCart,
      @NonNull DrawerLayout drawerLayoutUserCartView,
      @NonNull FloatingActionButton ftbGoToCheckOutPage,
      @NonNull NavigationView navigationViewUserCartView,
      @NonNull RecyclerView rvUserProductsUserCartView, @NonNull TextView toolbarTitle,
      @NonNull Toolbar toolbarUserCartView, @NonNull TextView tvwGoToAccountUserUserCartView) {
    this.rootView = rootView;
    this.bottomNavigationViewUserCartView = bottomNavigationViewUserCartView;
    this.btStripCart = btStripCart;
    this.drawerLayoutUserCartView = drawerLayoutUserCartView;
    this.ftbGoToCheckOutPage = ftbGoToCheckOutPage;
    this.navigationViewUserCartView = navigationViewUserCartView;
    this.rvUserProductsUserCartView = rvUserProductsUserCartView;
    this.toolbarTitle = toolbarTitle;
    this.toolbarUserCartView = toolbarUserCartView;
    this.tvwGoToAccountUserUserCartView = tvwGoToAccountUserUserCartView;
  }

  @Override
  @NonNull
  public DrawerLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityUserCartViewBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityUserCartViewBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_user_cart_view, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityUserCartViewBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.bottom_navigation_view_userCartView;
      BottomNavigationView bottomNavigationViewUserCartView = ViewBindings.findChildViewById(rootView, id);
      if (bottomNavigationViewUserCartView == null) {
        break missingId;
      }

      id = R.id.btStripCart;
      Button btStripCart = ViewBindings.findChildViewById(rootView, id);
      if (btStripCart == null) {
        break missingId;
      }

      DrawerLayout drawerLayoutUserCartView = (DrawerLayout) rootView;

      id = R.id.ftbGoToCheckOutPage;
      FloatingActionButton ftbGoToCheckOutPage = ViewBindings.findChildViewById(rootView, id);
      if (ftbGoToCheckOutPage == null) {
        break missingId;
      }

      id = R.id.navigation_view_userCartView;
      NavigationView navigationViewUserCartView = ViewBindings.findChildViewById(rootView, id);
      if (navigationViewUserCartView == null) {
        break missingId;
      }

      id = R.id.rvUserProducts_userCartView;
      RecyclerView rvUserProductsUserCartView = ViewBindings.findChildViewById(rootView, id);
      if (rvUserProductsUserCartView == null) {
        break missingId;
      }

      id = R.id.toolbar_title;
      TextView toolbarTitle = ViewBindings.findChildViewById(rootView, id);
      if (toolbarTitle == null) {
        break missingId;
      }

      id = R.id.toolbar_userCartView;
      Toolbar toolbarUserCartView = ViewBindings.findChildViewById(rootView, id);
      if (toolbarUserCartView == null) {
        break missingId;
      }

      id = R.id.tvwGoToAccountUser_userCartView;
      TextView tvwGoToAccountUserUserCartView = ViewBindings.findChildViewById(rootView, id);
      if (tvwGoToAccountUserUserCartView == null) {
        break missingId;
      }

      return new ActivityUserCartViewBinding((DrawerLayout) rootView,
          bottomNavigationViewUserCartView, btStripCart, drawerLayoutUserCartView,
          ftbGoToCheckOutPage, navigationViewUserCartView, rvUserProductsUserCartView, toolbarTitle,
          toolbarUserCartView, tvwGoToAccountUserUserCartView);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
