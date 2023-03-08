package org.techtown.kobb
import android.content.Intent
import android.net.wifi.p2p.WifiP2pManager.ServiceResponseListener
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.AuthFailureError
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.JsonRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONObject
import java.net.CookieManager
import javax.net.ssl.HttpsURLConnection
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
            var id = user_id.text.toString()
            var pw = user_pw.text.toString()
            var phone = user_phone.text.toString()
            var shop_name = user_shop_name.text.toString()
            val url="http://211.107.188.246:8003/KOBB/Join.do?"
            val request = object: StringRequest(
                Request.Method.POST,
                url
                ,
                {response->
                    Toast.makeText(this@Join_page, "통신성공", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this,Join_success_page ::class.java)
                    startActivity(intent)
                },
                { error ->
                    Toast.makeText(this@Join_page,"아이디가 중복 됩니다.", Toast.LENGTH_LONG).show()
                }
            )
            { // post 방식의 데이터를 담을 수 있는 위치
                @Throws(AuthFailureError::class)
                override fun getParams(): MutableMap<String, String>? {
                    val params: MutableMap<String, String> = HashMap()
                    params["user_id"] = id
                    params["user_pw"] = pw
                    params["user_shop_name"] = shop_name
                    params["user_phone"] = phone
                    Log.d("여기야",params.toString())
                    return params }
            }
            requestQueue.add(request)
            Log.d("요청 데이터 값",request.toString())
        })
    }
}