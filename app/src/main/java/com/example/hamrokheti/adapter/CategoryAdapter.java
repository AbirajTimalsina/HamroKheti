package com.example.hamrokheti.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hamrokheti.CategoryActivity;
import com.example.hamrokheti.ProductListActivity;
import com.example.hamrokheti.R;
import com.squareup.picasso.Picasso;

import org.json.JSONException;

import java.util.List;
import java.util.jar.JarException;

import model.category;
import url.Url;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>{

    Context mContext;
    List<category> categoryList;

    public CategoryAdapter(Context mContext, List<category> categoryList){
        this.mContext = mContext;
        this.categoryList = categoryList;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.categoryview,parent,false);

        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {

        category category = categoryList.get(position);
        String imagePath = Url.imagePath+ category.getCategory_image();
        Picasso.get().load(imagePath).into(holder.cat_Img);
        holder.tvTitle.setText(category.getCategory());
        // imagePath is called from Url class.
    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder{
        ImageView cat_Img;
        TextView tvTitle;

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);

            cat_Img =  itemView.findViewById(R.id.imgcat);
            tvTitle = itemView.findViewById(R.id.tvTitle);

            cat_Img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    String category = categoryList.get(getAdapterPosition()).get_id();
                    Intent intent = new Intent(mContext, ProductListActivity.class);
                    intent.putExtra("category", category);
                    mContext.startActivity(intent);
                }
            });
        }
    }
}
