package org.techtown.kobb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageButton

class Manage_main_page : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_manage_main_page)
        // Choice_mode_page 에서 넘어온 login id 정보
        val user_id = intent.getStringExtra("user_id")

        // 매출 현황
        val btn_Sales_condition_page = findViewById<Button>(R.id.btn_Sales_condition_page)
        btn_Sales_condition_page.setOnClickListener {

            val intent = Intent(this, Sales_condition_page::class.java)
            // Login page 에서 넘어온 user_id 값을 다음 페이지로 넘겨준다 (이하 동일)
            intent.putExtra("user_id",user_id)
            startActivity(intent)

        }
        // 메뉴 관리
        val btn_Control_menu_page = findViewById<Button>(R.id.btn_Control_menu_page)
        btn_Control_menu_page.setOnClickListener {

            val intent = Intent(this, Control_menu_page::class.java)
            intent.putExtra("user_id",user_id)
            startActivity(intent)
        }

        // 재고 관리
        val btn_Control_inventory_page = findViewById<Button>(R.id.btn_Control_inventory_page)
        btn_Control_inventory_page.setOnClickListener {
            val intent = Intent(this, Control_inventory_page::class.java)
            intent.putExtra("user_id",user_id)
            startActivity(intent)
        }

        // 키오스크 관리
        val btn_Control_kiosk_page = findViewById<Button>(R.id.btn_Control_kiosk_page)
        btn_Control_kiosk_page.setOnClickListener{
            val intent = Intent(this,Control_kiosk_page::class.java)
            intent.putExtra("user_id",user_id)
            startActivity(intent)
        }

        // 모드전환 -> 오류나서 일단 구현 x
        val btn_Choice_mode_page = findViewById<Button>(R.id.Choice_mode_page)
        btn_Choice_mode_page.setOnClickListener{
            val intent = Intent(this,Choice_mode_page::class.java)
            intent.putExtra("user_id",user_id)
            startActivity(intent)
        }

        // 마이페이지
        val btn_User_info_page = findViewById<ImageButton>(R.id.btn_User_info_page)
        btn_User_info_page.setOnClickListener{
            val intent = Intent(this,User_info_page::class.java)
            intent.putExtra("user_id",intent.getStringExtra("user_id"))
            startActivity(intent)

        }


    }
}