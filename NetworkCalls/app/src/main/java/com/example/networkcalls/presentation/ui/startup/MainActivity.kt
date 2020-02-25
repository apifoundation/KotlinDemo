package com.example.networkcalls.presentation.ui.startup

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.networkcalls.R
import com.example.networkcalls.presentation.ui.universities.UniversitiesFragment


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragment: Fragment =
            UniversitiesFragment()

        supportFragmentManager.beginTransaction()
            .replace(R.id.vContainer, fragment, fragment.javaClass.simpleName)
            .addToBackStack(null).commit()
    }
}
