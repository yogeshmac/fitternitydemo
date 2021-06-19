package com.example.fitternitydemo.datamodels.instudioresponse

import com.google.gson.annotations.SerializedName

data class Passes (
    val image: String,
    val header1: String,

    @SerializedName( "header1_color")
    val header1Color: String,

    val header2: String,

    @SerializedName( "header2_color")
    val header2Color: String,

    val subheader: String,

    @SerializedName("desc_header")
    val descHeader: String,

    @SerializedName("onepass_type")
    val onepassType: String,

    val description: String
)