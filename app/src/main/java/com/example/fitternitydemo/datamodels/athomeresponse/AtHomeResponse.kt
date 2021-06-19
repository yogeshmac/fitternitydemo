package com.example.fitternitydemo.datamodels.athomeresponse

import com.example.fitternitydemo.datamodels.instudioresponse.*
import com.google.gson.annotations.SerializedName

data class AtHomeResponse (
        @SerializedName("city_name")
    val cityName: String,


        @SerializedName("city_id")
    val cityID: Long,

        val instudio: String,


        @SerializedName("product_tags")
    val productTags: List<ProductTag>,

        val campaigns: List<CampaignElement>,

        @SerializedName("onepass_pre")
    val onepassPre: OnepassPre,

        @SerializedName("personal_training")
    val personalTraining: PersonalTraining,

        @SerializedName("upcoming_classes")
    val upcomingClasses: UpcomingClasses,

        val challenge: Challenge,

//        @SerializedName("fit_tv")
//    val fitTv: FitTv,

        @SerializedName("section_orders")
    val sectionOrders: List<String>
    

  
)