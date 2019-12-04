package com.akanksha.commonclassutil

import android.util.Log

/**
 * Author:    Akanksha Paul
 * Created:   14/9/19
 **/
class LogUtil {
    companion object {

        private var BOOL_LOG = true
        fun getInstance(log:Boolean){
            BOOL_LOG = log
        }
        fun errorLog(TAG: String, message: String) {
            if (BOOL_LOG)
                Log.e(TAG, message)
        }

        fun debugLog(TAG: String, message: String) {
            if (BOOL_LOG)
                Log.d(TAG, message)
        }

        fun warnLog(TAG: String, message: String) {
            if (BOOL_LOG)
                Log.w(TAG, message)
        }

        fun verboseLog(TAG: String, message: String) {
            if (BOOL_LOG)
                Log.v(TAG, message)
        }

        fun infoLog(TAG: String, message: String) {
            if (BOOL_LOG)
                Log.i(TAG, message)
        }
    }
}