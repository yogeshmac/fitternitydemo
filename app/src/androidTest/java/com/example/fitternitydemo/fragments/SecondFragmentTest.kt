package com.example.fitternitydemo.fragments

import android.util.Log
import androidx.test.espresso.matcher.ViewMatchers.assertThat
import com.example.fitternitydemo.datamodels.athomeresponse.AtHomeResponse
import com.example.fitternitydemo.retrofit.APIClient
import com.example.fitternitydemo.retrofit.GetApiData
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import junit.framework.TestCase
import org.junit.Assert
import org.junit.Test
import java.net.URI.create

class SecondFragmentTest : TestCase(){
    @Test
    fun testMethos () {
        // call the api
        val apiInterface  = APIClient().client?.create(GetApiData::class.java)

        apiInterface?.getData()
            ?.retry(10)
            ?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.subscribe(object : DisposableSingleObserver<AtHomeResponse?>() {
                override fun onSuccess(response: AtHomeResponse) {
                    Assert.assertEquals("mumbai", response.cityName)

                }

                override fun onError(e: Throwable) {

                }
            }
            )

    }
}