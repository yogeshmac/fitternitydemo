package com.example.fitternitydemo.activities

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.fitternitydemo.R
import com.example.fitternitydemo.utils.StatusBarUI


class SplashActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_splash)

        StatusBarUI.setDarkStatusBar(
                window, ContextCompat.getColor(
                applicationContext,
                R.color.transparent
        )
        )

        StatusBarUI.makeStatusBarUsable(window)




        openNewActivity()
    }



    private fun openNewActivity() {
        Handler().postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, 3000)
    }
}