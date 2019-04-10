package com.example.android.acm1.Fragment.recyclerview;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.acm1.Model.Announcement;
import com.example.android.acm1.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RecyclerAnnouncements extends RecyclerView.Adapter<RecyclerAnnouncements.RecyclerViewHolder>{

    private List<Announcement> announcements;
    private Context mContext;

    public RecyclerAnnouncements(List<Announcement> announcements, Context context) {
        this.announcements = announcements;
        this.mContext = context;
    }
    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.announcement_item,viewGroup,false);
        return new RecyclerViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder recyclerViewHolder, int i) {
        recyclerViewHolder.bind(i);
    }
    @Override
    public int getItemCount() {
        return announcements.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder{
        ImageView mAnnouncementImage;
        TextView mAnnouncementTitle;
        TextView mAnnouncementDate;
        TextView mAnnouncementBody;
        TextView mAnnouncementAuthor;

    public RecyclerViewHolder(View itemView){
            super(itemView);
            mAnnouncementImage = (ImageView) itemView.findViewById(R.id.announcement_image_url);
            mAnnouncementTitle = (TextView) itemView.findViewById(R.id.announcement_title);
            mAnnouncementDate = (TextView) itemView.findViewById(R.id.announcement_date);
            mAnnouncementBody = (TextView) itemView.findViewById(R.id.announcement_body);
            mAnnouncementAuthor = (TextView) itemView.findViewById(R.id.announcement_author);
        }
        void bind(final int position){
            Picasso.with(mContext).load(announcements.get(position).getImageUrl()).into(mAnnouncementImage);
            mAnnouncementTitle.setText(announcements.get(position).getTitle());
            mAnnouncementDate.setText(announcements.get(position).getDate());
            mAnnouncementBody.setText(announcements.get(position).getBody());
            mAnnouncementAuthor.setText(announcements.get(position).getAuthor());
        }

    }
}