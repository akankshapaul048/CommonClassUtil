package com.akanksha.commonclassutil

import android.app.Activity
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.annotation.AnimRes
import androidx.core.app.ActivityOptionsCompat

/**
 * Author:    Akanksha Paul
 * Created:   13/8/19
 */
class ActivityUtils {

  companion object{
      /**
       * Start the activity.
       *
       * @param clz The activity class.
       */
      fun startActivity(context: Context, clz: Class<out Activity>) {
          startActivity(context, null, context.packageName, clz.name, null)
      }

      /**
       * Start the activity.
       *
       * @param clz     The activity class.
       * @param options Additional options for how the Activity should be started.
       */
      fun startActivity(
          context: Context, clz: Class<out Activity>,
          options: Bundle?
      ) {
          startActivity(context, null, context.packageName, clz.name, options)
      }

      /**
       * Start the activity.
       *
       * @param clz       The activity class.
       * @param enterAnim A resource ID of the animation resource to use for the
       * incoming activity.
       * @param exitAnim  A resource ID of the animation resource to use for the
       * outgoing activity.
       */
      fun startActivity(
          context: Context, clz: Class<out Activity>,
          @AnimRes enterAnim: Int,
          @AnimRes exitAnim: Int
      ) {
          startActivity(
              context, null, context.packageName, clz.name,
              getOptionsBundle(context, enterAnim, exitAnim)
          )
          if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN && context is Activity) {
              context.overridePendingTransition(enterAnim, exitAnim)
          }
      }

      /**
       * Start the activity.
       *
       * @param extras The Bundle of extras to add to this intent.
       * @param clz    The activity class.
       */
      fun startActivity(
          context: Context, extras: Bundle,
          clz: Class<out Activity>
      ) {
          startActivity(context, extras, context.packageName, clz.name, null)
      }

      /**
       * Start the activity.
       *
       * @param extras  The Bundle of extras to add to this intent.
       * @param clz     The activity class.
       * @param options Additional options for how the Activity should be started.
       */
      fun startActivity(
          context: Context, extras: Bundle,
          clz: Class<out Activity>,
          options: Bundle?
      ) {
          startActivity(context, extras, context.packageName, clz.name, options)
      }

      /**
       * Start the activity.
       *
       * @param extras    The Bundle of extras to add to this intent.
       * @param clz       The activity class.
       * @param enterAnim A resource ID of the animation resource to use for the
       * incoming activity.
       * @param exitAnim  A resource ID of the animation resource to use for the
       * outgoing activity.
       */
      fun startActivity(
          context: Context, extras: Bundle,
          clz: Class<out Activity>,
          @AnimRes enterAnim: Int,
          @AnimRes exitAnim: Int
      ) {
          startActivity(
              context, extras, context.packageName, clz.name,
              getOptionsBundle(context, enterAnim, exitAnim)
          )
          if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN && context is Activity) {
              context.overridePendingTransition(enterAnim, exitAnim)
          }
      }

      private fun startActivity(
          context: Context,
          extras: Bundle?,
          pkg: String,
          cls: String,
          options: Bundle?
      ) {
          val intent = Intent(Intent.ACTION_VIEW)
          if (extras != null) intent.putExtras(extras)
          intent.component = ComponentName(pkg, cls)
          startActivity(intent, context, options)
      }

      /**
       * Start the activity.
       *
       * @param extras      The Bundle of extras to add to this intent.
       * @param activity    The activity.
       * @param clz         The activity class.
       * @param requestCode if &gt;= 0, this code will be returned in
       * onActivityResult() when the activity exits.
       */
      fun startActivityForResult(
          extras: Bundle,
          activity: Activity,
          clz: Class<out Activity>,
          requestCode: Int
      ) {
          startActivityForResult(
              activity, extras, activity.packageName, clz.name,
              requestCode, null
          )
      }

      private fun startActivity(
          intent: Intent,
          context: Context,
          options: Bundle?
      ) {
          /* if (!isIntentAvailable(intent)) {
              Log.e("ActivityUtils", "intent is unavailable");
              return false;
          }*/
          if (context !is Activity) {
              intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
          }
          if (options != null && Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
              context.startActivity(intent, options)
          } else {
              context.startActivity(intent)
          }
      }

      private fun getOptionsBundle(
          context: Context,
          enterAnim: Int,
          exitAnim: Int
      ): Bundle? {
          return ActivityOptionsCompat.makeCustomAnimation(context, enterAnim, exitAnim).toBundle()
      }

      private fun startActivityForResult(
          activity: Activity,
          extras: Bundle?,
          pkg: String,
          cls: String,
          requestCode: Int,
          options: Bundle?
      ) {
          val intent = Intent(Intent.ACTION_VIEW)
          if (extras != null) intent.putExtras(extras)
          intent.component = ComponentName(pkg, cls)
          startActivityForResult(intent, activity, requestCode, options)
      }

      private fun startActivityForResult(
          intent: Intent,
          activity: Activity,
          requestCode: Int,
          options: Bundle?
      ) {
          /* if (!isIntentAvailable(intent)) {
              Log.e("ActivityUtils", "intent is unavailable");
              return false;
          }*/
          if (options != null && Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
              activity.startActivityForResult(intent, requestCode, options)
          } else {
              activity.startActivityForResult(intent, requestCode)
          }
      }
  }
}
