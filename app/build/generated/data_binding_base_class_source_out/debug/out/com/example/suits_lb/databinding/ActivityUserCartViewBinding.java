// Generated by view binder compiler. Do not edit!
package com.example.suits_lb.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
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
  public final DrawerLayout drawerLayoutUserCartView;

  @NonNull
  public final FloatingActionButton ftbGoToCheckOutPage;

  @NonNull
  public final ImageButton imageButtonSearchUserCartView;

  @NonNull
  public final ImageButton imageButtonUserUserCartView;

  @NonNull
  public final NavigationView navigationViewUserCartView;

  @NonNull
  public final RecyclerView rvUserProductsUserCartView;

  @NonNull
  public final TextView toolbarTitleUserCartView;

  @NonNull
  public final Toolbar toolbarUserCartView;

  private ActivityUserCartViewBinding(@NonNull DrawerLayout rootView,
      @NonNull BottomNavigationView bottomNavigationViewUserCartView,
      @NonNull DrawerLayout drawerLayoutUserCartView,
      @NonNull FloatingActionButton ftbGoToCheckOutPage,
      @NonNull ImageButton imageButtonSearchUserCartView,
      @NonNull ImageButton imageButtonUserUserCartView,
      @NonNull NavigationView navigationViewUserCartView,
      @NonNull RecyclerView rvUserProductsUserCartView, @NonNull TextView toolbarTitleUserCartView,
      @NonNull Toolbar toolbarUserCartView) {
    this.rootView = rootView;
    this.bottomNavigationViewUserCartView = bottomNavigationViewUserCartView;
    this.drawerLayoutUserCartView = drawerLayoutUserCartView;
    this.ftbGoToCheckOutPage = ftbGoToCheckOutPage;
    this.imageButtonSearchUserCartView = imageButtonSearchUserCartView;
    this.imageButtonUserUserCartView = imageButtonUserUserCartView;
    this.navigationViewUserCartView = navigationViewUserCartView;
    this.rvUserProductsUserCartView = rvUserProductsUserCartView;
    this.toolbarTitleUserCartView = toolbarTitleUserCartView;
    this.toolbarUserCartView = toolbarUserCartView;
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

      DrawerLayout drawerLayoutUserCartView = (DrawerLayout) rootView;

      id = R.id.ftbGoToCheckOutPage;
      FloatingActionButton ftbGoToCheckOutPage = ViewBindings.findChildViewById(rootView, id);
      if (ftbGoToCheckOutPage == null) {
        break missingId;
      }

      id = R.id.imageButtonSearch_userCartView;
      ImageButton imageButtonSearchUserCartView = ViewBindings.findChildViewById(rootView, id);
      if (imageButtonSearchUserCartView == null) {
        break missingId;
      }

      id = R.id.imageButtonUser_userCartView;
      ImageButton imageButtonUserUserCartView = ViewBindings.findChildViewById(rootView, id);
      if (imageButtonUserUserCartView == null) {
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

      id = R.id.toolbar_title_userCartView;
      TextView toolbarTitleUserCartView = ViewBindings.findChildViewById(rootView, id);
      if (toolbarTitleUserCartView == null) {
        break missingId;
      }

      id = R.id.toolbar_userCartView;
      Toolbar toolbarUserCartView = ViewBindings.findChildViewById(rootView, id);
      if (toolbarUserCartView == null) {
        break missingId;
      }

      return new ActivityUserCartViewBinding((DrawerLayout) rootView,
          bottomNavigationViewUserCartView, drawerLayoutUserCartView, ftbGoToCheckOutPage,
          imageButtonSearchUserCartView, imageButtonUserUserCartView, navigationViewUserCartView,
          rvUserProductsUserCartView, toolbarTitleUserCartView, toolbarUserCartView);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
