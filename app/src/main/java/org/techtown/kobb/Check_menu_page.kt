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
        var number = 0;

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
        val btn_Cart_page1=findViewById<ImageButton>(R.id.btn_Cart_page1)



        //상호명
        var tvcname = findViewById<TextView>(R.id.tvcname)
        //받아온 매장명
        user_shop_name = intent.getStringExtra("매장명")!!
        tvcname.text = user_shop_name
        // page 20 메뉴확인 페이지
        // 메뉴마다 이미지뷰 사진 바뀜 : btn_check_menu_img
        // 장바구니 담기 버튼 : btn_Small_menu_page1 (바로 전 페이지로 갈 수 있는걸까?)
        // 장바구니 확인 버튼 : btn_Cart_page1
        // 뒤로가기 버튼 : btn_Small_menu_page2

        //장바구니 확인 버튼 눌렀을 때
        btn_Cart_page1.setOnClickListener {
            val intent = Intent(this@Check_menu_page,Cart_page::class.java)
            intent.putExtra("매장명",user_shop_name)
            intent.putExtra("먹포",eat)
            startActivity(intent)
        }








    }
}