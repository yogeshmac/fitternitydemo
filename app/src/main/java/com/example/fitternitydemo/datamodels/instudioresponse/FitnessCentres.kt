package com.example.fitternitydemo.datamodels.instudioresponse

import com.google.gson.annotations.SerializedName

data class FitnessCentres (
        val title: String,
        val description: String,

        @SerializedName("button_text")
        val buttonText: String,

        val data: List<FitnessCentresDatum>
)