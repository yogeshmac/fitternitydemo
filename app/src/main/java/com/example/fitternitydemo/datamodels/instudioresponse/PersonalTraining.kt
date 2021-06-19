package com.example.fitternitydemo.datamodels.instudioresponse

import com.google.gson.annotations.SerializedName

data class PersonalTraining (
    val title: String,
    val subtitle: String,
    val description: String,
    val image: String,

    @SerializedName("button_text")
    val buttonText: String,

    val link: String,
    val campaign: ChallengeCampaign
)