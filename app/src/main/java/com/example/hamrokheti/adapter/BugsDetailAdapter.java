package com.example.hamrokheti.adapter;

import android.content.Context;
import android.content.Intent;
import android.telephony.mbms.StreamingServiceInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hamrokheti.BugsDetailActivity;
import com.example.hamrokheti.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import model.bugsDetail;
import url.Url;

public class BugsDetailAdapter extends RecyclerView.Adapter<BugsDetailAdapter.BugsDetailViewHolder>{

    Context mContext;
    List<bugsDetail> bugsDetails;

    public BugsDetailAdapter(Context mContext, List<bugsDetail> bugsDetails) {
        this.mContext = mContext;
        this.bugsDetails = bugsDetails;
    }

    @NonNull
    @Override
    public BugsDetailViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext())
               .inflate(R.layout.bugsdetailview,parent,false);

       return new BugsDetailViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BugsDetailViewHolder holder, int position) {

       bugsDetail bugsDetail = bugsDetails.get(position);
       String imagepath = Url.imagePath+bugsDetail.getBugsDetail_image();
       Picasso.get().load(imagepath).into(holder.imgBug);
       holder.Tvdetial.setText(bugsDetail.getBugsDetail_body());

    }

    @Override
    public int getItemCount() {
        return bugsDetails.size();
    }

    public class BugsDetailViewHolder extends RecyclerView.ViewHolder {
       ImageView imgBug;
       TextView Tvdetial;

       public BugsDetailViewHolder(@NonNull View itemView) {
           super(itemView);

           imgBug = itemView.findViewById(R.id.imgBugdetail);
           Tvdetial = itemView.findViewById(R.id.tvBody);

       }
   }
}
