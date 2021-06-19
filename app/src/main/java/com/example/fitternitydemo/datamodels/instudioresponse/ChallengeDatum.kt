package com.example.fitternitydemo.datamodels.instudioresponse

import com.google.gson.annotations.SerializedName

data class ChallengeDatum (
    @SerializedName("challenge_id")
    val challengeID: Long,

    @SerializedName("challenge_slug")
    val challengeSlug: String,

    val priority: Long,

    @SerializedName("web_image")
    val webImage: String,

    @SerializedName("wap_image")
    val wapImage: String,

    @SerializedName("app_image")
    val appImage: String,

    val url: String
)