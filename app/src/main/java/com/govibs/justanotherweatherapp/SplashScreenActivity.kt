package com.govibs.justanotherweatherapp

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.support.v7.app.AppCompatActivity
import com.govibs.justanotherweatherapp.list.WeatherListActivity

class SplashScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
    }

    override fun onResume() {
        super.onResume()
        Handler(Looper.getMainLooper()).postDelayed({
            supportFinishAfterTransition()
            startActivity(WeatherListActivity.createWeatherListActivity(this))
        }, 1500)
    }
}
