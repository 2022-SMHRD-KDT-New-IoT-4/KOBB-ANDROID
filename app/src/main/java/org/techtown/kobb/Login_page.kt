package org.techtown.kobb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.android.volley.AuthFailureError
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

class Login_page : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_page)



        var login_user_id  = findViewById<EditText>(R.id.login_user_id)
        var login_user_pw = findViewById<EditText>(R.id.login_user_pw)
        var btn_Choice_mode_page = findViewById<Button>(R.id.btn_Customer_main_page)
        var btn_Join_page = findViewById<Button>(R.id.btn_Join_page)

        val requestQueue = Volley.newRequestQueue(applicationContext)

        btn_Choice_mode_page.setOnClickListener(View.OnClickListener {
            var id = login_user_id.text.toString()
            var pw = login_user_pw.text.toString()
            val url="http://119.206.166.38:8081/KOBB/Login.do?"

            val request = object : StringRequest(
                Request.Method.POST,
                url,
                {response->
                    var index1 = response.indexOf(',') // 데이터를 ,와 . 으로 구분 해놓음
                    var index2 = response.indexOf('.')
                    //  indext 0 번에있는 data = id
                    var user_id = response.subSequence(0,index1)
                    //  index 1 번에있는 data = pw
                    var user_pw = response.subSequence(index1+1,index2)
                    var user_shop_name = response.subSequence(index2+1,response.length)
                    Log.d("매장명",user_shop_name.toString())

                    // 로그인 실패가 아니라면
                    if(response!="로그인 실패") {
                        // 로그인 성공이라는 토스트를 띄운다
                        Toast.makeText(this@Login_page, "로그인 성공", Toast.LENGTH_SHORT).show()

                        // user_shop_name 을 가지고 choice_mode_page 로 이동한다.
                        val intent = Intent(this, Choice_mode_page::class.java)
                        intent.putExtra("user_shop_name", user_shop_name)
                        startActivity(intent)
                    }else{
                        Toast.makeText(this@Login_page,"로그인 실패 다시 시도해주세요", Toast.LENGTH_SHORT).show()
                    }
                },
                { error ->
                    Toast.makeText(this@Login_page,"아이디와 비밀번호를 확인해주세요", Toast.LENGTH_SHORT).show()
                }

            )

            // post 방식의 데이터를 담을 수 있는 위치
            { // post 방식의 데이터를 담을 수 있는 위치
            @Throws(AuthFailureError::class)
            override fun getParams(): MutableMap<String, String>? {
                val params: MutableMap<String, String> = HashMap()
                params["user_id"] = id
                params["user_pw"] = pw
                return params }
            }

            requestQueue.add(request)

        })

        // 회원가입 페이지로 이동
        btn_Join_page.setOnClickListener{
            intent = Intent(this,Join_page::class.java)
            startActivity(intent)
        }




    }


}