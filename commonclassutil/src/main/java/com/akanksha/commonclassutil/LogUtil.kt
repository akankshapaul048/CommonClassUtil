package com.akanksha.commonclassutil

import android.util.Log

/**
 * Author:    Akanksha Paul
 * Created:   14/9/19
 **/
class LogUtil {
    companion object {

        fun errorLog(TAG: String, message: String) {
            Log.e(TAG, message)
        }

        fun debugLog(TAG: String, message: String) {
            Log.d(TAG, message)
        }

        fun warnLog(TAG: String, message: String) {
            Log.w(TAG, message)
        }

        fun verboseLog(TAG: String, message: String) {
            Log.v(TAG, message)
        }

        fun infoLog(TAG: String, message: String) {
            Log.i(TAG, message)
        }
    }
}