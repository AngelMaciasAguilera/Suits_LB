package com.example.suits_lb.vistas.UserViews.recyclerViewUserNotifications;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.suits_lb.R;

import java.util.ArrayList;


public class ListNotificationsUserAdapter extends RecyclerView.Adapter<rvHolderUserNotifications>{
    private Context contexto;
    private ArrayList<String> notificationsUser;
    private LayoutInflater inflate;

    public ListNotificationsUserAdapter(Context contexto, ArrayList<String> notificationsUser) {
        this.contexto = contexto;
        this.notificationsUser = notificationsUser;
        this.inflate = LayoutInflater.from(this.contexto);
    }

    public Context getContexto() {
        return contexto;
    }

    public void setContexto(Context contexto) {
        this.contexto = contexto;
    }

    public ArrayList<String> getNotificationsUser() {
        return notificationsUser;
    }

    public void setNotificationsUser(ArrayList<String> notificationsUser) {
        this.notificationsUser = notificationsUser;
    }

    public LayoutInflater getInflate() {
        return inflate;
    }

    public void setInflate(LayoutInflater inflate) {
        this.inflate = inflate;
    }

    @NonNull
    @Override
    public rvHolderUserNotifications onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View notificationView = inflate.inflate(R.layout.single_notifications_view, parent, false);
        rvHolderUserNotifications hun = new rvHolderUserNotifications(notificationView,this);
        return hun;
    }

    @Override
    public void onBindViewHolder(@NonNull rvHolderUserNotifications holder, int position) {
        String notification = notificationsUser.get(position);
        holder.getTvwNotificationValue().setText(notification);
    }

    @Override
    public int getItemCount() {
        return notificationsUser.size();
    }
}
