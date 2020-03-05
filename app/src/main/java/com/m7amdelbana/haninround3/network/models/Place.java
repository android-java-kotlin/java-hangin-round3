package com.m7amdelbana.haninround3.network.models;

import android.widget.ImageView;

import com.google.gson.annotations.SerializedName;
import com.m7amdelbana.haninround3.R;
import com.squareup.picasso.Picasso;

import java.io.Serializable;

public class Place implements Serializable {

    @SerializedName("_id")
    private String id;

    @SerializedName("image")
    private String image;

    @SerializedName("coverImage")
    private String coverImage;

    @SerializedName("rating")
    private float rating;

    @SerializedName("totalRating")
    private int totalRating;

    @SerializedName("isActive")
    private boolean isActive;

    @SerializedName("name")
    private String name;

    @SerializedName("phone")
    private String phone;

    @SerializedName("address")
    private String address;

    @SerializedName("lat")
    private double lat;

    @SerializedName("lng")
    private double lng;

    @SerializedName("hourPrice")
    private double hourPrice;

    @SerializedName("dayPrice")
    private double dayPrice;

    @SerializedName("capacity")
    private int capacity;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(String coverImage) {
        this.coverImage = coverImage;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public int getTotalRating() {
        return totalRating;
    }

    public void setTotalRating(int totalRating) {
        this.totalRating = totalRating;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public double getHourPrice() {
        return hourPrice;
    }

    public void setHourPrice(double hourPrice) {
        this.hourPrice = hourPrice;
    }

    public double getDayPrice() {
        return dayPrice;
    }

    public void setDayPrice(double dayPrice) {
        this.dayPrice = dayPrice;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void loadImage(ImageView imageView) {
        Picasso.get()
                .load(getImage())
                .placeholder(R.drawable.img_placeholder)
                .error(R.drawable.img_placeholder_error)
                .into(imageView);
    }
}
