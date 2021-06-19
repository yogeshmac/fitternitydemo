package com.example.fitternitydemo.retrofit

import com.example.fitternitydemo.datamodels.athomeresponse.AtHomeResponse
import com.example.fitternitydemo.datamodels.instudioresponse.InStudioResponse
import com.example.fitternitydemo.interfaces.AtHomeApiResponse
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.GET

interface GetApiData {

    @GET("HomeScreenAtHome.json")
    fun getData() : Single<AtHomeResponse>

    @GET("HomeScreenInStudio.json")
    fun getStudioData() : Single<InStudioResponse>

}