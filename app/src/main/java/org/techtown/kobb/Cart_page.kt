package org.techtown.kobb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Cart_page : AppCompatActivity() {
    //매장명
    lateinit var user_shop_name : String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart_page)

        //상호명
        val tvcname2 = findViewById<TextView>(R.id.small_menu_name)
        //받아온 매장명
        user_shop_name = intent.getStringExtra("매장명")!!
        tvcname2.text = user_shop_name

        // page 21 장바구니 페이지
        // 뒤로가기 버튼 : btn_Small_menu_page3
        // 장바구니 버튼 : btn_Cart_page3
        // 장바구니 사진1 : btn_cart_page_img
        // 장바구니 사진2 : btn_cart_page_img1
        // 결제하기 버튼 : btn_Choice_pay_page
        // 이전페이지, 다음페이지 이동 어떻게 해야 하지?



    }
}