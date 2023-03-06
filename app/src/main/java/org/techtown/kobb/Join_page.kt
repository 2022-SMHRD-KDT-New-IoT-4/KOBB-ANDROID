package org.techtown.kobb

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class Join_page : AppCompatActivity() {
    var btn_join: Button? = null
    var user_shop: EditText? = null
    var user_id: EditText? = null
    var user_pw: EditText? = null
    var user_phone: EditText? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_join_page)


        title = "ORACLE"
        btn_join = findViewById<View>(R.id.btn_join) as Button
        user_shop = findViewById<View>(R.id.user_shop) as EditText
        user_id = findViewById<View>(R.id.user_id) as EditText
        user_pw = findViewById<View>(R.id.user_pw) as EditText
        user_phone = findViewById<View>(R.id.user_phone) as EditText

        btn_join!!.setOnClickListener {
            try {
                Toast.makeText(this@Join_page, "버튼눌림", Toast.LENGTH_SHORT).show()
                val result: String
                val id = user_id!!.text.toString()
                val shop = user_shop!!.text.toString()
                val pw = user_pw!!.text.toString()
                val phone = user_phone!!.text.toString()
                val task = RegisterActivity()
                result = task.execute(id, shop,phone,pw).get()
            } catch (e: Exception) {
                Log.i("DBtest", ".....ERROR.....!")
            }
        }
    }
}