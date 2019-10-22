package com.versi001.foodapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class ListFoodAdapter extends RecyclerView.Adapter<ListFoodAdapter.CategoryViewHolder> {
    private ArrayList<Food> listFood;
    private Context context;

    public ListFoodAdapter (Context context) {
        this.context = context;
    }

    public ArrayList<Food> getListFood() {

        return listFood;
    }

    public void setListFood(ArrayList<Food> listFood) {

        this.listFood = listFood;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemRow = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_cardview_food, viewGroup, false);
        return new CategoryViewHolder(itemRow);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder categoryViewHolder, int position) {
        final Food f = getListFood().get(position);
        categoryViewHolder.tvJudul.setText(getListFood().get(position).getJudul());
        categoryViewHolder.tvDeskripsi.setText(getListFood().get(position).getDeskripsi());
        Glide.with(context)
                .load(Integer.valueOf(f.getFoto()))
                .apply(new RequestOptions().override(550, 550))
                .into(categoryViewHolder.imgFoto);
        categoryViewHolder.btnDetail.setOnClickListener(new CustomOnItemClickListener(position, new CustomOnItemClickListener.OnItemClickCallback() {
            @Override
            public void onItemClicked(View view, int position) {
                Toast.makeText(context, "Share " + getListFood().get(position).getJudul(), Toast.LENGTH_SHORT).show();
            }
        }));
    }

    @Override
    public int getItemCount() {
        return getListFood().size();
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder {
        ImageView imgFoto;
        TextView tvJudul, tvDeskripsi;
        Button btnDetail;
        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFoto = itemView.findViewById(R.id.img_item_photo);
            tvJudul = itemView.findViewById(R.id.tv_item_name);
            tvDeskripsi = itemView.findViewById(R.id.tv_item_remarks);
            btnDetail = itemView.findViewById(R.id.btn_set_detail);
        }
    }
}
