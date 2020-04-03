package com.m7amdelbana.haninround3.ui.home;

import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.m7amdelbana.haninround3.R;
import com.m7amdelbana.haninround3.network.models.Place;

public class PlaceHolder extends RecyclerView.ViewHolder {

    private ImageView imageView;
    private TextView tvTitle;
    private TextView tvAddress;
    private RatingBar ratingBar;

    public PlaceHolder(@NonNull View itemView) {
        super(itemView);
        initView(itemView);
    }

    private void initView(View view) {
        imageView = view.findViewById(R.id.item_place_imageView);
        tvTitle = view.findViewById(R.id.item_place_title_textView);
        tvAddress = view.findViewById(R.id.item_place_address_textView);
        ratingBar = view.findViewById(R.id.item_place_ratingBar);
    }

    void bindView(Place place) {
        place.loadImage(imageView);
        tvTitle.setText(place.getName());
        tvAddress.setText(place.getAddress());
        ratingBar.setRating(place.getRating());
    }
}
