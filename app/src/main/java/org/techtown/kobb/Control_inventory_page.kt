package org.techtown.kobb

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class Control_inventory_page : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_control_inventory_page)

        // 1. id : lv_Control_inventory_page인 리사이클러뷰
        // 내가 사용할 어댑터 뷰의 위치와 어떤 걸 사용할 지 결정
        val lv_Control_inventory_page = findViewById<RecyclerView>(R.id.lv_Control_inventory_page)

        // 2. Template 결정 : Control_inventory_page.xml 파일

        // 3. Item 결정 : ArrayList<InventoryVO>
        // 정보가 arraylist 형식으로 쌓일 것
        val data = ArrayList<InventoryVO>()
        // 가데이터 넣기
        data.add(InventoryVO("1","우유","4000","4","은정상회","010-1234-4343"))
        data.add(InventoryVO("2","원두","9000","24","채영세탁소","010-4215-8111"))
        Log.d("데이터가 잘 들어갔니?",data[0].toString())

        // 4. Adapter 결정
        // ** 만약, Template의 최상위 Layout이 단순히 TextView 라면
        //      ArrayAdapter를 쓰자!! 아니라면, 만들자!

        // 페이지 정보 : this(이 페이지) , 보낼 내용 data
       val adapter = InventoryAdapter(applicationContext, data)

        // 5. Container 에 Adapter 부착
        lv_Control_inventory_page.adapter = adapter
        Log.d("왜 안나타나지?",data.toString())

        lv_Control_inventory_page.layoutManager=LinearLayoutManager(this)

        adapter.notifyDataSetChanged()
        // 6. Event 처리








    }
}