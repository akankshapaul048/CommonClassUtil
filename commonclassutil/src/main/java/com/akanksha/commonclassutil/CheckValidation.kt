package com.akanksha.commonclassutil

import android.util.Patterns

/**
 * Author:    Akanksha Paul
 * Created:   13/8/19
 */
class CheckValidation {

  companion object{
      private const val NUMBER_FORMAT = "[0-9]+"
      private const val NAME_FORMAT = "[a-zA-Z ]+"

      /**
       * this method is used to check validation for email
       *
       * @param email Email id
       * @return type boolean
       */
      fun isValidEmail(email: CharSequence?): Boolean {
          return if (email == null) {
              false
          } else {
              Patterns.EMAIL_ADDRESS.matcher(email).matches()
          }
      }

      /**
       * this method is used to check validation for mobile number
       *
       * @param mobile Mobile Number
       * @return type boolean
       */
      fun isValidMobileNumber(mobile: CharSequence?): Boolean {
          return if (mobile == null) {
              false
          } else {
              Patterns.PHONE.matcher(mobile).matches()
          }
      }

      /**
       * this method is used to check validation for number
       *
       * @param number input string
       * @return type boolean
       */
      fun isValidNumber(number: String?): Boolean {
          return number?.matches(NUMBER_FORMAT.toRegex()) ?: false
      }

      /**
       * this method is used to check validation for name
       *
       * @param name input string
       * @return type boolean
       */
      fun isValidName(name: String?): Boolean {
          return name?.matches(NAME_FORMAT.toRegex()) ?: false
      }

  }
}
