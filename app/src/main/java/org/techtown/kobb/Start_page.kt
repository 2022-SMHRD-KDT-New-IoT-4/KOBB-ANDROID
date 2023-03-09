package org.techtown.kobb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class Start_page : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start_page)

        Handler().postDelayed({
            val intent = Intent(this@Start_page,
                Login_page::class.java)
            startActivity(intent)
            finish()
        },2000)
    }
}