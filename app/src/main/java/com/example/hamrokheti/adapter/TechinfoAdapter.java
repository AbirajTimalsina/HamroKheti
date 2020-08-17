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

import com.example.hamrokheti.R;
import com.example.hamrokheti.TechDetailActivity;
import com.example.hamrokheti.TechinfoActivity;
import com.squareup.picasso.Picasso;

import java.util.List;

import model.techinfo;
import url.Url;

public class TechinfoAdapter extends RecyclerView.Adapter<TechinfoAdapter.TechinfoViewHolder> {

    Context mContext;
    List<techinfo> techinfoList;

    public TechinfoAdapter(Context mContext, List<techinfo> techinfoList) {
        this.mContext = mContext;
        this.techinfoList = techinfoList;
    }

    @NonNull
    @Override
    public TechinfoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view  = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.techinfoview,parent,false);
        return new TechinfoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TechinfoViewHolder holder, int position) {

        techinfo techinfo = techinfoList.get(position);
        String imagepath = Url.imagePath+techinfo.getTechinfo_image();
        Picasso.get().load(imagepath).into(holder.imgTech);
        holder.tvTechTtitle.setText(techinfo.getTechinfo_title());

    }

    @Override
    public int getItemCount() {
        return techinfoList.size();
    }

    public class TechinfoViewHolder extends RecyclerView.ViewHolder {

        ImageView imgTech;
        TextView tvTechTtitle;

        public TechinfoViewHolder(@NonNull View itemView) {
            super(itemView);

            imgTech = itemView.findViewById(R.id.imgtech);
            tvTechTtitle = itemView.findViewById(R.id.tvTechTitle);
            imgTech.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String techinfo = techinfoList.get(getAdapterPosition()).get_id();
                    Intent intent = new Intent(mContext,TechDetailActivity.class);
                    intent.putExtra("techinfo",techinfo);
                    mContext.startActivity(intent);
                }
            });
        }
    }
}
