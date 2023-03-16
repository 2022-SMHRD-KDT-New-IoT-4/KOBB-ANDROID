package org.techtown.kobb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.TextView

class Pay_page : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pay_page)
        var shop_name = findViewById<TextView>(R.id.user_shop_name)
        shop_name.text = intent.getStringExtra("user_shop_name")

        Handler().postDelayed({
            val intent = Intent(this,
                Finish_order_page::class.java)
            intent.putExtra("user_shop_name",shop_name.text)
            startActivity(intent)
            finish()
        },10000)

    }
}