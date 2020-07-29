package com.example.hamrokheti.adapter;

import android.content.Context;
import android.telecom.Call;
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

import model.bugsinfo;
import url.Url;

public class BugsinfoAdapter extends RecyclerView.Adapter<BugsinfoAdapter.BugsinfoViewHolder> {

    Context mContext;
    List<bugsinfo> bugsinfoList;

    public BugsinfoAdapter(Context mContext, List<bugsinfo> bugsinfoList) {
        this.mContext = mContext;
        this.bugsinfoList = bugsinfoList;
    }

    @NonNull
    @Override
    public BugsinfoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.bugsinfoview,parent,false);

        return new BugsinfoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BugsinfoViewHolder holder, int position) {

        bugsinfo bugsinfo = bugsinfoList.get(position);
        String imagepath = Url.imagePath+bugsinfo.getBugsinfo_image();
        Picasso.get().load(imagepath).into(holder.img);
        holder.txtbugsinfo.setText(bugsinfo.getTitle());

    }

    @Override
    public int getItemCount() {
        return bugsinfoList.size();
    }

    public class BugsinfoViewHolder extends RecyclerView.ViewHolder {

        ImageView img;
        TextView txtbugsinfo;

        public BugsinfoViewHolder(@NonNull View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.imgbugs);
            txtbugsinfo = itemView.findViewById(R.id.txttitle);

        }
    }
}
