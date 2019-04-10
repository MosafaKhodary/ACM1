package com.example.android.acm1.Fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.acm1.Model.Announcement;
import com.example.android.acm1.R;
import com.example.android.acm1.Fragment.recyclerview.RecyclerAnnouncements;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class AnnouncementsFragment extends Fragment {
    final private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference mDatabaseReference;

    private RecyclerView recyclerView;


    private RecyclerAnnouncements mAnnouncementAdapter;

    private List<Announcement> mAnnouncements;

    public AnnouncementsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mAnnouncements = new ArrayList<>();

        View rootView = inflater.inflate(R.layout.fragment_announcements, container, false);
        recyclerView = rootView.findViewById(R.id.announcements_recycler);
        mAnnouncementAdapter = new RecyclerAnnouncements(mAnnouncements,container.getContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(container.getContext()));
        recyclerView.setAdapter(mAnnouncementAdapter);
        getActivity().setTitle("Announcements");

        retrieveData();

        return rootView;
    }

    public void retrieveData() {
        mDatabaseReference = database.getReference();

        Query query = mDatabaseReference.child("Announcements");
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot singleSnapshot : dataSnapshot.getChildren()) {
                    Announcement announcement = singleSnapshot.getValue(Announcement.class);
                    mAnnouncements.add(announcement);
                }
                mAnnouncementAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }
}