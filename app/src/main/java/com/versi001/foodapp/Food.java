package com.versi001.foodapp;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class Food extends ArrayList<Parcelable> implements Parcelable {
    private String judul;
    private String deskripsi;
    private String foto;


    public String getBahan() {

        return bahan;}

    public void setBahan(String bahan) {

        this.bahan = bahan;
    }

    public String getMake() {

        return make;
    }

    public void setMake(String make) {

        this.make = make;
    }

    public String getPrice() {

        return price;
    }

    public void setPrice(String price) {

        this.price = price;
    }

    private String bahan;
    private String make;
    private String price;
    private String desc;

    public String getDesc() {

        return desc;
    }

    public void setDesc(String desc) {

        this.desc = desc;
    }

    public String getJudul() {

        return judul;
    }

    public void setJudul(String judul) {

        this.judul = judul;
    }

    public String getDeskripsi() {

        return deskripsi;
    }

    public void setDeskripsi(String deskripsi)
    {
        this.deskripsi = deskripsi;
    }

    public String getFoto() {

        return foto;
    }

    public void setFoto(String foto) {

        this.foto = foto;
    }


    public Food() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.judul);
        dest.writeString(this.deskripsi);
        dest.writeString(this.foto);
        dest.writeString(this.bahan);
        dest.writeString(this.make);
        dest.writeString(this.desc);
        dest.writeString(this.price);
    }

    private Food(Parcel in) {
        this.judul = in.readString();
        this.deskripsi = in.readString();
        this.foto = in.readString();
        this.bahan = in.readString();
        this.make = in.readString();
        this.desc = in.readString();
        this.price = in.readString();
    }

    public static final Creator<Food> CREATOR = new Creator<Food>() {
        @Override
        public Food createFromParcel(Parcel source) {
            return new Food(source);
        }

        @Override
        public Food[] newArray(int size) {
            return new Food[size];
        }
    };
}
