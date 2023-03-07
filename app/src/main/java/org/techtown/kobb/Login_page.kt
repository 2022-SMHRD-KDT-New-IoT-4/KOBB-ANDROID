package org.techtown.kobb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

class Login_page : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_page)



        var login_user_id  = findViewById<EditText>(R.id.login_user_id)
        var login_user_pw = findViewById<EditText>(R.id.login_user_pw)
        var btn_Choice_mode_page = findViewById<Button>(R.id.btn_Choice_mode_page)


        val requestQueue = Volley.newRequestQueue(applicationContext)

        btn_Choice_mode_page.setOnClickListener(View.OnClickListener {
            var id = login_user_id.text.toString()
            var pw = login_user_pw.text.toString()
            val url="http://172.30.1.89:8081/KOBB/Login.do?user_id="+id+"&user_pw="+pw

            val request = StringRequest(
                Request.Method.GET,
                url,
                {response->
                    Toast.makeText(this@Login_page,"통신성공", Toast.LENGTH_SHORT).show()

                },
                { error ->
                    Toast.makeText(this@Login_page,"통신실패", Toast.LENGTH_SHORT).show()
                }

            )
            // post 방식의 데이터를 담을 수 있는 위치
                Log.d("여기",request.toString())
            requestQueue.add(request)
        })


    }
}