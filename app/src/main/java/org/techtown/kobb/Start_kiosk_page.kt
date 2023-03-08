package org.techtown.kobb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class Start_kiosk_page : AppCompatActivity() {
    lateinit var user_shop_name : String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start_kiosk_page)
        //영업시작
       val btn_Choice_mode_page = findViewById<Button>(R.id.btn_Choice_mode_page)
        //문구
        val textView71 = findViewById<TextView>(R.id.textView71)
        //Choice에서 넘어온 이름 값
        user_shop_name = intent.getStringExtra("매장명")!!

        textView71.text= user_shop_name
        //영업시작을 눌렀을 때
        btn_Choice_mode_page.setOnClickListener {
            val intent = Intent(this,Customer_main_page::class.java)
            // 매장명 보내기
           intent.putExtra("매장명", user_shop_name)
           startActivity(intent)

        }
    }
}