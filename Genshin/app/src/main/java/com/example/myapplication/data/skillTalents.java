package com.example.myapplication.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class skillTalents {
    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("unlock")
    @Expose
    private String unlock;

    @SerializedName("description")
    @Expose
    private String description;

    @SerializedName("type")
    @Expose
    private String type;

    public String getName() {
        return name;
    }

    public String getUnlock() {
        return unlock;
    }

    public String getDescription() {
        return description;
    }

    public String getType() {
        return type;
    }
}
