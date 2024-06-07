package com.example.suits_lb.vistas.UserViews.recyclerViewProductSummary;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.suits_lb.R;

public class rvHolderUserProductSummary extends RecyclerView.ViewHolder implements View.OnClickListener{

    private TextView tvwStockMinProduct,tvwSubtotalMinProduct,tvwProductNameMIN;
    private ImageView imgvwProductMIN;

    private ListProductSummaryAdapter listProductSummaryAdapter;

    public rvHolderUserProductSummary(@NonNull View itemView,ListProductSummaryAdapter listProductSummaryAdapter) {
        super(itemView);
        tvwStockMinProduct = (TextView)itemView.findViewById(R.id.tvwProductStockMIN);
        tvwProductNameMIN = (TextView) itemView.findViewById(R.id.tvwProductNameMIN);
        tvwSubtotalMinProduct = (TextView)itemView.findViewById(R.id.tvwProductSubtotalMIN);
        imgvwProductMIN = (ImageView)itemView.findViewById(R.id.imgvwProductMIN);
        this.listProductSummaryAdapter = listProductSummaryAdapter;
        itemView.setOnClickListener(this);
    }

    public TextView getTvwStockMinProduct() {
        return tvwStockMinProduct;
    }

    public TextView getTvwProductNameMIN() {
        return tvwProductNameMIN;
    }

    public void setTvwProductNameMIN(TextView tvwProductNameMIN) {
        this.tvwProductNameMIN = tvwProductNameMIN;
    }

    public void setTvwStockMinProduct(TextView tvwStockMinProduct) {
        this.tvwStockMinProduct = tvwStockMinProduct;
    }

    public TextView getTvwSubtotalMinProduct() {
        return tvwSubtotalMinProduct;
    }

    public void setTvwSubtotalMinProduct(TextView tvwSubtotalMinProduct) {
        this.tvwSubtotalMinProduct = tvwSubtotalMinProduct;
    }

    public ImageView getImgvwProductMIN() {
        return imgvwProductMIN;
    }

    public void setImgvwProductMIN(ImageView imgvwProductMIN) {
        this.imgvwProductMIN = imgvwProductMIN;
    }

    public ListProductSummaryAdapter getListProductSummaryAdapter() {
        return listProductSummaryAdapter;
    }

    public void setListProductSummaryAdapter(ListProductSummaryAdapter listProductSummaryAdapter) {
        this.listProductSummaryAdapter = listProductSummaryAdapter;
    }

    @Override
    public void onClick(View v) {

    }
}
