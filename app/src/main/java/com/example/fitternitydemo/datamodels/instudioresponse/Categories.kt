package com.example.fitternitydemo.datamodels.instudioresponse

import com.google.gson.annotations.SerializedName

data class Categories (
    val title: String,
    val text: String,

    @SerializedName("max_category")
    val maxCategory: Long,

    @SerializedName("all_category_title")
    val allCategoryTitle: String,

    val categorytags: List<Categorytag>,
    val campaign: CategoriesCampaign
)