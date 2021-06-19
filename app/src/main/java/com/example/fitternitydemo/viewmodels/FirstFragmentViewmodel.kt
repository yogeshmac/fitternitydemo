package com.example.fitternitydemo.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.fitternitydemo.datamodels.instudioresponse.InStudioResponse
import com.example.fitternitydemo.interfaces.InStudioApiResponse
import com.example.fitternitydemo.retrofit.APIClient
import com.example.fitternitydemo.retrofit.GetApiData
import com.google.gson.Gson
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import org.json.JSONException
import org.json.JSONObject

class FirstFragmentViewmodel : ViewModel() {

    private var apiInterface: GetApiData? = null
    var apiResponses : InStudioApiResponse? = null


    fun getData(){
        if (apiInterface == null){
            apiInterface = APIClient().client?.create(GetApiData::class.java)
        }

        apiInterface?.getStudioData()
                ?.retry(10)
                ?.subscribeOn(Schedulers.io())
                ?.observeOn(AndroidSchedulers.mainThread())
                ?.subscribe(object : DisposableSingleObserver<InStudioResponse?>() {
                    override fun onSuccess(response: InStudioResponse) {
//                        Log.i("YogeshResponse", response.cityName+"")
                        apiResponses?.success(response)
//                        Log.i("YogeshResponse", Gson().toJson(response) + "")

                    }

                    override fun onError(e: Throwable) {
                        Log.i("YogeshResponse", e.toString() + "")
                        apiResponses?.error(e.message.toString())

                    }
                }
                )
    }

}