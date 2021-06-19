package com.example.fitternitydemo.datamodels.instudioresponse

import com.example.fitternitydemo.datamodels.athomeresponse.Overlay
import com.google.gson.annotations.SerializedName

data class UpcomingClassesDatum (
        @SerializedName("average_rating")
    val averageRating: Double,

        val name: String,
        val slug: String,

        @SerializedName("vendor_slug")
    val vendorSlug: String,

        @SerializedName("vendor_name")
    val vendorName: String,

        val coverimage: String,
        val overlayimage: String,

        @SerializedName("next_slot")
    val nextSlot: String,

        @SerializedName("total_rating_count")
    val totalRatingCount: Long,

        val city: String,
        val id: Long,
        val commercial: String,

        @SerializedName("service_type")
    val serviceType: String,

        @SerializedName("booking_points")
    val bookingPoints: Long? = null,

        @SerializedName("session_time")
    val sessionTime: Long,

//    @SerializedName("overlayimage_v2")
//    val overlayimageV2: Overlay? = null,

        @SerializedName("pps_oneliner")
    val ppsOneliner: String,

//    val flags: FlagsUnion,

        @SerializedName("overlay_details")
    val overlayDetails: List<Overlay>,

        @SerializedName("live_location")
    val liveLocation: String,

        @SerializedName("live_location_icon")
    val liveLocationIcon: String,

        @SerializedName("special_price")
    val specialPrice: Long? = null,

        @SerializedName("best_seller")
    val bestSeller: Boolean? = null
)