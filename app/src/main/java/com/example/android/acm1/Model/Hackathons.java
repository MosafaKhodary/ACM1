package com.example.android.acm1.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Hackathons {
    @SerializedName("array")
    List<Event> events;

    public List<Event> getEvents() {
        return events;
    }

}
