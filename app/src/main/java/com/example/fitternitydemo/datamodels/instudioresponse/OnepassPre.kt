package com.example.fitternitydemo.datamodels.instudioresponse

import com.google.gson.annotations.SerializedName

data class OnepassPre (
    @SerializedName("header_img")
    val headerImg: String,

    @SerializedName("button_text")
    val buttonText: String,

    val passes: Passes,
    val campaign: ChallengeCampaign
)