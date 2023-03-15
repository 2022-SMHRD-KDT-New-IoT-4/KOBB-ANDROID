package org.techtown.kobb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class Mode_change_page : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mode_change_page)


    // 뒤로가기버튼
    val Customer_main = findViewById<Button>(R.id.btn_back)
    // 전환하기 버튼
    val Choice_mode = findViewById<Button>(R.id.btn_mode_change)

        // 매장명 넣어주기
    val user_shop_name = findViewById<TextView>(R.id.user_shop_name)
        user_shop_name.text = intent.getStringExtra("user_shop_name")


        // 뒤로가기  -> Customer_main_page 로 이동
        Customer_main.setOnClickListener{
            val intent = Intent(this,Customer_main_page::class.java)
            intent.putExtra("user_shop_name", user_shop_name.text)
            startActivity(intent)

        }

        // 전환하기 버튼 눌렀을 때 (비밀번호 입력하지 않아도 넘어가도록 해 놓음)
        Choice_mode.setOnClickListener{
            val intent = Intent(this,Choice_mode_page::class.java)
            intent.putExtra("user_shop_name", user_shop_name.text)
            startActivity(intent)



        }


    }
}