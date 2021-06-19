package com.example.fitternitydemo.fragments

import android.util.Log
import androidx.test.espresso.matcher.ViewMatchers.assertThat
import com.example.fitternitydemo.retrofit.APIClient
import com.example.fitternitydemo.retrofit.GetApiData
import junit.framework.TestCase
import org.junit.Assert
import org.junit.Test
import java.net.URI.create

class SecondFragmentTest : TestCase(){
    @Test
    fun testMethos () {
        // call the api
        val api  = APIClient().client?.create(GetApiData::class.java)
        val response = api?.getData()
        // verify the response is OK
        Assert.assertNotNull(response);
    }
}