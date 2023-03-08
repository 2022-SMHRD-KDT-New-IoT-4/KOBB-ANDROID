package org.techtown.kobb

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley


class Join_page : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_join_page)

        val btn_join = findViewById<Button>(R.id.btn_join)
        val user_shop_name = findViewById<EditText>(R.id.user_shop_name)
        val user_id = findViewById<EditText>(R.id.user_id)
        val user_pw = findViewById<EditText>(R.id.user_pw)
        val user_phone = findViewById<EditText>(R.id.user_phone)




        val requestQueue = Volley.newRequestQueue(applicationContext)

        btn_join.setOnClickListener(View.OnClickListener {
            var shop_name = user_shop_name.text.toString()
            var id = user_id.text.toString()
            var pw = user_pw.text.toString()
            var phone = user_phone.text.toString()
            val url="http://172.30.1.89:8005/KOBB/Join.do?user_shop_name="+shop_name+"&user_id="+id+"&user_pw="+pw+"&user_phone="+phone

            val request = StringRequest(
                Request.Method.GET,
                url,
                {response->
                    Toast.makeText(this@Join_page,"통신성공", Toast.LENGTH_SHORT).show()

                },
                { error ->
                    Toast.makeText(this@Join_page,"통신실패", Toast.LENGTH_SHORT).show()
                }


            )
            // post 방식의 데이터를 담을 수 있는 위치

            requestQueue.add(request)
        })


    }
}