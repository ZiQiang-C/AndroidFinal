package com.example.myapplication.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class passiveTalents {

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("unlock")
    @Expose
    private String unlock;

    @SerializedName("description")
    @Expose
    private String description;

    @SerializedName("level")
    @Expose
    private String level;

    public String getName() {
        return name;
    }

    public String getUnlock() {
        return unlock;
    }

    public String getDescription() {
        return description;
    }

    public String getLevel() {
        return level;
    }
}
