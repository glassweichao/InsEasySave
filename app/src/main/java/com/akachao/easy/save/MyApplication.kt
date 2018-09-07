package com.akachao.easy.save

import android.app.Application
import com.facebook.drawee.backends.pipeline.Fresco

/**
 * Created by Char on 2018/9/6.
 */
class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Fresco.initialize(this)
    }


}