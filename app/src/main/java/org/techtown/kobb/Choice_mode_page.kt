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

        val btn_User_info_page = findViewById<ImageButton>(R.id.btn_User_info_page)

        // 모드 선택 페이지에서 매장명 보여주는 TextView
        val user_shop_name = findViewById<TextView>(R.id.user_shop_name)

        // 매장명에 text 를 login 시 가져온 user_shop_name 으로 변경
        user_shop_name.text = intent.getStringExtra("user_shop_name")!! //login에서 넘어온 매장명
        val user_id = intent.getStringExtra("user_id")
        
        val btn_Manage_main_page = findViewById<Button>(R.id.btn_Manage_main_page)
        val btn_Start_kiosk_page = findViewById<Button>(R.id.Choice_mode_page)
        //val btn_User_info_page = findViewById<ImageButton>(R.id.btn_User_info_page)
       //관리자 모드를 눌렀을 때 Manage_main_page로 이동 
        btn_Manage_main_page.setOnClickListener{
            val intent = Intent(this,Manage_main_page ::class.java)
            intent.putExtra("user_shop_name",user_shop_name.toString())
            intent.putExtra("user_id",user_id)
            startActivity(intent)
        }

        //고객 모드를 눌렀을 때 Start_kiosk_page로 이동
        btn_Start_kiosk_page.setOnClickListener{
            val intent = Intent(this,Start_kiosk_page::class.java)
            // 매장명 보내기
            intent.putExtra("user_shop_name",user_shop_name.text)
            startActivity(intent)
        }

        // 마이페이지 눌렀을 때 User_info_page로 이동
        btn_User_info_page.setOnClickListener{
            val intent = Intent(this,User_info_page::class.java)
            startActivity(intent)
        }


    }
}