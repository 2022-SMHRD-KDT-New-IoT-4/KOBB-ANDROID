
package org.techtown.kobb

import java.io.FileInputStream

import android.view.View
import android.os.Bundle
import android.widget.Button
import android.widget.CalendarView
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Sales_condition_page : AppCompatActivity() {
    var userID: String = "userID"
    lateinit var fname: String
    lateinit var str: String
    lateinit var calendarView: CalendarView
    lateinit var updateBtn: Button
    lateinit var deleteBtn:Button
    lateinit var saveBtn:Button
    lateinit var diaryTextView: TextView
    lateinit var diaryContent:TextView

    lateinit var contextEditText: EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sales_condition_page)

        // UI값 생성
        // 캘린더
        calendarView=findViewById(R.id.calendarView)
        // 일 총 매출액을 여기에서 보여주면 좋겠다.
        diaryTextView=findViewById(R.id.TextView)
        // 저장 버튼



        calendarView.setOnDateChangeListener { view, year, month, dayOfMonth ->
            diaryTextView.visibility = View.VISIBLE
            saveBtn.visibility = View.VISIBLE
            contextEditText.visibility = View.VISIBLE
            diaryContent.visibility = View.INVISIBLE
            updateBtn.visibility = View.INVISIBLE
            deleteBtn.visibility = View.INVISIBLE
            diaryTextView.text = String.format("%d / %d / %d", year, month + 1, dayOfMonth)
            contextEditText.setText("")
            checkDay(year, month, dayOfMonth, userID)
        }


    }

    // 달력 내용 조회
    fun checkDay(cYear: Int, cMonth: Int, cDay: Int, userID: String) {
        //저장할 파일 이름설정
        fname = "" + userID + cYear + "-" + (cMonth + 1) + "" + "-" + cDay + ".txt"

        var fileInputStream: FileInputStream
        try {
            fileInputStream = openFileInput(fname)
            val fileData = ByteArray(fileInputStream.available())
            fileInputStream.read(fileData)
            fileInputStream.close()
            str = String(fileData)
            contextEditText.visibility = View.INVISIBLE
            diaryContent.visibility = View.VISIBLE
            diaryContent.text = str




            if (diaryContent.text == null) {
                diaryContent.visibility = View.INVISIBLE
                updateBtn.visibility = View.INVISIBLE
                deleteBtn.visibility = View.INVISIBLE
                diaryTextView.visibility = View.VISIBLE
                saveBtn.visibility = View.VISIBLE
                contextEditText.visibility = View.VISIBLE
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }


    // 달력 내용 제거
//    @SuppressLint("WrongConstant")
//    fun removeDiary(readDay: String?) {
//        var fileOutputStream: FileOutputStream
//        try {
//            fileOutputStream = openFileOutput(readDay, MODE_NO_LOCALIZED_COLLATORS)
//            val content = ""
//            fileOutputStream.write(content.toByteArray())
//            fileOutputStream.close()
//        } catch (e: java.lang.Exception) {
//            e.printStackTrace()
//        }
//    }


    // 달력 내용 추가
//    @SuppressLint("WrongConstant")
//    fun saveDiary(readDay: String?) {
//        var fileOutputStream: FileOutputStream
//        try {
//            fileOutputStream = openFileOutput(readDay, MODE_NO_LOCALIZED_COLLATORS)
//            val content = contextEditText.text.toString()
//            fileOutputStream.write(content.toByteArray())
//            fileOutputStream.close()
//        } catch (e: java.lang.Exception) {
//            e.printStackTrace()
//        }
//    }
}

