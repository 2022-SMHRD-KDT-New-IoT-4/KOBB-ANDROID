package org.techtown.kobb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class Hot_cold_page : AppCompatActivity() {
    //매장명
    lateinit var user_shop_name : String

    lateinit var cold : String
    lateinit var hot : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hot_cold_page)
        //상호명
        val chname = findViewById<TextView>(R.id.chname)
        //받아온 매장명
        user_shop_name = intent.getStringExtra("매장명")!!
        chname.text = user_shop_name


        //차갑게
        val btn_Check_menu_page =findViewById<Button>(R.id.btn_Check_menu_page)
        //따듯하게
        val btn_btn_Check_menu_page =findViewById<Button>(R.id.btn_btn_Check_menu_page)

        //차갑게 눌렀을 때
        btn_Check_menu_page.setOnClickListener {
            val intent = Intent(this@Hot_cold_page,Check_menu_page::class.java)
            intent.putExtra("매장명",user_shop_name)
            intent.putExtra("COLD","COLD")
            startActivity(intent)
        }
        //따뜻하게 눌렀을 때
        btn_btn_Check_menu_page.setOnClickListener {
            val intent = Intent(this@Hot_cold_page,Check_menu_page::class.java)
            intent.putExtra("매장명",user_shop_name)
            intent.putExtra("HOT","HOT")
            startActivity(intent)
        }

        // page 19 온도결정 페이지 (하하 테스트에요)

        // 차갑게 버튼 : btn_Check_menu_page -> 메뉴확인 페이지로 이동
        // 따뜻하게 버튼 : btn_btn_Check_menu_page -> 메뉴확인 페이지로 이동
        // 장바구니 버튼 : btn_Cart_page3 -> 장바구니 페이지로 이동
        // 뒤로 가기 버튼 : btn_Small_menu_page -> 소메뉴 내 이전페이지로 이동 / 어떤 소메뉴에 있었는지 기억하고 그 페이지로 이동이 가능할까?





    }
}