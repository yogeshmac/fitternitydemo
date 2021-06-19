package com.example.fitternitydemo.interfaces

import com.example.fitternitydemo.datamodels.instudioresponse.InStudioResponse

interface InStudioApiResponse {
    fun error(s: String)

    fun success( response: InStudioResponse)
}