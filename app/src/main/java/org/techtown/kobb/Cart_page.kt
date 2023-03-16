package org.techtown.kobb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class Cart_page : AppCompatActivity() {
    //매장명
    lateinit var user_shop_name : String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart_page)

        //상호명
        val shop_name = findViewById<TextView>(R.id.user_shop_name)
        //받아온 매장명
        user_shop_name = intent.getStringExtra("user_shop_name")!!
        shop_name.text = user_shop_name

        // 결제하기 버튼 : btn_Choice_pay_page


        var pay_page = findViewById<Button>(R.id.btn_Choice_pay_page)

        pay_page.setOnClickListener{

            val intent = Intent(this, Choice_pay_page::class.java)
            intent.putExtra("user_shop_name",shop_name.text)
            startActivity(intent)
        }



    }
}