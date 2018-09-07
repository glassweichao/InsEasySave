package com.akachao.easy.save

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.akachao.easy.save.service.AutoSaveService

import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.content_home.*
import android.R.string.cancel
import android.app.Activity
import android.app.NotificationManager
import android.app.Service
import android.support.v4.app.NotificationManagerCompat
import android.app.NotificationChannel
import android.annotation.TargetApi
import android.content.Context
import android.support.v4.app.NotificationCompat


class HomeActivity : AppCompatActivity() {

    private var lastShownNotificationId = 1337

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        setSupportActionBar(toolbar)
        iniEvent()
    }

    private fun iniEvent() {
        switchAutoSave.setOnCheckedChangeListener { _, isChecked ->
            val intent = Intent(this, AutoSaveService().javaClass)
            if (isChecked) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    startForegroundService(intent)
                } else {
                    startService(intent)
                }
            } else {
                stopService(intent)
            }
        }
    }

}
