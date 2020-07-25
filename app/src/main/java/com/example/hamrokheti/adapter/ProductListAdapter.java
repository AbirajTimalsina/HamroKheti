package com.example.hamrokheti.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hamrokheti.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import model.productList;
import url.Url;

public class ProductListAdapter extends RecyclerView.Adapter<ProductListAdapter.ProductViewHolder>{

    Context mContext;
    List<productList> productLists;

    public ProductListAdapter(Context mContext, List<productList> productLists) {
        this.mContext = mContext;
        this.productLists = productLists;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.productview,parent,false);

        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder  holder, int position) {

        productList productList = productLists.get(position);
        String imagePath = Url.imagePath+productList.getProduct_image();
        Picasso.get().load(imagePath).into(holder.imgproduct);

        holder.TvTitle.setText(productList.getProduct_name());
        holder.TvPrice.setText(productList.getProduct_price());

    }

    @Override
    public int getItemCount() {
        return productLists.size();
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder {

        ImageView imgproduct;
        TextView TvTitle, TvPrice;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);

            imgproduct = itemView.findViewById(R.id.imgproduct);
            TvTitle = itemView.findViewById(R.id.TvTitle);
            TvPrice = itemView.findViewById(R.id.TvPrice);
        }
    }
}
