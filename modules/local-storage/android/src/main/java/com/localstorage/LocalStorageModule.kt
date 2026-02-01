package com.localstorage

import com.facebook.react.bridge.ReactApplicationContext

class LocalStorageModule(reactContext: ReactApplicationContext) :
  NativeLocalStorageSpec(reactContext) {

  override fun multiply(a: Double, b: Double): Double {
    return a * b
  }

  companion object {
    const val NAME = NativeLocalStorageSpec.NAME
  }
}
