package org.techtown.kobb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class Manage_main_page : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_manage_main_page)

        val btn_Sales_condition_page = findViewById<Button>(R.id.btn_Sales_condition_page)
        val btn_Control_menu_page = findViewById<Button>(R.id.btn_Control_menu_page)
        val btn_Control_inventory_page = findViewById<Button>(R.id.btn_Control_inventory_page)
        //val btn_Control_kiosk_page = findViewById<Button>(R.id.btn_Control_kiosk_page)
        val btn_Start_kiosk_page = findViewById<Button>(R.id.btn_Start_kiosk_page)
        val btn_User_info_page = findViewById<ImageButton>(R.id.btn_User_info_page)


        btn_Sales_condition_page.setOnClickListener {

            val intent = Intent(this, Sales_condition_page::class.java)
            startActivity(intent)

        }

        btn_Control_menu_page.setOnClickListener {

            val intent = Intent(this, Control_menu_page::class.java)
            startActivity(intent)
        }

        btn_Control_inventory_page.setOnClickListener {
            val intent = Intent(this, Control_inventory_page::class.java)
            startActivity(intent)
        }


        // 키오스크 관리 페이지 승철님 담담이라 잠시 주석 처리 해놓겠습니다.
        //btn_Control_kiosk_page.setOnClickListener{
        //    val intent = Intent(this,Control_kiosk_page::class.java)
        //}

        btn_Start_kiosk_page.setOnClickListener{
            val intent = Intent(this,Start_kiosk_page::class.java)
            startActivity(intent)
        }

        btn_User_info_page.setOnClickListener{
            val intent = Intent(this,User_info_page::class.java)
            startActivity(intent)

        }


    }
}