package com.example.lenovo.sunmo.StatusService.StatusDAO;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by User on 22/4/2560.
 */

public class Detail {
    @SerializedName("programName")
    public String programName;

    @SerializedName("projectName")
    public String projectName;

    @SerializedName("dateStart")
    public String dateStart;

    @SerializedName("pspType")
    public String pspType;

    @SerializedName("creator")
    public String creator;

    @SerializedName("success")
    public Boolean success;

    @SerializedName("languages")
    public ArrayList<String> languages;
}
