package com.localstorage

import android.content.Context
import com.facebook.fbreact.specs.NativeLocalStorageSpec
import com.facebook.react.bridge.ReactApplicationContext
import androidx.core.content.edit

class LocalStorageModule(reactContext: ReactApplicationContext) :
  NativeLocalStorageSpec(reactContext) {

    override fun setItem(value: String?, key: String?) {
        val sharedPref = reactApplicationContext.getSharedPreferences("my_prefs", Context.MODE_PRIVATE)
        sharedPref.edit {
            putString(key, value)
        }
    }

    override fun getItem(key: String?): String? {
        val sharedPref = reactApplicationContext.getSharedPreferences("my_prefs", Context.MODE_PRIVATE)
        val username = sharedPref.getString(key, null)
        return username
    }

    override fun removeItem(key: String?) {
        val sharedPref = reactApplicationContext.getSharedPreferences("my_prefs", Context.MODE_PRIVATE)
        sharedPref.edit {
            remove(key)
        }
    }

    override fun clear() {
        val sharedPref = reactApplicationContext.getSharedPreferences("my_prefs", Context.MODE_PRIVATE)
        sharedPref.edit {
            clear()
        }
    }

    companion object {
    const val NAME = NativeLocalStorageSpec.NAME
  }
}
