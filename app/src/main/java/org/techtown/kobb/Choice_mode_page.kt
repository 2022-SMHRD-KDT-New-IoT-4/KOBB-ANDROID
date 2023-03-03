package org.techtown.kobb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class Choice_mode_page : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choice_mode_page)

        val btn_Manage_main_page = findViewById<Button>(R.id.btn_Manage_main_page)
        val btn_Start_kiosk_page = findViewById<Button>(R.id.btn_Start_kiosk_page)
        val btn_User_info_page = findViewById<ImageButton>(R.id.btn_User_info_page)

        btn_Manage_main_page.setOnClickListener{

            val intent = Intent(this,Manage_main_page ::class.java)
            startActivity(intent)
        }

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