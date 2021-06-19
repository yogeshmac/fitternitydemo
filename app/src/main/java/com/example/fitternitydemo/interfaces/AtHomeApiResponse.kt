package com.example.fitternitydemo.interfaces

import com.example.fitternitydemo.datamodels.athomeresponse.AtHomeResponse


interface AtHomeApiResponse {
    fun error(s: String)

    fun success( response: AtHomeResponse)
}