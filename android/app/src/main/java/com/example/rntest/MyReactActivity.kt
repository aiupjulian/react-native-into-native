package com.example.rntest

import android.os.Bundle

import android.app.Activity
import com.facebook.react.common.LifecycleState
import com.facebook.react.shell.MainReactPackage
import com.facebook.react.ReactInstanceManager
import com.facebook.react.ReactRootView
import com.facebook.react.modules.core.DefaultHardwareBackBtnHandler

class MyReactActivity : Activity(), DefaultHardwareBackBtnHandler {
    private var mReactRootView: ReactRootView? = null
    private var mReactInstanceManager: ReactInstanceManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mReactRootView = ReactRootView(this)
        mReactInstanceManager = ReactInstanceManager.builder()
            .setApplication(application)
            .setCurrentActivity(this)
            .setBundleAssetName("index.bundle")
            .setJSMainModulePath("index")
            .addPackage(MainReactPackage())
            .setUseDeveloperSupport(BuildConfig.DEBUG)
            .setInitialLifecycleState(LifecycleState.RESUMED)
            .build()
        val initialProps = Bundle()
        initialProps.putString("nativeParameter", "String parameter from Android Native code")
        mReactRootView!!.startReactApplication(mReactInstanceManager, "RNTestScreen", initialProps)

        setContentView(mReactRootView)
    }

    override fun invokeDefaultOnBackPressed() {
        super.onBackPressed()
    }

    override fun onPause() {
        super.onPause()
        mReactInstanceManager?.onHostPause(this)
    }

    override fun onResume() {
        super.onResume()
        mReactInstanceManager?.onHostResume(this, this)
    }

    override fun onDestroy() {
        super.onDestroy()
        mReactInstanceManager?.onHostDestroy(this)
        mReactRootView?.unmountReactApplication()
    }

    override fun onBackPressed() {
        if (mReactInstanceManager == null) {
            super.onBackPressed()
        } else {
            mReactInstanceManager?.onBackPressed()
        }
    }
}
