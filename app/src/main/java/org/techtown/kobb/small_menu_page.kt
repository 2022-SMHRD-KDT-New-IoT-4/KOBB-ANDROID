package org.techtown.kobb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView

class small_menu_page : AppCompatActivity() {
    //매장명
    lateinit var user_shop_name : String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_small_menu_page)
        //상호명
        var tvname = findViewById<TextView>(R.id.tvname)
        //받아온 매장명
        user_shop_name = intent.getStringExtra("매장명")!!
        //상호명에 받아온 매장명 담아주기
        tvname.text = user_shop_name

        var btn_Hot_cold_page1 = findViewById<ImageButton>(R.id.btn_Hot_cold_page1)
        var btn_Hot_cold_page2 = findViewById<ImageButton>(R.id.btn_Hot_cold_page2)
        //왼쪽 화면 버튼 눌렀을 때
        btn_Hot_cold_page1.setOnClickListener{
            val intent = Intent(this@small_menu_page,Hot_cold_page::class.java)
            intent.putExtra("매장명",user_shop_name)
            startActivity(intent)
        }
        //오른쪽 화면 버튼 눌렀을 때
        btn_Hot_cold_page2.setOnClickListener{
            val intent = Intent(this@small_menu_page,Hot_cold_page::class.java)
            intent.putExtra("매장명",user_shop_name)
            startActivity(intent)
        }






    }
}