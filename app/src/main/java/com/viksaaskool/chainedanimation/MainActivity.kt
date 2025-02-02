package com.viksaaskool.chainedanimation

import android.os.Bundle
import androidx.activity.ComponentActivity
import com.viksaaskool.chainedanimation.ui.handleEdgeToEdge
import com.viksaaskool.chainedanimation.ui.screens.AppNavHost

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        handleEdgeToEdge {
            AppNavHost()
        }
    }
}