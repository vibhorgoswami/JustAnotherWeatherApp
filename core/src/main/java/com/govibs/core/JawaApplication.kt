package com.govibs.core

import android.app.Application
import com.squareup.leakcanary.LeakCanary

class JawaApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        LeakCanary.install(this)
    }
}