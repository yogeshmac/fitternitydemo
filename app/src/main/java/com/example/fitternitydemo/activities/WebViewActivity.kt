package com.example.fitternitydemo.activities


import android.os.Bundle
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import com.example.fitternitydemo.R
import com.example.fitternitydemo.databinding.ActivityWebViewBinding
import com.example.fitternitydemo.utils.StatusBarUI

class WebViewActivity : AppCompatActivity() {

   lateinit var binding : ActivityWebViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)

        binding = DataBindingUtil.setContentView(this,R.layout.activity_web_view)

        StatusBarUI.setDarkStatusBar(
                window, ContextCompat.getColor(
                applicationContext,
                R.color.white
        )
        )



        binding.webview.webViewClient = WebViewClient()

        // this will load the url of the website
        binding.webview.loadUrl("https://www.fitternity.com/")

        // this will enable the javascript settings
        binding.webview.settings.javaScriptEnabled = true

        // if you want to enable zoom feature
        binding.webview.settings.setSupportZoom(true)

    }
}