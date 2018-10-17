package com.example.tinnovakovic.popularmovies_kotlin

import android.content.Context
import android.net.ConnectivityManager
import android.content.Context.CONNECTIVITY_SERVICE


object Utils {

    /** Helper function that checks if device is connected to the internet */
    fun isOnline(context: Context): Boolean {
        val cm = context.getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager

        return cm.activeNetworkInfo != null && cm.activeNetworkInfo.isConnected
    }
}