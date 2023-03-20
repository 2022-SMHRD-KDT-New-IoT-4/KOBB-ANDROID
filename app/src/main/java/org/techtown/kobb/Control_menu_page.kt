package org.techtown.kobb


import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.util.rangeTo
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.AuthFailureError
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONArray
import org.json.JSONObject


class Control_menu_page : AppCompatActivity() {

    lateinit var spinner: Spinner
    lateinit var adapter : MenuAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_control_menu_page)
        var user_id = intent.getStringExtra("user_id")

        val requestQueue = Volley.newRequestQueue(applicationContext)
        val url = "http://211.107.188.246:8003/KOBB/Menu.do?"

        // 메뉴관리 페이지 메뉴 목록 부분
        val lv_Control_menu_page = findViewById<RecyclerView>(R.id.lv_Control_inventory_page)
        spinner = findViewById(R.id.spinner)

        // 메뉴 데이터 VO
        val data = ArrayList<MenuVO>()

        val request = object  : StringRequest(
            Request.Method.POST,
            url,
            {response ->
                val result = JSONArray(response)
                Log.d("하이",result[0].toString())

                for(i in 0 until result.length()){

                    val menu = result[i] as JSONObject

                    val menu_num = menu.getString("menu_seq").toLong()
                    val menu_name = menu.getString("menu_name")
                    val menu_price = menu.getString("menu_price").toLong()
                    // 상품상태 number 로 되어있어서 변경해야함
                    val menu_status = menu.getString("menu_status")
                    val menu_category = menu.getString("menu_category")
                    val menu_image = menu.getString("menu_img")

                    data.add(MenuVO(menu_num-1,menu_name,menu_price,menu_category, menu_status,menu_image))

                    Log.d("하이",data.toString())


                }
                adapter.notifyDataSetChanged()



            },
            { error->
                Toast.makeText(this,"통신실패", Toast.LENGTH_SHORT).show()
            }
        )
        { // post 방식의 데이터를 담을 수 있는 위치
            @Throws(AuthFailureError::class)
            override fun getParams(): MutableMap<String, String>? {
                val params: MutableMap<String, String> = HashMap()
                params["user_id"] = user_id.toString()
                return params }
        }
        requestQueue.add(request)
        Log.d("요청 데이터 값", request.toString())






        adapter = MenuAdapter(applicationContext,data)

        lv_Control_menu_page.adapter = adapter

        lv_Control_menu_page.layoutManager=LinearLayoutManager(this)


        // 토글 목록(spinner) --> sppiner_array 에서 불러오기
        val items = resources.getStringArray(R.array.my_array)
        val spinnerAdapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,items)
        spinner.adapter = spinnerAdapter

        // 시작 위치 설정
        spinner.setSelection(0)
        spinner.onItemSelectedListener = object :
        AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

            }

            override fun onNothingSelected(p0: AdapterView<*>?) {



            }


        }














    }
}