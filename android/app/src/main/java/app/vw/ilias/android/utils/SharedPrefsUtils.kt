package app.vw.ilias.android.utils

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import com.google.gson.Gson
import ilias.vw.libs.Cart

/**
 * Created by ilias on 14/04/18.
 */
class SharedPrefsUtils {
    companion object {
        val PREFS_FILE = "ilias.vw.android"
        @JvmStatic fun cacheCart(cart: Cart, activity: Activity) {
            var sharedPrefs: SharedPreferences = activity.getSharedPreferences(PREFS_FILE, Context.MODE_PRIVATE)
            var gson: Gson = Gson()
            var json: String = gson.toJson(cart)
            sharedPrefs.edit().putString("cart", json).apply()
        }

        @JvmStatic fun getCart(activity: Activity): Cart? {
            var sharedPrefs: SharedPreferences = activity.getSharedPreferences(PREFS_FILE, Context.MODE_PRIVATE)
            var gson: Gson = Gson()
            var json: String = sharedPrefs.getString("cart", "")
            if(json == "") {
                return null
            }

            var cart: Cart = gson.fromJson(json, Cart::class.java)
            return cart
        }
    }
}