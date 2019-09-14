package com.akanksha.commonclassutil

import android.content.Context
import android.graphics.Typeface
import android.os.Build
import android.util.Log
import java.util.*


/**
 * Author:    Akanksha Paul
 * Created:   13/8/19
 */
class TypefaceUtil {
    companion object {
        /**
         * This method is used to override font family from defaukt to custom font
         * @param context Activity context
         * @param defaultFontNameToOverride default font family list
         * @param customFontFileNameInAssets custom font family list
         */
        fun overrideFont(
            context: Context, defaultFontNameToOverride: Array<String>,
            customFontFileNameInAssets: Array<String>
        ) {


            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                val newMap = HashMap<String, Typeface>()
                for (i in defaultFontNameToOverride.indices) {

                    val customFontTypeface =
                        Typeface.createFromAsset(context.assets, customFontFileNameInAssets[i])
                    newMap[defaultFontNameToOverride[i]] = customFontTypeface
                }
                try {
                    val staticField = Typeface::class.java
                        .getDeclaredField("sSystemFontMap")
                    staticField.isAccessible = true
                    staticField.set(null, newMap)
                } catch (e: NoSuchFieldException) {
                    e.printStackTrace()
                } catch (e: IllegalAccessException) {
                    e.printStackTrace()
                }

            } else {
                try {
                    for (i in defaultFontNameToOverride.indices) {
                        val customFontTypeface =
                            Typeface.createFromAsset(context.assets, customFontFileNameInAssets[i])
                        val defaultFontTypefaceField =
                            Typeface::class.java.getDeclaredField(defaultFontNameToOverride[i])
                        defaultFontTypefaceField.isAccessible = true
                        defaultFontTypefaceField.set(null, customFontTypeface)
                    }
                } catch (e: Exception) {
                    Log.e(TypefaceUtil::class.java.simpleName, "Can not set custom font")
                }

            }
        }
    }
}
