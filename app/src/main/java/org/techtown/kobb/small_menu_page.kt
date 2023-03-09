package org.techtown.kobb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class small_menu_page : AppCompatActivity() {
    //매장명
    lateinit var user_shop_name : String
    //먹포
    lateinit var eat:String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_small_menu_page)
        //먹고가기 포장하기
       eat = intent.getStringExtra("먹포")!!

        //상호명
        var tvname = findViewById<TextView>(R.id.tvcname)
        //받아온 매장명
        user_shop_name = intent.getStringExtra("매장명")!!
        //상호명에 받아온 매장명 담아주기
        tvname.text = user_shop_name

        var btn_Hot_cold_page1 = findViewById<Button>(R.id.btn_Hot_cold_page1)
        var btn_Hot_cold_page2 = findViewById<Button>(R.id.btn_Hot_cold_page2)

         btn_Hot_cold_page1.setOnClickListener{
            var intent = Intent(this,Hot_cold_page::class.java )
             intent.putExtra("매장명",user_shop_name)
             intent.putExtra("먹포",eat)

             startActivity(intent)
         }

        btn_Hot_cold_page2.setOnClickListener{
            var intent = Intent(this,Hot_cold_page::class.java )
            startActivity(intent)
            intent.putExtra("매장명",user_shop_name)
            intent.putExtra("먹포",eat)
        }





    }
}