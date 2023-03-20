
package org.techtown.kobb

import java.io.FileInputStream

import android.view.View
import android.os.Bundle
import android.widget.Button
import android.widget.CalendarView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Sales_condition_page : AppCompatActivity() {
    // 사용자 아이디 'kobb'으로 추가
    var userID: String = "userID"
    lateinit var calendarView: CalendarView
    lateinit var sales_search_result: TextView
    lateinit var Sales_condition_search : TextView
    lateinit var month_sales : TextView
    lateinit var select_month : TextView
    lateinit var select_date: TextView
    lateinit var btn_Sales_condition : Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sales_condition_page)

        // UI값 생성
        // 캘린더
        calendarView=findViewById(R.id.calendarView)
        // 일 총 매출을 보여주는 곳
        sales_search_result = findViewById(R.id.sales_search_result)
        // 조회하기 버튼
        btn_Sales_condition = findViewById(R.id.btn_Sales_condition)
        // 월매출 금액
        month_sales = findViewById(R.id.month_sales)
        // 선택한 월
        select_month = findViewById(R.id.select_month)
        // 선택한 일자
        select_date = findViewById(R.id.select_date)



        // calendarView에 있는 data 클릭시 이벤트
        calendarView.setOnDateChangeListener { view, year, month, dayOfMonth ->

            // 선택한 월 출력
            select_month.visibility = View.VISIBLE
            // 월매출 출력
            month_sales.visibility = View.VISIBLE
            // 선택한 일자
            select_date.text = String.format("%d년 %d월 %d"+"일 매출", year, month + 1, dayOfMonth)
            select_date.visibility = View.VISIBLE
            checkDay(year, month, dayOfMonth, userID)

        }


    }

    // 달력 내용 조회
    fun checkDay(cYear: Int, cMonth: Int, cDay: Int, userID: String) {
        // 조회하기 버튼 클릭시 이벤트 등록
        btn_Sales_condition.setOnClickListener{

            sales_search_result.text ="720,000원"




        }

        try {


        } catch (e: Exception) {
            e.printStackTrace()
        }
    }


}

