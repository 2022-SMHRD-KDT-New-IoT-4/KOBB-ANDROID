package org.techtown.kobb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Join_success_page : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_join_success_page)

        val btn_Login_page = findViewById<Button>(R.id.btn_Login_page)


        btn_Login_page.setOnClickListener{

            val intent = Intent(this@Join_success_page,Login_page::class.java)
            startActivity(intent)


        }
    }
}