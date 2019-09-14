package com.akanksha.commonclassutil

import android.content.Context
import android.view.View
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar

/**
 * Author:    Akanksha Paul
 * Created:   13/8/19
 **/
class ToastUtil{
    companion object {
        fun showLongToast(context: Context, message: String) {
            Toast.makeText(context, message, Toast.LENGTH_LONG).show()
        }

        fun showShortToast(context: Context, message: String) {
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
        }

        fun showLongSnackBar(view: View, message: String) {
            val snackBar = Snackbar.make(view, message, Snackbar.LENGTH_LONG)
            snackBar.show()
        }

        fun showShortSnackBar(view: View, message: String) {
            val snackBar = Snackbar.make(view, message, Snackbar.LENGTH_SHORT)
            snackBar.show()
        }
    }
}