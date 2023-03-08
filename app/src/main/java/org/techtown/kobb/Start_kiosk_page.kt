package org.techtown.kobb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Start_kiosk_page : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start_kiosk_page)

        //영업시작버튼
        var btn_Choice_mode_page = findViewById<Button>(R.id.btn_Choice_mode_page)
        // 고객메인페이지로 이동
        btn_Choice_mode_page.setOnClickListener{
           var intent = Intent(this@Start_kiosk_page,
           Customer_main_page::class.java)
            startActivity(intent)


        }
    }
}