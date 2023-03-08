package org.techtown.kobb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Start_kiosk_page : AppCompatActivity() {
    lateinit var user_shop_name : String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start_kiosk_page)
        //문구
        val tv = findViewById<TextView>(R.id.tv)
        //Choice에서 넘어온 이름 값
        user_shop_name = intent.getStringExtra("매장명")!!

        tv.text= user_shop_name
    }
}