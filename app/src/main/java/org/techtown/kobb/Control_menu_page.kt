package org.techtown.kobb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView




class Control_menu_page : AppCompatActivity() {

    lateinit var spinner: Spinner
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_control_menu_page)

        // 메뉴관리 페이지 메뉴 목록 부분
        val lv_Control_menu_page = findViewById<RecyclerView>(R.id.lv_Control_inventory_page)

        spinner = findViewById(R.id.spinner)
        val data = ArrayList<MenuVO>()


        data.add(MenuVO("1","아메리카노","4000","커피류","판매중","img1"))
        data.add(MenuVO("2","카페라떼","4000","커피류","판매중","img2"))
        data.add(MenuVO("3","에스프레소","4000","커피류","판매중","img3"))
        data.add(MenuVO("4","카푸치노","4000","커피류","판매중","img4"))
        data.add(MenuVO("5","카페모카","4000","커피류","판매중","img5"))
        data.add(MenuVO("6","콜드브루","4000","커피류","판매중","img6"))
        data.add(MenuVO("7","돌체라떼","4000","커피류","판매중","img7"))
        data.add(MenuVO("8","사케라또","4000","커피류","판매중","img8"))
        data.add(MenuVO("9","카페룽고","4000","커피류","판매중","img9"))
        data.add(MenuVO("10","카페크레마","4000","커피류","판매중","img10"))
        data.add(MenuVO("11","자허블","4000","커피류","판매중","img11"))
        data.add(MenuVO("12","크림라떼","4000","커피류","판매중","img12"))


        val adapter = MenuAdapter(applicationContext,data)

        lv_Control_menu_page.adapter = adapter

        lv_Control_menu_page.layoutManager=LinearLayoutManager(this)

        adapter.notifyDataSetChanged()

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