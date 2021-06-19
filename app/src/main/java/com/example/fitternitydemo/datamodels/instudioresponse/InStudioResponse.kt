package com.example.fitternitydemo.datamodels.instudioresponse

import com.google.gson.annotations.SerializedName

data class InStudioResponse (
    @SerializedName("city_name")
    val cityName: String,
    

    @SerializedName("city_id")
    val cityID: Long,

    val instudio: String,

    @SerializedName("product_tags")
    val productTags: List<ProductTag>,

    val campaigns: List<CampaignElement>,

    @SerializedName("categories")
    val categories: Categories,

    @SerializedName("onepass_pre")
    val onepassPre: OnepassPre,

    @SerializedName("upcoming_classes")
    val upcomingClasses: UpcomingClasses,

    @SerializedName("fitness_centres")
    val fitnessCentres: FitnessCentres,

    @SerializedName("section_orders")
    val sectionOrders: List<String>
)