package com.localstorage

import com.facebook.react.BaseReactPackage
import com.facebook.react.bridge.NativeModule
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.module.model.ReactModuleInfo
import com.facebook.react.module.model.ReactModuleInfoProvider
import java.util.HashMap

class LocalStoragePackage : BaseReactPackage() {
  override fun getModule(name: String, reactContext: ReactApplicationContext): NativeModule? {
    return if (name == LocalStorageModule.NAME) {
      LocalStorageModule(reactContext)
    } else {
      null
    }
  }

  override fun getReactModuleInfoProvider(): ReactModuleInfoProvider {
    return ReactModuleInfoProvider {
      val moduleInfos: MutableMap<String, ReactModuleInfo> = HashMap()
      moduleInfos[LocalStorageModule.NAME] = ReactModuleInfo(
        LocalStorageModule.NAME,
        className = LocalStorageModule.NAME,
          canOverrideExistingModule = false,  // canOverrideExistingModule
          needsEagerInit = false,  // needsEagerInit
          isCxxModule = false,  // isCxxModule
          isTurboModule = true // isTurboModule
      )
      moduleInfos
    }
  }
}
