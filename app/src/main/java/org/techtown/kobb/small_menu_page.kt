package org.techtown.kobb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class small_menu_page : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_small_menu_page)

        var btn_Hot_cold_page1 = findViewById<ImageButton>(R.id.btn_Hot_cold_page1)
        var btn_Hot_cold_page2 = findViewById<ImageButton>(R.id.btn_Hot_cold_page2)

        btn_Hot_cold_page1.setOnClickListener{
            val intent = Intent(this@small_menu_page,Hot_cold_page::class.java)
            startActivity(intent)
        }
        btn_Hot_cold_page2.setOnClickListener{
            val intent = Intent(this@small_menu_page,Hot_cold_page::class.java)
            startActivity(intent)
        }






    }
}