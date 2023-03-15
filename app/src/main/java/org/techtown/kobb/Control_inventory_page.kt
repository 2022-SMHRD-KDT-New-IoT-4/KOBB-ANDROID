package org.techtown.kobb

import android.os.Bundle
import android.util.Log
import android.widget.SearchView
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
        data.add(InventoryVO("1","우유","4000","4","승주마트","010-0000-0000"))
        data.add(InventoryVO("2","원두","9000","24","인영카페","010-1111-1111"))
        data.add(InventoryVO("3","레몬","6000","13","윤정과일","010-2222-2222"))
        data.add(InventoryVO("4","딸기","14000","3","윤정과일","010-3333-3333"))
        data.add(InventoryVO("5","시럽","3000","18","인영카페","010-4444-4444"))
        data.add(InventoryVO("6","M컵","3000","10","종일상회","010-5555-5555"))
        data.add(InventoryVO("7","L컵","4000","9","종일상회","010-6666-6666"))
        data.add(InventoryVO("8","S컵","2000","6","종일상회","010-7777-7777"))
        data.add(InventoryVO("9","빨대","1000","42","승철샵","010-8888-8888"))
        data.add(InventoryVO("10","홀더","5000","32","승철샵","010-9999-9999"))
        data.add(InventoryVO("11","세제","7000","34","은정마트","010-1010-1010"))
        data.add(InventoryVO("12","파우더","6000","66","은정마트","010-1212-1212"))

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
    private fun initSearchView() {

        var search = findViewById<SearchView>(R.id.searchView)
        // init SearchView
        search.isSubmitButtonEnabled = false
        search.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            // 검색을 실행했을 경우, retrofit 을 사용하여 데이터 검색 후 추출하여 저장
            override fun onQueryTextSubmit(query: String?): Boolean {

                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {

                return true
            }
        })
    }
}