package com.akanksha.commonclassutil

import android.content.Context
import android.preference.PreferenceManager

/**
 * Author:    Akanksha Paul
 * Created:   13/8/19
 */
/*
This class is used to store the certain values in the shared preferences.
 */
class PreferencesManager {
    companion object {
        /*
    This method is used to store string values in shared preferences.
     */
        fun saveStringPreferences(context: Context, key: String, value: String) {
            val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
            val editor = sharedPreferences.edit()
            editor.putString(key, value)
            editor.apply()
        }

        /*
       This method is used to store integer values in shared preferences.
     */
        fun saveIntPreferences(context: Context, key: String, value: Int) {
            val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
            val editor = sharedPreferences.edit()
            editor.putInt(key, value)
            editor.apply()
        }

        /*
       This method is used to store boolean values in shared preferences.
     */
        fun saveBooleanPreferences(context: Context, key: String, value: Boolean) {
            val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
            val editor = sharedPreferences.edit()
            editor.putBoolean(key, value)
            editor.apply()
        }

        /*
   This method is used to get string values from shared preferences.
    */
        fun getStringPreferences(context: Context, key: String): String {
            val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
            return sharedPreferences.getString(key, "")!!
        }

        /*
      This method is used to get integer values from shared preferences.
    */
        fun getIntPreferences(context: Context, key: String): Int {
            val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
            return sharedPreferences.getInt(key, 0)
        }

        /*
      This method is used to get boolean values from shared preferences.
    */
        fun getBooleanPreferences(context: Context, key: String): Boolean {
            val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
            return sharedPreferences.getBoolean(key, false)
        }

        /**
         * This method is used to clear data from shared preferences
         */
        fun clearPreference(mContext: Context, key: String) {
            val mPrefs = PreferenceManager.getDefaultSharedPreferences(mContext)
            mPrefs.edit().remove(key).apply()
        }
    }
}
