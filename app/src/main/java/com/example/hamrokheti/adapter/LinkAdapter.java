package com.example.hamrokheti.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hamrokheti.R;

import java.util.List;

import model.link;

public class LinkAdapter extends RecyclerView.Adapter<LinkAdapter.linkViewHolder> {

    Context mContext;
    List<link>linkList;

    public LinkAdapter(Context mContext, List<link> linkList) {
        this.mContext = mContext;
        this.linkList = linkList;
    }

    @NonNull
    @Override
    public linkViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.linkview,parent,false);
        return new linkViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull linkViewHolder holder, int position) {

        link link = linkList.get(position);
        holder.tvLinkTitle.setText(link.getTitle());
        holder.tvLinkBody.setText(link.getBody());
        holder.tvLink.setText(link.getLink());
    }

    @Override
    public int getItemCount() {
        return linkList.size();
    }

    public class linkViewHolder extends RecyclerView.ViewHolder {

        TextView tvLinkTitle,tvLinkBody,tvLink;

        public linkViewHolder(@NonNull View itemView) {
            super(itemView);

            tvLinkTitle = itemView.findViewById(R.id.tvLinkTitle);
            tvLinkBody = itemView.findViewById(R.id.tvLinkBody);
            tvLink = itemView.findViewById(R.id.tvLink);
        }
    }
}
