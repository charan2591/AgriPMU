package com.example.pmufirstapplication.util

import android.app.Application
import android.graphics.Color
import androidx.appcompat.content.res.AppCompatResources
import com.example.pmufirstapplication.R
import sakout.mehdi.StateViews.StateViewsBuilder

class MainClass : Application() {

    override fun onCreate() {
        super.onCreate()

        StateViewsBuilder.init(this)
            .setIconColor(Color.parseColor("#D2D5DA"))
            .addState("error"
            ,"No Connection"
            ,"Error retrieving information from server.",
                AppCompatResources.getDrawable(this, R.drawable.ic_server_error)
            ,"Retry")
            .addState("internet",
            "No Internet"
            ,"Error no internet connection."
            ,AppCompatResources.getDrawable(this,R.drawable.)
            "Try Again")
            .addState("search",
                "No Results Found"
                ,"Unfortunately there are no results matching your search"
                ,AppCompatResources.getDrawable(this,R.drawable.)
                null)
            .addState("custom",
                "Custom State"
                ,"This is a custom state, made in 5 seconds"
                ,AppCompatResources.getDrawable(this,R.drawable.)
                "Cool")
            .setButtonBackgroundColor(Color.parseColor("#317DED"))
            .setButtonTextColor(Color.parseColor("#FFFFFF"))
            .setIconSize(150)
    }
}