package com.akanksha.commonclassutil

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat


/**
 * Author:    Akanksha Paul
 * Created:   13/8/19
 */
/* This class is used to check run time permission check in marshmallow versions*/

class CheckPermission {
    companion object{

        const val REQUEST_CODE_ASK_MULTIPLE_PERMISSIONS = 124
        const val REQUEST_CODE_SEND_SMS_PERMISSIONS = 200
        const val REQUEST_CODE_READ_CONTACTS_PERMISSION = 300
        const val REQUEST_CODE_CALL_PERMISSION = 400
        const val REQUEST_CODE_STORAGE_PERMISSION = 350
        const val REQUEST_CODE_LOCATION_PERMISSION = 450
        const val REQUEST_CODE_LOCATION_PERMISSION_BACKGROUND = 450
        const val REQUEST_CODE_CAMERA_PERMISSION = 360
        const val REQUEST_CODE_CAMERA_STORAGE_PERMISSION = 460
        const val REQUEST_CODE_READ_SMS_PERMISSIONS = 500

        fun checkIsMarshMallowVersion(): Boolean {
            val sdkVersion = Build.VERSION.SDK_INT
            return sdkVersion >= Build.VERSION_CODES.M
        }

        /**
         * Used to check whether camera and storage permission is provided or not.
         */
        fun checkCameraStoragePermission(mContext: Context): Boolean {
            val result = ContextCompat.checkSelfPermission(mContext, Manifest.permission.WRITE_EXTERNAL_STORAGE)
            val result1 = ContextCompat.checkSelfPermission(mContext, Manifest.permission.CAMERA)
            return result == PackageManager.PERMISSION_GRANTED && result1 == PackageManager.PERMISSION_GRANTED
        }

        /**
         * Used to check whether camera permission is provided or not.
         */
        fun checkCameraPermission(mContext: Context): Boolean {
            val result = ContextCompat.checkSelfPermission(mContext, Manifest.permission.CAMERA)
            return result == PackageManager.PERMISSION_GRANTED
        }

        /**
         * Used to check whether storage permission is provided or not.
         */
        fun checkStoragePermission(mContext: Context): Boolean {
            val result = ContextCompat.checkSelfPermission(mContext, Manifest.permission.WRITE_EXTERNAL_STORAGE)
            return result == PackageManager.PERMISSION_GRANTED
        }

        /**
         * Used to check whether Contact permission is provided or not.
         */
        fun checkContactsPermission(mContext: Context): Boolean {
            val result = ContextCompat.checkSelfPermission(mContext, Manifest.permission.READ_CONTACTS)
            return result == PackageManager.PERMISSION_GRANTED
        }

        /**
         * Used to check whether Contact permission is provided or not.
         */
        fun checkCallPhonePermission(mContext: Context): Boolean {
            val result = ContextCompat.checkSelfPermission(mContext, Manifest.permission.CALL_PHONE)
            return result == PackageManager.PERMISSION_GRANTED
        }

        /**
         * Used to check whether SMS permission is provided or not.
         */
        fun checkSMSPermission(mContext: Context): Boolean {
            val result = ContextCompat.checkSelfPermission(mContext, Manifest.permission.SEND_SMS)
            return result == PackageManager.PERMISSION_GRANTED
        }

        /**
         * Used to request SMS permission.
         */
        fun requestSendsSMSPermission(activity: Activity) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(activity, Manifest.permission.SEND_SMS)) {
                ActivityCompat.requestPermissions(
                    activity,
                    arrayOf(Manifest.permission.SEND_SMS),
                    REQUEST_CODE_SEND_SMS_PERMISSIONS
                )
            } else {
                ActivityCompat.requestPermissions(
                    activity,
                    arrayOf(Manifest.permission.SEND_SMS),
                    REQUEST_CODE_SEND_SMS_PERMISSIONS
                )
            }
        }

        /**
         * Used to check whether SMS permission is provided or not.
         */
        fun checkReadSMSPermission(mContext: Context): Boolean {
            val result = ContextCompat.checkSelfPermission(mContext, Manifest.permission.RECEIVE_SMS)
            val result1 = ContextCompat.checkSelfPermission(mContext, Manifest.permission.READ_SMS)
            return result == PackageManager.PERMISSION_GRANTED && result1 == PackageManager.PERMISSION_GRANTED
        }

        /**
         * Used to request SMS permission.
         */
        fun requestReadSMSPermission(activity: Activity) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(
                    activity,
                    Manifest.permission.RECEIVE_SMS
                ) || ActivityCompat.shouldShowRequestPermissionRationale(activity, Manifest.permission.READ_SMS)
            ) {
                ActivityCompat.requestPermissions(
                    activity,
                    arrayOf(Manifest.permission.RECEIVE_SMS, Manifest.permission.READ_SMS),
                    REQUEST_CODE_READ_SMS_PERMISSIONS
                )
            } else {
                ActivityCompat.requestPermissions(
                    activity,
                    arrayOf(Manifest.permission.RECEIVE_SMS, Manifest.permission.READ_SMS),
                    REQUEST_CODE_READ_SMS_PERMISSIONS
                )

            }
        }

        /**
         * Used to request Camera and storage permission.
         */
        fun requestCameraStoragePermission(activity: Activity) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(
                    activity,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE
                ) || ActivityCompat.shouldShowRequestPermissionRationale(activity, Manifest.permission.CAMERA)
            ) {
                ActivityCompat.requestPermissions(
                    activity,
                    arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA),
                    REQUEST_CODE_CAMERA_STORAGE_PERMISSION
                )
            } else {
                ActivityCompat.requestPermissions(
                    activity,
                    arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA),
                    REQUEST_CODE_CAMERA_STORAGE_PERMISSION
                )

            }
        }

        /**
         * Used to request Camera permission.
         */
        fun requestCameraPermission(activity: Activity) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(activity, Manifest.permission.CAMERA)) {
                ActivityCompat.requestPermissions(
                    activity,
                    arrayOf(Manifest.permission.CAMERA),
                    REQUEST_CODE_CAMERA_PERMISSION
                )
            } else {
                ActivityCompat.requestPermissions(
                    activity,
                    arrayOf(Manifest.permission.CAMERA),
                    REQUEST_CODE_CAMERA_PERMISSION
                )

            }
        }

        /**
         * Used to request Storage permission.
         */
        fun requestStoragePermission(activity: Activity) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                ActivityCompat.requestPermissions(
                    activity,
                    arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),
                    REQUEST_CODE_STORAGE_PERMISSION
                )
            } else {
                ActivityCompat.requestPermissions(
                    activity,
                    arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),
                    REQUEST_CODE_STORAGE_PERMISSION
                )

            }
        }

        /**
         * Used to request Contacts permission.
         */
        fun requestContactsPermission(activity: Activity) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(activity, Manifest.permission.READ_CONTACTS)) {
                ActivityCompat.requestPermissions(
                    activity,
                    arrayOf(Manifest.permission.READ_CONTACTS),
                    REQUEST_CODE_READ_CONTACTS_PERMISSION
                )
            } else {
                ActivityCompat.requestPermissions(
                    activity,
                    arrayOf(Manifest.permission.READ_CONTACTS),
                    REQUEST_CODE_READ_CONTACTS_PERMISSION
                )
            }
        }

        /**
         * Used to request Calling permission.
         */
        fun requestCallPhonePermission(activity: Activity) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(activity, Manifest.permission.CALL_PHONE)) {
                ActivityCompat.requestPermissions(
                    activity,
                    arrayOf(Manifest.permission.CALL_PHONE),
                    REQUEST_CODE_CALL_PERMISSION
                )
            } else {
                ActivityCompat.requestPermissions(
                    activity,
                    arrayOf(Manifest.permission.CALL_PHONE),
                    REQUEST_CODE_CALL_PERMISSION
                )
            }
        }

        /**
         * Used to check Location Permission.
         */
        fun checkLocationPermission(mContext: Context): Boolean {
            val result = ContextCompat.checkSelfPermission(mContext, Manifest.permission.ACCESS_COARSE_LOCATION)
            val result1 = ContextCompat.checkSelfPermission(mContext, Manifest.permission.ACCESS_FINE_LOCATION)
            /*if (Build.VERSION.SDK_INT>= Build.VERSION_CODES.Q) {
                val result2 = ContextCompat.checkSelfPermission(
                    mContext,
                    Manifest.permission.ACCESS_BACKGROUND_LOCATION
                )
                return result == PackageManager.PERMISSION_GRANTED && result1 == PackageManager.PERMISSION_GRANTED && result2 == PackageManager.PERMISSION_GRANTED
            } else{
                return result == PackageManager.PERMISSION_GRANTED && result1 == PackageManager.PERMISSION_GRANTED
            }*/
            return result == PackageManager.PERMISSION_GRANTED && result1 == PackageManager.PERMISSION_GRANTED
        }
/**
         * Used to check Location Permission.
         */
        fun checkLocationPermissionBackground(mContext: Context): Boolean {
            val result = ContextCompat.checkSelfPermission(mContext, Manifest.permission.ACCESS_COARSE_LOCATION)
            val result1 = ContextCompat.checkSelfPermission(mContext, Manifest.permission.ACCESS_FINE_LOCATION)
            if (Build.VERSION.SDK_INT>= Build.VERSION_CODES.Q) {
                val result2 = ContextCompat.checkSelfPermission(
                    mContext,
                    Manifest.permission.ACCESS_BACKGROUND_LOCATION
                )
                return result == PackageManager.PERMISSION_GRANTED && result1 == PackageManager.PERMISSION_GRANTED && result2 == PackageManager.PERMISSION_GRANTED
            } else{
                return result == PackageManager.PERMISSION_GRANTED && result1 == PackageManager.PERMISSION_GRANTED
            }


        }

        /**
         * Used to request Location permission.
         */
        fun requestLocationPermission(activity: Activity) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(
                    activity,
                    Manifest.permission.ACCESS_COARSE_LOCATION
                ) || ActivityCompat.shouldShowRequestPermissionRationale(activity, Manifest.permission.ACCESS_FINE_LOCATION)
            ) {
                ActivityCompat.requestPermissions(
                    activity,
                    arrayOf(Manifest.permission.ACCESS_COARSE_LOCATION,
                        Manifest.permission.ACCESS_FINE_LOCATION,
                        Manifest.permission.ACCESS_BACKGROUND_LOCATION),
                    REQUEST_CODE_LOCATION_PERMISSION
                )
            } else {
                ActivityCompat.requestPermissions(
                    activity,
                    arrayOf(Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION,
                        Manifest.permission.ACCESS_BACKGROUND_LOCATION),
                    REQUEST_CODE_LOCATION_PERMISSION
                )

            }
        }

        /**
         * Checks for multiple permissions.
         */
        fun checkAllPermissions(mContext: Context): Boolean {
            val result = ContextCompat.checkSelfPermission(mContext, Manifest.permission.WRITE_EXTERNAL_STORAGE)
            val result1 = ContextCompat.checkSelfPermission(mContext, Manifest.permission.CAMERA)
            val result2 = ContextCompat.checkSelfPermission(mContext, Manifest.permission.ACCESS_FINE_LOCATION)
            val result3 = ContextCompat.checkSelfPermission(mContext, Manifest.permission.ACCESS_COARSE_LOCATION)
            val result4 = ContextCompat.checkSelfPermission(mContext, Manifest.permission.SEND_SMS)
            val result5 = ContextCompat.checkSelfPermission(mContext, Manifest.permission.READ_CONTACTS)
            return (result == PackageManager.PERMISSION_GRANTED && result1 == PackageManager.PERMISSION_GRANTED
                    && result2 == PackageManager.PERMISSION_GRANTED && result3 == PackageManager.PERMISSION_GRANTED
                    && result4 == PackageManager.PERMISSION_GRANTED && result5 == PackageManager.PERMISSION_GRANTED)
        }

        /*
         * Requests for multiple permissions.
         */
        fun requestAllPermissions(activity: Activity) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                || ActivityCompat.shouldShowRequestPermissionRationale(activity, Manifest.permission.CAMERA)
                || ActivityCompat.shouldShowRequestPermissionRationale(activity, Manifest.permission.ACCESS_FINE_LOCATION)
                || ActivityCompat.shouldShowRequestPermissionRationale(activity, Manifest.permission.ACCESS_COARSE_LOCATION)
                || ActivityCompat.shouldShowRequestPermissionRationale(activity, Manifest.permission.RECORD_AUDIO)
                || ActivityCompat.shouldShowRequestPermissionRationale(activity, Manifest.permission.SEND_SMS)
                || ActivityCompat.shouldShowRequestPermissionRationale(activity, Manifest.permission.CALL_PHONE)
                || ActivityCompat.shouldShowRequestPermissionRationale(activity, Manifest.permission.READ_CONTACTS)
            ) {
                ActivityCompat.requestPermissions(
                    activity,
                    arrayOf(
                        Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        Manifest.permission.CAMERA,
                        Manifest.permission.ACCESS_FINE_LOCATION,
                        Manifest.permission.ACCESS_COARSE_LOCATION,
                        Manifest.permission.RECORD_AUDIO,
                        Manifest.permission.SEND_SMS,
                        Manifest.permission.CALL_PHONE,
                        Manifest.permission.READ_CONTACTS
                    ),
                    REQUEST_CODE_ASK_MULTIPLE_PERMISSIONS
                )
            } else {
                ActivityCompat.requestPermissions(
                    activity,
                    arrayOf(
                        Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        Manifest.permission.CAMERA,
                        Manifest.permission.ACCESS_FINE_LOCATION,
                        Manifest.permission.ACCESS_COARSE_LOCATION,
                        Manifest.permission.RECORD_AUDIO,
                        Manifest.permission.SEND_SMS,
                        Manifest.permission.CALL_PHONE,
                        Manifest.permission.READ_CONTACTS
                    ),
                    REQUEST_CODE_ASK_MULTIPLE_PERMISSIONS
                )

            }
        }

        /*
         * Checks for dynamic permissions
         */
        fun hasPermissions(context: Context?, vararg permissions: String): Boolean {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && context != null && permissions != null) {
                for (permission in permissions) {
                    if (ActivityCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED) {
                        return false
                    }
                }
            }
            return true
        }
    }
}
