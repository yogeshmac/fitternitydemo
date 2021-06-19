package com.example.fitternitydemo.datamodels.instudioresponse

import com.google.gson.annotations.SerializedName

data class UpcomingClasses (
    val title: String,
    val description: String,

    @SerializedName("button_text")
    val buttonText: String,

    val campaign: ChallengeCampaign,

    @SerializedName("session_type")
    val sessionType: String,

    val data: List<UpcomingClassesDatum>
)