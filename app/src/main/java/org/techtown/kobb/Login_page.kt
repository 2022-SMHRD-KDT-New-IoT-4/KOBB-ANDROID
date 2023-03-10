package org.techtown.kobb

import android.content.Intent
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
        var btn_Choice_mode_page = findViewById<Button>(R.id.btn_Mode_change_page)
        var btn_Join_page = findViewById<Button>(R.id.btn_Join_page)

        val requestQueue = Volley.newRequestQueue(applicationContext)

        btn_Choice_mode_page.setOnClickListener(View.OnClickListener {
            var id = login_user_id.text.toString()
            var pw = login_user_pw.text.toString()
            val url="http://119.206.166.38:8081/KOBB/Login.do?user_id="+id+"&user_pw="+pw

            val request = StringRequest(
                Request.Method.GET,
                url,
                {response->
                    // Log.d("리스폰스",String(response.toString().toByteArray(Charsets.ISO_8859_1),Charsets.UTF_8))
                     var  id2 = response.subSequence(0,response.indexOf(','))
                    //Log.d("쪼갠 아이디 값",id2.toString())
                    var pw2 = response.subSequence(response.indexOf(',')+1,response.indexOf('.'))
                    Log.d("쪼갠 패스워드 값",pw2.toString())
                     var user_shop_name = response.subSequence(response.indexOf('.')+1,response.length)
                    Log.d("쪼갠 이름 값",user_shop_name.toString())
                    if(response!="fuck") {
                        Toast.makeText(this@Login_page, "로그인 성공", Toast.LENGTH_SHORT).show()
                        user_shop_name = String(response.subSequence(response.indexOf('.')+1,response.length).toString().toByteArray(Charsets.ISO_8859_1),Charsets.UTF_8)
                        val intent = Intent(this, Choice_mode_page::class.java)
                        intent.putExtra("매장명", user_shop_name)
                        Log.d("?", user_shop_name.toString())

                        startActivity(intent)
                    }else{
                        Toast.makeText(this@Login_page,"로그인 실패 다시 시도해주세요", Toast.LENGTH_SHORT).show()
//                        val intent = Intent(this, Login_page::class.java)
//                        intent.putExtra("사용자 이름", name)
//                        startActivity(intent)
                    }
                },
                { error ->
                    Log.d("톻신에러", error.printStackTrace().toString());
                    Toast.makeText(this@Login_page,"통신실패", Toast.LENGTH_SHORT).show()
                }

            )
            // post 방식의 데이터를 담을 수 있는 위치

            requestQueue.add(request)

        })

        // 회원가입 페이지로 이동
        btn_Join_page.setOnClickListener{
            intent = Intent(this,Join_page::class.java)
            startActivity(intent)
        }




    }


}