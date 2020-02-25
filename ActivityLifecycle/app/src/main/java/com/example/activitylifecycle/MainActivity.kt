package com.example.activitylifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.util.logging.Logger

class MainActivity : AppCompatActivity() {


    companion object {
        val log = Logger.getLogger(MainActivity::class.java.name)
    }





    //Called upon when the activity has been brought to the foreground
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        log.info("OnCreate Called")
    }

    //Called second when the activity has been brought to the foreground
    // OR after a user bring the application back to the foregound after putting the application on standby
    override fun onStart() {
        super.onStart()
        log.info("onStart Called")
    }

    //Called third when the activity has been brought to the foreground from a different activity or start
    // OR after a user brings the application back to the foreground after pulling the application on standby
    override fun onResume() {
        super.onResume()
        log.info("OnResume Called")
    }



    //Called after a user brings an application to the foreground, in the selected activity
    override fun onRestart() {
        super.onRestart()
        log.info("OnRestart Called")
    }





    // This lifecycle event is invoked when a user visits a different Activity, or when the application is sent to the background
    override fun onPause() {
        super.onPause()
        log.info("OnPause Called")
    }

    // This lifecycle event is invoked once onPause is finished
    override fun onStop() {
        super.onStop()
        log.info("OnStop Called")
    }

    // This lifecycle event is invoked when user navigates to a different activity, or the application is closed, after the onStop event has finished
    override fun onDestroy() {
        super.onDestroy()
        log.info("OnDestroy Called")
    }


}
