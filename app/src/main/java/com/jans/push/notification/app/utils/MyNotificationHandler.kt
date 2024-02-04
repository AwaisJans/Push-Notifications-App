package com.jans.push.notification.app.utils

import android.content.Context
import android.content.Intent
import com.jans.push.notification.app.config.AppConfig
import com.jans.push.notification.app.activities.MainActivity
import com.onesignal.OSNotificationOpenedResult
import com.onesignal.OneSignal

class MyNotificationHandler(private val context : Context) : OneSignal.OSNotificationOpenedHandler {

   override fun notificationOpened(result: OSNotificationOpenedResult?) {
       if (result == null) return
       val type = result.action.type
       val data = result.notification.additionalData

       val name = data.optString(AppConfig.NAME)

       val intent = Intent(context, MainActivity::class.java)
       intent.flags = Intent.FLAG_ACTIVITY_REORDER_TO_FRONT or Intent.FLAG_ACTIVITY_NEW_TASK
       intent.putExtra(AppConfig.NAME, name)
       context.startActivity(intent)
   }
}