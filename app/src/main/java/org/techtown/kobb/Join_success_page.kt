package org.techtown.kobb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import org.w3c.dom.Text

class Join_success_page : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_join_success_page)

        val btn_Login_page = findViewById<Button>(R.id.btn_Login_page)
        val user_shop_name = findViewById<TextView>(R.id.user_shop_name)
        user_shop_name.text = intent.getStringExtra("user_shop_name")+"사장님"


        btn_Login_page.setOnClickListener{

            val intent = Intent(this@Join_success_page,Login_page::class.java)
            startActivity(intent)


        }
    }
}