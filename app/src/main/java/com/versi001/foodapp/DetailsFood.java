package com.versi001.foodapp;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class DetailsFood extends AppCompatActivity {
    public static final String EXTRA_PARCEL = "extra_parcel";
    ImageView imgPoster;
    TextView tvJudul, tvDesc, tvBahan, tvMake, tvPrice;
    Food food;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_food);

        imgPoster = findViewById(R.id.img_photo);
        tvJudul = findViewById(R.id.judul_food);
        tvDesc = findViewById(R.id.deskripsi);
        tvBahan = findViewById(R.id.bahan_tv);
        tvMake = findViewById(R.id.make_tv);
        tvPrice = findViewById(R.id.price_tv);

        food = getIntent().getParcelableExtra(EXTRA_PARCEL);

        getSupportActionBar().setTitle(food.getJudul());
        tvJudul.setText(food.getJudul());
        tvDesc.setText(food.getDesc());
        tvBahan.setText(food.getBahan());
        tvMake.setText(food.getMake());
        tvPrice.setText(food.getPrice());

        RequestOptions requestOptions = new RequestOptions().centerCrop();

        Glide.with(this)
                .load(Integer.valueOf(food.getFoto()))
                .apply(requestOptions)
                .into(imgPoster);
    }
}
