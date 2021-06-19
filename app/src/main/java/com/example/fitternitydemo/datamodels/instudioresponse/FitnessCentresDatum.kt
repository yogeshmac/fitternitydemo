package com.example.fitternitydemo.datamodels.instudioresponse

import com.google.gson.annotations.SerializedName

data class FitnessCentresDatum (
        @SerializedName("average_rating")
        val averageRating: Double,

        val coverimage: String,
        val location: String,
        val slug: String,
        val id: Long,
        val categorytags: List<String>,
        val category: String,

        @SerializedName("total_rating_count")
        val totalRatingCount: Long,

//        val flags: DatumFlagsClass,
        val commercial: String,
        val featured: Boolean,

//        @SerializedName("offering_images")
//        val offeringImages: List<OfferingImage>,

        @SerializedName("trial_header")
        val trialHeader: String,

        @SerializedName("membership_header")
        val membershipHeader: String,

        @SerializedName("membership_icon")
        val membershipIcon: String,

        @SerializedName("membership_offer_default")
        val membershipOfferDefault: Boolean,

        @SerializedName("membership_offer")
        val membershipOffer: String,

        val type: String,
        val address: String,
        val title: String,
        val subcategories: List<String>,

        @SerializedName("tag_image")
        val tagImage: String

//        @SerializedName("abw_vendor")
//        val abwVendor: AbwVendorUnion? = null
)