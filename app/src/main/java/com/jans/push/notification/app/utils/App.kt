package com.jans.push.notification.app.utils

import android.app.Application
import com.jans.push.notification.app.config.AppConfig
import com.onesignal.OneSignal

class App:Application() {
    override fun onCreate() {
        super.onCreate()

        OneSignal.initWithContext(this)
        OneSignal.setAppId(AppConfig.ONESIGNAL_APP_ID)
        OneSignal.setNotificationOpenedHandler(MyNotificationHandler(applicationContext))

    }
}