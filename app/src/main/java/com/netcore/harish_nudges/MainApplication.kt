package com.netcore.harish_nudges

import android.app.Application
import com.netcore.android.Smartech
import com.netcore.android.logger.SMTDebugLevel
import io.hansel.compose.SmtCompose
import io.hansel.core.logger.HSLLogLevel
import io.hansel.hanselsdk.Hansel
import java.lang.ref.WeakReference
internal var smartech: Smartech? = null

class MainApp : Application() {

    override fun onCreate() {
        super.onCreate()

        HSLLogLevel.all.isEnabled = true
        HSLLogLevel.mid.isEnabled = true
        HSLLogLevel.debug.isEnabled = true
        Hansel.enableDebugLogs()
        SmtCompose.discardedTagsLogging = true

        Smartech.getInstance(WeakReference(this)).let {
            it.setDebugLevel(level = SMTDebugLevel.Level.VERBOSE)
            it.initializeSdk(this)
            it.trackAppInstallUpdateBySmartech()
            smartech = it
        }
    }
}