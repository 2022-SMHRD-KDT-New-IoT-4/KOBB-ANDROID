package org.techtown.kobb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView

class Check_menu_page : AppCompatActivity() {
    //매장명
    lateinit var user_shop_name : String
    //차갑게
    lateinit var cold: String
    //뜨겁게
    lateinit var hot : String
    //먹포
    lateinit var eat:String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_check_menu_page)
        //먹고가기 포장하기
        eat = intent.getStringExtra("먹포")!!

        var btn_cart_page3 = findViewById<ImageButton>(R.id.btn_cart_page3)

        btn_cart_page3.setOnClickListener{
            intent = Intent(this,Cart_page::class.java)
            startActivity(intent)
        }

        //차가운지 뜨거운지
         var ch = findViewById<TextView>(R.id.ch)
        if(intent.getStringExtra("COLD")!=null){
            cold = intent.getStringExtra("COLD")!!
            ch.text = cold
        }else{
            hot =intent.getStringExtra("HOT")!!
            ch.text = hot
        }


        // 수량 증감 버튼
        var minbutton = findViewById<Button>(R.id.minbutton)
        var plusbutton = findViewById<Button>(R.id.plusbutton)
        val result = findViewById<TextView>(R.id.result)
        var number = 1;

        // 마이너스 버튼 선택시
        minbutton.setOnClickListener {
            number--
            result.setText(number.toString())
        }
        // 플러스 버튼 선택시
        plusbutton.setOnClickListener {
            number++
            result.setText(number.toString())
        }



        //장바구니 확인
        val btn_Cart_page1=findViewById<Button>(R.id.btn_Cart_page1)



        //상호명
        var tvcname = findViewById<TextView>(R.id.tvcname2)
        //받아온 매장명
        user_shop_name = intent.getStringExtra("매장명")!!
        tvcname.text = user_shop_name

        //장바구니 확인 버튼 눌렀을 때
        btn_Cart_page1.setOnClickListener {
            val intent = Intent(this@Check_menu_page,Cart_page::class.java)
            intent.putExtra("매장명",user_shop_name)
            intent.putExtra("먹포",eat)
            startActivity(intent)
        }








    }
}