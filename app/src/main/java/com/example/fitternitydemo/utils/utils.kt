package com.example.fitternitydemo.utils

import android.content.Context
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.fitternitydemo.R
import com.example.flatdialoglibrary.dialog.FlatDialog

fun Context.toast(value:String){
    Toast.makeText(this,value,Toast.LENGTH_LONG).show()
}

fun customDialog(context: Context,title:String,description: String){
    val flatDialog = FlatDialog(context)
    flatDialog.setTitle(title)
        .setBackgroundColor(ContextCompat.getColor(context, R.color.colorPrimary))
        .setSubtitle(description)
        .setFirstButtonText("Ok")
        .setSecondButtonText("CANCEL")
        .withFirstButtonListner {
            flatDialog.dismiss()
            // do something ...
        }
        .withSecondButtonListner {
            flatDialog.dismiss()
        }
        .show()
}