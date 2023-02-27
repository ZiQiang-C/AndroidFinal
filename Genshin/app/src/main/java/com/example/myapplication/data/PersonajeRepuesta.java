package com.example.myapplication.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PersonajeRepuesta {
    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("vision")
    @Expose
    private String vision;

    @SerializedName("weapon")
    @Expose
    private String weapon;

    @SerializedName("nation")
    @Expose
    private String nation;

    @SerializedName("affiliation")
    @Expose
    private String affiliation;

    @SerializedName("rarity")
    @Expose
    private String rarity;

    @SerializedName("constellation")
    @Expose
    private String constellation;

    @SerializedName("birthday")
    @Expose
    private String birthday;

    @SerializedName("description")
    @Expose
    private String description;

    @SerializedName("skillTalents")
    @Expose
    private List<skillTalents> skillTalents;

    @SerializedName("passiveTalents")
    @Expose
    private List<passiveTalents> passiveTalents;

    @SerializedName("constellations")
    @Expose
    private List<constellations> constellations;

    @SerializedName("vision_key")
    @Expose
    private String vision_key;

    @SerializedName("weapon_type")
    @Expose
    private String weapon_type;

    public String getName() {
        return name;
    }

    public String getTitle() {
        return title;
    }

    public String getVision() {
        return vision;
    }

    public String getWeapon() {
        return weapon;
    }

    public String getNation() {
        return nation;
    }

    public String getAffiliation() {
        return affiliation;
    }

    public String getRarity() {
        return rarity;
    }

    public String getConstellation() {
        return constellation;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getDescription() {
        return description;
    }

    public List<com.example.myapplication.data.skillTalents> getSkillTalents() {
        return skillTalents;
    }

    public List<com.example.myapplication.data.passiveTalents> getPassiveTalents() {
        return passiveTalents;
    }

    public List<com.example.myapplication.data.constellations> getConstellations() {
        return constellations;
    }

    public String getVision_key() {
        return vision_key;
    }

    public String getWeapon_type() {
        return weapon_type;
    }
}
