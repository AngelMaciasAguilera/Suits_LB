package com.example.suits_lb.vistas.UserViews.recyclerViewUserNotifications;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.suits_lb.R;

public class rvHolderUserNotifications extends RecyclerView.ViewHolder implements View.OnClickListener {
    private TextView tvwNotificationValue;
    private ListNotificationsUserAdapter listNotificationsUserAdapter;

    public rvHolderUserNotifications(@NonNull View itemView, ListNotificationsUserAdapter listNotificationsUserAdapter) {
        super(itemView);
        this.tvwNotificationValue = itemView.findViewById(R.id.tvwNotificationValue);
        this.listNotificationsUserAdapter = listNotificationsUserAdapter;
        itemView.setOnClickListener(this);
    }

    public TextView getTvwNotificationValue() {
        return tvwNotificationValue;
    }

    public void setTvwNotificationValue(TextView tvwNotificationValue) {
        this.tvwNotificationValue = tvwNotificationValue;
    }

    public ListNotificationsUserAdapter getListNotificationsUserAdapter() {
        return listNotificationsUserAdapter;
    }

    public void setListNotificationsUserAdapter(ListNotificationsUserAdapter listNotificationsUserAdapter) {
        this.listNotificationsUserAdapter = listNotificationsUserAdapter;
    }

    @Override
    public void onClick(View v) {

    }
}
