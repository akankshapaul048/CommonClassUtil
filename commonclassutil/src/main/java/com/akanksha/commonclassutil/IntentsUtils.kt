package com.akanksha.commonclassutil

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.content.pm.ResolveInfo
import android.net.Uri

/**
 * Author:    Akanksha Paul
 * Created:   13/8/19
 */
class IntentsUtils {
    companion object {
        fun invokeWebBrowser(activity: Activity, url: String) {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            val pm = activity.packageManager
            val activities:List<ResolveInfo> = pm.queryIntentActivities(intent, 0);
            if (activities.isNotEmpty()) {
                activity.startActivity(intent);
            } else {
                // Do something else here. Maybe pop up a Dialog or Toast
                ToastUtil.showShortToast(activity,"No application present to handle your request.")
            }
        }

        fun invokeWebSearch(activity: Activity, url: String) {
            val intent = Intent(Intent.ACTION_WEB_SEARCH)
            intent.data = Uri.parse(url)
            activity.startActivity(intent)
        }

        fun dial(activity: Activity) {
            val intent = Intent(Intent.ACTION_DIAL)
            activity.startActivity(intent)
        }

        /**
         * ask call permission before calling the method
         */
        @SuppressLint("MissingPermission")
        fun call(activity: Activity, tel: String) {
            val intent = Intent(Intent.ACTION_CALL)
            intent.data = Uri.parse("tel:$tel")
            activity.startActivity(intent)
        }

        fun showMapAtLatLong(activity: Activity, geo: String) {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(geo)
            activity.startActivity(intent)
        }
    }
}
