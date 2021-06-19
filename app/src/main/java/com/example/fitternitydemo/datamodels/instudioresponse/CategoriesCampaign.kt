package com.example.fitternitydemo.datamodels.instudioresponse

import com.google.gson.annotations.SerializedName

data class CategoriesCampaign (
    val image: String,
    val title: String,

    @SerializedName("bg_color")
    val bgColor: String,

    @SerializedName("text_color")
    val textColor: String,

    val url: String
)