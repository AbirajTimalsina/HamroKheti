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

import model.techDetail;
import url.Url;

public class TechDetailAdapter extends RecyclerView.Adapter<TechDetailAdapter.TechinfoViewHolder>{

    Context mContext;
    List<techDetail> techDetailList;

    public TechDetailAdapter(Context mContext, List<techDetail> techDetailList) {
        this.mContext = mContext;
        this.techDetailList = techDetailList;
    }

    @NonNull
    @Override
    public TechinfoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.techdetailview,parent,false);
        return new TechinfoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TechinfoViewHolder holder, int position) {
        techDetail techDetail = techDetailList.get(position);
        String imagepath = Url.imagePath+techDetail.getTechDetail_image();
        Picasso.get().load(imagepath).into(holder.imgTechdetail);
        holder.tvTechBody.setText(techDetail.getTechDetail_body());
    }

    @Override
    public int getItemCount() {
        return techDetailList.size();
    }

    public class TechinfoViewHolder extends RecyclerView.ViewHolder {
        ImageView imgTechdetail;
        TextView tvTechBody;

        public TechinfoViewHolder(@NonNull View itemView) {
            super(itemView);

            imgTechdetail = itemView.findViewById(R.id.imgTechdetail);
            tvTechBody = itemView.findViewById(R.id.tvTechBody);

        }
    }
}
