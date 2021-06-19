package com.example.fitternitydemo.datamodels.instudioresponse

import com.google.gson.annotations.SerializedName

data class Categorytag (
    val name: String,
    val slug: String,

    @SerializedName("_id")
    val id: Long,

    val image: String
)
