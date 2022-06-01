package me.lwn.library.globalcontext

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Bundle
import android.widget.TextView

class MainActivity : Activity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        assert(application == AppGlobal.getApplication())

        setContentView(TextView(AppGlobal.getApplication()).also {
            it.text = """
              application:${AppGlobal.getApplication()},
              
              packageName:${AppGlobal.getPackageName()},
              
              processName:${AppGlobal.getProcessName()}
            """.trimIndent()
            it.textSize = 18F
        })
    }
}