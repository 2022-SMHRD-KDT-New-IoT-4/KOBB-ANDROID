package org.techtown.kobb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView

class Choice_mode_page : AppCompatActivity() {
    lateinit var user_shop_name : String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choice_mode_page)
        //login에서 넘어온 이름 값
        user_shop_name = intent.getStringExtra("매장명")!!

        //매장명
        val choice_user_shop_name = findViewById<TextView>(R.id.choice_user_shop_name)
        // 매장명에 이름 값 담아주기
        choice_user_shop_name.text =user_shop_name
        
        val btn_Manage_main_page = findViewById<Button>(R.id.btn_Manage_main_page)
        val btn_Start_kiosk_page = findViewById<Button>(R.id.btn_Start_kiosk_page)
        val btn_User_info_page = findViewById<ImageButton>(R.id.btn_User_info_page)
       //관리자 모드를 눌렀을 때 Manage_main_page로 이동 
        btn_Manage_main_page.setOnClickListener{
        
            val intent = Intent(this,Manage_main_page ::class.java)
            startActivity(intent)
        }
        //고객 모드를 눌렀을 때 Start_kiosk_page로 이동 
        btn_Start_kiosk_page.setOnClickListener{
            val intent = Intent(this,Start_kiosk_page::class.java)
            // 매장명 보내기 
            intent.putExtra("매장명", user_shop_name)
            startActivity(intent)
        }

        btn_User_info_page.setOnClickListener{
            val intent = Intent(this,User_info_page::class.java)
            startActivity(intent)
        }


    }
}