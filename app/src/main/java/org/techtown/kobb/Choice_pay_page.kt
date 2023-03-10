package org.techtown.kobb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Choice_pay_page : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choice_pay_page)

        var btn_card = findViewById<Button>(R.id.btn_Mode_change_page)

        btn_card.setOnClickListener{
            var intent = Intent(this,Pay_page::class.java)
            startActivity(intent)
        }



    }
}