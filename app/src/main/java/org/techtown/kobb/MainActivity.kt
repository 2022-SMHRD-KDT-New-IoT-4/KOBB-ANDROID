package org.techtown.kobb

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

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn_req = findViewById<Button>(R.id.btn_req)
        val edt_msg = findViewById<EditText>(R.id.edt_msg)

        val requestQueue = Volley.newRequestQueue(applicationContext)

        btn_req.setOnClickListener(View.OnClickListener {
            var data = edt_msg.text.toString()
            val url="http://169.254.200.1:8003/AndroidServer/AndroidTest"

                val request = StringRequest(
                    Request.Method.POST,
                    url,
                    {response->
                        Toast.makeText(this@MainActivity,"통신성공",Toast.LENGTH_SHORT).show()

                    },
                    { error ->
                        Toast.makeText(this@MainActivity,"통신실패",Toast.LENGTH_SHORT).show()
                    }


                )
                // post 방식의 데이터를 담을 수 있는 위치



            requestQueue.add(request)
        })


    }
}