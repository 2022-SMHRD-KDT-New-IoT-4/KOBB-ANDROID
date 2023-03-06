package org.techtown.kobb

import android.content.res.Configuration
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class Start_kiosk_page : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start_kiosk_page)
    }
}

fun onConfigurationChanged(newConfig: Configuration) {
    onConfigurationChanged(newConfig)
    if (newConfig.orientation === Configuration.ORIENTATION_LANDSCAPE) {
        // 가로 모드 처리
    } else if (newConfig.orientation === Configuration.ORIENTATION_PORTRAIT) {
        // 세로 모드 처리
    }
}