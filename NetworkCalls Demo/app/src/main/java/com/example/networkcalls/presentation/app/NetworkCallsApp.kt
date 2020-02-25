package com.example.networkcalls.presentation.app

import android.app.Application

class NetworkCallsApp : Application() {

    companion object {

        lateinit var app: NetworkCallsApp
    }

    override fun onCreate() {
        super.onCreate()
        app = this
    }
}