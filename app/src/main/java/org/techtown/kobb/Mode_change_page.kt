package org.techtown.kobb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Mode_change_page : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mode_change_page)

        // Page16 모드전환(잠금)페이지
        var Mode_change_page = findViewById<Button>(R.id.btn_Customer_main_page)

        Mode_change_page.setOnClickListener {
            intent = Intent(this,Mode_change_page::class.java)
            startActivity(intent)


        }
        // 모드번환 버튼 : btn_Choice_mode_page
        // 뒤로가기 버튼 : btn_Customer_main_page
        // 전환하기 버튼 : btn_manage_main_page ( 다른 파일과 id값 중복돼서 소문자로 id값 부여)




    }
}