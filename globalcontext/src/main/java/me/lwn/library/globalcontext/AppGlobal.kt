package me.lwn.library.globalcontext

import android.app.ActivityThread
import android.app.Application

/**
 * A partial delegate class for ActivityThread.class.
 *
 * with this helper, you can easily access those hidden api
 *
 * in your project.
 *
 * created by fatter 2022/6/1
 */
object AppGlobal {

    /**
     * get current application instance
     *
     * NOTE: DO NOT CALL this in application.attachBaseContext()
     */
    fun getApplication(): Application {
        return ActivityThread.currentApplication()
    }

    /**
     * get current application packageName
     *
     * NOTE: DO NOT CALL this in application.attachBaseContext()
     */
    fun getPackageName(): String {
        return ActivityThread.currentPackageName()
    }

    /**
     * get current application processName
     *
     * NOTE: DO NOT CALL this in application.attachBaseContext()
     */
    fun getProcessName(): String {
        return ActivityThread.currentProcessName()
    }

    /**
     * get current ActivityThread instance
     *
     * NOTE: DO NOT CALL this in application.attachBaseContext()
     */
    fun getCurrentActivityThread(): Any {
        return ActivityThread.currentActivityThread()
    }
}